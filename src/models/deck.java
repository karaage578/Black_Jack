package models;

import java.util.Random;

public class deck {
    static int[] deck = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52 };

    static int turn_count = 0;

    static void shuffleDeck(int[] deck) {
        int n = deck.length;
        Random rnd = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomValue = i + rnd.nextInt(n - i);
            int randomElement = deck[randomValue];
            deck[randomValue] = deck[i];
            deck[i] = randomElement;
        }
    }

    static void cardDraw() {
        if (turn_count < deck.length) {
            cards card = new cards(deck[turn_count]);
            cards card2 = new cards(deck[turn_count + 1]);

            player.atCard(card);
            player.atCard(card2);
            turn_count = turn_count + 2;
        } else {
            System.out.println("デッキ切れです。");
        }

    }
}
