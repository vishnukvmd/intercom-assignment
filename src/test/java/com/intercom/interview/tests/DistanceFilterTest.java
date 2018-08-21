package com.intercom.interview.tests;

import com.intercom.interview.test.filters.DistanceFilter;
import com.intercom.interview.test.models.Customer;
import com.intercom.interview.test.models.Location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceFilterTest {
    private final Location sourceLocation = new Location(28.564188060311675, 77.1939073787088);
    private final DistanceFilter distanceFilter = new DistanceFilter(sourceLocation, 10);

    @Test
    public void testNearbyCustomer() {
        Customer nearByCustomer = new Customer(1, "Nearby Customer", new Location(28.5655129, 77.1917786));
        assertEquals(distanceFilter.test(nearByCustomer), true);
    }

    @Test
    public void testFarawayCustomer() {
        Customer farAwayCustomer = new Customer(1, "Faraway Customer", new Location(27.1750151, 78.0399665));
        assertEquals(distanceFilter.test(farAwayCustomer), false);
    }
}