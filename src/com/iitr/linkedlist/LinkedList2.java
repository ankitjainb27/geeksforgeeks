package com.iitr.linkedlist;

public class LinkedList2 {

    Node123 head;

    //TODO - TOASK why Node class need to be static
    //NOTES - In Linked List things are inserted in the start of the list
    static class Node123 {
        int data;
        Node123 next;

        Node123(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        // write your code here
        LinkedList2 linkedList = new LinkedList2();
        linkedList.head = new Node123(1);
        Node123 node1 = new Node123(2);
        linkedList.head.next = node1;
        Node123 node2 = new Node123(3);
        node1.next = node2;
        linkedList.printList();
        linkedList.push_node(0);
        linkedList.printList();
        linkedList.insertAfter(node2, 4);
        linkedList.printList();
        System.out.println();
        linkedList.insertInEnd(6);
        linkedList.printList();


    }

    private void insertInEnd(int i) {
        Node123 node = new Node123(i);
        Node123 n = head;
        if (head == null) {
            head = new Node123(i);
            return;
        }

        while (n.next != null) {
            n = n.next;
        }
        n.next = node;

    }

    private void insertAfter(Node123 node1, int i) {
        if (node1 == null) {
            System.out.print("Can't be null");
            return;
        }
        Node123 node = new Node123(i);
        node.next = node1.next;
        node1.next = node;
    }

    private void push_node(int i) {
        Node123 node = new Node123(i);
        node.next = head;
        head = node;
    }

    public void printList() {
        Node123 n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }


}
