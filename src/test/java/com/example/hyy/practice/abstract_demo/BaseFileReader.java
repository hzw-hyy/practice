package com.example.hyy.practice.abstract_demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 假设现在有一个文件，里面的内容非常简单——“HeLlo WOrld”。
 * 现在需要有一个读取器将内容读取出来，最好能按照大写的方式，或者小写的方式。
 *
 * @author hyy
 * @version 1.0
 */
public abstract class BaseFileReader {


    /**
     * 文本的路径
     */
    protected Path filePath;


    /**
     * 获取文本的路径。
     *
     * @param filePath
     */
    protected BaseFileReader(Path filePath) {
        this.filePath = filePath;
    }


    /**
     * 获取文本中的内容。
     *
     * @return
     * @throws IOException
     */
    public List<String> readFile() throws IOException {
        return Files.lines(filePath).map(this::mapFileLine).collect(Collectors.toList());
    }

    /**
     * 通用方法_将从文本中获取到的字符串转换成所需要的格式。
     *
     * @param line 读取到每行的字符串。
     * @return 返回转换好的所需要的格式。
     */
    protected abstract String mapFileLine(String line);
}
