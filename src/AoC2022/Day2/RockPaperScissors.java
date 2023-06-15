package AoC2022.Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {
    /*
    A = Rock    X = Rock    = 1 Score
    B = Paper   Y = Paper   = 2 Score
    C = Scissor Z = Scissor = 3 Score

    Lose = 0
    Draw = 3
    Win = 6

     */
    int points = 0;
    public RockPaperScissors() {
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
                        case 'A' -> points += (1+3);
                        case 'B' -> points += (1+0);
                        case 'C' -> points += (1+6);
                    }
                }
                else if(me.equals('Y')) {
                    switch (opponent) {
                        case 'A' -> points += (2+6);
                        case 'B' -> points += (2+3);
                        case 'C' -> points += (2+0);
                    }
                }
                else if(me.equals('Z')) {
                    switch (opponent) {
                        case 'A' -> points += (3+0);
                        case 'B' -> points += (3+6);
                        case 'C' -> points += (3+3);
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
        new RockPaperScissors();
    }
}
