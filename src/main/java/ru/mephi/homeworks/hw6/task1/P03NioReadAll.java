package ru.mephi.homeworks.hw6.task1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("src\\main\\java\\ru\\mephi\\homeworks\\hw6\\task1\\hamlet.txt");
        try{
            // Read file into array here
            fileArr = Files.readAllLines(file);
            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            fileArr.stream().filter(x-> x.contains("Ros.")).forEach(System.out::println);

            System.out.println("\n=== Guildenstern ===");
            fileArr.stream().filter(x-> x.contains("Guil.")).forEach(System.out::println);
            // Filter for Guil. here



        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }
    }
}
