package com.besa.PwAAgent.pepper.adapter;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Map;

@JsonPropertyOrder({ "id", "proxyName", "methodName", "params" })
public class PepperSendable implements Serializable {

    private double id;
    private String proxyName;
    private String methodName;
    private Map<String, ?> params;

    public PepperSendable(double id, String proxyName, String methodName, Map<String, ?> params) {
        this.proxyName = proxyName;
        this.methodName = methodName;
        this.id = id;
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Map<String, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, ?> params) {
        this.params = params;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

}
