package com.ahmedhemaz.linkedList.partition;

import com.ahmedhemaz.linkedList.LinkedListImp.LinkedList;

public class Partition {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.printLinkedList();
        System.out.println();
        partition(linkedList, 2);
        linkedList.printLinkedList();

    }


    /* my solution of leetcode
        Link: https://leetcode.com/problems/partition-list/submissions/
    *  class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallListHead = new ListNode(0);
        ListNode smallListRunner = smallListHead;
        ListNode bigListHead = new ListNode(0);
        ListNode bigListRunner = bigListHead;
        ListNode runner = head;

        while(runner != null) {
            if(runner.val < x) {
                smallListRunner.next = runner;
                smallListRunner = smallListRunner.next;
            }else {
                bigListRunner.next = runner;
                bigListRunner = bigListRunner.next;
            }
            runner = runner.next;
        }

        bigListRunner.next = null;
        smallListHead = smallListHead.next;
        bigListHead = bigListHead.next;
        smallListRunner.next = bigListHead;
        return smallListHead == null ? bigListHead : smallListHead;

    }
}
    *
    *
    *
    * */

    // bug when the partiation is the head node
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
            System.out.println(current.value);
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
