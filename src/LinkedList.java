public class LinkedList {
    Node head, point;
    int length;

    public LinkedList() {
        head = null;
        point = null;
        length = 0;
    }

    static class Node {
        int val;
        Node next;

        public Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            point = node;
            length++;
            return;
        }
        point.next = node;
        point = node;
        length++;
        return;
    }

    public void print() {
        System.out.print("The Array Elements are: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete(int ind) {
        if (ind == 0) {
            head = head.next;
            return;
        }
        if (length < ind || ind < 0) {
            System.out.println("Invalid delete Index");
            return;
        }
        int tind = 0;
        Node temp = head, prev = null;
        while (tind++ != ind && temp != null) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null && prev != null)
            prev.next = temp.next;
        temp = null;
    }
}
