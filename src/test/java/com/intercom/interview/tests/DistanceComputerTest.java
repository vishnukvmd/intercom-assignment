package com.intercom.interview.tests;

import com.intercom.interview.test.DistanceComputer;
import com.intercom.interview.test.models.Location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceComputerTest {
    private static final Location LOCATION_ONE = new Location(28.5792594, 77.1897742);
    private static final Location LOCATION_TWO = new Location(28.5681599, 77.1879428);

    @Test
    public void testForSameLocation() {
        assertEquals(DistanceComputer.computeDistance(LOCATION_ONE, LOCATION_ONE), 0, 0);
    }

    @Test
    public void testForDifferentLocations() {
        assertEquals(DistanceComputer.computeDistance(LOCATION_ONE, LOCATION_TWO), 1.2471, 0.0001);
    }
}
