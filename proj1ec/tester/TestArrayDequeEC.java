package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    /*Adds a few things to list,checking isEmtpy() and size() are correct,
    * finallu printing the results.*/
    public void addIsEmptySizeTest(){

        System.out.println("Make sure to uncomment the lines below (add delete this print statement). ");
        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();

        assertTrue("A newly initialized LLdeque should be empty",lld1.isEmpty());

        lld1.addFirst(1);
        assertEquals(1,lld1.size());
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.addLast(2);
        assertEquals(2,lld1.size());

        lld1.addFirst(3);
        assertEquals(3,lld1.size());

        System.out.println("Printing out deque");
        lld1.printDeque();
    }
    /*Adds an item, then removes an item, and ensures that dll is empty afterwards */
    @Test
    public void addRemoveTest(){

        System.out.println("Make sure to uncomment the lines below (add delete this print statement). ");

        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();

        assertTrue("lld1 should be a emptu upon initializetion",lld1.isEmpty());

        lld1.addFirst(10);
        assertFalse("lld1 should contain 1 item",lld1.isEmpty());

        lld1.removeFirst();
        assertTrue("lld1 should be empty after remve", lld1.isEmpty());
    }
    @Test
    public void removeEmptyTest(){
        System.out.println("Make sure to uncomment the lines below (add delete this print statement). ");

        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();
        lld1.addFirst(7);

        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();

        int size = lld1.size();
        String errorMsg = "Bad size returned when removing from emptu deque. \n";
        errorMsg += " student size() returned " + size + "\n";
        errorMsg += " actual suze() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }
    @Test
    public void multioleParamTest(){
        StudentArrayDeque<String> lld1 = new StudentArrayDeque<>();
        StudentArrayDeque<Double> lld2 = new StudentArrayDeque<>();
        StudentArrayDeque<Boolean> lld3 = new StudentArrayDeque<>();

        lld1.addFirst("Jcole");
        lld2.addFirst(3.1415926);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    public void emptyNullReturnTest(){
        System.out.println("Make sure to uncomment the lines below (add delete this print statement). ");

        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();

        assertEquals("Shoule return null when removeFirst is called on an empty Deque",null, lld1.removeFirst());
        assertEquals("Shoule return null when removeFirst is called on an empty Deque",null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void getDequeTest(){
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();

        ArrayDequeSolution<Integer> lld2 = new ArrayDequeSolution<>();

        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (int i = 0; i < 1000000; i++) {
            lld2.addLast(i);
        }

        for (int i = 0; i <200 ; i++) {
            int StdRandom = edu.princeton.cs.algs4.StdRandom.uniform(999999);
            assertEquals("they should all equals,you konw that kids",lld2.getRecursive(StdRandom),lld1.get(StdRandom));
        }


    }

    @Test
    public void bigDequeTest(){
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        StudentArrayDeque<Integer> lld1 = new StudentArrayDeque<>();
        
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

}

