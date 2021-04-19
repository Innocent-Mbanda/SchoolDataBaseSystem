package com.example.demo.controllers;

import com.example.demo.model.SchoolCatalogue;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
 @PostMapping("/school")
    public ResponseEntity<SchoolCatalogue>createSchool( @RequestBody SchoolCatalogue schoolData){
        return new ResponseEntity<>(schoolService.createSchool(schoolData), HttpStatus.OK);
    }

    @GetMapping("schools")

    public List<SchoolCatalogue>getAllSchools(){
     return schoolService.getAllSchools();
    }
   @GetMapping("schools/{id}")
    public ResponseEntity<Optional<SchoolCatalogue>>getSchoolById(@PathVariable String id){
     return new ResponseEntity<>(schoolService.getSchoolById(id),HttpStatus.OK);
    }

    @DeleteMapping("school/{id}")
  public ResponseEntity<String > deleteSchoolById
          (@PathVariable String id, SchoolCatalogue schoolCatalogue){
     if (schoolService.deleteSchoolById(id)){
         return new ResponseEntity<>("School deleted",HttpStatus.OK);
     }else {
         return new ResponseEntity<>("School does not exist",HttpStatus.OK);
     }

  }

 public ResponseEntity<String>updateSchoolById(@PathVariable String id, SchoolCatalogue schoolCatalogue){
     if(schoolService.updateSchoolById(id,schoolCatalogue)){
         return new ResponseEntity<String>("Successful",HttpStatus.OK);


     } else {
         return  new ResponseEntity<>("Not successful",HttpStatus.OK);
     }
 }
}
