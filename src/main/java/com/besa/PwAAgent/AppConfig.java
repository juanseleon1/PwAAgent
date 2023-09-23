package com.besa.PwAAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.besa.PwAAgent.other.MailAdapter;
import com.besa.PwAAgent.other.MessageAdapter;
import com.besa.PwAAgent.pepper.action.PepperActionDescriptor;
import com.besa.PwAAgent.pepper.action.PepperActionExecutor;
import com.besa.PwAAgent.pepper.adapter.PepperAdapter;
import com.besa.PwAAgent.pepper.adapter.PepperAdapterReceiver;
import com.besa.PwAAgent.pepper.config.PepperInterfaceInterpreter;
import com.besa.PwAAgent.pepper.config.PepperRobotResources;
import com.besa.PwAAgent.pepper.emotion.PepperEmotionalConfig;
import com.besa.PwAAgent.pepper.emotion.PepperEmotionalStrategy;
import com.besa.PwAAgent.pepper.service.PepperEmotionExtractorServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperInterfaceEventServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperMailServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperMessageServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperMovementServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperRawVideoServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperRobotResourceServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperSentimentAnalysisServiceConfig;
import com.besa.PwAAgent.pepper.service.PepperSpeechEngineServiceConfig;
import com.besa.PwAAgent.pwa.PwAConversationManagerBuilder;
import com.besa.PwAAgent.pwa.PwAEnrichmentStrategy;

import BESA.BDI.AgentStructuralModel.Agent.LatentGoalStructure;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionDescriptor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionExecutor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.ActionModulator;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.EnrichmentStrategy;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotEmotionalConfig;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.SRConfiguration;
import BESA.SocialRobot.InteractiveAgent.agent.ConversationManagerBuilder;
import BESA.SocialRobot.InteractiveAgent.agent.InteractiveAgentState;
import BESA.SocialRobot.InteractiveAgent.agent.InterfaceInterpreter;
import BESA.SocialRobot.InteractiveAgent.manager.PromptBuilder;
import BESA.SocialRobot.ServiceProvider.agent.adapter.SRService;
import BESA.SocialRobot.ServiceProvider.services.ServiceNames;
import BESA.SocialRobot.ServiceProvider.services.interfaces.interfaceevent.InterfaceEventService;
import BESA.SocialRobot.ServiceProvider.services.interfaces.mail.MailService;
import BESA.SocialRobot.ServiceProvider.services.interfaces.message.MessageService;
import BESA.SocialRobot.ServiceProvider.services.robotresources.ResourceService;
import BESA.SocialRobot.ServiceProvider.services.robotstate.movement.MovementService;
import BESA.SocialRobot.ServiceProvider.services.sensing.emotionextractor.EmotionExtractorService;
import BESA.SocialRobot.ServiceProvider.services.sensing.rawvideo.RawVideoService;
import BESA.SocialRobot.ServiceProvider.services.speech.sentimentanalysis.SentimentAnalysisService;
import BESA.SocialRobot.ServiceProvider.services.speech.speechengine.SpeechEngineService;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.agent.UserEmotionalInterpreterState;

@Configuration
public class AppConfig {

        @Autowired
        Environment env;

