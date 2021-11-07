package com.saikrishna.vedantu.shm;

import com.saikrishna.vedantu.shm.model.SortingHat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SHM {
    public static void main(String[] args) throws IOException {
//        readFromConsole();
        staticTesting();
        staticTesting1();


    }

    private static void staticTesting1() {
        System.out.println("----------------------");
        SortingHat sortingHat = new SortingHat(12);
        addStudent(sortingHat,1,"B","V");
        addStudent(sortingHat,2,"A","V");
        addStudent(sortingHat,3,"A","V");
        addStudent(sortingHat,4,"B","NV");
        addStudent(sortingHat,5,"B","V");
        addStudent(sortingHat,6,"A","NV");
        addStudent(sortingHat,7,"A","V");
        addStudent(sortingHat,8,"A","NV");
        addStudent(sortingHat,9,"B","NV");
        addStudent(sortingHat,10,"B","V");
        addStudent(sortingHat,11,"A","NV");
        addStudent(sortingHat,12,"B","NV");
        addStudent(sortingHat,13,"A","NV");
        sortingHat.getStudentsBoardingHouse();
        System.out.println("----------------------");
    }

    private static void staticTesting() {
        System.out.println("----------------------");
        SortingHat sortingHat = new SortingHat(12);
        addStudent(sortingHat,1,"B","V");
        addStudent(sortingHat,2,"A","V");
        addStudent(sortingHat,3,"A","V");
        addStudent(sortingHat,4,"B","NV");
        addStudent(sortingHat,5,"B","V");
        addStudent(sortingHat,6,"A","NV");
        addStudent(sortingHat,7,"A","V");
        addStudent(sortingHat,8,"A","NV");
        addStudent(sortingHat,9,"B","NV");
        addStudent(sortingHat,10,"B","V");
        addStudent(sortingHat,11,"A","NV");
        addStudent(sortingHat,12,"B","NV");
        sortingHat.getStudentsBoardingHouse();
        System.out.println("----------------------");
    }

    private static void addStudent(SortingHat sortingHat, int i, String c, String f) {
        try {
            sortingHat.registerStudent(i,c,f);
        } catch (Exception ex) {
            System.out.printf("Error: "+ex.getMessage());
        }
    }

    private static void readFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int capacity = Integer.parseInt(input[1]);
        SortingHat sortingHat = new SortingHat(capacity);
        while (capacity-->0){
            String[] regStudent = br.readLine().split(" ");
            try {
                sortingHat.registerStudent(Integer.parseInt(regStudent[1]),regStudent[2],regStudent[3]);
            } catch (Exception ex) {
                System.out.printf("Error: "+ex.getMessage());
            }
        }
        sortingHat.getStudentsBoardingHouse();
    }
}
