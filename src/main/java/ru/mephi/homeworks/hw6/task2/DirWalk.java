package ru.mephi.homeworks.hw6.task2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirWalk {
  public static void main(String[] args) {
    try{// Add try with resources here
      Stream<Path> files = Files.walk(Paths.get("."));

        System.out.println("\n=== Dir walk ===");
        files
                .forEach(System.out::println);
        // Print directory list here  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");
        files
            .filter(path -> path.toString().contains("build"))
            .forEach(System.out::println);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  }
}
