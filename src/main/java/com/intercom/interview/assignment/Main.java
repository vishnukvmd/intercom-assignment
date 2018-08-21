package com.intercom.interview.assignment;

import com.intercom.interview.assignment.controllers.CustomerRecordsController;
import com.intercom.interview.assignment.io.FileReader;
import com.intercom.interview.assignment.io.PrettyPrinter;
import com.intercom.interview.assignment.models.CustomerRecord;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = FileReader.readFile(args[0]);
        List<CustomerRecord> invitees = new CustomerRecordsController().getRecords(input);
        PrettyPrinter.printCustomers(invitees);
    }
}
