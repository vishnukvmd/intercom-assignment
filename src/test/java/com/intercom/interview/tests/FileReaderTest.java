package com.intercom.interview.tests;

import com.intercom.interview.test.io.FileReader;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {
    @Test
    public void testFileRead() throws IOException {
        String filePath = "src/main/resources/customers.txt";
        List<String> fileContents = FileReader.readFile(filePath);

        BufferedReader br = new BufferedReader(new java.io.FileReader(filePath));
        for (String content : fileContents) {
            assertEquals(content, br.readLine());
        }
        assertEquals(br.readLine(), null); // Ensure that there's nothing left to read
    }

    @Test(expected = IOException.class)
    public void testFileReadFailure() throws IOException {
        String filePath = "404.txt";
        FileReader.readFile(filePath);
    }
}
