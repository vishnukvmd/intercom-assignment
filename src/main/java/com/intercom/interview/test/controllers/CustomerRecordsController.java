package com.intercom.interview.test.controllers;

import com.intercom.interview.test.deserializers.CustomerRecordDeserializer;
import com.intercom.interview.test.filters.DistanceFilter;
import com.intercom.interview.test.models.CustomerRecord;

import static com.intercom.interview.test.Config.OFFICE_LOCATION;
import static com.intercom.interview.test.Config.RADIUS_IN_KMS;

public class CustomerRecordsController extends RecordsController<CustomerRecord> {
    public CustomerRecordsController() {
        super(new CustomerRecordDeserializer(), new DistanceFilter(OFFICE_LOCATION, RADIUS_IN_KMS));
    }
}
