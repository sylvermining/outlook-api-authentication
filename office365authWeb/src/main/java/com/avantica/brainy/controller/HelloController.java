package com.avantica.brainy.controller;

import com.avantica.brainy.model.BodyToken;
import com.avantica.brainy.session.SessionContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by max.macalupu on 31/05/2016.
 */
@RestController
public class HelloController {

    private String message = "Hello World";

    @RequestMapping("/")
    public String index() {
        message.toString();
        return "index";
    }

    @RequestMapping("/jsontest")
    public @ResponseBody Map<String, String> callSomething () {
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", "http://www.avantica.net");
        return map;
    }

    @RequestMapping("/sessioninfo")
    public @ResponseBody BodyToken getSessionInfo(@RequestParam(value="oid", required=true) String oid){
        return SessionContext.getSession(oid);
    }
}