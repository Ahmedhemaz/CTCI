package com.ahmedhemaz.linkedList.LinkedListImp;

public class LinkedList {
    public class Node {
        public int value;
        public Node next;
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

    public Node getNodOf(int value) {
        Node current = this.head;
        while (current != null) {
            if (current.value == value) return  current;
            current = current.next;
        }
        return  null;
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
