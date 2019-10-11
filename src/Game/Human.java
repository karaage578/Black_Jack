package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Human {
    List<Card> hand = new ArrayList<>();
    Boolean isReady = false;
    Boolean isBet = false;
    int moneyInHand = 3000;
    //改行
    public static final String LS = System.getProperty("line.separator");
    Scanner scanner = new Scanner(System.in);

    //手札に加える
    public void setHand(Card c) {
        hand.add(c);
    }

    //手札の数を合計する
    public int sumHand(List<Card> hand) {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum = sum + hand.get(i).getPoint();
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
            System.out.print(LS + "所持金：" + moneyInHand + LS);
            System.out.print("チップベット額を入力してください(例：　300)：");
            String chipBet = scanner.next();
            //★数値以外が入力された場合は注意文言を表示
            try {
                bet = Integer.parseInt(chipBet);

                if (bet > moneyInHand) {
                    System.out.print("ベット額が所持金額を超えています：" + LS);
                } else {
                    isBet = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("数値を入力してください" + LS);
            }

        }
        moneyInHand = moneyInHand - bet;

        return bet;
    }

    public void betReturn(int i) {
        int betReturn = i;
        System.out.print(i + "$をゲットしました" + LS);
        moneyInHand = moneyInHand + betReturn;
    }

}
