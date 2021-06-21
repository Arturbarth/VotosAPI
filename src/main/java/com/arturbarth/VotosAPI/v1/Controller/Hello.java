package com.arturbarth.VotosAPI.v1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(value = "/Hello", method = RequestMethod.GET)
    public String hello() {
        return "Olá teste";
    }
}
