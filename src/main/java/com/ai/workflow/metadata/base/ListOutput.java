package com.ai.workflow.metadata.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @title: ListOuput
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
@NoArgsConstructor
public class ListOutput<T> extends AbstractOutput<List<T>> {

    private List<T> list;

    public ListOutput(List<T> list) {
        this.list = list;
    }

    @Override
    public List<T> content() {
        return this.list;
    }
}
