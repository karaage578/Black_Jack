package models;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    static List<cards> d_hand = new ArrayList<>();

    public static void atCard(cards card) {
        d_hand.add(card);
    }
}
