package com.intercom.interview.tests;

import com.intercom.interview.assignment.controllers.CustomerRecordsController;
import com.intercom.interview.assignment.models.CustomerRecord;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerRecordRecordsControllerTest {
    private final CustomerRecordsController controller = new CustomerRecordsController();

    @Test
    public void test() {
        String firstCustomer = "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}\n";
        String secondCustomer = "{\"latitude\": \"53.2451022\", \"user_id\": 2, \"name\": \"Ian Kehoe\", \"longitude\": \"-6.238335\"}\n";
        List<String> input = new ArrayList<>();
        input.add(firstCustomer);
        input.add(secondCustomer);

        List<CustomerRecord> records = controller.getRecords(input);

        assertEquals(records.size(), 1);
        assertEquals(records.get(0).id, 2);
    }
}
