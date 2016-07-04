package com.avantica.brainy.enums;

public enum AuthorizeParametersEnum {

    AUTHORIZE_PATH("url","https://login.microsoftonline.com/common/oauth2/v2.0/authorize"),
    REDIRECT_URI("redirect_uri","https://localhost:9090/autenticate?clientID="),
    GRANT_TYPE("grant_type","authorization_code"),
    RESPONSE_MODE("response_mode","query"),
    SCOPE("scope","openid+offline_access+profile+https://outlook.office.com/mail.read+https://outlook.office.com/mail.send"),
    CLIENT_ID("client_id","59f79330-4ac5-42d6-8ee1-f189cb710690"),
    RESPONSE_TYPE("response_type","code"),
    STATE("state","someValue");

    private String parameterCode;
    private String parameterValue;

    AuthorizeParametersEnum(final String parameter, final String value) {
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
