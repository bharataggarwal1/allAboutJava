package com.bharat.collection.linkedlist;

import java.util.*;

public class LinkedListProblems {
    public static void main(String[] args)
    {
        push(20);
        push(4);
        push(15);
        push(10);
        head.next.next.next.next = head;

        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
        //to find middle of the linked list use fast pointer

        // parallel streaming on linked list -no advantage - accessing is sequential O(n)
        LinkedList<Integer> list =new LinkedList<>();
        //no array resizing required to add/remove elements
        //uses doubly linked list next,prev pointer
        list.add(2,5);
    }

    static Node head; // head of list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    //using hashset or using fast pointer(floyd's algorithm)
    static boolean detectLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            if (s.contains(h))
                return true;
            s.add(h);
            h = h.next;
        }
        return false;
    }


}
