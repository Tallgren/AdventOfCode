package AoC2022.D1P2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CalorieCalculator {
    int sum = 0;
    int highest = 0;

    ArrayList<Integer> calorieList = new ArrayList<>();
    public CalorieCalculator() throws IOException {

            try {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2022.D1P1\\input.txt"));
                String line = reader.readLine();

                while (line != null) {
                    if(!line.equals("")) {
                        sum += Integer.parseInt(line);
                    }
                    else {
                        calorieList.add(sum);
                        sum = 0;
                    }
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printTopThreeCalorieCarriers();
        }

        public void printTopThreeCalorieCarriers() {
            Collections.sort(calorieList);
            Collections.reverse(calorieList);
            System.out.println(calorieList);
            int temp = calorieList.get(0) + calorieList.get(1) + calorieList.get(2);
            System.out.println(temp);
        }

    public static void main(String[] args) throws IOException {
        new CalorieCalculator();
    }
}
