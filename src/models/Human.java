package models;

import java.util.ArrayList;
import java.util.List;

public class Human {
    List<Card> hand = new ArrayList<>();
    Boolean oneFlag = false;
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
        //合計が22以上であり、手札にAがある場合は合計から-10する
        if (sum >= 22) {
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(j).getNum() == 1) {
                    sum = sum - 10;
                }

            }
        }
        return sum;
    }

}
