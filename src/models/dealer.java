package models;

import java.util.ArrayList;
import java.util.List;

public class dealer {
    static List<cards> d_hand = new ArrayList<>();

    public static void atCard(cards card) {
        d_hand.add(card);
    }
}
