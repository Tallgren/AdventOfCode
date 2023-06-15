# AdventOfCode

Advent of Code
This is a collection of my Advent of Code projects.

The website for the problems and descriptions can be found at https://adventofcode.com/ (enter what year e.g adventofcode.com/2022)

All days has a part 1 and part 2. Part 2 unlocks after finishing part 1 so often the code has to be rewritten and improved

I've done most problems in java but also tried some kotlin solutions


Key takeaways:
  - 2022 Day 4: Collections.disjoint, two collections return true ("are disjointed") if no elements match in the collections
  - 2018 Day 1: [i % inputList.size] can be used to loop to beginning of list (10%10 = 0(pos[0]) 11%10 = 1(pos[1]) etc...)
  - 2022 Day 5: Pattern and matcher to group and get ints from string (both multiple digits and 1 digit)
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(line);
    if(matcher.find()) {...Integer.parseInt(matcher.group())...}
