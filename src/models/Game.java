package models;

import java.util.Scanner;

public class Game {
    //改行
    public static final String LS = System.getProperty("line.separator");
    public static final Scanner scanner = new Scanner(System.in);

    //ゲーム処理
    static Boolean startGame(Deck deck, Human p, Human d, Boolean continueGame) {

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

        //★呼び出しが多いメソッドを変数化しておく
        int pSumHand = p.sumHand(p.hand);
        int dSumHand = d.sumHand(d.hand);

        //勝負
        judge(p, d, betAmount, pSumHand, dSumHand);

        System.out.print("NextGame？(yes or no)：");
        String choice = scanner.next();
        if (choice.equals("no")) {
            continueGame = false;
        }

        //手札を戻しデッキを再度シャッフルする→リセット処理としてメソッド化する？
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

    //判定(★成功率の高い処理から順に記述する)
    private static void judge(Human p, Human d, int betAmount, int pSumHand, int dSumHand) {
        showEachCards(p, d);
        if ((dSumHand <= 21 && pSumHand > 21)
                || ((dSumHand <= 21 && pSumHand <= 21)) && (dSumHand > pSumHand)) {
            System.out.println("あなたの負けです" + LS);

        } else if ((dSumHand > 21 && pSumHand <= 21)
                || ((dSumHand <= 21 && pSumHand <= 21)) && (dSumHand < pSumHand)) {
            betAmount = betAmount * 2;
            System.out.println("あなたの勝ちです" + LS);
            p.betReturn(betAmount);
        } else if ((dSumHand > 21 && pSumHand > 21) || dSumHand == pSumHand) {
            System.out.println("引き分けです" + LS);
            p.betReturn(betAmount);
        }
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
        System.out.println(LS +
                "【プレイヤー (" + p.sumHand(p.hand) + ")】" + LS + "所持金：" + p.moneyInHand
                + LS
                + "-------------" + LS);
        for (int i = 0; i < p.hand.size(); i++) {
            p.hand.get(i).showCard();
        }
        System.out.println(LS + "-------------");
    }

    //ディーラーのカードを表示
    private static void showDealerCards(Human d) {
        //プレイヤーのカードを表示する
        System.out.println(LS +
                "【ディーラー (" + d.sumHand(d.hand) + ")】" + LS
                + "-------------" + LS);
        for (int i = 0; i < d.hand.size(); i++) {
            d.hand.get(i).showCard();
        }
        System.out.println(LS + "-------------");
    }

    //プレーヤー、ディーラーのカードを表示
    private static void showEachCards(Human p, Human d) {
        //プレイヤーのカードを表示する
        showPlayerCards(p);
        //ディーラーのカードを表示する
        showDealerCards(d);
    }

}
