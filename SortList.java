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
public class SortList {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        for(int i=1; i<=10; i++) {
            a.push(new LinkedListNode((int)(Math.random() * 50 + 1)));
        }
        
        System.out.println("Sebelum sorting: ");
        a.print();
        System.out.println();
        
        a.bubbleSort();
        System.out.println("Setelah sorting dengan bubble sort: ");
        a.print();
        
        System.out.println("====================================");
        
        LinkedList b = new LinkedList();
        for(int i=1; i<=10; i++) {
            b.push(new LinkedListNode((int)(Math.random() * 50 + 1)));
        }
        
        System.out.println("Sebelum sorting: ");
        b.print();
        System.out.println();
        
        b.quickSort(b.head, b.tail);
        System.out.println("Setelah sorting dengan quick sort: ");
        b.print();
    }
}
