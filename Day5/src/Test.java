public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("-----PT1-----");
        Crane c = new Crane(true);
        c.feedStacks();
        c.addToStacks();
        c.readInput();
        c.printStacks();
        System.out.println("-----PT2-----");
        Crane c2 = new Crane(false);
        c2.feedStacks();
        c2.addToStacks();
        c2.readInput();
        c2.printStacks();
    }
}
