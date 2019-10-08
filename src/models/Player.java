package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static List<cards> p_hand = new ArrayList<>();

    public static void atCard(cards card) {
        p_hand.add(card);
    }
}
