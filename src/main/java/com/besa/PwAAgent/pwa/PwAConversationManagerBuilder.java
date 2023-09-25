package com.besa.PwAAgent.pwa;

import BESA.SocialRobot.InteractiveAgent.agent.ConversationManagerBuilder;
import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;

public class PwAConversationManagerBuilder implements ConversationManagerBuilder {

    @Override
    public ConversationManager buildConversationManager() {
        return new PwAConversationManager();
    }

}
