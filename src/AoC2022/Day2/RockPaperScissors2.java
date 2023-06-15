package AoC2022.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors2 {
    /*
    A = Rock    X = Lose    Rock    = 1 Score
    B = Paper   Y = Draw    Paper   = 2 Score
    C = Scissor Z = Win     Scissor = 3 Score

    Lose = 0
    Draw = 3
    Win = 6

     */
    int points = 0;
    public RockPaperScissors2() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day2/input.txt"));
            String line = reader.readLine();
            Character opponent;
            Character me;


            while (line != null) {
                opponent = line.charAt(0);
                me = line.charAt(2);

                if(me.equals('X')) {
                    switch (opponent) {
                        case 'A' -> points += (0+3);
                        case 'B' -> points += (0+1);
                        case 'C' -> points += (0+2);
                    }
                }
                else if(me.equals('Y')) {
                    switch (opponent) {
                        case 'A' -> points += (3+1);
                        case 'B' -> points += (3+2);
                        case 'C' -> points += (3+3);
                    }
                }
                else if(me.equals('Z')) {
                    switch (opponent) {
                        case 'A' -> points += (6+2);
                        case 'B' -> points += (6+3);
                        case 'C' -> points += (6+1);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(points);
    }

    public static void main(String[] args) {
        new RockPaperScissors2();
    }
}
