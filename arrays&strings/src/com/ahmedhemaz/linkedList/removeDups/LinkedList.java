package com.ahmedhemaz.linkedList.removeDups;

public class LinkedList {
    class Node {
        int value;
        Node next;
        public  Node(int value ) {
            this.value = value;
        }
    }
    int value;
    Node head;
    Node tail;
    public LinkedList() {
    }

    public void add(int value) {
        if (head == null && tail == null) head = tail = new Node(value);
        else {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    public void printLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
    }

    public Node getHead() {
        return this.head;
    }
}
