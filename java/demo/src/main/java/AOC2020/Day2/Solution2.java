package AOC2020.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Solution2 {
    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        try {
            File myFile = new File("java/demo/src/main/java/AOC2020/Input/input2.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("error" + e);
        }
        List<String[]> splitData = new ArrayList<String[]>();
        for(String line: data){
            String[] splitString = line.replace("-", " ").split(" ");
            splitData.add(splitString);
        }
        int valid_counter_1 = 0;
        for(String[] field: splitData){
            String password = field[field.length - 1];
            char character = field[2].charAt(0);
            int lower = Integer.parseInt(field[0]);
            int upper = Integer.parseInt(field[1]);
            int count = StringUtils.countMatches(password, character);
            if(lower <= count && count <= upper){
                valid_counter_1++;
            }
        }
        System.out.println("Part 1: " + valid_counter_1);

        int valid_counter_2 = 0;
        for(String[] field : splitData){
            String password = field[field.length - 1];
            char character = field[2].charAt(0);
            int lower = Integer.parseInt(field[0])-1;
            int upper = Integer.parseInt(field[1])-1;
            if(password.charAt(lower)==character ^ password.charAt(upper) == character){
                valid_counter_2++;
            }
        }
        System.out.println("Part 2: " + valid_counter_2);
    }
    }

