package com.example.onlinecomplaint_backend.controller;

import com.example.onlinecomplaint_backend.dao.ComplaintDao;
import com.example.onlinecomplaint_backend.model.ComplaintModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ComplaintController {

    @Autowired
    ComplaintDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "addcomplaint", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> AddComplaint(@RequestBody ComplaintModel c){

        dao1.save(c);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}
