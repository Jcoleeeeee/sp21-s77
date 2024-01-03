package deque;


public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addLast(Item x){
        if (size == items.length ){
            resize( items.length * 2);
        }
        items[nextLast] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }
    public void addFirst(Item x){
        if (size == items.length){
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        nextFirst = (nextFirst + 1) % items.length;
        size++;
    }
    public Item removeFirst(){
        if (isEmpty()){
            return null; 
        }
        nextFirst = (nextFirst + 1) % items.length;
        Item remveitem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        if (size > 16 && size == items.length/4) {
            resize(items.length / 2);
        }
        return remveitem;
    }
    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        nextLast = (nextLast - 1) % items.length;
        Item removed = items[nextLast];
        items[nextLast] = null;
        size--;
        if (size > 16 && size == items.length / 4){
            resize(items.length / 2);
        }
        return removed;
    }

    public Item get(int x){
        return items[x];
    }


    private void resize(int capacity){
        Item[] newItems = (Item[]) new Object[capacity];
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
