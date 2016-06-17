package com.avantica.brainy.session;

import com.avantica.brainy.model.RequestInfo;

import java.util.HashMap;


public class RequestSessionContext extends HashMap<String, RequestInfo>{

	private static final long serialVersionUID = 1L;
	private static RequestSessionContext sessionContext;

	private RequestSessionContext(){
		super();
	}
	
	private static RequestSessionContext getInstance(){
		if( sessionContext == null){
			sessionContext = new RequestSessionContext();
		}
		return sessionContext;
	}

	public synchronized static void nuevo(RequestInfo info){
		getInstance().put(info.getSessionId(), info);
	}

}