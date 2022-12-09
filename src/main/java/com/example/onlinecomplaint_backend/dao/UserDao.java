package com.example.onlinecomplaint_backend.dao;

import com.example.onlinecomplaint_backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `cpassword`, `email`, `name`, `password`, `phone` FROM `user` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    public List<UserModel> userLogin(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `cpassword`, `email`, `name`, `password`, `phone` FROM `user` WHERE `id`= :id",nativeQuery = true)
    public  List<UserModel> profileView(@Param("id") Integer id);
}
