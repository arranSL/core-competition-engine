package com.scottlogic.competition_engine.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    public TestController() {}

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }

}
