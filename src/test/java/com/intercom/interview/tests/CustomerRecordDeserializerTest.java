package com.intercom.interview.tests;

import com.google.gson.JsonSyntaxException;
import com.intercom.interview.assignment.deserializers.CustomerRecordDeserializer;
import com.intercom.interview.assignment.models.CustomerRecord;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerRecordDeserializerTest {
    private final CustomerRecordDeserializer customerRecordDeserializer = new CustomerRecordDeserializer();

    @Test
    public void testValidCustomerDeserialization() {
        CustomerRecord customerRecord = customerRecordDeserializer.apply("{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}");
        assertEquals(customerRecord.id, 12);
        assertEquals(customerRecord.name, "Christina McArdle");
        assertEquals(customerRecord.location.latitude, 52.986375, 0);
        assertEquals(customerRecord.location.longitude, -6.043701, 0);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testInvalidJson() {
        customerRecordDeserializer.apply("\"latitude\": \"52.986375\"");
    }
}
