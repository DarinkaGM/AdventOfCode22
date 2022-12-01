import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CaloriesCounter {
    private Map<Elf, List<Integer>> elfCalories = new HashMap<Elf, List<Integer>>();
    private Map<Elf, Integer> elfSum = new HashMap<Elf, Integer>();
    private int c = 1;

    public void readInput() {
        try {
            Scanner s = new Scanner(new FileReader("/Users/darinka/Desktop/Day1/src/input.txt"));
            Scanner s2 = new Scanner(new FileReader("/Users/darinka/Desktop/Day1/src/input.txt"));
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

    public static void main(String[] args) {
        CaloriesCounter cc = new CaloriesCounter();
        cc.readInput();
        cc.getSum();
        cc.getMaxSum();
    }
}