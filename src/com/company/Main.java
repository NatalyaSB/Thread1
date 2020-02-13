package com.company;

//import java.util.ArrayList;
//import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService threadPool = Executors.newFixedThreadPool(8);
        ThreadPool threadPool = new ThreadPool (10);
        for (int i = 0; i < 10; i++) {
            //
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                // Имитация длительной работы
                try {
                     TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException e) {
                     throw new IllegalStateException(e);
                }
                 Thread t = Thread.currentThread();
                 String name = t.getName();
                 System.out.println("Я работаю в потоке name=" + name);
                 }
                 , threadPool
            );
        }
        threadPool.shutdown();
    }

}
