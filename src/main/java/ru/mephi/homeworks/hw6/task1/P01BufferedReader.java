package ru.mephi.homeworks.hw6.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01BufferedReader {
    
    public static void main(String[] args) {
        
        try{
            BufferedReader bReader = 
                new BufferedReader(new FileReader("src\\main\\java\\ru\\mephi\\homeworks\\hw6\\task1\\hamlet.txt"));
            
            System.out.println("=== Entire File ===");//Okay
            bReader.lines().forEach(System.out::println);
            bReader.close();
                        
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
