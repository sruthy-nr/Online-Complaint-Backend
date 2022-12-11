package com.example.onlinecomplaint_backend.dao;

import com.example.onlinecomplaint_backend.model.ComplaintModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintDao extends CrudRepository<ComplaintModel,Integer> {

    @Query(value = "SELECT `id`, `complaint`, `userid` FROM `complaint` WHERE `userid`= :userid",nativeQuery = true)
    public List<ComplaintModel> userViewComplaint(@Param("userid") int userid);
}
