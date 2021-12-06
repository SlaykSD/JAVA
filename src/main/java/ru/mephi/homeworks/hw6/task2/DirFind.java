package ru.mephi.homeworks.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {
    
    public static void main(String[] args) {

        try{ // Add try with resources
            Stream<Path> files = Files.list(Paths.get(args[0]));
            System.out.println("\n=== Find all dirs ===");
            files.forEach(System.out::println);
            // Print out directory list here
                
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
