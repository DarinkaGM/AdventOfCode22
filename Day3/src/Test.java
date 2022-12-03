public class Test {
    public static void main(String[] args) throws Exception {
        Rucksack r = new Rucksack(true);
        r.readInput();
        System.out.println("------PT1------");
        System.out.println("Total: " + (r.getScore()));
        Rucksack r2 = new Rucksack(false);
        System.out.println("------PT2------");
        r2.readInput();
        System.out.println("Total: " + (r2.getScore()));
    }
}
