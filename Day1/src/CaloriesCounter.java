import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class CaloriesCounter {
    private Map<Elf, List<Integer>> elfCalories = new HashMap<Elf, List<Integer>>();
    private Map<Elf, Integer> elfSum = new HashMap<Elf, Integer>();
    private List<Entry<Elf, Integer>> l;

    private int c = 1;

    public void readInput() {
        try {
            Scanner s = new Scanner(new FileReader(
                    "/Users/darinka/AdventOfCode22/Day1/src/input.txt"));
            Scanner s2 = new Scanner(new FileReader(
                    "/Users/darinka/AdventOfCode22/Day1/src/input.txt"));
            String line = s2.nextLine();
            int c1 = s.nextInt();
            List<Integer> listOfCal = new ArrayList<Integer>();

            while (s.hasNextInt()) {
                if (line.equals("")) {
                    List<Integer> temp = new ArrayList<Integer>();
                    listOfCal.stream().forEach(i -> temp.add(i));
                    Elf elf = new Elf(c);
                    elfCalories.put(elf, temp);
                    line = s2.nextLine();
                    ++c;
                    listOfCal.clear();
                } else {
                    line = s2.nextLine();
                    listOfCal.add(c1);
                    c1 = s.nextInt();
                }
            }
            s.close();
            s2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getSum() {
        for (Elf e : elfCalories.keySet()) {
            Integer acc = 0;
            for (Integer d : elfCalories.get(e)) {
                acc += d;
            }
            elfSum.put(e, acc);
        }
    }

    public Integer getMaxSum() {
        Integer max = 0;
        for (Integer d : elfSum.values()) {
            if (d > max) {
                max = d;
            }
        }
        System.out.println(max.toString());
        return max;
    }

    public void sortDescending() {
        l = new ArrayList<>(elfSum.entrySet());
        l.sort(Entry.comparingByValue(Comparator.reverseOrder()));
    }

    public int getTopThreeSum() {
        sortDescending();
        int sum = 0;
        int count = 0;

        for (Map.Entry<Elf, Integer> it : l) {
            if (count < 3) {
                sum += it.getValue();
                ++count;
            } else {
                break;
            }
        }
        return sum;
    }
}