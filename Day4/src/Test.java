public class Test {
    public static void main(String[] args) throws Exception {
        CampCleanup cc = new CampCleanup(true);
        cc.readInput();
        CampCleanup cc2 = new CampCleanup(false);
        cc2.readInput();
    }
}