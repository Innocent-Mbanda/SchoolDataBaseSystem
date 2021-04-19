package com.example.demo.services;

import com.example.demo.model.SchoolCatalogue;
import com.example.demo.repostories.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    private RestTemplate restTemplate;
    private String url ="http://localhost:5000/api/v1/course";

@Autowired
    private SchoolRepo schoolRepo;

   public SchoolCatalogue createSchool(SchoolCatalogue schoolInfo){
       return schoolRepo.save(schoolInfo);
   }

public List<SchoolCatalogue>getAllSchools(){
       return schoolRepo.findAll();
}

public Optional<SchoolCatalogue> getSchoolById(String id){
       return schoolRepo.findById(id);
}

public Boolean deleteSchoolById(String id){
       Optional<SchoolCatalogue>isSchoolAvailable =schoolRepo.findById(id);
       if (isSchoolAvailable.isPresent()){
            schoolRepo.deleteById(id);
            return true;

       }else {
           return false;
       }
}

public Boolean updateSchoolById(String id, SchoolCatalogue schoolCatalogue){

       Optional<SchoolCatalogue>isSchoolAvailable = schoolRepo.findById(id);
       if (isSchoolAvailable.isPresent()){
           SchoolCatalogue schoolData = isSchoolAvailable.get();

           schoolData.setSchoolName(schoolCatalogue.getSchoolName());
           schoolData.setSchoolLocation(schoolCatalogue.getSchoolLocation());
           schoolData.setSchoolPrincipleName(schoolCatalogue.getSchoolPrincipleName());
           schoolRepo.save(schoolData);
           return true;
       }
       else {
           return false;
       }
}







}
