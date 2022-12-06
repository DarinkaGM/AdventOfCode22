import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Markers {
    private Boolean pt1;
    int p;

    public Markers(boolean pt1) {
        this.pt1 = pt1;
    }

    public void setP() {
        if (pt1) {
            this.p = 4;
        } else {
            this.p = 14;
        }
    }

    public void readInput() throws FileNotFoundException {
        setP();
        Scanner s = new Scanner(new FileReader("/Users/darinka/AdventOfCode22/Day6/src/input.txt"));
        String str = s.nextLine();
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length - 1; i++) {
            Set<Character> chSet = new HashSet<Character>();
            int x = 0;
            for (int j = i; j < i + p; j++) {
                chSet.add(chArr[j]);
                x = j;
            }
            x++;
            if (!(chSet.size() < p)) {
                System.out.println("Found at index " + i + " after " + x + " processed items.");
                break;
            }
        }
        s.close();
    }

}