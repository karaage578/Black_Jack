package models;

import java.util.ArrayList;
import java.util.List;

public class Human {
    List<Card> hand = new ArrayList<>();

    Boolean isReady = false;

    //手札に加える
    public void setHand(Card c) {
        hand.add(c);
    }

    //手札の数を合計する
    public int sumHand(List<Card> hand) {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum = sum + Card.Point(hand.get(i), hand);
        }
        return sum;
    }
}
