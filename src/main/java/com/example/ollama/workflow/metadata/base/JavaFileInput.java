package com.example.ollama.workflow.metadata.base;

import com.example.ollama.workflow.metadata.FieldInject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @title: JavaFileInput
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
@NoArgsConstructor
public class JavaFileInput extends AbstractInput {

    private String dir;
    private String content;

    public JavaFileInput(String dir) {
        this.dir = dir;
    }

    public JavaFileInput(String dir, List<FieldInject> fieldInjects) {
        this.dir = dir;
        super.fieldInjects = fieldInjects;
    }


    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
