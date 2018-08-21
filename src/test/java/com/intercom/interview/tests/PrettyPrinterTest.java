package com.intercom.interview.tests;

import com.intercom.interview.test.io.PrettyPrinter;
import com.intercom.interview.test.models.Customer;
import com.intercom.interview.test.models.Location;

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
        Customer firstCustomer = new Customer(1, "Ewa", new Location(53.339428, -6.257664));
        Customer secondCustomer = new Customer(2, "Vishnu", new Location(28.564188060311675, 77.1939073787088));
        List<Customer> customers = new ArrayList<>();
        customers.add(firstCustomer);
        customers.add(secondCustomer);
        PrettyPrinter.printCustomers(customers);
        assertEquals(temporaryOutputStream.toString(), "1\tEwa\n2\tVishnu\n");
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
