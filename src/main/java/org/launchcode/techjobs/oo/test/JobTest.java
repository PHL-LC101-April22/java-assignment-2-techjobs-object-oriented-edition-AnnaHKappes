package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job_test1 = new Job();
        Job job_test2 = new Job();
        assertNotEquals(job_test1.getId(), job_test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Employer employer_test = new Employer("ACME");
        Location location_test = new Location("Desert");
        PositionType positionType_test = new PositionType("Quality control");
        CoreCompetency coreCompetency_test = new CoreCompetency("Persistence");
        Job job_test3 = new Job("Product tester", employer_test, location_test, positionType_test, coreCompetency_test);

        assertEquals("Product tester", job_test3.getName());
        assertEquals("ACME", job_test3.getEmployer().getValue());
        assertEquals("Desert", job_test3.getLocation().getValue());
        assertEquals("Quality control", job_test3.getPositionType().getValue());
        assertEquals("Persistence", job_test3.getCoreCompetency().getValue());

        assertTrue(employer_test instanceof Employer);
        assertTrue(location_test instanceof Location);
        assertTrue(positionType_test instanceof PositionType);
        assertTrue(coreCompetency_test instanceof CoreCompetency);
        assertTrue(job_test3 instanceof Job);
    }

    @Test
    public void testJobsForEquality(){
        Job job_test4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job_test5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job_test4.getId() == job_test5.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job_test6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job_test6.toString().charAt(0));
        assertEquals('\n', job_test6.toString().charAt(job_test6.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job_test7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job_test7.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", job_test7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job_test8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + job_test8.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", job_test8.toString());
    }
}
