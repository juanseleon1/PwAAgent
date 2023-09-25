package com.besa.PwAAgent.pwa;

import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;
import BESA.SocialRobot.InteractiveAgent.manager.PromptBuilder;

public class PwAConversationManager extends ConversationManager{

    @Override
    public String getAnswerFromText(PromptBuilder arg0, String arg1, String arg2) {
        return arg2;
    }

}
