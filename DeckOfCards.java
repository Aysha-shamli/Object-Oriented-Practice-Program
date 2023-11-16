package oopsConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class DeckOfCards {
    public static void main(String[] args) {
        List<Card> deck = initializeDeck();
        shuffleDeck(deck);

        String[][] playersCards = distributeCards(deck, 4, 9);
        printPlayersCards(playersCards);
    }

    private static List<Card> initializeDeck() {
        List<Card> deck = new ArrayList<>();

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
    private static void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck, new Random());
    }

    private static String[][] distributeCards(List<Card> deck, int numPlayers, int cardsPerPlayer) {
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        int cardIndex = 0;
        for (int player = 0; player < numPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                playersCards[player][card] = deck.get(cardIndex).toString();
                cardIndex++;
            }
        }
        return playersCards;
    }
    private static void printPlayersCards(String[][] playersCards) {
        for (int player = 0; player < playersCards.length; player++) {
            System.out.println("Player " + (player + 1) + " cards:");
            for (int card = 0; card < playersCards[player].length; card++) {
                System.out.println(playersCards[player][card]);
            }
            System.out.println();
        }
    }
}
