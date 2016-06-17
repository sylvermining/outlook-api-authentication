package com.avantica.brainy.session;

import com.avantica.brainy.model.BodyToken;
import com.avantica.brainy.model.MainSession;

import java.util.HashMap;


public class RequestContext extends AbstractContext{


	@Override
	protected synchronized void crearNuevaSession(MainSession mainSession) {
		String key = mainSession.getID();
		super.put(key,mainSession);
	}
}