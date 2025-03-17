/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tasnimfattal;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author tasni
 * @param <T>
 */
public class MultiLinkedList<T> {

    private MultiNode<T> head;

    public void addFirst(T data) {
        MultiNode<T> newNode = new MultiNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addLast(T data) {
        MultiNode<T> newNode = new MultiNode<>(data);

        if (head == null) {
            head = newNode;
        } else {
            MultiNode<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void insertAfter(T data, T search) {
        MultiNode<T> temp = head;

        while (temp != null && !temp.getData().equals(search)) {
            temp = temp.getNext();
        }

        if (temp != null) {
            MultiNode<T> newNode = new MultiNode<>(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        } else {
            addLast(data);
        }
    }

    public T getRandomElement() {
        int size = size();
        int randomIndex = getRandomIndex(size);
        MultiNode<T> temp = head;
        for (int i = 0; i < randomIndex; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public int getRandomIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public boolean remove(T data) {
        if (head == null) {
            System.out.println("empty list !");
        } else {
            if (head.getData().equals(data)) {
                head = head.getNext();
                return true;
            } else {
                MultiNode<T> temp = head.getNext();
                MultiNode<T> prev = head;

                while (temp != null && !temp.getData().equals(data)) {
                    prev = temp;
                    temp = temp.getNext();
                }

                if (temp != null) {
                    prev.setNext(temp.getNext());
                    return true;
                } else {
                    System.out.println(data + " not found !");
                }
            }
        }
        return false;
    }

    public void print() {
        MultiNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }

        System.out.println("null");
    }

    public int size() {
        MultiNode<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.getNext();
        }

        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            MultiNode<T> newNode = new MultiNode<>(data);
            MultiNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public T get(int index) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MultiNode<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }
        return current.getData();
    }

    public void set(int index, T data) {
        if (isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MultiNode<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }
        current.setData(data);
    }

    public int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        int removedData = (int) head.getData();
        head = head.getNext();
        return removedData;
    }

    public boolean contains(T data) {
        MultiNode<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public MultiNode<T> getHead() {
        return head;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapNodes(i, j);
        }
    }

    private void swapNodes(int i, int j) {
        if (i == j) {
            return;
        }
        MultiNode<T> node1 = getNodeAtIndex(i);
        MultiNode<T> node2 = getNodeAtIndex(j);
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    private MultiNode<T> getNodeAtIndex(int index) {
        MultiNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

   
    void sortList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
