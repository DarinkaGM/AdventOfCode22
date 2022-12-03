public class Test {
    public static void main(String[] args) throws Exception {
        Rucksack r = new Rucksack();
        r.readInput();
        r.getScore();
        System.out.println("Total: " + (r.getScore()));
    }
}
