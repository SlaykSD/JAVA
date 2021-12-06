package ru.mephi.homeworks.hw6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("src\\main\\java\\ru\\mephi\\homeworks\\hw6\\task1\\hamlet.txt");
    List<String> fileArr;
    AtomicReference<String> word  = new AtomicReference<>("");
// Remove these comments
    try{
        // Read fileinto array here
        fileArr = Files.readAllLines(file);
        System.out.println("\n=== Lord Count ===");

        AtomicLong wordCount = new AtomicLong(); // Replace with your pipeline
        Consumer<String> countWords = lineOfFile ->{
            int offset;
            String line = lineOfFile.trim(); //copy line
            while (!line.isEmpty() && ((offset = line.indexOf(word.get())) >= 0 )){
                wordCount.getAndIncrement();
                line = line.substring(offset + word.get().length());
            }
        };
        fileArr.stream().filter(x->x.contains("lord") || x.contains("Lord"))
                .peek(System.out::println)
                .forEach(x->{
                    word.set("lord");
                    countWords.accept(x);
                    word.set("Lord");
                    countWords.accept(x);
                });

        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
        wordCount.set(0); // Replace with your pipeline
        fileArr.stream().filter(x->x.contains("Prison") || x.contains("prison"))
                .peek(System.out::println)
                .forEach(x->{
                    word.set("Prison");
                    countWords.accept(x);
                    word.set("prison");
                    countWords.accept(x);
                });

        
        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  }
}
