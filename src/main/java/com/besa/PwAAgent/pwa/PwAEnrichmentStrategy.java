package com.besa.PwAAgent.pwa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import BESA.Log.ReportBESA;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ModulatedActionRequestData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.RobotActionProfile;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel.Action;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel.Parameter;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.actionmodel.Primitive;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.EnrichmentStrategy;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.EmotionalStateData;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.guard.RobotEmotions;
import BESA.SocialRobot.agentUtils.ServiceDataRequest;

public class PwAEnrichmentStrategy implements EnrichmentStrategy {
        public static double id = 0;

        @Override
        public ModulatedActionRequestData enrichActionRequestData(ActionRequestData data,
                        RobotActionProfile robotProfile,
                        EmotionalStateData emoData) {
                List<ServiceDataRequest> serviceDataRequests = new ArrayList<>();
                // ReportBESA.debug("emotionas: " + emoData.getEmotions().toString());
                RobotEmotions currentEmotion = emoData.getEmotions().keySet().iterator().next();
                double currentValue = emoData.getEmotions().get(currentEmotion);
                // ReportBESA.debug("ADIOS: " + data.getActionName());
                // ReportBESA.debug("ADIOS: " + currentEmotion.name());

                Action action = robotProfile.getAction(data.getActionName());
                Map<String, Object> params = new HashMap<>();
                params.putAll(data.getParameters());
                for (Primitive primitive : action.getPrimitives()) {
                        Set<Parameter> parameters = primitive.getParameters();
                        for (Parameter parameter : parameters) {
                                switch (parameter.getName()) {
                                        case "speed":
                                                float maxSpeed = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "maxSpeed"));
                                                float minSpeed = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "minSpeed"));
                                                float speed = (float) (minSpeed + (maxSpeed - minSpeed) * currentValue);
                                                params.put(parameter.getName(), speed);
                                                break;
                                        case "ledColor":
                                                String[] colors = parameter.getConfig(currentEmotion.name()).split("_");
                                                String ledColor = selectLedColor(colors, currentValue);
                                                params.put(parameter.getName(), ledColor);
                                                break;
                                        case "ledIntensity":
                                                float maxIntensity = Float
                                                                .parseFloat(parameter.getConfig()
                                                                                .get(currentEmotion.name()
                                                                                                + "maxIntensity"));
                                                float minIntensity = Float
                                                                .parseFloat(parameter.getConfig()
                                                                                .get(currentEmotion.name()
                                                                                                + "minIntensity"));
                                                float intensity = (float) (minIntensity
                                                                + (maxIntensity - minIntensity) * currentValue);
                                                params.put(parameter.getName(), intensity);
                                                break;
                                        case "speechPitch":
                                                float maxPitch = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "maxPitch"));
                                                float minPitch = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "minPitch"));
                                                float pitch = (float) (minPitch + (maxPitch - minPitch) * currentValue);
                                                params.put(parameter.getName(), pitch);
                                                break;
                                        case "speechSpeed":
                                                float maxSpeedSpeech = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "maxSpeed"));
                                                float minSpeedSpeech = Float
                                                                .parseFloat(parameter.getConfig().get(
                                                                                currentEmotion.name() + "minSpeed"));
                                                float speedSpeech = (float) (minSpeedSpeech
                                                                + (maxSpeedSpeech - minSpeedSpeech) * currentValue);
                                                params.put(parameter.getName(), speedSpeech);
                                                break;
                                }
                        }
                        serviceDataRequests
                                        .add(new ServiceDataRequest(id++, primitive.getService(),
                                                        primitive.getFunction(), params));
                }
                return new ModulatedActionRequestData(data.getId(), data.getActionName(), data.getTaskName(),
                                serviceDataRequests);
        }

        private String selectLedColor(String[] colors, double currentValue) {
                double absValue = Math.abs(currentValue);
                String value = "";
                if (absValue >= 0.6 && absValue <= 1) {
                        value = colors[0];
                } else if (absValue >= 0.2 && absValue < 0.6) {
                        value = colors[1];
                } else if (absValue >= 0 && absValue < 0.2) {
                        value = colors[2];
                }

                return value;
        }

}
