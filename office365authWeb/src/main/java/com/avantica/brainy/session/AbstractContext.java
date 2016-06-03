package com.avantica.brainy.session;

import com.avantica.brainy.model.MainSession;

import java.util.HashMap;

/**
 * Created by max.macalupu on 02/06/2016.
 */
public abstract class AbstractContext extends HashMap<String,MainSession>{

//    private static MainSession sessionContext;
//
//    private AbstractContext(){
//        super();
//    }
//
//    private static SessionContext getInstance(){
//        if( sessionContext == null){
//            sessionContext = new MainSession();
//        }
//        return sessionContext;
//    }

    protected  abstract void crearNuevaSession(MainSession mainSession);
}