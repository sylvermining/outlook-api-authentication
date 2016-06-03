package com.avantica.brainy.controller;

import com.avantica.brainy.model.ApplicationsEnum;
import com.avantica.brainy.model.BodyToken;
import com.avantica.brainy.session.SessionContext;
import com.avantica.brainy.utiles.DecodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = "/autenticate", method = RequestMethod.POST)
	public String autenticate(@RequestParam(value="access_token", required=false) String access_token,
							  @RequestParam(value="scope", required=false) String scope) {
		BodyToken tokenInfo = DecodeUtil.decodeToken(access_token);
		SessionContext.nuevo(tokenInfo);
		return "redirect:" +ApplicationsEnum.BRAINY_AUTH_CLIENT.getRedirectURL()+tokenInfo.getOid();
	}
}