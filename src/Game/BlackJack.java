package Game;

public class BlackJack {

    public static void main(String[] args) {

        Boolean continueGame = true;

        //インスタンス作成
        Deck deck = new Deck();
        Human p = new Human();
        Human d = new Human();

        //プレイヤーがゲーム終了を選択するか、所持金が0になると終了
        while (continueGame && p.moneyInHand > 0) {

            continueGame = Game.startGame(deck, p, d, continueGame);
        }

        if (p.moneyInHand == 0) {
            System.out.println("お金が無くなりました、、、");
        }

        //ゲーム終了
        System.out.println("ゲーム終了！");
        System.exit(0);
    }
}
