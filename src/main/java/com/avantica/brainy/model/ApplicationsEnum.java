package com.avantica.brainy.model;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationsEnum {

	BRAINY_AUTH_CLIENT("brainy.auth.client.pk", "App de pruebas","https://localhost:9090/sessioninfo?oid="),
    BRAINY_WEB_APP_CLIENT("brainy.web.app.client.pk", "Web App for testing","https://localhost:9090/somepath?oid=");

	private String code;
	private String redirectURL;
	private String description;

	ApplicationsEnum(final String code, final String description, final String redirectURL) {
		this.code = code;
		this.description = description;
		this.redirectURL = redirectURL;
	}

	private static Map<String,ApplicationsEnum> mapWithData = new HashMap<>();

	static {
		for(ApplicationsEnum param: ApplicationsEnum.values()){
			mapWithData.put(param.code,param);
		}
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public static  ApplicationsEnum findByCode(String code){
		return mapWithData.get(code);
	}

    public static boolean containsKey(String key) {
        return mapWithData.containsKey(key);
    }
}