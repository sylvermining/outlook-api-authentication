package com.avantica.brainy.model;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationsEnum {

	BRAINY_AUTH_CLIENT("brainy.auth.client.pk", "App de pruebas","http://authclientserver.com:8080/authclient/welcome.jsp?id=");

	private String codigo;
	private String redirectURL;
	private String descripcion;

	ApplicationsEnum(final String codigo, final String descripcion, final String redirectURL) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.redirectURL = redirectURL;
	}


	private static Map<String,ApplicationsEnum> mapWithData = new HashMap<>();
	static {
		for(ApplicationsEnum param: ApplicationsEnum.values()){
			mapWithData.put(param.codigo,param);
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public static  ApplicationsEnum findByCode(String codigo){
		return mapWithData.get(codigo);
	}
}