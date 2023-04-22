package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\CRAFT_PC\\IdeaProjects\\Task1\\src\\test.txt"));
        String test = bufferedReader.readLine();

        String[] result = test.split(",");
        StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE");
        for (String element: result) {
            String[] fieldAndValue = element.split(":");
            String field = fieldAndValue[0]
                    .replaceAll("\\{|\"| ", "");
            String value = fieldAndValue[1].replaceAll("}| ", "");
            if (!value.equals("\"null\"")) {
                if (sb.lastIndexOf("=") != -1) {
                    sb.append(" AND");
                }
                sb.append(" " + field + " = " + value);
            }
        }
        System.out.println(sb);





    }

}