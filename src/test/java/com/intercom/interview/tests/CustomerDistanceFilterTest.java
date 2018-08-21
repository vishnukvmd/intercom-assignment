package com.intercom.interview.tests;

import com.intercom.interview.assignment.filters.CustomerDistanceFilter;
import com.intercom.interview.assignment.models.CustomerRecord;
import com.intercom.interview.assignment.models.Location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerDistanceFilterTest {
    private final Location sourceLocation = new Location(28.564188060311675, 77.1939073787088);
    private final CustomerDistanceFilter customerDistanceFilter = new CustomerDistanceFilter(sourceLocation, 10);

    @Test
    public void testNearbyCustomer() {
        CustomerRecord nearByCustomer = new CustomerRecord(1, "Nearby Customer", new Location(28.5655129, 77.1917786));
        assertEquals(customerDistanceFilter.test(nearByCustomer), true);
    }

    @Test
    public void testFarawayCustomer() {
        CustomerRecord farAwayCustomer = new CustomerRecord(1, "Faraway Customer", new Location(27.1750151, 78.0399665));
        assertEquals(customerDistanceFilter.test(farAwayCustomer), false);
    }
}
