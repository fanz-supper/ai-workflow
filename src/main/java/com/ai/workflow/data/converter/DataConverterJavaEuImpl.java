package com.ai.workflow.data.converter;

import com.ai.workflow.DataConvertEu;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.base.StringOutput;

/**
 * @title: DataConverterYamlEuImpl
 * @description:
 * @author: zhangfan
 */
public class DataConverterJavaEuImpl implements DataConvertEu {
    private static String start = "```java";
    private static String end = "```";

    @Override
    public Output convert(Output output) {

        if (output instanceof StringOutput strOutput) {
            String content = strOutput.content();
            int i = content.indexOf(start);
            int l = i + start.length();
            int j = content.indexOf(end, l);

            if (i > -1 && j > l) {
                return new StringOutput(content.substring(l, j));
            }
        }

        return output;
    }
}
