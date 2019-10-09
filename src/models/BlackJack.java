package models;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {

        //山札を作成しシャッフル
        Deck deck = new Deck();
        deck.shuffleDeck();
        //カードをプレイヤーディーラーに配る
        Human p = new Human();
        Human d = new Human();

        TwoDraw(deck, p, d);

        //pレイヤー、ディーラーともにステイであれば勝負
        while (!p.isReady || !d.isReady) {
            //３．４．プレイヤー、ディーラー（ヒットorステイ）
            PlayerTurn(deck, p, d);
        }

        //勝負
        if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) > 21) || (d.sumHand(d.hand) == p.sumHand(p.hand))) {
            showEachCards(p, d);
            System.out.println("引き分けです");
        } else if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) <= 21) || (d.sumHand(d.hand) < p.sumHand(p.hand))) {
            showEachCards(p, d);
            System.out.println("あなたの勝ちです");
        } else if ((d.sumHand(d.hand) <= 21 && p.sumHand(p.hand) > 21) || (d.sumHand(d.hand) > p.sumHand(p.hand))) {
            showEachCards(p, d);
            System.out.println("あなたの負けです");
        }
    }

    //ゲームスタート時のカード配布メソッド
    private static void TwoDraw(Deck deck, Human p, Human d) {
        p.setHand(deck.drawCard());
        p.setHand(deck.drawCard());
        d.setHand(deck.drawCard());
        d.setHand(deck.drawCard());

    }

    private static void PlayerTurn(Deck deck, Human p, Human d) {
        Scanner scanner = new Scanner(System.in);

        if (p.isReady == false) {
            showPlayerCards(p);
            System.out.print("ヒットしますか？(yes or no)：");
            String choice = scanner.next();
            //yesならカードを1枚引き、それ以外ならステイ状態にする
            if (choice.equals("yes")) {
                p.setHand(deck.drawCard());
            } else {
                p.isReady = true;
            }
        }

        //ディーラーターン
        if (d.sumHand(d.hand) <= 16) {
            d.setHand(deck.drawCard());
        } else {
            d.isReady = true;
        }
    }

    private static void showPlayerCards(Human p) {
        //プレイヤーのカードを表示する
        System.out.println("【プレイヤー (" + p.sumHand(p.hand) + ")】" + LINE_SEPARATOR + "-------------" + LINE_SEPARATOR);
        for (int i = 0; i < p.hand.size(); i++) {
            Card.showCard(p.hand.get(i));
        }
        System.out.println(LINE_SEPARATOR + "-------------");
    }

    private static void showEachCards(Human p, Human d) {
        //プレイヤーのカードを表示する
        System.out.println("【プレイヤー (" + p.sumHand(p.hand) + ")】" + LINE_SEPARATOR + "-------------" + LINE_SEPARATOR);
        for (int i = 0; i < p.hand.size(); i++) {
            Card.showCard(p.hand.get(i));
        }
        System.out.println(LINE_SEPARATOR + "-------------");
        //ディーラーのカードを表示する
        System.out.println("【ディーラー(" + d.sumHand(d.hand) + ")】" + LINE_SEPARATOR + "-------------" + LINE_SEPARATOR);
        for (int i = 0; i < d.hand.size(); i++) {
            Card.showCard(d.hand.get(i));
        }
        System.out.println(LINE_SEPARATOR + "-------------");
    }

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
