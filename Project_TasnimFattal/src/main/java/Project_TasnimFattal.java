
import com.mycompany.project_tasnimfattal.MultiLinkedList;
import com.mycompany.project_tasnimfattal.MultiNode;
import com.mycompany.project_tasnimfattal.TombolaGame_TasnimFattal;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * @author tasni
 */

/*public class Project_TasnimFattal {

    public static void main(String[] args) {
        // Creating a Tombola game
        TombolaGame_TasnimFattal<Integer> game = new TombolaGame_TasnimFattal<>();

        MultiLinkedList<Integer> numbers = new MultiLinkedList<>();

        for (int i = 1; i < 91; i++) {
            numbers.addLast(i);
        }

        Random random = new Random();
        MultiLinkedList<MultiLinkedList<Integer>> linkedLists = new MultiLinkedList<>();

        for (int j = 0; j < 3; j++) {//üç satır
            MultiLinkedList<Integer> MultilinkedList = new MultiLinkedList<>();
            for (int i = 0; i < 9; i++) {//tane kolum
                if (i < 5) {
                    int data = numbers.getRandomElement();
                    MultilinkedList.addLast(data);
                    numbers.remove(data);

                } else { // Fill the rest with -1 to indicate empty spaces
                    MultilinkedList.addLast(-1);
                }
                int data = numbers.getRandomElement();
                MultilinkedList.addLast(data);
                numbers.remove(data);

            }
             MultilinkedList = shuffleMultiLinkedList( MultilinkedList);
            linkedLists.addLast( MultilinkedList);
            
             // Her adımdan sonra kartları oluştur ve güncellenmiş halini göster
            System.out.println("Step " + (j + 1) + ":");
            generateCard(linkedLists.get(j).size(), 9);
            printCard();
        }
        // Random permutation oluştur
        MultiLinkedList<Integer> randomPermutation = generatePermutation(90);

        // Oyunu başlat
        game.playGame(randomPermutation, linkedLists);

    }
    
    // generateCard method
    public static MultiLinkedList<MultiLinkedList<Integer>> card;

    public static void generateCard(int rowCount, int columnCount) {
        card = new MultiLinkedList<>();
        MultiLinkedList<Integer> numbers = generatePermutation(rowCount * columnCount);

        for (int i = 0; i < rowCount; i++) {
            MultiLinkedList<Integer> row = new MultiLinkedList<>();
            for (int j = 0; j < columnCount; j++) {
                int data = numbers.removeFirst();
                row.addLast(data);
            }
            card.addLast(row);
        }
    }
    
    // printCard method
    public static void printCard() {
        for (int i = 0; i < card.size(); i++) {
            for (int j = 0; j < card.get(i).size(); j++) {
                System.out.print(card.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
    
    
    
    // Shuffle a multi-linked list
    public static MultiLinkedList<Integer> shuffleMultiLinkedList(MultiLinkedList<Integer> list) {
        int size = list.size();
        Random rand = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            MultiNode<Integer> currentNodeI = list.head;
            for (int k = 0; k < i; k++) {
                currentNodeI = currentNodeI.next;
            }
            MultiNode<Integer> currentNodeJ = list.head;
            for (int k = 0; k < j; k++) {
                currentNodeJ = currentNodeJ.next;
            }

            int temp = currentNodeI.data;
            currentNodeI.data = currentNodeJ.data;
            currentNodeJ.data = temp;
        }
        return list;
    }

    public static MultiLinkedList<Integer> generatePermutation(int n) {
        MultiLinkedList<Integer> permutationList = new MultiLinkedList<>();
        for (int i = 1; i <= n; i++) {
            permutationList.addLast(i);
        }
        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            MultiNode<Integer> currentNodeI = permutationList.head;
            for (int k = 0; k < i; k++) {
                currentNodeI = currentNodeI.next;
            }
            MultiNode<Integer> currentNodeJ = permutationList.head;
            for (int k = 0; k < j; k++) {
                currentNodeJ = currentNodeJ.next;
            }

            int temp = currentNodeI.data;
            currentNodeI.data = currentNodeJ.data;
            currentNodeJ.data = temp;
        }
        return permutationList;
    }*/



       /* // Creating a Tombola game
        TombolaGame_TasnimFattal<Integer> game = new TombolaGame_TasnimFattal<>();

        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 1; i < 91; i++) {
            numbers.addLast(i);
        }

        Random random = new Random();
        LinkedList<LinkedList<Integer>> linkedLists = new LinkedList<>();

        for (int j = 0; j < 3; j++) {//üç satır
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < 9; i++) {//tane kolum
                if (i < 5) {
                    int data = numbers.getRandomElement();
                    linkedList.addLast(data);
                    numbers.remove(data);

                } else { // Fill the rest with -1 to indicate empty spaces
                    linkedList.addLast(-1);
                }
                int data = numbers.getRandomElement();
                linkedList.addLast(data);
                numbers.remove(data);

            }
            linkedList = shuffleLinkedList(linkedList);
            linkedLists.addLast(linkedList);
        }
        // Random permutation oluştur
        LinkedList<Integer> randomPermutation = generatePermutation(90);

        // Oyunu başlat
        game.playGame(randomPermutation, linkedLists);

    }
    
    // Shuffle a linked list
    public static LinkedList<Integer> shuffleLinkedList(LinkedList<Integer> list) {
        int size = list.size();
        Random rand = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Node<Integer> currentNodeI = list.head;
            for (int k = 0; k < i; k++) {
                currentNodeI = currentNodeI.next;
            }
            Node<Integer> currentNodeJ = list.head;
            for (int k = 0; k < j; k++) {
                currentNodeJ = currentNodeJ.next;
            }

            int temp = currentNodeI.data;
            currentNodeI.data = currentNodeJ.data;
            currentNodeJ.data = temp;
        }
        return list;
    }

    public static LinkedList<Integer> generatePermutation(int n) {
        LinkedList<Integer> permutationList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            permutationList.addLast(i);
        }
        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Node<Integer> currentNodeI = permutationList.head;
            for (int k = 0; k < i; k++) {
                currentNodeI = currentNodeI.next;
            }
            Node<Integer> currentNodeJ = permutationList.head;
            for (int k = 0; k < j; k++) {
                currentNodeJ = currentNodeJ.next;
            }

            int temp = currentNodeI.data;
            currentNodeI.data = currentNodeJ.data;
            currentNodeJ.data = temp;
        }
        return permutationList;
    }
}*/

/* // Generating random permutation of numbers
        int[] randomPermutation = game.generatePermutation(90);

        // Generating cards for players
        game.player1Card.createCard();
        game.player2Card.createCard();

        // Display initial cards
        System.out.println("Player 1's Card:");
        game.player1Card.displayCard();
        System.out.println("\nPlayer 2's Card:");
        game.player2Card.displayCard();

        // Start the game
        game.playGame(randomPermutation);*/
