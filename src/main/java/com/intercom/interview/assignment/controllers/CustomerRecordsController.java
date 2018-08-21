package com.intercom.interview.assignment.controllers;

import com.intercom.interview.assignment.deserializers.CustomerRecordDeserializer;
import com.intercom.interview.assignment.filters.CustomerDistanceFilter;
import com.intercom.interview.assignment.models.CustomerRecord;

import static com.intercom.interview.assignment.Config.OFFICE_LOCATION;
import static com.intercom.interview.assignment.Config.RADIUS_IN_KMS;

public class CustomerRecordsController extends RecordsController<CustomerRecord> {
    public CustomerRecordsController() {
        super(new CustomerRecordDeserializer(), new CustomerDistanceFilter(OFFICE_LOCATION, RADIUS_IN_KMS));
    }
}
