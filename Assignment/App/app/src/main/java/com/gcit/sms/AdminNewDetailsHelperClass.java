package com.gcit.sms;

public class AdminNewDetailsHelperClass {
    private String name, employeeid, email, phoneNo, course, standard, fileUri;
    public AdminNewDetailsHelperClass(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public AdminNewDetailsHelperClass(String name, String employeeid, String email, String phoneNo, String course, String standard, String fileUri){
        this.name = name;
        this.employeeid = employeeid;
        this.email = email;
        this.phoneNo = phoneNo;
        this.course = course;
        this.standard = standard;
        this.fileUri = fileUri;
    }
}
