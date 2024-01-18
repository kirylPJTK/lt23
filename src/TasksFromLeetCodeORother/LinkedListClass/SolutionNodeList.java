package TasksFromLeetCodeORother.LinkedListClass;

public class SolutionNodeList {
    public static void main(String[] args) {
        NodeList arr1 = new NodeList();
        NodeList arr2 = new NodeList();

        arr1.add(2);
        arr1.add(4);
        arr1.add(3);

        arr2.add(5);
        arr2.add(6);
        arr2.add(4);

        System.out.println(arr1.toString());

        arr1.reverseList();
        arr2.reverseList();

        System.out.println(arr1.toString() + " - " + arr2.toString());

        System.out.println(arr1.makeItNum() + arr2.makeItNum());

        int resNum = arr1.makeItNum() + arr2.makeItNum();

        System.out.println(arr1.makeNotNum(resNum).toString());
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NodeList {
    private Node head;

    public NodeList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        Node left = null;
        Node current = head;
        Node right = null;

        while (current != null) {
            right = current.next;
            current.next = left;
            left = current;
            current = right;
        }

        head = left;
    }

    public int makeItNum() {
        int result = 0;
        Node current = head;

        while (current != null) {
            result = result * 10 + current.data;
            current = current.next;
        }

        return result;
    }

    public NodeList makeNotNum(int num) {
        int tmp = num;
        int count = 0;

        while (tmp > 0) {
            tmp /= 10;
            count++;
        }

        NodeList result = new NodeList();
        for (int i = count - 1; i >= 0; i--) {
            result.add(num % 10);
            num /= 10;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}
