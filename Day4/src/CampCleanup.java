import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CampCleanup {
    private Set<Integer> e1 = new HashSet<Integer>();
    private Set<Integer> e2 = new HashSet<Integer>();
    private int x = 0;
    private Boolean pt1 = true;

    public CampCleanup(Boolean b) {
        this.pt1 = b;
    }

    public void readInput() throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(
                "/Users/darinka/AdventOfCode22/Day4/src/input.txt")).useDelimiter("\\-|\\,|\n");
        int c = 0;
        int F, S;
        while (s.hasNext()) {
            c++;
            F = s.nextInt();
            S = s.nextInt();

            for (int i = F; i <= S; i++) {
                if (c == 1) {
                    e1.add(i);
                } else {
                    e2.add(i);
                }
            }
            if (c == 2) {
                if (pt1) {
                    if ((e1.stream().allMatch(e2::contains))
                            || (e2.stream().allMatch(e1::contains))) {
                        x++;
                    }
                } else {
                    if (!Collections.disjoint(e1, e2)) {
                        x++;
                    }
                }
                c = 0;
                e1.clear();
                e2.clear();
                s.nextLine();
            }
        }
        System.out.println("x:" + x);
        s.close();
    }
}