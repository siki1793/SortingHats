package com.saikrishna.vedantu.shm.model;

import com.saikrishna.vedantu.shm.enums.FoodPreferences;

// hold student data
public class Student {

    private Integer rollNo;
    private String classRoom;
    private FoodPreferences foodPreferences;

    // student bulder pattern to create the student object
    public static class StudentBuilder {
        private Integer rollNo;
        private String classRoom;
        private FoodPreferences foodPreferences;
        public static StudentBuilder newInstance()
        {
            return new StudentBuilder();
        }
        private StudentBuilder() {}
        public StudentBuilder rollNo(Integer id)
        {
            this.rollNo = id;
            return this;
        }
        public StudentBuilder classRoom(String classRoom)
        {
            this.classRoom = classRoom;
            return this;
        }
        public StudentBuilder foodPreferences(FoodPreferences foodPreferences)
        {
            this.foodPreferences = foodPreferences;
            return this;
        }
        public Student build()
        {
            return new Student(this);
        }
    }

    public Student(StudentBuilder builder)
    {
        this.rollNo = builder.rollNo;
        this.classRoom = builder.classRoom;
        this.foodPreferences = builder.foodPreferences;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public FoodPreferences getFoodPreferences() {
        return foodPreferences;
    }

    public void setFoodPreferences(FoodPreferences foodPreferences) {
        this.foodPreferences = foodPreferences;
    }

    @Override
    public String toString()
    {
        return "rollNo = " + this.rollNo + ", classRoom = " + this.classRoom +
                ", foodPreferences = " + this.foodPreferences;
    }

}
