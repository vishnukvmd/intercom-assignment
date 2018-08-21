package com.intercom.interview.assignment.filters;

import com.intercom.interview.assignment.models.CustomerRecord;
import com.intercom.interview.assignment.models.Location;

import static com.intercom.interview.assignment.util.DistanceComputer.computeDistance;

public class DistanceFilter extends Filter<CustomerRecord> {
    private final Location location;
    private final long radiusInKms;

    public DistanceFilter(Location sourceLocation, long radiusInKms) {
        this.location = sourceLocation;
        this.radiusInKms = radiusInKms;
    }

    @Override
    public boolean test(CustomerRecord customerRecord) {
        return computeDistance(location, customerRecord.location) <= radiusInKms;
    }
}
