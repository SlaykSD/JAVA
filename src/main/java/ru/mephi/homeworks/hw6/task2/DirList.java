package ru.mephi.homeworks.hw6.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
  public static void main(String[] args) {

// remove comments
    try{ // Add Try with resources here
        DirectoryStream<Path> files = Files.newDirectoryStream(Path.of(args[0]));
        System.out.println("\n=== Dir list ===");
        for (Path path: files) {
          System.out.println(path.getFileName());
        }

      //files.forEach(Path::getFileName);
        // Print directory list here

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  }
}
