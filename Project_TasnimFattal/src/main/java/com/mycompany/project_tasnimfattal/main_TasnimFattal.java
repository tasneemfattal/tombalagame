package com.mycompany.project_tasnimfattal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main_TasnimFattal {

    private MultiLinkedList<MultiLinkedList<Integer>> cardPlayer1; // Birinci oyuncunun kartlarını tutacak MultiLinkedList
    private MultiLinkedList<MultiLinkedList<Integer>> cardPlayer2; // İkinci oyuncunun kartlarını tutacak MultiLinkedList

    public static void main(String[] args) {
        main_TasnimFattal program = new main_TasnimFattal();
        program.startTombolaGame();
    }

    public void startTombolaGame() {
        generateAndPrintCards();
        playGame();
    }

    public void generateAndPrintCards() {
        cardPlayer1 = new MultiLinkedList<>();
        cardPlayer2 = new MultiLinkedList<>();

        Random random = new Random();

        for (int j = 0; j < 3; j++) {
            MultiLinkedList<Integer> currentRowPlayer1 = new MultiLinkedList<>();
            MultiLinkedList<Integer> currentRowPlayer2 = new MultiLinkedList<>();

            List<Integer> selectedNumbers = new ArrayList<>(); // Önceden seçilen sayıları takip etmek için liste oluştur

            for (int i = 0; i < 9; i++) {
                if (i < 5) {
                    // Her sütun için başlangıç ve bitiş değerlerini belirleyin
                    int startValue = 1 + 10 * i;
                    int endValue = 10 * (i + 1);

                    // Bu aralıkta olmayan bir rastgele sayı seçin
                    int dataPlayer1;
                    do {
                        dataPlayer1 = random.nextInt(endValue - startValue + 1) + startValue;
                    } while (currentRowPlayer1.contains(dataPlayer1) || selectedNumbers.contains(dataPlayer1)); // Aynı sayıyı tekrar seçmemek ve daha önce seçilmemiş bir sayı seçmek için kontrol yapın

                    // İkinci oyuncunun kartlarını seçin ve birinci oyuncunun kartlarındaki sayılarla çakışmamasını sağlayın
                    int dataPlayer2;
                    do {
                        dataPlayer2 = random.nextInt(endValue - startValue + 1) + startValue;
                    } while (currentRowPlayer2.contains(dataPlayer2) || selectedNumbers.contains(dataPlayer2) || (currentRowPlayer1.contains(dataPlayer2) && dataPlayer2 != -1)); // Aynı sayıyı tekrar seçmemek, daha önce seçilmemiş bir sayı seçmek ve birinci oyuncunun kartlarındaki sayılardan farklı bir sayı seçmek için kontrol yapın

                    // Seçilen sayıları listeye ekleyin
                    selectedNumbers.add(dataPlayer1);
                    selectedNumbers.add(dataPlayer2);

                    currentRowPlayer1.addLast(dataPlayer1);
                    currentRowPlayer2.addLast(dataPlayer2);
                } else {
                    // -1 değerlerini rastgele olarak ekle
                    int dataPlayer1;
                    do {
                        dataPlayer1 = random.nextInt(90) + 1; // 1 ile 90 arasında rastgele bir sayı seç
                    } while (selectedNumbers.contains(dataPlayer1)); // Daha önce seçilmemiş bir sayı seçmek için kontrol yap

                    int dataPlayer2;
                    do {
                        dataPlayer2 = random.nextInt(90) + 1; // 1 ile 90 arasında rastgele bir sayı seç
                    } while (selectedNumbers.contains(dataPlayer2)); // Daha önce seçilmemiş bir sayı seçmek için kontrol yap

                    // Seçilen sayıları listeye ekleyin
                    selectedNumbers.add(dataPlayer1);
                    selectedNumbers.add(dataPlayer2);

                    currentRowPlayer1.addLast(-1);
                    currentRowPlayer2.addLast(-1);
                }
            }

            cardPlayer1.addLast(currentRowPlayer1);
            cardPlayer2.addLast(currentRowPlayer2);

        }

        // Kartları yazdır
        System.out.println("Player 1's Cards:");
        printCard(cardPlayer1);
        System.out.println("Player 2's Cards:");
        printCard(cardPlayer2);
    }

    /*public void generateAndPrintCards() {
        cardPlayer1 = new MultiLinkedList<>();
        cardPlayer2 = new MultiLinkedList<>();

        MultiLinkedList<Integer> numbers = new MultiLinkedList<>();
        for (int i = 1; i <= 90; i++) {
            numbers.addLast(i);
        }

        Random random = new Random();

        for (int j = 0; j < 3; j++) {
            MultiLinkedList<Integer> currentRowPlayer1 = new MultiLinkedList<>();
            MultiLinkedList<Integer> currentRowPlayer2 = new MultiLinkedList<>();

            for (int i = 0; i < 9; i++) {
                if (i < 5) {
                    
                    int dataPlayer1 = numbers.getRandomElement();
                    int dataPlayer2;
                    do {
                        dataPlayer2 = numbers.getRandomElement();
                    } while (dataPlayer2 == dataPlayer1); // İkinci oyuncunun kartları birinci oyuncununkilerden farklı olmalı

                    currentRowPlayer1.addLast(dataPlayer1);
                    currentRowPlayer2.addLast(dataPlayer2);
                    numbers.remove(dataPlayer1);
                    numbers.remove(dataPlayer2);
                } else {
                    currentRowPlayer1.addLast(-1);
                    currentRowPlayer2.addLast(-1);
                }
            }

            currentRowPlayer1 = shuffleMultiLinkedList(currentRowPlayer1);
            currentRowPlayer2 = shuffleMultiLinkedList(currentRowPlayer2);
            cardPlayer1.addLast(currentRowPlayer1);
            cardPlayer2.addLast(currentRowPlayer2);
        }

        // Kartları yazdır
        System.out.println("Player 1's Cards:");
        printCard(cardPlayer1);
        System.out.println("Player 2's Cards:");
        printCard(cardPlayer2);
    }*/
    public void printCard(MultiLinkedList<MultiLinkedList<Integer>> card) {
        for (int i = 0; i < card.size(); i++) {
            for (int j = 0; j < card.get(i).size(); j++) {
                System.out.print(card.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public MultiLinkedList<Integer> shuffleMultiLinkedList(MultiLinkedList<Integer> list) {
        int size = list.size();
        Random rand = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            MultiNode<Integer> currentNodeI = list.getHead();
            for (int k = 0; k < i; k++) {
                currentNodeI = currentNodeI.next;
            }
            MultiNode<Integer> currentNodeJ = list.getHead();
            for (int k = 0; k < j; k++) {
                currentNodeJ = currentNodeJ.next;
            }

            int temp = currentNodeI.data;
            currentNodeI.data = currentNodeJ.data;
            currentNodeJ.data = temp;
        }
        return list;
    }

    public void playGame() {
        TombolaGame_TasnimFattal game = new TombolaGame_TasnimFattal(); // Oyun nesnesi oluştur
        game.playGame(cardPlayer1); // Oyunu başlat

        // Oyun sonunda kartları tekrar yazdır
        System.out.println("Player 1's Cards:");
        printCard(cardPlayer1);
        System.out.println("Player 2's Cards:");
        printCard(cardPlayer2);
    }
}