        @Bean
        SRConfiguration srConfiguration() {
                SRConfiguration config = new SRConfiguration();
                String robotIP = env.getProperty("robot.ip");
                int robotPort = Integer.parseInt(env.getProperty("robot.port"));

                PepperAdapter adapter = new PepperAdapter(robotIP, robotPort);
                MailAdapter mailAdapter = new MailAdapter();
                MessageAdapter messageAdapter = new MessageAdapter();
                int portNumber = 53152;

                Map<String, List<SRService<?>>> serviceProviders = new HashMap<>();
                List<SRService<?>> interfacesServices = new ArrayList<>();
                interfacesServices.add(new InterfaceEventService(ServiceNames.INTERFACEEVENT, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperInterfaceEventServiceConfig()));
                interfacesServices.add(
                                new MailService(ServiceNames.MAIL, mailAdapter, new PepperAdapterReceiver(portNumber++),
                                                new PepperMailServiceConfig()));
                interfacesServices.add(new MessageService(ServiceNames.MESSAGE, messageAdapter,
                                new PepperAdapterReceiver(portNumber++), new PepperMessageServiceConfig()));
                serviceProviders.put("interfaces", interfacesServices);

                List<SRService<?>> robotResourceServices = new ArrayList<>();
                robotResourceServices.add(new ResourceService(ServiceNames.ROBOT_RESOURCES, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperRobotResourceServiceConfig()));
                serviceProviders.put("robotResources", robotResourceServices);

                List<SRService<?>> robotStateServices = new ArrayList<>();
                robotStateServices.add(
                                new MovementService(ServiceNames.MOVEMENT, adapter,
                                                new PepperAdapterReceiver(portNumber++),
                                                new PepperMovementServiceConfig()));
                serviceProviders.put("robotState", robotStateServices);

                List<SRService<?>> robotSensingServices = new ArrayList<>();
                robotSensingServices.add(new EmotionExtractorService(ServiceNames.EMOTIONEXTRACTOR, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperEmotionExtractorServiceConfig()));
                robotSensingServices.add(
                                new RawVideoService(ServiceNames.RAWVIDEO, adapter,
                                                new PepperAdapterReceiver(portNumber++),
                                                new PepperRawVideoServiceConfig()));
                serviceProviders.put("robotSensing", robotSensingServices);

                List<SRService<?>> robotSpeechServices = new ArrayList<>();
                robotSpeechServices.add(new SpeechEngineService(ServiceNames.SPEECHENGINE, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperSpeechEngineServiceConfig()));
                robotSpeechServices.add(new SentimentAnalysisService(ServiceNames.SENTIMENTANALYSIS, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperSentimentAnalysisServiceConfig()));
                serviceProviders.put("robotSpeech", robotSpeechServices);
                config.setSps(serviceProviders);

                MotivationAgentConfiguration motivationAgentConfiguration = new MotivationAgentConfiguration();
                LatentGoalStructure latentGoalStructure = new LatentGoalStructure();
                motivationAgentConfiguration.setGoalStructure(latentGoalStructure);
                motivationAgentConfiguration.setSemanticDictPath("conf/robot/emotionalmodel/semanticDict.yaml");
                motivationAgentConfiguration.setCharacterDescPath("conf/robot/emotionalmodel/characterDescriptor.yaml");

                EnrichmentStrategy eas = new PwAEnrichmentStrategy();
                ActionModulator actionModulator = new ActionModulator(eas);

                RobotResources robotResources = new PepperRobotResources();
                motivationAgentConfiguration.setRobotResources(robotResources);
                RobotEmotionalConfig configDescriptor = new PepperEmotionalConfig();
                RobotEmotionalStrategy emotionalStrategy = new PepperEmotionalStrategy();
                motivationAgentConfiguration.setRobotEmotionalConfig(configDescriptor);
                motivationAgentConfiguration.setRobotEmotionalStrategy(emotionalStrategy);
                ActionDescriptor actionDescriptor = new PepperActionDescriptor();
                ActionExecutor actionExecutor = new PepperActionExecutor(robotResources, configDescriptor,
                                actionDescriptor);

                ActionAgentState actionState = new ActionAgentState(actionModulator, actionExecutor);
                config.setConfig(motivationAgentConfiguration);
                config.setActionAgentState(actionState);

                PromptBuilder promptBuilder = new PromptBuilder();
                InterfaceInterpreter interpreter = new PepperInterfaceInterpreter();
                ConversationManagerBuilder builder = new PwAConversationManagerBuilder();
                InteractiveAgentState interactiveAgentState = new InteractiveAgentState(promptBuilder, interpreter,
                                builder);
                config.setInteractiveAgentState(interactiveAgentState);

                UserEmotionalInterpreterState userState = new PwAEmotionalInterpreterState();
                config.setUserEmotionalInterpreterState(userState);

                config.setup();
                config.start();
                
                return config;
        }
}
