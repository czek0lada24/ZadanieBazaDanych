package com.example.zadaniebazadanych;


public class Student {
    private int _id;
    private String _studentname;
    private String _v3;


    public Student(int id, String studentname, String v3) {
        this._id = id;
        this._studentname = studentname;
        this._v3=v3;
    }

    public Student() {

    }

    /**********************/
    public void setID(int id) {
        this._id = id;
    }
    public int getID() {
        return this._id;
    }

    /**********************/
    public void setStudentName(String studentname) {
        this._studentname = studentname;
    }
    public String getStudentName() {
        return this._studentname;
    }
    /**********************/
    public void setVV3(String v3) {
        this._v3 = v3;
    }
    public String getVV3() {
        return this._v3;
    }






}

