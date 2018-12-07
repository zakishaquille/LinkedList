/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modul3;

/**
 *
 * @author Shaquille
 */
public class LinkedList {

    LinkedListNode head;
    LinkedListNode tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void print() {
        LinkedListNode current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    void push(LinkedListNode new_node) {
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
        } else {
            this.tail.next = new_node;
            new_node.prev = this.tail;
            this.tail = new_node;
        }
    }

    void insert(LinkedListNode new_node) {
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
        } else if (new_node.data <= this.head.data) {
            new_node.set_next(this.head);
            this.head = new_node;
        } else if (new_node.data >= this.tail.data) {
            new_node.set_prev(this.tail);
            this.tail = new_node;
        } else {
            LinkedListNode position = head;
            while (position.data < new_node.data) {
                position = position.next;
            }
            LinkedListNode previous_position = position.prev;
            new_node.set_next(position);
            new_node.set_prev(previous_position);
        }
    }

    LinkedListNode find_node_by_data(int data) {
        LinkedListNode current = this.head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
        }
        return null;
    }

    void delete(LinkedListNode deleted) {
        if (deleted != null && this.head != null) {
            if (this.head == this.tail && deleted == this.head) {
                this.head = null;
                this.tail = null;
            } else if (deleted == this.head) {
                LinkedListNode new_head = this.head.next;
                this.head.set_next(null);
                new_head.set_prev(null);
                this.head = new_head;
            } else if (deleted == this.tail) {
                LinkedListNode new_tail = this.tail.prev;
                this.tail.set_prev(null);
                new_tail.set_next(null);
                this.tail = new_tail;
            } else {
                LinkedListNode deleted_prev = deleted.prev;
                LinkedListNode deleted_next = deleted.next;
                deleted.set_prev(null);
                deleted.set_next(null);
                deleted_prev.set_next(deleted_next);
            }
        }
    }

    void bubbleSort() {
        boolean changed;

        do {
            LinkedListNode current = head;
            LinkedListNode previous = null;
            LinkedListNode next = head.next;
            changed = false;

            while (next != null) {
                if (current.data > next.data) {
                    changed = true;

                    if (previous != null) {
                        LinkedListNode nextnext = next.next;

                        previous.next = next;
                        next.next = current;
                        current.next = nextnext;
                    } else {
                        LinkedListNode nextnext = next.next;

                        head = next;
                        next.next = current;
                        current.next = nextnext;
                    }

                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (changed);
    }

    LinkedListNode partition(LinkedListNode start, LinkedListNode end) {
        LinkedListNode l = start;
        LinkedListNode h = end.prev;
        LinkedListNode pivot = end;

        if (end != null && end.next != start) {
            while (h != null && h.next != l) {
                if (l.data <= pivot.data) {
                    l = l.next;
                } else if (h.data >= pivot.data) {
                    h = h.prev;
                } else {
                    int temp = l.data;
                    l.data = h.data;
                    h.data = temp;
                }
            }
            int temp = pivot.data;
            pivot.data = l.data;
            l.data = temp;
        }
        return l;
    }

    void quickSort(LinkedListNode start, LinkedListNode end) {
        if (end != null && end.next != start) {
            LinkedListNode pivot = partition(start, end);
            quickSort(start, pivot.prev);
            quickSort(pivot.next, end);
        }
    }
    
}