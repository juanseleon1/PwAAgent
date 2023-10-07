package com.besa.PwAAgent.pepper.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Map;

@JsonPropertyOrder({ "id", "proxyName", "methodName", "params" })
public class PepperSendable implements Serializable {

    private double id;
    private String proxyName;
    private String methodName;
    private Map<String, Object> params;

    public PepperSendable() {
    }

    public PepperSendable(double id, String proxyName, String methodName, Map<String, Object> params) {
        this.proxyName = proxyName;
        this.methodName = methodName;
        this.id = id;
        this.params = params;
    }

    @JsonProperty("id")
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @JsonProperty("proxyName")
    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    @JsonProperty("methodName")
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @JsonProperty("params")
    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PepperSendable [id=" + id + ", proxyName=" + proxyName + ", methodName=" + methodName + ", params="
                + params + "]";
    }
}
