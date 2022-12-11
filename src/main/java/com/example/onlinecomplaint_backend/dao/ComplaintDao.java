package com.example.onlinecomplaint_backend.dao;

import com.example.onlinecomplaint_backend.model.ComplaintModel;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao extends CrudRepository<ComplaintModel,Integer> {
}
