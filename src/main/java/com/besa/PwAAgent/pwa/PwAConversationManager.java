package com.besa.PwAAgent.pwa;

import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;
import BESA.SocialRobot.InteractiveAgent.guard.InteractionEventData;
import BESA.SocialRobot.InteractiveAgent.manager.ConversationManager;
import BESA.SocialRobot.InteractiveAgent.manager.PromptBuilder;

public class PwAConversationManager extends ConversationManager{

    @Override
    public String getAnswerFromText(PromptBuilder builder, String context, String text) {
        return text;
    }

    @Override
    public ConversationEventData handleCustomEventData(InteractionEventData data) {
        PwAConversationEventData conversationEventData = new PwAConversationEventData();
        conversationEventData.setRetroalimentationValue(data.getData().containsKey("retro"));
        return conversationEventData;
    }

}
