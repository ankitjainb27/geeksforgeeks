package com.iitr.linkedlist;

/**
 * Created by AnkitJain on 15/06/16.
 */
public class LinkedList {
    Node head;

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        ll.head.next = second;
        second.next = third;

        ll.push(0);
        ll.insertAfter(second, 4);
        ll.append(5);
        //ll.printList();
//        ll.delete(4);
        //System.out.println("----");
        //ll.printList();
//        ll.delete(2);
        //System.out.println("----");
        //ll.printList();
        ll.deleteAtPosition(6);

        System.out.println("Length = " + ll.length());
        System.out.println("Length Recursive = " + ll.lengthRecurvise(ll.head));
        ll.swap(0, 5);
        ll.printList();
        System.out.println("----");
        ll.head = ll.reverseIterative();
        ll.head = ll.reverseRecursion(ll.head, null);
        ll.printList();
    }

    private Node reverseRecursion(Node remaining, Node prev) {
        if (remaining == null) {
            head = prev;
            return null;
        }
        Node next1 = remaining.next;
        remaining.next = prev;
        reverseRecursion(next1,remaining );
        return head;
    }

    private Node reverseIterative() {
        Node prev = null;
        Node current = head;
        Node next1 = current.next;
        while (current != null) {
            current.next = prev;
            prev = current;
            if (next1 != null) {
                current = next1;
            } else {
                break;
            }
            next1 = next1.next;
        }
        return current;
    }

    private void swap(int i, int j) {
        if (i == j)
            return;
        Node node = head;
        Node prevI = null;
        Node prevJ = null;
        Node currentI = null;
        Node currentJ = null;
        if (head.data == i) {
            currentI = head;
            prevI = null;
        }
        if (head.data == j) {
            currentJ = head;
            prevJ = null;
        }
        while (node.next != null) {
            if (node.next.data == i) {
                prevI = node;
                currentI = node.next;
            } else if (node.next.data == j) {
                prevJ = node;
                currentJ = node.next;
            }
            node = node.next;
        }
        if (currentI == null || currentJ == null) {
            return;
        }
        Node temp;
        if (prevI != null) {
            prevI.next = currentJ;
        } else {
            head = currentJ;
        }
        if (prevJ != null) {
            prevJ.next = currentI;
        } else {
            head = currentI;
        }

        temp = currentI.next;
        currentI.next = currentJ.next;
        currentJ.next = temp;
        //swap(currentI.next, currentJ.next);

        return;

    }

    private void swap(Node next, Node next1) {
        Node temp = next;
        next = next1;
        next1 = temp;
        return;
    }

    private int lengthRecurvise(Node node) {
        if (node == null)
            return 0;
        return 1 + lengthRecurvise(node.next);
    }

    private int length() {
        int count = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;

    }

    private void deleteAtPosition(int i) {
        int counter = 0;
        if (head != null) {
            if (i == 0) {
                head = head.next;
                return;
            } else {
                Node node = head;
                while (node != null && counter < i - 1) {
                    node = node.next;
                    counter++;
                }
                if (node == null || node.next == null) {
                    return;
                }
                node.next = node.next.next;

            }
        }
    }

    private void delete(int i) {
        if (head != null) {
            if (head.data == i) {
                head = head.next;
                return;
            } else {
                Node node = head.next;
                Node prev = head;
                while (node != null) {
                    if (node.data == i) {
                        prev.next = node.next;
                        return;
                    }
                    prev = node;
                    node = node.next;
                }
                return;
            }
        }
    }

    private void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private void push(int start) {
        Node startItem = new Node(start);
        startItem.next = head;
        head = startItem;
    }

    private void insertAfter(Node prev_node, int value) {
        if (prev_node != null) {
            Node new_node = new Node(value);
            new_node.next = prev_node.next;
            prev_node.next = new_node;
        }
        return;
    }

    private void append(int end) {
        if (head == null) {
            head = new Node(end);
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(end);

        }
        return;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
