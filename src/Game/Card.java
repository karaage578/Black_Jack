package Game;

public class Card {
    private int num;
    private String mark;
    private Boolean visible;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Card() {

    }

    public Card(int num, String mark) {
        setVisible(false);
        setNum(num);
        setMark(mark);
        if (this.num == 1) {
            ;
        }
    }

    public void showCard() {

        if (this.num == 1) {
            System.out.println(this.mark + " A");
        } else if (this.num == 11) {
            System.out.println(this.mark + " J");
        } else if (this.num == 12) {
            System.out.println(this.mark + " Q");
        } else if (this.num == 13) {
            System.out.println(this.mark + " K");
        } else {
            System.out.println(this.mark + " " + this.num);
        }
    }

    //★インスタンスメソッドにすることでthis.変数名で使用できる
    public int getPoint() {

        int point = this.num;
        //Aは基本11と数える
        if (this.num == 1) {
            point = 11;
        } else if (this.num >= 11) {
            //J,Q,Kを10と数える
            point = 10;
        }

        return point;

    }

}
