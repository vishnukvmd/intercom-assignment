package com.intercom.interview.test.filters;

import com.intercom.interview.test.models.CustomerRecord;
import com.intercom.interview.test.models.Location;

import static com.intercom.interview.test.util.DistanceComputer.computeDistance;

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
