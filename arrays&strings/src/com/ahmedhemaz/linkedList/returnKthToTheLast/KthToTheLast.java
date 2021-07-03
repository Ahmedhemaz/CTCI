package com.ahmedhemaz.linkedList.returnKthToTheLast;

import com.ahmedhemaz.linkedList.LinkedListImp.LinkedList;

public class KthToTheLast {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(4);
//        linkedList.add(6);
//        linkedList.add(99);
//        linkedList.add(101);
//        linkedList.add(3);
//        linkedList.add(1);
//        linkedList.add(0);
//        linkedList.add(0);
//        linkedList.add(0);
        linkedList.printLinkedList();
        System.out.println();
        LinkedList.Node node = findKthFromLast(linkedList.getHead(), 7);
        System.out.println(node != null ? node.value : null);
    }

    // Time O(N) Space O(1)
    public static LinkedList.Node findKthFromLast(LinkedList.Node head, int k) {
        if (head == null) return null;
        LinkedList.Node slowPointer = head;
        LinkedList.Node current = head;
        int counter = 0;
        while(current.next != null) {
            if(counter >= k-1) {
                slowPointer = slowPointer.next;
            }
            current = current.next;
            counter++;
        }
        if(counter < k)
            throw new IllegalArgumentException("K is bigger than LinkedList size which is: " + (counter + 1));
        return slowPointer;
    }
}
