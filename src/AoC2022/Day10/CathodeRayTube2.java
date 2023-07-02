package AoC2022.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CathodeRayTube2{

    int cycle = 0;
    int toBeAdded = 0;

    //register starts at 1 for some reason >:(
    //lots of bugsearching for this problem
    int register = 1;

    ArrayList<ArrayList<Character>> display = new ArrayList<>(6);
    public CathodeRayTube2() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day10/input.txt"));
            String line = reader.readLine();
            for (int i = 0; i <= 5; i++) {
                display.add(new ArrayList<Character>(40));
            }

            while(line != null) {
                noopOrAdd(line);
                //loops once or twice based on input line
                //gets the correct array based on multiples of 40 and tries to draw a pixel
                for(int i = noopOrAdd(line); i >= 0; i--) {
                    cycle++;
                    display.get((cycle-1)/40).add(drawPixel());
                }
                //adds to register after loop and resets toBeAdded
                register += toBeAdded;
                toBeAdded = 0;
                line = reader.readLine();
            }

            //prints 2d-array
            for (ArrayList<Character> list:display) {
                System.out.println(list);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //checks if input is a noop or an addx, return amount of loops to either once or twice
    //also if addx, sets int to be added from string
    public int noopOrAdd(String line) {
        if(line.equals("noop")) {
            return 0;
        }
        else {
            toBeAdded = Integer.parseInt(line.substring(5));
            return 1;
        }
    }

    //checks if cycleposition aligns with register value and returns either '#' or '.'
    public char drawPixel() {
        if ((cycle-1)%40 >= register-1 && (cycle-1)%40 <= register+1) {
            return '#';
        }
        return '.';
    }

    public static void main(String[] args) {new CathodeRayTube2();}
}