/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_tasnimfattal;

/**
 *
 * @author tasni
 */
public class Player<T> {

    private MultiLinkedList<T> card;

    public Player() {
        this.card = new MultiLinkedList<>();
    }

    public MultiLinkedList<T> getCard() {
        return card;
    }

    public void setCard(MultiLinkedList<T> card) {
        this.card = card;
    }
}
