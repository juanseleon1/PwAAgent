package com.besa.PwAAgent.pepper.config;

import org.yaml.snakeyaml.Yaml;

import BESA.SocialRobot.BDIAgent.ActionAgent.ActionExecutor.RobotActionProfile;
import BESA.SocialRobot.BDIAgent.BeliefAgent.PhysicalState.InternalState.RobotResources;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PepperConfigParser {
    public static RobotResources parseResources(String filePath) {
        RobotResources robotResources = null;
        try {
            Yaml yaml = new Yaml();
            FileReader reader;
            reader = new FileReader(filePath);
            robotResources = yaml.loadAs(reader, RobotResources.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return robotResources;
    }

    public static RobotActionProfile parseRobotProfile(String filePath) {
        RobotActionProfile profile = null;
        try {
            Yaml yaml = new Yaml();
            FileReader reader;
            reader = new FileReader(filePath);
            profile = yaml.loadAs(reader, RobotActionProfile.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
