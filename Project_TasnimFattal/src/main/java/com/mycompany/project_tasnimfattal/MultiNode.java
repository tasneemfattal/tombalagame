/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tasnimfattal;

/**
 *
 * @author tasni
 * @param <T>
 */
public class MultiNode<T> {
   /* T data;
        MultiNode<T> next;
        MultiNode<T> down;

        public MultiNode(T data) {
            this.data = data;
            this.next = null;
            this.down = null;
        }*/

    T data; // Generic data type
    MultiNode<T> next; // Pointer to next
    MultiNode<T> down; // Pointer to next row

    // Constructor with one parameter
    public MultiNode(T data) {
        this.data = data; // Assign given data
        this.next = null; // set next pointer to null
        this.down = null; // set down pointer to null
    }

   public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MultiNode<T> getNext() {
        return next;
    }

    public void setNext(MultiNode<T> next) {
        this.next = next;
    }

    public MultiNode<T> getDown() {
        return down;
    }

    public void setDown(MultiNode<T> down) {
        this.down = down;
    }
   
    
    
}
