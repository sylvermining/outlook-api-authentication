package com.avantica.brainy.model;

import java.util.HashMap;
import java.util.Map;

public enum ParametersEnum {
	
	TOKEN_LOGIN("url", "https://login.microsoftonline.com/common/oauth2/v2.0/authorize"),
	CLIEND_ID("client_id", "0640edc0-5c2d-4422-846c-505868ba7e15"),
	AUTHORIZ("grant_type", "authorization_code"),
	RESPONSE_MODE("response_mode", "form_post"),
	RESPONSE_TYPE_TOKEN("response_type", "token"),
	SCOPE("scope", "openid+offline_access+profile+https://outlook.office.com/mail.read+https://outlook.office.com/mail.send"),
	REDIRECT("redirect_uri", "https://brainy-auth.com:9090/autenticate");

	private String descripcion;
	private String codigo;

	ParametersEnum(final String descripcion, final String codigo) {
		this.descripcion = descripcion;
		this.codigo = codigo;
	}


	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

}