package AoC2022.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CathodeRayTube{

    int cycle = 0;
    int toBeAdded = 0;
    int total = 0;

    //register starts at 1 for some reason >:(
    //lots of bugsearching for this problem
    int register = 1;
    public CathodeRayTube() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day10/input.txt"));
            String line = reader.readLine();

            while(line != null) {
                noopOrAdd(line);
                //loops once or twice based on input line
                for(int i = noopOrAdd(line); i >= 0; i--) {
                    //ups cycles
                    cycle++;
                    //checks for multiples of 40 starting at 20 (20,60,100... etc)
                    //multiplies register X with cycles to get signal strength and adds to total
                    if ((cycle -20) % 40 == 0) {
                        System.out.println("Cycle: " + cycle);
                        System.out.println("Register: " +register);
                        total += register*cycle;
                        System.out.println("Signal strength: " + register*cycle);
                    }
                }
                //adds to register after loop and resets toBeAdded
                register += toBeAdded;
                toBeAdded = 0;
                line = reader.readLine();
            }
            System.out.println("Total sum signal strengths: " + total);
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


    public static void main(String[] args) {new CathodeRayTube();}
}