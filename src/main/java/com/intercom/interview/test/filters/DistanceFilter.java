package com.intercom.interview.test.filters;

import com.intercom.interview.test.models.Customer;
import com.intercom.interview.test.models.Location;

import java.util.function.Predicate;

import static com.intercom.interview.test.DistanceComputer.computeDistance;

public class DistanceFilter implements Predicate<Customer> {
    private final Location location;
    private final long radiusInKms;

    public DistanceFilter(Location sourceLocation, long radiusInKms) {
        this.location = sourceLocation;
        this.radiusInKms = radiusInKms;
    }

    @Override
    public boolean test(Customer customer) {
        return computeDistance(location, customer.location) <= radiusInKms;
    }
}
