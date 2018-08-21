package com.intercom.interview.tests;

import com.intercom.interview.assignment.Main;

import org.junit.Test;

import java.io.IOException;

public class MainTest {
    @Test
    public void test() throws IOException {
        String[] args = {"src/main/resources/customers.txt"};
        Main.main(args);
    }
}
