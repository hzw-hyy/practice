package com.example.hyy.practice.abstract_demo;

import java.nio.file.Path;

/**
 * @author hyy
 * @version 1.0
 * @date 2020/6/30 17:32
 */
public class UppercaseFileReader extends BaseFileReader {
    /**
     * 获取文本的路径。
     *
     * @param filePath
     */
    protected UppercaseFileReader(Path filePath) {
        super(filePath);
    }

    /**
     * 通用方法将从文本中获取到的字符串转换成大写的格式。
     *
     * @param line 读取到每行的字符串。
     * @return 返回转换好的大写的格式。
     */
    @Override
    protected String mapFileLine(String line) {
        return line.toUpperCase();
    }
}
