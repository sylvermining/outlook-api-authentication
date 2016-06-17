package com.avantica.brainy.controller;

import com.avantica.brainy.model.BodyToken;
import com.avantica.brainy.session.SessionContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionInfoController {

    @RequestMapping("/sessioninfo")
    public @ResponseBody BodyToken getSessionInfo(@RequestParam(value = "oid") String oid) {
        return SessionContext.getSession(oid);
    }
}