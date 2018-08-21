package com.intercom.interview.test.io;

import com.intercom.interview.test.models.Customer;

import java.util.List;

public class PrettyPrinter {
    public static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer.id + "\t" + customer.name);
        }
    }
}
