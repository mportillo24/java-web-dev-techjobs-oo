package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job newJob;
    Job secondJob;

    @Before
    public void createJob() {
        newJob = new Job();
        secondJob = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(secondJob.getId() == newJob.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product control", new Employer("ACME"), new Location("Mountain"), new PositionType("Quality assurance"), new CoreCompetency("Fun"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testJobsForToString() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob1.toString(), testJob1.toString());
    }

    @Test
    public void testJobsToStringPrintsAllData() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: " + testJob1.getId() + "\n" +
                "Name: " + testJob1.getName() + "\n" +
                "Employer: " + testJob1.getEmployer() + "\n" +
                "Location: " + testJob1.getLocation() + "\n" +
                "Position Type: " + testJob1.getPositionType() + "\n" +
                "Core Competency: " + testJob1.getCoreCompetency() + "\n",
                testJob1.toString());
    }

    @Test
    public void testJobsToStringHasEmptyField() {
        Job testJob1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: " + testJob1.getId() + "\n" +
                "Name: " + testJob1.getName() + "\n" +
                "Employer: Data Not Available" + "\n" +
                "Location: " + testJob1.getLocation() + "\n" +
                "Position Type: " + testJob1.getPositionType() + "\n" +
                "Core Competency: " + testJob1.getCoreCompetency() + "\n", testJob1.toString());
    }
}
