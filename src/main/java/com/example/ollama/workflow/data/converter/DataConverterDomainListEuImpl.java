package com.example.ollama.workflow.data.converter;

import com.example.ollama.workflow.DataConvertEu;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.ListOutput;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

/**
 * @title: DataConverterDomainListEuImpl
 * @description:
 * @author: zhangfan
 */
public class DataConverterDomainListEuImpl implements DataConvertEu {

    @Override
    public Output convert(Output output) {

        if (output != null && output.content() != null && output.content() instanceof String str) {

            DataConverterYamlEuImpl dataConverterYamlEu = new DataConverterYamlEuImpl();
            Output convert = dataConverterYamlEu.convert(output);

            Yaml yaml = new Yaml();
            Map<String, List> domains = yaml.load(convert.content().toString());

            ListOutput listOutput = new ListOutput(domains.get("modules"));
            return listOutput;
        }

        return null;
    }
}
