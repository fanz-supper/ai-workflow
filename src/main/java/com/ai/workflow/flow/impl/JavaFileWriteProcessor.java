package com.ai.workflow.flow.impl;

import com.ai.workflow.metadata.base.JavaFileInput;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title: JavaFileWriteProcessor
 * @description:
 * @author: zhangfan
 */
public class JavaFileWriteProcessor extends AbstractNodeProcessor<JavaFileInput> {

    private static final String startMarkP = "package";
    private static final String endMarkP = ";";
    private static final String startMarkC = "class";
    private static final String endMarkC = "{";

    private static final String classPattern = "\\b(class|interface|enum)\\s+(\\w+)";


    public JavaFileWriteProcessor(JavaFileInput javaFileInput) {
        this.input = javaFileInput;
    }

    @Override
    public void doProcess() {

        String fileDir = extract(startMarkP, endMarkP).replaceAll("\\.", File.separator);
        try {

            String dir = input.getDir() + File.separator + fileDir;
            Files.createDirectories(Path.of(dir));
            String javaFileName = extractClassName() + ".java";

            FileOutputStream fileOutputStream = new FileOutputStream(dir + File.separator + javaFileName);
            fileOutputStream.write(input.getContent().getBytes());
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String extract(String startMark, String endMark) {

        String fileContent = input.getContent();
        int i = fileContent.indexOf(startMark);
        int l = i + startMark.length();
        int j = fileContent.indexOf(endMark, l);
        return StringUtils.deleteWhitespace(fileContent.substring(l, j));
    }

    private String extractClassName() {

        Pattern pattern = Pattern.compile(classPattern);
        Matcher matcher = pattern.matcher(input.getContent());

        if (matcher.find()) {
            return matcher.group(2);  // 获取类名
        }

        throw new IllegalArgumentException("The java file content does not meet expectations : " + input.getContent());

    }

}
