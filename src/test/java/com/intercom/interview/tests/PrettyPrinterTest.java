package com.intercom.interview.tests;

import com.intercom.interview.assignment.io.PrettyPrinter;
import com.intercom.interview.assignment.models.CustomerRecord;
import com.intercom.interview.assignment.models.Location;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrettyPrinterTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream temporaryOutputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(temporaryOutputStream));
    }

    @Test
    public void testPrintStatements() {
        CustomerRecord firstCustomer = new CustomerRecord(1, "Ewa", new Location(53.339428, -6.257664));
        CustomerRecord secondCustomer = new CustomerRecord(2, "Vishnu", new Location(28.564188060311675, 77.1939073787088));
        List<CustomerRecord> customerRecords = new ArrayList<>();
        customerRecords.add(firstCustomer);
        customerRecords.add(secondCustomer);
        PrettyPrinter.printCustomers(customerRecords);
        assertEquals(temporaryOutputStream.toString(), "1\tEwa\n2\tVishnu\n");
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
