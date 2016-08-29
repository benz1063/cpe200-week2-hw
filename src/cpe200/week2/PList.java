package cpe200.week2;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        PNode tmp = new PNode(i, head, null);

        if (tail==null){
            tail = head;
        }
        else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
            tmp.next = null;
            size++;
        }

    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char ptr = tail.data;
        PNode tmp;
        if (tail.prev == null) {
            tmp = tail;
            size--;
        }
        else {
            tail = tail.prev;
            tmp = tail.next;
            tail.next = null;
            size--;
        }
        return ptr;
    }

    public boolean search(char i) {

        PNode tmp=head;
        if (tmp.data  == i) {
            return true;
        }
        else {
            while (tmp.next.data != i) {
                tmp = tmp.next;
                if (tmp.next == null) {
                    return false;
                }

            }return true;
        }

    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void printForward() {

        PNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
