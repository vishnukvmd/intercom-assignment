package com.intercom.interview.assignment.io;

import com.intercom.interview.assignment.models.CustomerRecord;

import java.util.List;

public class PrettyPrinter {
    public static void printCustomers(List<CustomerRecord> customerRecords) {
        for (CustomerRecord customerRecord : customerRecords) {
            System.out.println(customerRecord.id + "\t" + customerRecord.name);
        }
    }
}
