package com.avantica.brainy.session;

import com.avantica.brainy.model.BodyToken;

import java.util.HashMap;


public class SessionContext extends HashMap<String, BodyToken>{

	private static final long serialVersionUID = 1L;
	private static SessionContext sessionContext;
	
	private SessionContext(){
		super();
	}
	
	private static SessionContext getInstance(){
		if( sessionContext == null){
			sessionContext = new SessionContext();
		}
		return sessionContext;
	}

	public synchronized static void nuevo(BodyToken info){
		getInstance().put(info.getOid(), info);
	}
	
	public static BodyToken getSession(String key){
		return getInstance().get(key);
	}
}