package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@Document(collection = "schoolCatalogue")

public class SchoolCatalogue {
    @Id
    private String schoolId;
    private String schoolName;
    private String schoolLocation;
    private String schoolPrincipleName;

    public SchoolCatalogue(){

    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getSchoolPrincipleName() {
        return schoolPrincipleName;
    }

    public void setSchoolPrincipleName(String schoolPrincipleName) {
        this.schoolPrincipleName = schoolPrincipleName;
    }
}
