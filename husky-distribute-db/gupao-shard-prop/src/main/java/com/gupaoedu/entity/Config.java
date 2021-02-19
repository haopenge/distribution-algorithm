package com.gupaoedu.entity;

public class Config {
    private Integer configId;

    private String paraName;

    private String paraValue;

    private String paraDesc;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName == null ? null : paraName.trim();
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue == null ? null : paraValue.trim();
    }

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc == null ? null : paraDesc.trim();
    }

    @Override
    public String toString() {
        return " -------- Config {" +
                "configId=" + configId +
                ", paraName='" + paraName + '\'' +
                ", paraValue='" + paraValue + '\'' +
                ", paraDesc='" + paraDesc + '\'' +
                '}';
    }
}