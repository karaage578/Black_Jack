package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> cardArray = new ArrayList<>();
    int cardCount = 0;

    public Deck() {
        //デッキインスタンス作成時にカードを作成
        createDeck();
    }

    //シャッフル
    public void shuffleDeck() {
        Collections.shuffle(cardArray);
    }

    //ドロー
    public Card drawCard() {
        cardCount++;
        return cardArray.get(cardCount - 1);
    }

    //デッキ作成
    public void createDeck() {
        for (int i = 1; i <= 13; i++) {
            cardArray.add(new Card(i, "♠"));
            cardArray.add(new Card(i, "♥"));
            cardArray.add(new Card(i, "☘"));
            cardArray.add(new Card(i, "♦"));
        }
    }
}
