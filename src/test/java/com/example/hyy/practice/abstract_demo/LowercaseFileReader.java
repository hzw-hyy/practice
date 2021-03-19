package com.example.hyy.practice.abstract_demo;

import java.nio.file.Path;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/30 17:30
 */
public class LowercaseFileReader extends BaseFileReader {
    /**
     * 获取文本的路径。
     *
     * @param filePath
     */
    protected LowercaseFileReader(Path filePath) {
        super(filePath);
    }

    /**
     * 通用方法将从文本中获取到的字符串转换成小写的格式。
     *
     * @param line 读取到每行的字符串。
     * @return 返回转换好的小写的格式。
     */
    @Override
    protected String mapFileLine(String line) {
        return line.toLowerCase();
    }
}
