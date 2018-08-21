package com.intercom.interview.test.controllers;

import com.intercom.interview.test.deserializers.CustomerDeserializer;
import com.intercom.interview.test.filters.DistanceFilter;
import com.intercom.interview.test.models.Customer;

import static com.intercom.interview.test.Config.OFFICE_LOCATION;
import static com.intercom.interview.test.Config.RADIUS_IN_KMS;

public class CustomerRecordsController extends RecordsController<Customer> {
    public CustomerRecordsController() {
        super(new CustomerDeserializer(), new DistanceFilter(OFFICE_LOCATION, RADIUS_IN_KMS));
    }
}
