package models;

public class BlackJack {

    public static void main(String[] args) {
        //１．山札を作成しシャッフル
        Deck deck = new Deck();
        deck.shuffleDeck();
        for (int i = 1; i < 53; i++) {
            Card.showCard(deck.cardArray.get(i));
        }
        //２．カードをプレイヤーディーラーに配る
        Player p1 = new Player();
        Dealer d1 = new Dealer();

        //３．４．プレイヤー、ディーラー（ヒットorステイ）

        //カードを2枚引く

        //カードを1枚引く
    }
}
