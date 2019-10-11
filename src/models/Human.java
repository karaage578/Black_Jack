package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human {
    List<Card> hand = new ArrayList<>();
    Boolean isReady = false;
    Boolean isBet = false;
    Chips moneyInHand = new Chips(3000);

    Scanner scanner = new Scanner(System.in);

    //手札に加える
    public void setHand(Card c) {
        hand.add(c);
    }

    //手札の数を合計する
    public int sumHand(List<Card> hand) {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum = sum + Card.Point(hand.get(i), hand);
        }
        //合計が22以上であり、手札にAがある場合は合計から-10する
        if (sum >= 22) {
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(j).getNum() == 1) {
                    sum = sum - 10;
                }

            }
        }
        return sum;
    }

    //チップをベットする
    public int chipBet() {
        int bet = 0;
        while (!isBet) {
            System.out.print(LINE_SEPARATOR + "所持金：" + moneyInHand.getAmount() + LINE_SEPARATOR);
            System.out.print("チップベット額を入力してください(例：　300)：");
            String chipBet = scanner.next();
            bet = Integer.parseInt(chipBet);

            if (bet > moneyInHand.getAmount()) {
                System.out.print("ベット額が所持金額を超えています：" + LINE_SEPARATOR);
            } else {
                isBet = true;
            }
        }
        moneyInHand.setAmount(moneyInHand.getAmount() - bet);

        return bet;
    }

    public void betReturn(int i) {
        int betReturn = i;
        System.out.print(i + "$をゲットしました" + LINE_SEPARATOR);
        moneyInHand.setAmount(moneyInHand.getAmount() + betReturn);
    }

    //改行
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}
