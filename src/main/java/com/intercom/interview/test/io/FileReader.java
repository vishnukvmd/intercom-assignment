package com.intercom.interview.test.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    }
}
