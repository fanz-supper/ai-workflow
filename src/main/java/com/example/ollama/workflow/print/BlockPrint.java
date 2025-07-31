package com.example.ollama.workflow.print;

import reactor.core.publisher.Flux;

/**
 * @title: BlockPrint
 * @description:
 * @author: zhangfan
 */
public class BlockPrint {

    private static Printer printer = System.out::print;

    public static void registerPrinter(Printer p) {
        printer = p;
    }

    public static void print(String title, String str) {
        printer.print(str);
    }

    public static void print(String title, Flux<String> flux) {
        flux.doOnNext(printer::print).blockLast();
    }

    public interface Printer {
        void print(String msg);
    }

}
