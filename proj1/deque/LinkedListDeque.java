package deque;

import jh61b.junit.In;
import org.apache.commons.beanutils.PropertyUtilsBean;

public class LinkedListDeque<BleeoBlorp> {

    public class IntNode{
        public IntNode prev;
        public BleeoBlorp item;
        public IntNode next;

    }
    private int size;
    private IntNode sentinel;
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return sentinel == sentinel.next;
    }
    /*create a linklist */
//    public LinkedListDeque(){
//        sentinel = new IntNode();
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//    }
    public void addFirst(BleeoBlorp x){
        IntNode newNode = new IntNode();
        newNode.item = x;
        newNode.prev = sentinel;
        newNode.next = sentinel.next;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }
    public LinkedListDeque(){
        sentinel = new IntNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addLast(BleeoBlorp x){
        IntNode newNode = new IntNode();
        newNode.item = x;
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
    public void printDeque(){
        IntNode node = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(node.item);
            node = node.next;
        }
    }
    public BleeoBlorp removeFirst(){
        if (isEmpty()){
            return null;
        }
        IntNode removedNode = sentinel.next;
        if (removedNode.next != null){
            removedNode.next.prev = sentinel;
            sentinel.next = removedNode.next;
        }
        removedNode.next = null;
        removedNode.prev = null;

        return  removedNode.item;
    }
    public BleeoBlorp removeLast(){
        if (isEmpty()){
            return null;
        }
        IntNode removedNode = sentinel.prev;
        if (removedNode.prev != null){
            removedNode.prev.next = sentinel;
            sentinel.prev = removedNode.prev;
        }
        removedNode.next = null;
        removedNode.prev = null;
        size--;

        return removedNode.item;
    }
    public BleeoBlorp get(int index){
        if (index >= size || index < 0){
            return null;
        }
        IntNode node = sentinel.next;
        for (int i = 0 ; i < index; i++){
            node = node.next;
        }
        return node.item;
    }

    public BleeoBlorp getRecursive(int index){
        if (index >= size || index < 0){
            return null;
        }
        return getRecursiveHelper(index,sentinel.next);
    }

    private BleeoBlorp getRecursiveHelper(int index,IntNode node){
        if (index == 0 ){
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }

}
