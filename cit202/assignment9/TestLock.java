public class TestLock {
    public static void main (String [] args) {
        CombinationLock cl = new CombinationLock();
        cl.turn(false, 4);
        //cl.turn(true, 8);
    }
}