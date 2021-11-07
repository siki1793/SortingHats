package com.saikrishna.vedantu.shm.model;

import com.saikrishna.vedantu.shm.enums.FoodPreferences;

import java.util.*;

public class SortingHat {

    // capacity to hold the total number of rooms
    private Integer houseCapacity;
    // map to hold class room and food preferences and list of students in fifo
    private Map<String, LinkedList<Student>> boardingHouse;
    // map to hold if the user is already present then dont allow to override the student details
    private Map<Integer, Student> studentMap;

    public SortingHat(Integer houseCapacity) {
        this.houseCapacity = houseCapacity;
        this.boardingHouse = new HashMap<>();
        this.studentMap = new HashMap<>();
        checkIfNotRegisteredStudentIsEmpty();
    }

    public Integer getHouseCapacity() {
        return houseCapacity;
    }

    public Map<String, LinkedList<Student>> getBoardingHouse() {
        return boardingHouse;
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    private void validate(Integer rollNo, String classRoom, FoodPreferences foodPreferences, Boolean[] isStudentExist) throws Exception {
        if (Objects.isNull(foodPreferences)) throw new Exception("Invalid Food Preference");
        if (Objects.isNull(rollNo) || String.valueOf(rollNo).length() > 4) throw new Exception("Invalid roll null");
        if (studentMap.containsKey(rollNo)) {
            isStudentExist[0] = true;
            return;
        }

    }

    private void addToHouseCapacity(){
        this.houseCapacity -= 1;
    }

    private void putStudentToMap(Student student) {
        this.studentMap.put(student.getRollNo(),student);
    }

    public void registerStudent(Integer rollNo, String classRoom, String foodPreferences) throws Exception {
        FoodPreferences foodPreferencesEnum = FoodPreferences.getFoodPreferences(foodPreferences);
        Boolean[] isStudentExist = new Boolean[1];
        isStudentExist[0] = false;
        validate(rollNo, classRoom, foodPreferencesEnum, isStudentExist);
        if (isStudentExist[0]) return;
        addToHouseCapacity();
        Student newStudent = Student.StudentBuilder.newInstance()
                .rollNo(rollNo)
                .classRoom(classRoom)
                .foodPreferences(foodPreferencesEnum).build();
        putStudentToMap(newStudent);
        if(checkHouseCapacity()) {
            houseCapacityStudentNotRegistered(newStudent);
        } else {
            setStudentSortMap(newStudent);
        }

    }

    private void setStudentSortMap(Student newStudent) {
        String classRoomFoodPreferenceCombo = getClassRoomFoodPreferenceCombo(newStudent.getClassRoom().toUpperCase(),newStudent.getFoodPreferences());
        LinkedList<Student> studentList = this.boardingHouse.getOrDefault(classRoomFoodPreferenceCombo, new LinkedList<>());
        studentList.add(newStudent);
        this.boardingHouse.put(classRoomFoodPreferenceCombo,studentList);
    }

    public void getStudentsBoardingHouse() {
        for(Map.Entry<String,LinkedList<Student>> studentListSet: this.boardingHouse.entrySet()){
            String studentListString = getStudentListString(studentListSet.getValue());
            System.out.println(studentListSet.getKey()+" : "+studentListString);
        }
    }

    private String getStudentListString(LinkedList<Student> studentList) {
        StringBuilder studentListString = new StringBuilder();
        studentListString.append("[");
        for(int i=0;i<studentList.size();i++) {
            studentListString.append(studentList.get(i).getRollNo());
            if(i<studentList.size()-1)
                studentListString.append(",");
        }
        studentListString.append("]");
        return studentListString.toString();
    }

    private void checkIfNotRegisteredStudentIsEmpty() {
        if(!this.boardingHouse.containsKey("NA")) {
            this.boardingHouse.put("NA",new LinkedList<>());
        }
    }

    private String getClassRoomFoodPreferenceCombo(String classRoom, FoodPreferences foodPreferencesEnum) {
        StringBuilder classRoomFoodPreferenceComboBuilder = new StringBuilder();
        classRoomFoodPreferenceComboBuilder.append(classRoom).append(foodPreferencesEnum.name());
        return classRoomFoodPreferenceComboBuilder.toString();
    }

    //Default Non Registered Students and since its FIFO using linked list if remove student is required.
    private void houseCapacityStudentNotRegistered(Student student) {
        LinkedList<Student> studentList = this.boardingHouse.getOrDefault("NA", new LinkedList<>());
        studentList.add(student);
        this.boardingHouse.put("NA" , studentList);
    }

    private boolean checkHouseCapacity() {
        return this.houseCapacity<0;
    }


}
