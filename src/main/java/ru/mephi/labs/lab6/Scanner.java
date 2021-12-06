package ru.mephi.labs.lab6;
/*
Задание №1
• Написать основной класс, который принмает имя файла в качестве аргумента
• Используя консольный ввод, определить искомую в файле строку
• Используя связанные потоки, считать данные из файла и определить количество вхождений искомой строки


 */

import lombok.Getter;

import java.io.*;

public class Scanner {
    @Getter
    private final String filename;

    public Scanner(String filename)
    {
        this.filename = filename;
    }
    public Integer countNumberEntering(String subline) throws Exception {
        int result = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while (((line = reader.readLine())!= null)){
                int offset;

                    while (!line.isEmpty() && ((offset = line.indexOf(subline)) >= 0 )){
                        result++;
                        line = line.substring(offset+subline.length());
                    }
            }
            reader.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result>0)
        {
            return result;
        }else {
            throw new Exception("Not found this line");
        }
    }
    public Integer findFileIndexLine(String subline) throws Exception {
        int result;
        String line;
        boolean isFinded = false;
        int index = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));


            while (!isFinded && ((line = reader.readLine())!= null)){

                if(line.lastIndexOf(subline) > 0 ){
                    isFinded = true;
                    break;
                }
                index++;
            }
            reader.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isFinded)
        {
            result = index;
            return result;
        }else {
            throw new Exception("Not found this line");
        }

    }
    public String findFileLineByIndex(Integer index) throws Exception {
        String result;
        String line = "";
        boolean isFinded = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            Integer i = 1;
            while (!isFinded && ((line = reader.readLine())!= null)){
                if(i.equals(index)){
                    isFinded = true;
                    break;
                }
                i++;
            }
            reader.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isFinded)
        {
            result = line;
            return result;
        }else {
            throw new Exception("Not found this line");
        }
    }
    private String dialog(){
        System.out.println("Welcome to the Scanner your files");
        System.out.println("""
                Choose action
                0)Exit
                1)Find line by index
                2)Find line by string
                3)Number of line entering""");
        String result  = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            boolean flag = false;
            //
            while(!flag){
                System.out.print("Input integer [0-3]: ");
                result = in.readLine().trim();
                try {
                    var cheched = Integer.parseInt(result);

                    if(cheched>= 0 && cheched <=3) {
                        flag = true;
                        break;
                    }
                }catch (NumberFormatException exception)
                {
                    System.out.println(exception.getMessage());
                }
                System.out.println("Please repeat your answer");
            }

            switch (Integer.parseInt(result)) {
                case 0 -> result = "0_";
                case 1 -> {
                    result = "1_";
                    result += String.valueOf(getIndex(in));
                }
                case 2 -> {
                    result = "2_";
                    result += getLine(in);
                }
                case 3 -> {
                    result = "3_";
                    result += getLine(in);
                }
            }


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public String mainDialog(){
        var answer = dialog();
        int choise = 0;
        choise += (answer.indexOf("0_") ==0? 1:0)+
                (answer.indexOf("1_")==0?2:0) +
                (answer.indexOf("2_")==0?3:0) +
                (answer.indexOf("3_")==0?4:0);
        switch (choise){
            case 1 -> {
                System.out.println("-------------Bye!");
                answer = "";
                return answer;
            }
            case 2 -> {
                System.out.println("-------------Find line by index...");
                try {
                    answer = "\nFind is successful: " + findFileLineByIndex(Integer.valueOf(answer.substring(2)));
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                    answer = "Error";
                }
                return answer;
            }
            case 3 -> {
                System.out.println("-------------Find line by string...");
                try {
                    answer = "\nFind is successful: " + findFileIndexLine(answer.substring(2)).toString();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                    answer = "Error";
                }
                return answer;
            }
            case 4 -> {
                System.out.println("-------------Counting the number of Entering...");
                try {
                    answer = "\nNumber of Entering: " + countNumberEntering(answer.substring(2)).toString();
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                    answer = "Error";
                }
                return answer;
            }
        }

        return answer;
    }
    
    private  String getLine(BufferedReader reader) throws IOException{
        System.out.print("Input string line: ");
        return  reader.readLine();
    }
    private  int getIndex(BufferedReader reader) throws IOException{
        int res = 0;
        boolean flag = false;
        while (!flag){
            System.out.print("Input index: ");
            String in = reader.readLine().trim();
            try {
                if(Integer.parseInt(in)> -1){
                    res = Integer.parseInt(in);
                    flag = true;
                }
            }catch (NumberFormatException exception){
                System.out.println(exception.getMessage());
            }
        }
        return res;
    }

}
