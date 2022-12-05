import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Crane {
    private ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
    private Stack<Character> s1, s2, s3, s4, s5, s6, s7, s8, s9;
    int move, from, to;
    String str1, str2, str3;
    Boolean pt1;

    public Crane(Boolean b) {
        this.pt1 = b;
    }

    public void readInput() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader("/Users/darinka/AdventOfCode22/Day5/src/input.txt"))
                .useDelimiter("\\s|\\n");
        while (s.hasNext("move")) {
            str1 = s.next();
            move = s.nextInt();
            str2 = s.next();
            from = s.nextInt() - 1;
            str3 = s.next();
            to = s.nextInt() - 1;

            handleMove(move, from, to);
        }
        s.close();
    }

    public void handleMove(int move, int from, int to) {
        for (int i = 0; move > i; move--) {
            if (stacks.get(from).size() >= move) {
                if (pt1) {
                    stacks.get(to).push(stacks.get(from).pop());
                } else {
                    stacks.get(to).add(stacks.get(from).get(stacks.get(from).size() - move));
                    stacks.get(from).remove(stacks.get(from).size() - move);
                }
            }
        }
    }

    public void printStacks() {
        stacks.forEach(s -> System.out.println(s.get(s.size() - 1)));
    }

    public void feedStacks() throws FileNotFoundException {
        s1 = new Stack<Character>();
        s2 = new Stack<Character>();
        s3 = new Stack<Character>();
        s4 = new Stack<Character>();
        s5 = new Stack<Character>();
        s6 = new Stack<Character>();
        s7 = new Stack<Character>();
        s8 = new Stack<Character>();
        s9 = new Stack<Character>();
        Scanner s = new Scanner(new FileReader("/Users/darinka/AdventOfCode22/Day5/src/input2.txt"))
                .useDelimiter("\\s|\\n");
        String line = s.nextLine();

        while (s.hasNextLine()) {
            for (int i = 1; i <= 33; i += 4) {
                if (!(line.charAt(i) == ' ')) {
                    switch (i) {
                        case 1:
                            s1.add(line.charAt(i));
                            break;
                        case 5:
                            s2.add(line.charAt(i));
                            break;
                        case 9:
                            s3.add(line.charAt(i));
                            break;
                        case 13:
                            s4.add(line.charAt(i));
                            break;
                        case 17:
                            s5.add(line.charAt(i));
                            break;
                        case 21:
                            s6.add(line.charAt(i));
                            break;
                        case 25:
                            s7.add(line.charAt(i));
                            break;
                        case 29:
                            s8.add(line.charAt(i));
                            break;
                        case 33:
                            s9.add(line.charAt(i));
                            break;
                    }
                }
            }
            line = s.nextLine();
        }
    }

    public void addToStacks() {
        stacks.add(s1);
        stacks.add(s2);
        stacks.add(s3);
        stacks.add(s4);
        stacks.add(s5);
        stacks.add(s6);
        stacks.add(s7);
        stacks.add(s8);
        stacks.add(s9);
        stacks.stream().forEach(s -> Collections.reverse(s));
    }
}