/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tasnimfattal;

import com.mycompany.project_tasnimfattal.MultiLinkedList;
import java.util.Random;

/**
 *
 * @author tasni
 * @param <T>
 */
public class TombolaGame_TasnimFattal<T> {


    private String data;

    public MultiLinkedList<MultiLinkedList<Integer>> createCards(int rowCount, int columnCount) {
        MultiLinkedList<MultiLinkedList<Integer>> cards = new MultiLinkedList<>();
        int[] numbers = generatePermutation(rowCount * columnCount);

        for (int i = 0; i < rowCount; i++) {
            MultiLinkedList<Integer> card = new MultiLinkedList<>();
            for (int j = 0; j < columnCount; j++) {
                if (j == 0) {
                    for (int k = 0; k < 5; k++) {
                        int data = numbers[i * columnCount + j * 5 + k];
                        card.addLast(data);
                    }
                } else {
                    for (int k = 0; k < 4; k++) {
                        card.addLast(-1); // Fill the rest with -1 to indicate empty spaces
                    }
                }
            }
            shuffleMultiLinkedList(card); // Shuffle the numbers
            cards.addLast(card);
        }
        return cards;
    }

    public void playGame(MultiLinkedList<MultiLinkedList<Integer>> cards) {
        int[] randomPermutation = generatePermutation(90);
        int drawnNumberCount = 0;

        Player player1 = new Player();
        Player player2 = new Player();

        while (drawnNumberCount < randomPermutation.length) {
            int randomNumber = randomPermutation[drawnNumberCount];
            System.out.println("Number called: " + randomNumber);

            boolean foundInPlayer1 = checkNumber(player1.getCard(), randomNumber);
            boolean foundInPlayer2 = checkNumber(player2.getCard(), randomNumber);

            if (foundInPlayer1) {
                markNumber(player1.getCard(), randomNumber);
                System.out.println("Player 1 marks off number " + randomNumber);
            }
            if (foundInPlayer2) {
                markNumber(player2.getCard(), randomNumber);
                System.out.println("Player 2 marks off number " + randomNumber);
            }

            printUpdatedCards(player1, player2);

            if (!foundInPlayer1 && !foundInPlayer2) {
                System.out.println("Number " + randomNumber + " not found in any player's cards!");
            }

            drawnNumberCount++;
        }
    }

    private void printUpdatedCards(Player player1, Player player2) {
        System.out.println("Player 1's Cards:");
        printCard(player1.getCard());
        System.out.println("Player 2's Cards:");
        printCard(player2.getCard());
    }

    public boolean checkNumber(MultiLinkedList<MultiLinkedList<Integer>> cards, int number) {
        for (int i = 0; i < cards.size(); i++) {
            MultiLinkedList<Integer> row = cards.get(i);
            for (int j = 0; j < row.size(); j++) {
                int data = row.get(j);
                if (data == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public void markNumber(MultiLinkedList<Integer> card, int randomNumber) {
        MultiNode<Integer> currentRow = card.getHead();

        // Kartın her satırını kontrol et
        while (currentRow != null) {
            MultiNode<Integer> currentNode = currentRow;

            // Her satırdaki her düğümü kontrol et
            while (currentNode != null) {
                // Sayı bulunduğunda, düğümün değerine "*" işaretini ekle
                if (currentNode.getData().equals(randomNumber)) {
                    // currentNode.setData("*" + String.valueOf(currentNode.getData()));
                   // currentNode.setData("*" + currentNode.getData());
                    return;
                }
                currentNode = currentNode.getNext();
            }

            // Bir sonraki satıra geç
            currentRow = currentRow.getDown();
        }
    }

   /* public boolean checkBingo(MultiLinkedList<MultiLinkedList<Integer>> cards) {
        // Her bir satırı kontrol et, eğer tüm elemanlar * işareti içeriyorsa Bingo yapılmıştır
        for (int i = 0; i < cards.size(); i++) {
            MultiLinkedList<Integer> row = cards.get(i);
            for (int j = 0; j < row.size(); j++) {
                int data = row.get(j);
                if (data > 0 && !String.valueOf(data).contains("*")) {
                    return false; // Eğer bir hücre * işareti içermiyorsa Bingo yok demektir
                }
            }
        }
        return true; // Eğer tüm hücreler * işareti içeriyorsa Bingo yapılmıştır
    }

    public boolean checkFirstBingo(MultiLinkedList<Integer> card) {
        MultiNode<Integer> currentRow = card.getHead();
        while (currentRow != null) {
            int count = 0;
            MultiNode<Integer> currentNode = currentRow;
            while (currentNode != null) {
                if (currentNode.getData().toString().contains("*")) {
                    count++;
                }
                if (count == 5) {
                    return true;
                }
                currentNode = currentNode.getNext();
            }
            currentRow = currentRow.getDown();
        }
        return false;
    }

    public boolean checkSecondBingo(MultiLinkedList<Integer> card) {
        MultiNode<Integer> currentRow = card.getHead();
        int count = 0;
        while (currentRow != null) {
            MultiNode<Integer> currentNode = currentRow;
            while (currentNode != null) {
                if (currentNode.getData().toString().contains("*")) {
                    count++;
                }
                if (count == 10) {
                    return true;
                }
                currentNode = currentNode.getNext();
            }
            currentRow = currentRow.getDown();
        }
        return false;
    }

    public boolean checkTombala(MultiLinkedList<Integer> card) {
        int count = 0;
        MultiNode<Integer> currentRow = card.getHead();
        while (currentRow != null) {
            MultiNode<Integer> currentNode = currentRow;
            while (currentNode != null) {
                if (currentNode.getData().toString().contains("*")) {
                    count++;
                }
                if (count == 15) {
                    return true;
                }
                currentNode = currentNode.getNext();
            }
            currentRow = currentRow.getDown();
        }
        return false;
    }


     public boolean checkBingo(MultiLinkedList<Integer> card) {
        // Her bir satırı kontrol et, eğer tüm elemanlar * işareti içeriyorsa Bingo yapılmıştır
        MultiNode<Integer> currentRow = card.getHead();
        while (currentRow != null) {
            boolean bingo = true;
            MultiNode<Integer> currentNode = currentRow;
            while (currentNode != null) {
                if (!currentNode.getData().toString().contains("*")) {
                    bingo = false;
                    break;
                }
                currentNode = currentNode.getNext();
            }
            if (bingo) {
                return true;
            }
            currentRow = currentRow.getDown();
        }
        return false;
    }*/
    public void printCard(MultiLinkedList<MultiLinkedList<Integer>> cards) {
        for (int i = 0; i < cards.size(); i++) {
            MultiLinkedList<Integer> row = cards.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] generatePermutation(int n) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int index1 = rand.nextInt(n);
            int index2 = rand.nextInt(n);

            int temp = permutation[index1];
            permutation[index1] = permutation[index2];
            permutation[index2] = temp;
        }
        return permutation;
    }

    public void shuffleMultiLinkedList(MultiLinkedList<Integer> list) {
        int size = list.size();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(size);
            int temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }

    }
}

