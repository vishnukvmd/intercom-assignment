package com.intercom.interview.tests;

import com.google.gson.JsonSyntaxException;
import com.intercom.interview.test.deserializers.CustomerDeserializer;
import com.intercom.interview.test.models.Customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerDeserializerTest {
    private CustomerDeserializer customerDeserializer;

    @Before
    public void setup() {
        customerDeserializer = new CustomerDeserializer();
    }

    @Test
    public void testValidCustomerDeserialization() {
        Customer customer = customerDeserializer.apply("{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}");
        assertEquals(customer.id, 12);
        assertEquals(customer.name, "Christina McArdle");
        assertEquals(customer.location.latitude, 52.986375, 0);
        assertEquals(customer.location.longitude, -6.043701, 0);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testInvalidJson() {
        customerDeserializer.apply("\"latitude\": \"52.986375\"");
    }
}
