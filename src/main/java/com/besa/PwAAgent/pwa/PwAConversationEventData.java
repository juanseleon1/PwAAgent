package com.besa.PwAAgent.pwa;

import BESA.SocialRobot.InteractiveAgent.guard.ConversationEventData;

public class PwAConversationEventData extends ConversationEventData {
    private boolean isRetroalimentationValue;

    public PwAConversationEventData() {
        super();
        isRetroalimentationValue = false;
    }

    public boolean isRetroalimentationValue() {
        return isRetroalimentationValue;
    }

    public void setRetroalimentationValue(boolean isRetroalimentationValue) {
        this.isRetroalimentationValue = isRetroalimentationValue;
    }
}
