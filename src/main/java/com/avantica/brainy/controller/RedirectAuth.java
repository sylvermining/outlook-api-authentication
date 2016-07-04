package com.avantica.brainy.controller;

import com.avantica.brainy.enums.AuthorizeParametersEnum;
import com.avantica.brainy.model.ApplicationsEnum;
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

@PermitAll
@Controller
public class RedirectAuth {

    @RequestMapping(value = "/redirectAuth", method = RequestMethod.GET)
    public String firstAuthRedirect(HttpServletRequest request, @RequestParam(value = "appID") String appID) {
        String sessionID = request.getSession().getId();
        RequestInfo info = FactoryUtiles.buildRequestInfo(sessionID, appID);
        RequestSessionContext.nuevo(info);
        return "redirect:" + generateCompleteURL();
    }

    @RequestMapping(value = "/redirectOutlookAuth", method = RequestMethod.GET)
    public String secondAuthRedirect(HttpServletRequest request, @RequestParam(value = "appID") String appID) {
        if(ApplicationsEnum.containsKey(appID)) {
            return "redirect:http://www.google.com";
        }
        return "redirect:" + generateCompleteOutlookURL(appID);
    }


    private String generateCompleteURL() {
        return QueryString.withDomain(ParametersEnum.TOKEN_LOGIN.getCodigo())
                .andParameter(ParametersEnum.CLIEND_ID)
                .andParameter(ParametersEnum.REDIRECT)
                .andParameter(ParametersEnum.AUTHORIZ)
                .andParameter(ParametersEnum.SCOPE)
                .andParameter(ParametersEnum.RESPONSE_TYPE_TOKEN)
                .andParameter(ParametersEnum.RESPONSE_MODE)
                .giveMeURL();
    }

    private String generateCompleteOutlookURL(String clientID) {
        return QueryString.withDomain(
                AuthorizeParametersEnum.AUTHORIZE_PATH.getParameterCode())
                .andParameter(AuthorizeParametersEnum.REDIRECT_URI)
                .andParameter(AuthorizeParametersEnum.GRANT_TYPE)
                .andParameter(AuthorizeParametersEnum.RESPONSE_MODE)
                .andParameter(AuthorizeParametersEnum.SCOPE)
                .andParameter(AuthorizeParametersEnum.CLIENT_ID)
                .andParameter(AuthorizeParametersEnum.RESPONSE_TYPE)
                .andParameter(AuthorizeParametersEnum.STATE.getParameterCode(), clientID)
                .giveMeURL();
    }
}