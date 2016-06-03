package com.avantica.brainy.utiles;

import com.avantica.brainy.model.ApplicationsEnum;
import com.avantica.brainy.model.RequestInfo;

/**
 * Created by max.macalupu on 03/06/2016.
 */
public class FactoryUtiles {

    public static RequestInfo buildRequestInfo(String sessionId, String applicationId){
        ApplicationsEnum appEnum = ApplicationsEnum.findByCode(applicationId);

        if(appEnum == null){
            throw new RuntimeException("Error in getting request");
        }

        RequestInfo information = new RequestInfo();
        information.setAppId(applicationId);
        information.setSessionId(sessionId);
        information.setRedirectUrl(appEnum.getRedirectURL());
        return information;
    }
}