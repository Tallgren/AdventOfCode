package AoC2022.Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplyStacks {
    ArrayList<ArrayList<Character>> array = new ArrayList<>(9);
    int lineNum = 0;
    Pattern pattern = Pattern.compile("\\d+");
    String message = "";

    public SupplyStacks() {

        //initializing 2d array
        for(int i = 0; i < 9; i++) {
            array.add(new ArrayList(40));
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day5/input.txt"));
            String line = reader.readLine();

             /*
                    [V] [G]             [H]
                [Z] [H] [Z]         [T] [S]
                [P] [D] [F]         [B] [V] [Q]
                [B] [M] [V] [N]     [F] [D] [N]
                [Q] [Q] [D] [F]     [Z] [Z] [P] [M]
                [M] [Z] [R] [D] [Q] [V] [T] [F] [R]
                [D] [L] [H] [G] [F] [Q] [M] [G] [W]
                [N] [C] [Q] [H] [N] [D] [Q] [M] [B]
                 1   2   3   4   5   6   7   8   9
             */

            while (line != null) {

                Matcher matcher = pattern.matcher(line);

                //reads initial lineup of crates and add to 2d Array
                if(lineNum < 8) {
                    int x = 0;
                    for (int i = 1; i < line.length(); i += 4) {
                        if(line.charAt(i)!=' ') {
                            array.get(x).add(line.charAt(i));
                        }
                        x++;
                    }
                }
                //reads instructions on crate movement
                else if(lineNum > 9) {
                    int amount = 0;
                    int from = 0;
                    int to = 0;
                    int counter = 0;

                    //ran into an issue where I took ints from string based on index (two digits don't work)
                    //found pattern and matcher to group and get ints from string (both 12 and 1 now works)
                    //have to loop matcher.find to get next matcher.group (move [3] from [2] to [5])
                    while(matcher.find()) {
                        switch(counter) {
                            case 0: amount = Integer.parseInt(matcher.group());
                            case 1: from = Integer.parseInt(matcher.group());
                            case 2: to = Integer.parseInt(matcher.group());
                        }
                        counter++;
                    }
                    //loop to switch positions of blocks
                    for (int z = 0; z < amount; z++) {
                        array.get(to-1).add(0, array.get(from-1).get(0));
                        array.get(from-1).remove(0);
                    }
                }

                lineNum++;
                line = reader.readLine();
            }

            for (List<Character> row : array) {
                for (Character element : row) {
                    System.out.print(element + " ");
                }
                message += row.get(0);
                System.out.println();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The crates on top are: " + message);
    }

    public static void main(String[] args) {
        new SupplyStacks();
    }
}
