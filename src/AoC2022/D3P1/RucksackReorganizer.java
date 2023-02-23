package AoC2022.D3P1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RucksackReorganizer {
    String charPriority = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int sum = 0;

    public RucksackReorganizer() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2022.D3P1\\input.txt"));
        String line = reader.readLine();
        String ruckSack1 = "";
        String ruckSack2 = "";

        while (line != null) {
            ruckSack1 = line.substring(0, (line.length()/2));
            ruckSack2 = line.substring((line.length()/2), line.length());
            Character doubledItem = '_';

            for (int i = 0; i < ruckSack1.length(); i++) {
                Character temp = ruckSack1.charAt(i);

                if(ruckSack2.indexOf(temp)!= -1) {
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
        new RucksackReorganizer();
    }
}
