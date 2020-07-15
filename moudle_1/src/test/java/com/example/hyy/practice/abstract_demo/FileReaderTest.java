package com.example.hyy.practice.abstract_demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/30 17:33
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource = FileReaderTest.class.getClassLoader().getResource("helloworld.txt");
        Path path = Paths.get(resource.toURI());
        BaseFileReader lowercaseFileReader = new LowercaseFileReader(path);
        BaseFileReader uppercaseFileReader = new UppercaseFileReader(path);
        System.out.println(lowercaseFileReader.readFile());
        System.out.println(uppercaseFileReader.readFile());
    }
}
