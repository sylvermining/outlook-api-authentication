package com.avantica.brainy.enums;

public enum AuthorizeTokenParameterEnum {

    CLIENT_ID("client_id","someValue"),
    CLIENT_SECRETE("client_secret","someValue"),
    CODE("code","someValue");

    private String parameterCode;
    private String parameterValue;

    AuthorizeTokenParameterEnum(final String parameter, final String value) {
        this.parameterCode = parameter;
        this.parameterValue = value;
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public String getParameterValue() {
        return parameterValue;
    }
}
