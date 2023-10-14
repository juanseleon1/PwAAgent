package com.besa.PwAAgent;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.besa.PwAAgent.agent.utils.MessageAdapterReceiver;
import com.besa.PwAAgent.agent.utils.TerminalUtils;
import com.besa.PwAAgent.db.model.userprofile.Dosis;
import com.besa.PwAAgent.db.model.userprofile.FranjaMedicamento;
import com.besa.PwAAgent.db.model.userprofile.PwAMedicalContext;
import com.besa.PwAAgent.db.model.userprofile.PwAProfile;
import com.besa.PwAAgent.db.repository.PwAProfileRepository;
import com.besa.PwAAgent.other.MailAdapter;
import com.besa.PwAAgent.other.MessageAdapter;
import com.besa.PwAAgent.pepper.adapter.PepperAdapter;
import com.besa.PwAAgent.pepper.adapter.PepperAdapterReceiver;
import com.besa.PwAAgent.pepper.config.PepperConfigParser;
import com.besa.PwAAgent.pepper.config.PepperInterfaceInterpreter;
import com.besa.PwAAgent.pepper.config.PwAAgentConfiguration;
import com.besa.PwAAgent.pepper.emotion.PepperEmotionalStrategy;
import com.besa.PwAAgent.pepper.emotion.PepperInterpreterStrategy;
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
import com.besa.PwAAgent.pwa.PwAEmotionalInterpreterState;
import com.besa.PwAAgent.pwa.PwAEnrichmentStrategy;

import BESA.BDI.AgentStructuralModel.StateBDI;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionAgentState;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.ActionExecutor;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.RobotActionProfile;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.ActionModulator;
import BESA.SocialRobot.BDIAgent.ActionAgent.ActionModulator.EnrichmentStrategy;
import BESA.SocialRobot.BDIAgent.BeliefAgent.BeliefAgent;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PsychologicalState.AgentEmotionalState.RobotEmotionalStrategy;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.SocioDemographicalContext;
import BESA.SocialRobot.BDIAgent.BeliefAgent.UserProfile.Context.UserContext;
import BESA.SocialRobot.BDIAgent.MotivationAgent.bdi.autonomy.SRAutonomyManager;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.SRConfiguration;
import BESA.SocialRobot.EmotionalInterpreterAgent.agent.EmotionalInterpreterStrategy;
import BESA.SocialRobot.ExplainabilityAgent.agent.ExplainabilityAgentState;
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
        @Autowired
        PwAProfileRepository repo;

        @Bean
        SRConfiguration srConfiguration() {
                SRConfiguration config = new PwAAgentConfiguration();
                String robotIP = env.getProperty("robot.ip");
                int robotPort = Integer.parseInt(env.getProperty("robot.port"));
                String resourcePath = env.getProperty("robot.resourcePath");
                String semanticPath = env.getProperty("robot.semanticPath");
                String charPath = env.getProperty("robot.charPath");
                String profilePath = env.getProperty("robot.profilePath");
                String fuzzyPath = env.getProperty("robot.fuzzyPath");
                PepperAdapter adapter = new PepperAdapter(robotIP, robotPort);
                MailAdapter mailAdapter = new MailAdapter();
                MessageAdapterReceiver receiver = new MessageAdapterReceiver();
                TerminalUtils terminal = new TerminalUtils(receiver);
                MessageAdapter messageAdapter = new MessageAdapter(terminal);
                int portNumber = 53152;
                Map<String, List<SRService<?>>> serviceProviders = new HashMap<>();
                List<SRService<?>> interfacesServices = new ArrayList<>();
                EmotionalInterpreterStrategy emotionalInterpreterStrategy = new PepperInterpreterStrategy();
                config.setEas(emotionalInterpreterStrategy);
                interfacesServices.add(new InterfaceEventService(ServiceNames.INTERFACEEVENT, adapter,
                                new PepperAdapterReceiver(portNumber++), new PepperInterfaceEventServiceConfig()));
                interfacesServices.add(
                                new MailService(ServiceNames.MAIL, mailAdapter, new PepperAdapterReceiver(portNumber++),
                                                new PepperMailServiceConfig()));
                interfacesServices.add(new MessageService(ServiceNames.MESSAGE, messageAdapter,
                                receiver, new PepperMessageServiceConfig()));
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
                motivationAgentConfiguration.setSemanticDictPath(semanticPath);
                motivationAgentConfiguration.setCharacterDescPath(charPath);
                motivationAgentConfiguration.setAutonomyManager(new SRAutonomyManager(fuzzyPath));
                motivationAgentConfiguration.setThreshold(0.3);
                EnrichmentStrategy eas = new PwAEnrichmentStrategy();

                RobotActionProfile actionProfile = PepperConfigParser.parseRobotProfile(profilePath);
                ActionModulator actionModulator = new ActionModulator(eas, actionProfile);

                RobotResources robotResources = PepperConfigParser.parseResources(resourcePath);
                motivationAgentConfiguration.setRobotResources(robotResources);
                RobotEmotionalStrategy emotionalStrategy = new PepperEmotionalStrategy();
                motivationAgentConfiguration.setRobotEmotionalStrategy(emotionalStrategy);
                ActionExecutor actionExecutor = new ActionExecutor(robotResources);

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

                config.setRiskDetectionAgentState(new PwARiskDetectionAgentState());
                config.setup();
                config.start();
                terminal.setAgent(config.getMotivationAgent());
                Optional<PwAProfile> optPerfil = repo.findById("0");
                if (optPerfil.isPresent()) {
                        PwAProfile perfil = optPerfil.get();
                        StateBDI state = (StateBDI) config.getMotivationAgent().getState();
                        BeliefAgent blvs = (BeliefAgent) state.getBelieves();
                        PwAMedicalContext medical = perfil.getUserMedicalContext();
                        List<FranjaMedicamento> franjas = new ArrayList<>();
                        List<Dosis> dosis = new ArrayList<>();
                        Dosis dosis1 = new Dosis();
                        dosis1.setCantidad(2);
                        dosis1.setMedicamento("Telmisartán");
                        Dosis dosis2 = new Dosis();
                        dosis2.setCantidad(1);
                        dosis2.setMedicamento("Vitamina D");
                        dosis.add(dosis1);
                        dosis.add(dosis2);
                        FranjaMedicamento franja = new FranjaMedicamento();
                        franja.setHora(LocalTime.now().plusMinutes(5));
                        franja.setId(1);
                        franja.setDosis(dosis);
                        franjas.add(franja);
                        medical.setFranjaMedicamentoList(franjas);
                        UserContext context = new UserContext();
                        SocioDemographicalContext sContext = new SocioDemographicalContext();
                        sContext.setId("0");
                        sContext.setName(perfil.getNombre());
                        sContext.setLastName(perfil.getApellido());
                        context.setSocioDemoContext(sContext);
                        perfil.setUserContext(context);
                        blvs.getActiveUsers().add("0");
                        blvs.addUserProfile("0", perfil);
                }
                terminal.setRecords((ExplainabilityAgentState) config.getExplainabilityAgent().getState());
                Thread t = new Thread(terminal);
                t.start();
                return config;
        }

}
