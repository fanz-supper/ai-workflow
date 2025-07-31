package com.ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class OllamaApplicationTests {


	@Autowired
	OllamaChatModel ollamaChatModel;

	@Test
	void contextLoads() throws InterruptedException {

//		System.out.println(ollamaChatModel.call("请给我讲个笑话"));
		Flux<String> callStream = ollamaChatModel.stream(TemplateStatic.des);
		CountDownLatch countDownLatch = new CountDownLatch(1);
		callStream.doOnNext(System.out::print).subscribe(System.out::print, throwable -> {
		}, () -> countDownLatch.countDown());

		countDownLatch.await();


	}

}
