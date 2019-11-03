package com.infra.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/root")
public class DemoController {

    @RequestMapping(value = "/work",method = RequestMethod.GET,produces = "text/plain")
    public String working(){
        return "8081";
    }
    @RequestMapping(value = "/feed-master",method = RequestMethod.GET,produces = "text/plain")
    public String workingFeed(){
        return "8081";
    }

    @RequestMapping(value = "/feed-master/demo/demo",method = RequestMethod.GET,produces = "text/plain")
    public String workingFeedDEMO(){
        return "8081";
    }

}
