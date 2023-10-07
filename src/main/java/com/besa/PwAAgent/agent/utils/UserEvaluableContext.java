package com.besa.PwAAgent.agent.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BESA.SocialRobot.BDIAgent.BeliefAgent.InteractionState.InteractionContext.ServiceContext;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public abstract class UserEvaluableContext extends ServiceContext {
    private List<String> retroValues;
    private static FIS fis = null;

    public UserEvaluableContext() {
        this.retroValues = new ArrayList<>();
        loadFis();
    }

    private static void loadFis() {
        if (fis == null) {
            fis = FIS.load("conf/performance/performance_system.fcl", true);
            if (fis == null) {
                System.err.println("Cannot load FCL file: performance_system");
            }
        }
    }

    public String calculateFeedback(double emotionValence) {
        HashMap<String, Double> resultados = new HashMap<>();
        resultados.put("Cinco", retroValues.stream().filter(retroa -> retroa.equalsIgnoreCase("Cinco")).count() * 5d);
        resultados.put("Cuatro", retroValues.stream().filter(retroa -> retroa.equalsIgnoreCase("Cuatro")).count() * 4d);
        resultados.put("Tres", retroValues.stream().filter(retroa -> retroa.equalsIgnoreCase("Tres")).count() * 3d);
        resultados.put("Dos", retroValues.stream().filter(retroa -> retroa.equalsIgnoreCase("Dos")).count() * 2d);
        resultados.put("Uno", retroValues.stream().filter(retroa -> retroa.equalsIgnoreCase("Uno")).count() * 1d);
        double average = resultados.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        double factor = calculateEvaluableFactor(emotionValence, average);
        updateTasteForRelatedObjs(factor);
        return factor > 0.5 ? "Positive" : "Negative";
    }

    public abstract void updateTasteForRelatedObjs(double factor);

    public List<String> getRetroValues() {
        return retroValues;
    }

    public void setRetroValues(List<String> retroValues) {
        this.retroValues = retroValues;
    }

    private static double calculateEvaluableFactor(double emotionValence, double feedback) {
        loadFis();
        // Set input values
        fis.setVariable("emotions", emotionValence);
        fis.setVariable("feedback", feedback);

        // Evaluate the fuzzy rules
        fis.evaluate();
        FunctionBlock functionBlock = fis.getFunctionBlock("performance_system");
        return functionBlock.getVariable("PerformanceLevel").getValue();
    }
}
