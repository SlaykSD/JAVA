package ru.mephi.homeworks.hw6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02NioRead {
    
    public static void main(String[] args) {
//  Remove these comments
        try{ // Create Try with Resources here
            var lines = Files.lines(Paths.get("src\\main\\java\\ru\\mephi\\homeworks\\hw6\\task1\\hamlet.txt"));
            System.out.println("\n=== Entire File ===");
            lines.forEach(System.out::println);
            // print lines here

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}
