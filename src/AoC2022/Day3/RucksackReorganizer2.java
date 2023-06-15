package AoC2022.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RucksackReorganizer2 {
    String charPriority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int sum = 0;

    public RucksackReorganizer2() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day3/input.txt"));
        String line = reader.readLine();
        String ruckSack1 = "";
        String ruckSack2 = "";
        String ruckSack3 = "";


        while (line != null) {
            ruckSack1 = line;
            ruckSack2 = reader.readLine();
            ruckSack3 = reader.readLine();
            Character doubledItem = '_';

            for (int i = 0; i < ruckSack1.length(); i++) {
                Character temp = ruckSack1.charAt(i);

                if((ruckSack2.indexOf(temp)!= -1)&&(ruckSack3.indexOf(temp)!= -1)) {
                    doubledItem = temp;
                }
            }
            sum += getPriority(doubledItem);
            line = reader.readLine();
        }
        reader.close();
    } catch (
    IOException e) {
        e.printStackTrace();
    }
        System.out.println(sum);
}
    public int getPriority(Character item) {
        int priority = charPriority.indexOf(item) + 1;
        return priority;
    }

    public static void main(String[] args) {
        new RucksackReorganizer2();
    }
}
