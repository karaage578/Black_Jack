package models;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        //山札を作成しシャッフル
        Deck deck = new Deck();
        deck.shuffleDeck();
        //カードをプレイヤーディーラーに配る
        Player p = new Player();
        Dealer d = new Dealer();

        TwoDraw(deck, p, d);

        //pレイヤー、ディーラーともにステイであれば勝負
        while (p.isReady && d.isReady) {
            //３．４．プレイヤー、ディーラー（ヒットorステイ）
            PlayerTurn(deck, p, d);
        }

        //勝負
        if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) > 21) || (d.sumHand(d.hand) == p.sumHand(p.hand))) {
            System.out.print("引き分けです");
        } else if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) <= 21) || (d.sumHand(d.hand) < p.sumHand(p.hand))) {
            System.out.print("あなたの勝ちです");
        } else if ((d.sumHand(d.hand) <= 21 && p.sumHand(p.hand) > 21) || (d.sumHand(d.hand) > p.sumHand(p.hand))) {
            System.out.print("あなたの負けです");
        }
    }

    //ゲームスタート時のカード配布メソッド
    private static void TwoDraw(Deck deck, Player p, Dealer d) {
        p.setHand(deck.drawCard());
        p.setHand(deck.drawCard());
        d.setHand(deck.drawCard());
        d.setHand(deck.drawCard());

    }

    private static void PlayerTurn(Deck deck, Player p, Dealer d) {
        //
        Scanner scanner = new Scanner(System.in);
        System.out.print("ヒットしますか？(yes or no)：");
        String choice = scanner.next();
        //yesならカードを1枚引き、それ以外ならステイ状態にする
        if (choice == "yes") {
            p.setHand(deck.drawCard());
        } else {
            p.isReady = true;
        }
        //ディーラーターン
        if (d.sumHand(d.hand) <= 16) {
            d.setHand(deck.drawCard());
        } else {
            d.isReady = true;
        }
    }
}
