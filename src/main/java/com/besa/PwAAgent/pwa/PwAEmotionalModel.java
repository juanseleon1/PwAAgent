package com.besa.PwAAgent.pwa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BESA.SocialRobot.UserEmotionalInterpreterAgent.guard.UserEmotion;
import BESA.SocialRobot.UserEmotionalInterpreterAgent.model.UserEmotionalModel;

public class PwAEmotionalModel extends UserEmotionalModel {

    public static enum Emotion {
        calm,
        anger,
        joy,
        sorrow,
        laughter,
        excitement,
        surprise,
        attention
    }

    @Override
    public List<UserEmotion> calculateCompositeEmotions() {
        List<UserEmotion> userEmotions = new ArrayList<>();
        Map<Emotion, UserEmotion> emotions = new HashMap<>();
        int numEmotions = getEmotionBundles().size();
        getEmotionBundles().forEach( (emotionBundle) -> {
            emotionBundle.getEmotions().forEach( (emotion) -> {
                Emotion e = Emotion.valueOf(emotion.getName());
                if (emotions.containsKey(e)) {
                    UserEmotion ue = emotions.get(e);
                    ue.setIntensity(ue.getIntensity() + emotion.getIntensity());
                } else {
                    emotions.put(e, emotion);
                }
            });
        });
        emotions.forEach( (k, v) -> {
            v.setIntensity(v.getIntensity()/numEmotions);
            userEmotions.add(v);
        });
        return userEmotions;
    }

    @Override
    public void persist() {
        // empty for now.
    }

}
