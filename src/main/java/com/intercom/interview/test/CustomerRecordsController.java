package com.intercom.interview.test;

import com.intercom.interview.test.filters.DistanceFilter;
import com.intercom.interview.test.models.Customer;
import com.intercom.interview.test.models.Location;
import com.intercom.interview.test.deserializers.CustomerDeserializer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRecordsController {
    private static final Location OFFICE_LOCATION = new Location(53.339428, -6.257664);
    private static final long RADIUS_IN_KMS = 100;

    private final CustomerDeserializer customerDeserializer;
    private final DistanceFilter distanceFilter;

    public CustomerRecordsController() {
        customerDeserializer = new CustomerDeserializer();
        distanceFilter = new DistanceFilter(OFFICE_LOCATION, RADIUS_IN_KMS);
    }

    public List<Customer> getInvitees(List<String> input) {
        List<Customer> customers = input
                .stream()
                .map(customerDeserializer)
                .filter(distanceFilter)
                .collect(Collectors.toList());
        sortCustomers(customers);
        return customers;
    }

    private static void sortCustomers(List<Customer> customers) {
        customers.sort(Comparator.comparingLong(o -> o.id));
    }
}
