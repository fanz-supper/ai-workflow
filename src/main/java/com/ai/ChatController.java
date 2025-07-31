package com.ai;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.io.*;
import java.util.Base64;
import java.util.Map;

@RestController
public class ChatController {

    private final OllamaChatModel chatModel;

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.chatModel.call(message));
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }

    @PostMapping("/ai/generateCode")
    public Map<String, String> code(@RequestBody MessageRecord mr) {

        if (!StringUtils.hasText(mr.body())) {
            return Map.of("error", "500");
        }
        String decode = new String(Base64.getDecoder().decode(mr.body()));
        String callResult = this.chatModel.call(decode);
        System.out.println(callResult);
        writeFile(callResult, mr.filePath());
        return Map.of("code", callResult);
    }

    private void writeFile(String callResult, String filePath) {

        try {
            ByteArrayInputStream byteInput = new ByteArrayInputStream(callResult.getBytes());
            InputStreamReader reader = new InputStreamReader(byteInput);
            BufferedReader br = new BufferedReader(reader);

            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            br.readLine(); //跳过第一行
            String line = br.readLine();
            String nextLine = null;
            while ((nextLine = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                line = nextLine;
            }

            br.close();
            bw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
