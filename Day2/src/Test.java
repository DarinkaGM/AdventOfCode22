public class Test {
    public static void main(String[] args) throws Exception {
        Game g = new Game();
        g.readInput();
        g.readInput2();
        g.getSum();
        g.getSum2();
    }
}
// W = 6
// D = 3
// L = 0

// X = 1
// Y = 2
// Z = 3

// --------------PT1---------------
// A
// X + D
// Y + W
// Z + L

// B
// X + L
// Y + D
// Z + W

// C
// X + W
// Y + L
// Z + D

// --------------PT2---------------
// X -> L
// Y -> D
// Z -> W

// A
// X -> L + Z
// Y -> D + X
// Z -> W + Y

// B
// X -> L + X
// Y -> D + Y
// Z -> W + Z

// C
// X -> L + Y
// Y -> D + Z
// Z -> W + X