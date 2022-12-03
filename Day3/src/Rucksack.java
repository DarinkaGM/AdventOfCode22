import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Rucksack {
    private ArrayList<String> rucksack = new ArrayList<String>();
    private Set<Character> abc1 = new HashSet<Character>();
    private Set<Character> abc2 = new HashSet<Character>();
    private List<Character> f = new ArrayList<Character>();

    public void readInput() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(
                "/Users/darinka/AdventOfCode22/Day3/src/input.txt"));
        String l = s.nextLine();
        while (s.hasNextLine()) {
            rucksack.add(l);
            compartments(l.substring(0, l.length() / 2), l.substring(l.length() / 2));
            l = s.nextLine();
        }
        s.close();
    }

    public void compartments(String s1, String s2) {
        for (char c : s1.toCharArray()) {
            abc1.add(c);
        }
        for (char c : s2.toCharArray()) {
            abc2.add(c);
        }
        abc1.retainAll(abc2);
        migrateSets();

    }

    public void migrateSets() {
        abc1.forEach(c -> {
            f.add(c);
        });
        abc1.clear();
        abc2.clear();
    }

    public int getScore() {
        return f.stream().mapToInt(c -> Character.isLowerCase(c) ? (1 + (c - 'a')) : (27 + (c - 'A')))
                .sum();
    }
}
