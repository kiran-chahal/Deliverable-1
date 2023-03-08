/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author kchahal
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BlackJack {
    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Initialize variables
        ArrayList<Integer> playerCards = new ArrayList<Integer>();
        ArrayList<Integer> dealerCards = new ArrayList<Integer>();
        int playerTotal = 0;
        int dealerTotal = 0;

        // Deal cards to player and dealer
        playerCards.add(random.nextInt(10) + 1);
        playerCards.add(random.nextInt(10) + 1);
        dealerCards.add(random.nextInt(10) + 1);
        dealerCards.add(random.nextInt(10) + 1);

        // Calculate player's total
        for (int card : playerCards) {
            playerTotal += card;
        }

        // Player's turn
        System.out.println("Your cards: " + playerCards);
        System.out.println("Your total: " + playerTotal);
        while (playerTotal < 21) {
            System.out.print("Do you want to hit or stand? (h/s) ");
            String choice = input.nextLine();
            if (choice.equals("h")) {
                playerCards.add(random.nextInt(10) + 1);
                playerTotal = 0;
                for (int card : playerCards) {
                    playerTotal += card;
                }
                System.out.println("Your cards: " + playerCards);
                System.out.println("Your total: " + playerTotal);
            } else if (choice.equals("s")) {
                break;
            }
        }

        // Dealer's turn
        System.out.println("Dealer's cards: " + dealerCards);
        System.out.println("Dealer's total: " + dealerTotal);
        while (dealerTotal < 17) {
            dealerCards.add(random.nextInt(10) + 1);
            dealerTotal = 0;
            for (int card : dealerCards) {
                dealerTotal += card;
            }
            System.out.println("Dealer's cards: " + dealerCards);
            System.out.println("Dealer's total: " + dealerTotal);
        }

        // Determine the winner
        if (playerTotal > 21) {
            System.out.println("You bust. Dealer wins.");
        } else if (dealerTotal > 21) {
            System.out.println("Dealer busts. You win!");
        } else if (playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else if (dealerTotal > playerTotal) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }

}