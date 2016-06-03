package com.avantica.brainy.controller;

import com.avantica.brainy.model.ParametersEnum;
import com.avantica.brainy.model.RequestInfo;
import com.avantica.brainy.session.RequestSessionContext;
import com.avantica.brainy.utiles.FactoryUtiles;
import com.avantica.brainy.utiles.QueryString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@PermitAll
@Controller
public class RedirectAuth{

	@RequestMapping(value = "/redirectAuth", method = RequestMethod.GET)
	public String firstAuthRedirec(HttpServletRequest request, HttpServletResponse response,
								   @RequestParam(value = "appID") String appID) {

		String sessionID = request.getSession().getId();
		RequestInfo info = FactoryUtiles.buildRequestInfo(sessionID,appID);
		RequestSessionContext.nuevo(info);
		return "redirect:" +generateCompleteURL(info);
	}

	private String generateCompleteURL(RequestInfo info){
		return  QueryString.withDomain(ParametersEnum.TOKEN_LOGIN.getCodigo())
				.andParameter(ParametersEnum.CLIEND_ID)
				.andParameter(ParametersEnum.REDIRECT)
				.andParameter(ParametersEnum.AUTHORIZ)
				.andParameter(ParametersEnum.SCOPE)
				.andParameter(ParametersEnum.RESPONSE_TYPE_TOKEN)
				.andParameter(ParametersEnum.RESPONSE_MODE)
				.giveMeURL();
	}
}