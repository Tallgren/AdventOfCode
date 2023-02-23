package AoC2022.D1P1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalorieCalculator {

    int calories = 0;
    int sum = 0;
    int highest = 0;

    public CalorieCalculator() throws IOException {

            try {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Toby9\\IdeaProjects\\AdventOfCode\\src\\AoC2022.D1P1\\input.txt"));
                String line = reader.readLine();

                while (line != null) {
                    if(!line.equals("")) {
                        sum += Integer.parseInt(line);
                    }
                    else {
                        if(sum > highest) {
                            highest = sum;
                        }
                        sum = 0;
                    }
                    // read next line
                    line = reader.readLine();
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(highest);
        }

    public static void main(String[] args) throws IOException {
        new CalorieCalculator();
    }
}
