package com.example.onlinecomplaint_backend.controller;

import com.example.onlinecomplaint_backend.dao.UserDao;
import com.example.onlinecomplaint_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OnlineComplaintController {

    @Autowired
    UserDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String Homepage(){
        return "WELCOME TO MY WEBSITE";
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userregistration", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserRegistration(@RequestBody UserModel u){
        dao.save(u);
        HashMap<String, String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel u){

        String email=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());
        List<UserModel> result=(List<UserModel>) dao.userLogin(email, password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profileview",consumes = "application/json",produces = "application/json")
    public List<UserModel> ProfileView(@RequestBody UserModel u)
    {
        return (List<UserModel>) dao.profileView(u.getId());

    }

}
