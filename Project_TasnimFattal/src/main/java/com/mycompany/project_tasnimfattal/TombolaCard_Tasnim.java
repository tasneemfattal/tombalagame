/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tasnimfattal;


import java.util.Random;


/**
 *
 * @author tasni
 * @param <T>
 */
public class TombolaCard_Tasnim<T> {

    private MultiLinkedList<T> card;

    public TombolaCard_Tasnim() {
        this.card = new MultiLinkedList<>();
    }

    public MultiLinkedList<T> getCard() {
        return card;
    }
    
    

    // Belirli bir hücreye değer eklemek için metot
    public void setValueAt(int row, int column, T value) {
        MultiNode<T> currentRow = card.getHead();
        for (int i = 0; i < row; i++) {
            if (currentRow.getDown() != null) {
                currentRow = currentRow.getDown();
            } else {
                System.out.println("Invalid row index.");
                return;
            }
        }

        MultiNode<T> currentCell = currentRow;
        for (int j = 0; j < column; j++) {
            if (currentCell.getNext() != null) {
                currentCell = currentCell.getNext();
            } else {
                System.out.println("Invalid column index.");
                return;
            }
        }

        currentCell.setData(value);
    }

    // Belirli bir hücreden değer almak için metot
    public T getValueAt(int row, int column) {
        MultiNode<T> currentRow = card.getHead();
        for (int i = 0; i < row; i++) {
            if (currentRow.getDown() != null) {
                currentRow = currentRow.getDown();
            } else {
                System.out.println("Invalid row index.");
                return null;
            }
        }

        MultiNode<T> currentCell = currentRow;
        for (int j = 0; j < column; j++) {
            if (currentCell.getNext() != null) {
                currentCell = currentCell.getNext();
            } else {
                System.out.println("Invalid column index.");
                return null;
            }
        }

        return currentCell.getData();
    }

    // Belirli bir satırı döndürmek için metot
    public MultiLinkedList<T> getRow(int row) {
        MultiLinkedList<T> rowList = new MultiLinkedList<>();

        MultiNode<T> currentRow = card.getHead();
        for (int i = 0; i < row; i++) {
            if (currentRow.getDown() != null) {
                currentRow = currentRow.getDown();
            } else {
                System.out.println("Invalid row index.");
                return null;
            }
        }

        MultiNode<T> currentCell = currentRow;
        while (currentCell != null) {
            rowList.addLast(currentCell.getData());
            currentCell = currentCell.getNext();
        }

        return rowList;
    }

    // Belirli bir sütunu döndürmek için metot
    public MultiLinkedList<T> getColumn(int column) {
        MultiLinkedList<T> columnList = new MultiLinkedList<>();

        MultiNode<T> currentRow = card.getHead();
        while (currentRow != null) {
            MultiNode<T> currentCell = currentRow;
            for (int i = 0; i < column; i++) {
                if (currentCell.getNext() != null) {
                    currentCell = currentCell.getNext();
                } else {
                    System.out.println("Invalid column index.");
                    return null;
                }
            }
            columnList.addLast(currentCell.getData());
            currentRow = currentRow.getDown();
        }

        return columnList;
    }

    public void shuffleCard() {
         // Kartı doğrudan karıştırma
        card = shuffleMultiLinkedList(card);
        /*// Shuffle the card directly without converting types
        MultiLinkedList<Integer> shuffledCard = shuffleMultiLinkedList((MultiLinkedList<Integer>) card);

        // Create a new card of type T and add the shuffled data to it
        MultiLinkedList<T> newCard = new MultiLinkedList<>();
        MultiNode<Integer> currentRow = shuffledCard.getHead();
        while (currentRow != null) {
            MultiNode<Integer> currentCell = currentRow;
            MultiLinkedList<T> newRow = new MultiLinkedList<>();
            while (currentCell != null) {
                newRow.addLast((T) currentCell.getData()); // Add the cell data to the new row
                currentCell = currentCell.getNext();
            }
            newCard.addLast((T) newRow); // Add the new row to the new card
            currentRow = currentRow.getDown();
        }

        card = newCard; // Update the card with the new shuffled and converted version*/
    }

    // Kartı karıştırmak için yardımcı metot
    private MultiLinkedList<T> shuffleMultiLinkedList(MultiLinkedList<T> multiLinkedList) {
        int size = multiLinkedList.size();
        Random random = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            for (int k = 0; k < multiLinkedList.size(); k++) {
                T temp = multiLinkedList.get(k);
                multiLinkedList.set(k, multiLinkedList.get(j));
                multiLinkedList.set(j, temp);
            }
        }
        return multiLinkedList;
    }
   
    

}

