package com.lll.CollectionsStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fayne on 2018/03/13.
 */
public class test {
    public static void main(String[] args) {
        reverselinkedlist();


    }

    /**
     * 反转链表，通过迭代法
     */
    private static void reverselinkedlist() {
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        resverse(a1);
        System.out.println(a5.toString());
    }

    private static void resverse(Node a1) {
        Node pre = null;
        Node cur = a1;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

    }

    private static void testforcoll() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(7);
        list.add(8);
        Collections.sort(list);
        Collections.addAll(list, 1, 2, 3, 8);
        int i = Collections.binarySearch(list, 9);
        System.out.println(list);
        System.out.println(i);
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
