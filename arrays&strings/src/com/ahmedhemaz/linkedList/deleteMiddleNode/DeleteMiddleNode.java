package com.ahmedhemaz.linkedList.deleteMiddleNode;

import com.ahmedhemaz.linkedList.LinkedListImp.LinkedList;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(99);
        linkedList.add(101);
        linkedList.add(3);
        linkedList.add(0);
        linkedList.printLinkedList();
        System.out.println();
//        removeMiddleNode(linkedList.getHead());
        deleteMiddleNode(linkedList.getNodOf(6));
        linkedList.printLinkedList();

    }

    public static void deleteMiddleNode(LinkedList.Node node) {
        if (node == null || node.next == null) return;
        node.value = node.next.value;
        node.next = node.next.next;

    }

    public static void removeMiddleNode(LinkedList.Node head) {
        if (head == null || head.next == null) return;
        LinkedList.Node beforeMidNode = getBeforeMidNode(head);
        removeNextNode(beforeMidNode);
    }

    public static LinkedList.Node getBeforeMidNode(LinkedList.Node head) {
        LinkedList.Node fastPointer = head.next;
        LinkedList.Node slowPointer = head;

        while(fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static void removeNextNode(LinkedList.Node currentNode) {
        currentNode.next = currentNode.next.next;
    }


}
