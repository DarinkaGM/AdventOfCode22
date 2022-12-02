import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Game {
    private int tp, tp2 = 0;
    private int W = 6;
    private int D = 3;
    private int X = 1;
    private int Y = 2;
    private int Z = 3;

    public void readInput() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(
                "/Users/darinka/AdventOfCode22/Day2/src/input.txt"));
        String l = s.nextLine();
        while (s.hasNextLine()) {
            switch (l) {
                case "A X":
                    tp += X + D;
                    break;
                case "A Y":
                    tp += Y + W;
                    break;
                case "A Z":
                    tp += Z;
                    break;
                case "B X":
                    tp += X;
                    break;
                case "B Y":
                    tp += Y + D;
                    break;
                case "B Z":
                    tp += Z + W;
                    break;
                case "C X":
                    tp += X + W;
                    break;
                case "C Y":
                    tp += Y;
                    break;
                case "C Z":
                    tp += Z + D;
                    break;
                case "":
                    break;
            }
            l = s.nextLine();
        }
        s.close();
    }

    public void readInput2() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(
                "/Users/darinka/AdventOfCode22/Day2/src/input.txt"));
        String l = s.nextLine();
        while (s.hasNextLine()) {
            switch (l) {
                case "A X":
                    tp2 += Z;
                    break;
                case "A Y":
                    tp2 += X + D;
                    break;
                case "A Z":
                    tp2 += Y + W;
                    break;
                case "B X":
                    tp2 += X;
                    break;
                case "B Y":
                    tp2 += Y + D;
                    break;
                case "B Z":
                    tp2 += Z + W;
                    break;
                case "C X":
                    tp2 += Y;
                    break;
                case "C Y":
                    tp2 += Z + D;
                    break;
                case "C Z":
                    tp2 += X + W;
                    break;
                case "":
                    break;
            }
            l = s.nextLine();
        }
        s.close();
    }

    public int getSum() {
        System.out.println(tp);
        return tp;
    }

    public int getSum2() {
        System.out.println(tp2);
        return tp2;
    }
}