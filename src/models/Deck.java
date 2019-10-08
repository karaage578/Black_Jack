package models;

import java.util.Random;

public class Deck {

    List<Cards> cardArray = new ArrayList<cards>();

    public deck(){
        //作り出される

    }

    static int turn_count = 0;

    public shuffleDeck(cards deck) {
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
