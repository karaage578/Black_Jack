package models;

import java.util.ArrayList;
import java.util.List;

public class dealer {
    List<cards> d_hand = new ArrayList<>();

    public void atCard(cards card) {
        d_hand.add(card);
    }
}
