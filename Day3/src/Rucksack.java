import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Rucksack {
    private ArrayList<String> rucksack = new ArrayList<String>();
    private Set<Character> abc1 = new HashSet<Character>();
    private Set<Character> abc2 = new HashSet<Character>();
    private Set<Character> abc3 = new HashSet<Character>();
    private List<Character> f = new ArrayList<Character>();
    private Boolean pt1 = true;

    Rucksack(Boolean b) {
        this.pt1 = b;
    }

    public void readInput() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(
                "/Users/darinka/AdventOfCode22/Day3/src/input.txt"));
        String l = s.nextLine();
        String e1 = "";
        String e2 = "";
        String e3 = "";
        int c = 0;
        while (s.hasNextLine()) {
            rucksack.add(l);
            c++;
            if (!pt1) {
                switch (c) {
                    case 1:
                        e1 = l;
                        break;
                    case 2:
                        e2 = l;
                        break;
                    case 3:
                        e3 = l;
                        break;
                }
                if (c == 3) {
                    compartments(e1, e2, e3);
                    c = 0;
                    e1 = "";
                    e2 = "";
                    e3 = "";
                }
            } else if (pt1) {
                compartments(l.substring(0, l.length() / 2), l.substring(l.length() / 2));
            }
            l = s.nextLine();
        }
        s.close();
    }

    public void compartments(String s1, String s2) {
        abc1 = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        abc2 = s2.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        abc1.retainAll(abc2);
        migrateSets();
    }

    public void compartments(String s1, String s2, String s3) {
        abc1 = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        abc2 = s2.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        abc3 = s3.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        abc1.retainAll(abc2);
        abc1.retainAll(abc3);
        migrateSets();
    }

    public void migrateSets() {
        abc1.forEach(c -> {
            f.add(c);
        });
        abc1.clear();
        abc2.clear();
        abc3.clear();
    }

    public int getScore() {
        return f.stream().mapToInt(c -> Character.isLowerCase(c) ? (1 + (c - 'a')) : (27 + (c - 'A')))
                .sum();
    }
}
