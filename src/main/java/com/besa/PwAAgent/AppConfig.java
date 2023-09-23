package com.besa.PwAAgent;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.MotivationAgentConfiguration;
import BESA.SocialRobot.BDIAgent.MotivationAgent.utils.SRConfiguration;


@Configuration
public class AppConfig {
    @Bean
    public SRConfiguration srConfiguration() {
        SRConfiguration config = new SRConfiguration();
        MotivationAgentConfiguration motivationAgentConfiguration = new MotivationAgentConfiguration();

        config.setConfig(motivationAgentConfiguration);

        config.setup();
        config.start();
        return config;
    }
}
