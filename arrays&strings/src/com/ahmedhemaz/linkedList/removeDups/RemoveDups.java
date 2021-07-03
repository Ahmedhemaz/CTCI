package com.ahmedhemaz.linkedList.removeDups;

import com.ahmedhemaz.linkedList.LinkedListImp.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(6);
        linkedList.add(99);
        linkedList.add(88);
        linkedList.add(88);
        linkedList.add(88);
        linkedList.add(88);
        linkedList.add(88);
        linkedList.add(105);
        linkedList.printLinkedList();
        removeDup(linkedList.getHead());
        System.out.println();
        System.out.println("==============");
        linkedList.printLinkedList();
    }

    // time O(N) space O(M) M => Number of unique values of the list
    public static void removeDup(LinkedList.Node linkedList) {
        Set<Integer> hset = new HashSet<>();
        if(linkedList == null || linkedList.next == null) return;

        LinkedList.Node current = linkedList;
        hset.add(current.value);
        while(current.next != null) {
            if(!hset.add(current.next.value)) {
                current.next = current.next.next;
            }else  {
                current = current.next;
            }
        }
    }

    // time O(N^2) space O(1)
    public static void removeDupWithNoExtraSpace(LinkedList.Node linkedList) {
        if(linkedList == null || linkedList.next == null) return;
        LinkedList.Node current = linkedList;
        while(current != null) {
            LinkedList.Node fastPointer = current;
            while(fastPointer.next != null) {
               if (current.value == fastPointer.next.value) {
                   fastPointer.next = fastPointer.next.next;
               } else {
                   fastPointer = fastPointer.next;
               }
           }
           current = current.next;
        }
    }
}
