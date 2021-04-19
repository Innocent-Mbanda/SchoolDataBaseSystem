package com.example.demo.repostories;

import com.example.demo.model.SchoolCatalogue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends MongoRepository<SchoolCatalogue,String> {

}
