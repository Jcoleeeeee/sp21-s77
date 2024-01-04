package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> List1 = new AListNoResizing<>();
        BuggyAList<Integer> List2 = new BuggyAList<>();

        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        List2.addLast(4);
        List2.addLast(5);
        List2.addLast(6);


        assertEquals(List1.size(),List2.size());
        assertEquals(List1.removeLast(),List2.removeLast());
        assertEquals(List1.removeLast(),List2.removeLast());
        assertEquals(List1.removeLast(),List2.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(L.size(),broken.size());
            } else if (L.size() == 0) {
                continue;
            } else if (operationNumber == 2){
                //getLast
                assertEquals(L.getLast(),broken.getLast());
            }else if (operationNumber == 3){
                assertEquals(L.removeLast(),broken.removeLast());
            }
        }
    }
}
