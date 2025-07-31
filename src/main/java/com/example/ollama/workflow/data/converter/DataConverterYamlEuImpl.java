package com.example.ollama.workflow.data.converter;

import com.example.ollama.workflow.DataConvertEu;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.StringOutput;

/**
 * @title: DataConverterYamlEuImpl
 * @description:
 * @author: zhangfan
 */
public class DataConverterYamlEuImpl implements DataConvertEu {
    private static String start = "```yaml";
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
