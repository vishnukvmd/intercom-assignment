package com.intercom.interview.test;

import com.intercom.interview.test.controllers.CustomerRecordsController;
import com.intercom.interview.test.io.FileReader;
import com.intercom.interview.test.io.PrettyPrinter;
import com.intercom.interview.test.models.CustomerRecord;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = FileReader.readFile(args[0]);
        List<CustomerRecord> invitees = new CustomerRecordsController().getRecords(input);
        PrettyPrinter.printCustomers(invitees);
    }
}
