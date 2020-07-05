package com.example.kristalai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kristalai.pojo.RandomNumberResponse;
import com.example.kristalai.service.ListenEntriesService;
import com.example.kristalai.service.ListenEntriesServiceImpl;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class RESTAPIController {
    private ListenEntriesService entries;

    @Autowired
    public RESTAPIController(ListenEntriesService entries) {
        this.entries = entries;
    }

    @GetMapping(path = "/getvalues")
    public RandomNumberResponse listenEntries(HttpServletResponse response){
        RandomNumberResponse result= entries.checkDB();

        if(result.getMessage().equals("Success")){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        return result;
    }

}
