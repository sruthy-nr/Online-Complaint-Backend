package com.example.onlinecomplaint_backend.controller;

import com.example.onlinecomplaint_backend.dao.ComplaintDao;
import com.example.onlinecomplaint_backend.model.ComplaintModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallcomplaint")
    public List<ComplaintModel> ViewComplaint(){

        return (List<ComplaintModel>) dao1.findAll();
    }

    @CrossOrigin("*")
    @PostMapping(path = "/userviewcomplaint", consumes = "application/json", produces = "application/json")
    public List<ComplaintModel> UserViewComplaint(@RequestBody ComplaintModel c){

        return (List<ComplaintModel>) dao1.userViewComplaint(c.getUserid());
    }

}
