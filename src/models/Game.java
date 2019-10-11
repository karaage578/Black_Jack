package models;

import java.util.Scanner;

public class Game {
    //ゲーム処理
    static Boolean startGame(Deck deck, Human p, Human d, Boolean continueGame) {
        Scanner scanner = new Scanner(System.in);
        //山札をシャッフル
        deck.shuffleDeck();

        //カードをプレイヤーディーラーに配る
        TwoDraw(deck, p, d);

        //チップベット
        int betAmount = p.chipBet();

        //プレイヤー、ディーラーともにステイであれば勝負
        while (!p.isReady || !d.isReady) {
            //３．４．プレイヤー、ディーラー（ヒットorステイ）
            PlayerTurn(deck, p, d);
        }

        //勝負
        if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) > 21) || (d.sumHand(d.hand) == p.sumHand(p.hand))) {
            showEachCards(p, d);
            betAmount = betAmount / 2;
            System.out.println("引き分けです" + LINE_SEPARATOR);
            p.betReturn(betAmount);
        } else if ((d.sumHand(d.hand) > 21 && p.sumHand(p.hand) <= 21)
                || ((d.sumHand(d.hand) <= 21 && p.sumHand(p.hand) <= 21)) && (d.sumHand(d.hand) < p.sumHand(p.hand))) {
            showEachCards(p, d);
            betAmount = betAmount * 2;
            System.out.println("あなたの勝ちです" + LINE_SEPARATOR);
            p.betReturn(betAmount);
        } else if ((d.sumHand(d.hand) <= 21 && p.sumHand(p.hand) > 21)
                || ((d.sumHand(d.hand) <= 21 && p.sumHand(p.hand) <= 21)) && (d.sumHand(d.hand) > p.sumHand(p.hand))) {
            showEachCards(p, d);
            System.out.println("あなたの負けです" + LINE_SEPARATOR);
        }

        System.out.print("NextGame？(yes or no)：");
        String choice = scanner.next();
        if (choice.equals("no")) {
            continueGame = false;
        }

        //手札を戻しデッキを再度シャッフルする
        p.hand.clear();
        d.hand.clear();
        p.isReady = false;
        p.isBet = false;
        d.isReady = false;
        deck.cardCount = 0;
        deck.cardArray.clear();
        deck.createDeck();
        deck.shuffleDeck();

        return continueGame;
    }

    //ゲームスタート時のカード配布メソッド
    private static void TwoDraw(Deck deck, Human p, Human d) {
        p.setHand(deck.drawCard());
        p.setHand(deck.drawCard());
        d.setHand(deck.drawCard());
        d.setHand(deck.drawCard());

    }

    //プレイヤーの選択（ヒットorステイ）
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

    //プレイヤーのカードを表示
    private static void showPlayerCards(Human p) {
        //プレイヤーのカードを表示する
        System.out.println(LINE_SEPARATOR +
                "【プレイヤー (" + p.sumHand(p.hand) + ")】" + LINE_SEPARATOR + "所持金：" + p.moneyInHand.getAmount()
                + LINE_SEPARATOR
                + "-------------" + LINE_SEPARATOR);
        for (int i = 0; i < p.hand.size(); i++) {
            Card.showCard(p.hand.get(i));
        }
        System.out.println(LINE_SEPARATOR + "-------------");
    }

    //プレーヤー、ディーラーのカードを表示
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

    //改行
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
