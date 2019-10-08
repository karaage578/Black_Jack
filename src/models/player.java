package models;

import java.util.ArrayList;
import java.util.List;

public class player {
    List<cards> p_hand = new ArrayList<>();

    public void atCard(cards card) {
        p_hand.add(card);
    }
}
