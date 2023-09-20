package AoC2022.Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class MonkeyInTheMiddle{
    ArrayList<Monkey> monkeys = new ArrayList<>();
    int worryLevel = 0;
    public MonkeyInTheMiddle() {

        //create all monkeys
        createMonkeys();

        //loop rounds(20tot) for every monkey(7tot)
        for (int round = 1; round <= 20; round++) {
            for (Monkey monkey:monkeys) {
                ArrayList<Integer> itemList = monkey.getItems();
                //loop while monkey has items to inspect/throw left in its itemlist
                while (!monkey.getItems().isEmpty()) {
                    //different operation based on monkey
                    switch (monkeys.indexOf(monkey)) {
                        case 0 -> worryLevel = itemList.get(0) * 7;
                        case 1 -> worryLevel = itemList.get(0) * itemList.get(0);
                        case 2 -> worryLevel = itemList.get(0) + 8;
                        case 3 -> worryLevel = itemList.get(0) + 4;
                        case 4 -> worryLevel = itemList.get(0) + 3;
                        case 5 -> worryLevel = itemList.get(0) + 5;
                        case 6 -> worryLevel = itemList.get(0) + 7;
                        case 7 -> worryLevel = itemList.get(0) * 3;
                    }

                    //worrylevel is divided by 3 rounded down when monkey about to throw
                    worryLevel = worryLevel/3;
                    //if worrylevel is evenly divided by testToDivide throw to ifTrue monkey
                    // else throw to isFalse monkey
                    if(worryLevel % monkey.testToDivide == 0) {
                        monkeys.get(monkey.ifTrue).getItems().add(worryLevel);
                    } else {
                        monkeys.get(monkey.ifFalse).getItems().add(worryLevel);
                    }
                    //up counter each inspection of an item
                    monkey.setCounter(monkey.getCounter() +1);
                    monkey.getItems().remove(0);
                }
            }
            //print monkey inventory
            System.out.println("----- Round: " + round + " -----");
            for (Monkey monkey:monkeys) {
                System.out.println(monkey.getItems());
            }
        }

        //print all monkey counters
        System.out.println("All monkey-counters:");
        monkeys.stream().map(Monkey::getCounter).sorted().forEach(System.out::println);

        //sort monkeycounters and print the two highest numbers multiplied
        List<Integer> firstTwoInts = monkeys.stream()
                .map(Monkey::getCounter)
                .sorted(Comparator.reverseOrder())
                .limit(2).toList();
        System.out.println("Two highest multiplied: " + firstTwoInts.get(0)*firstTwoInts.get(1));
    }


    //creates all monkeys and puts them in arraylist (monkeys)
    public void createMonkeys() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/AoC2022/Day11/input.txt"));
            String line = reader.readLine();

            while(line != null) {

                ArrayList<Integer> items = new ArrayList<>();
                int testToDivide = 0;
                int ifTrue = 0;
                int ifFalse = 0;

                line = reader.readLine();
                String numbers = line.substring(18);
                String[] numbersArray = numbers.split(", ");

                //adds all starting items to itemlist
                for (String element:numbersArray) {
                    items.add(Integer.parseInt(element));
                }
                reader.readLine();
                line = reader.readLine();
                testToDivide = Integer.parseInt(line.substring(21));

                line = reader.readLine();
                ifTrue = Integer.parseInt(line.substring(29));

                line = reader.readLine();
                ifFalse = Integer.parseInt(line.substring(30));

                //monkey constructor
                monkeys.add(new Monkey(items, testToDivide, ifTrue, ifFalse));
                reader.readLine();

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {new MonkeyInTheMiddle();}
}
