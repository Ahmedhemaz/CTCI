package com.ahmedhemaz.linkedList.partition;

import com.ahmedhemaz.linkedList.LinkedListImp.LinkedList;

public class Partition {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.printLinkedList();
        System.out.println();
        partition(linkedList, 5);
        linkedList.printLinkedList();

    }

    public static void partition(LinkedList ls, int partitionVal) {
        LinkedList.Node firstLowerNode = ls.getHead();
        LinkedList.Node current = ls.getHead();
        while(current.next != null) {
            if (current.next.value < partitionVal) {
                addNext(firstLowerNode, current.next.value);
                current.next = current.next.next;
                firstLowerNode = firstLowerNode.next;
            }else {
                current = current.next;
            }
        }
        if (ls.getHead().value >= partitionVal) {
            current.next = new LinkedList.Node(ls.getHead().value);
            ls.setHead(ls.getHead().next);
        }    }

    public static void addNext(LinkedList.Node currentNode, int val) {
        LinkedList.Node newNode = new LinkedList.Node(val);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

}
