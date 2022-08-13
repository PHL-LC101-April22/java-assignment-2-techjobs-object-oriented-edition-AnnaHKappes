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
    public void testJobConstructorSetsAllFields(){
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

    }

}
