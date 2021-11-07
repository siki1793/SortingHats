package com.saikrishna.vedantu.shm;

import com.saikrishna.vedantu.shm.model.SortingHat;
import com.saikrishna.vedantu.shm.model.Student;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.*;

public class SortingHatTests {

    public static Object[][] sampleData1() {
        return new Object[][] {
                { 1 , "B", "V" },
                { 2 , "A", "V" },
                { 3 , "A", "V" },
                { 4 , "B", "NV" },
                { 5 , "B", "V" },
                { 6 , "A", "NV" },
                { 7 , "A", "V" },
                { 8 , "A", "NV" },
                { 9 , "B", "NV" },
                { 10 , "B", "V" },
                { 11 , "A", "NV" },
                { 12 , "B", "NV" }
        };
    }

    public static Object[][] sampleData2() {
        return new Object[][] {
                { 1 , "B", "V" },
                { 2 , "A", "V" },
                { 3 , "A", "V" },
                { 4 , "B", "NV" },
                { 5 , "B", "V" },
                { 6 , "A", "NV" },
                { 7 , "A", "V" },
                { 8 , "A", "NV" },
                { 9 , "B", "NV" },
                { 10 , "B", "V" },
                { 11 , "A", "NV" },
                { 12 , "B", "NV" },
                { 13 , "A", "NV" }
        };
    }
    @Test
    public void checkHouseCapacity() {
        SortingHat sortingHat = new SortingHat(12);
        assertTrue(sortingHat.getHouseCapacity()==12);
    }
    @Test
    public void fillSortingHatForSchoolHostelEqualCapacity() {
        Object[][] sampleData = sampleData1();
        SortingHat sortingHat = new SortingHat(sampleData.length);
        for(Object[] data: sampleData) {
            try {
                sortingHat.registerStudent((Integer)data[0],data[1].toString(),data[2].toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LinkedList<Student> bvList = sortingHat.getBoardingHouse().get("BV");
        LinkedList<Student> avList = sortingHat.getBoardingHouse().get("AV");
        LinkedList<Student> bnvList = sortingHat.getBoardingHouse().get("BNV");
        LinkedList<Student> anvList = sortingHat.getBoardingHouse().get("ANV");
        assertEquals(1, bvList.get(0).getRollNo().intValue());
        assertEquals(3, avList.get(1).getRollNo().intValue());
        assertEquals(12, bnvList.get(2).getRollNo().intValue());
        assertEquals(11, anvList.get(2).getRollNo().intValue());
    }
    @Test
    public void fillSortingHatForSchoolHostelCapacityFull() {
        Object[][] sampleData = sampleData2();
        SortingHat sortingHat = new SortingHat(sampleData.length-1);
        for(Object[] data: sampleData) {
            try {
                sortingHat.registerStudent((Integer)data[0],data[1].toString(),data[2].toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LinkedList<Student> naList = sortingHat.getBoardingHouse().get("NA");
        assertNotNull(naList);
        assertEquals(1, naList.size());
    }
}
