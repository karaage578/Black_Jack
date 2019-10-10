package models;

import java.util.List;

public class Card {
    private int num;
    private int point;
    private String mark;
    private Boolean visible;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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

    public Card(int num, int point, String mark) {
        setVisible(false);
        setNum(num);
        setPoint(point);
        setMark(mark);
        if (this.num == 1) {
            ;
        }
    }

    public static void showCard(Card c) {

        if (c.num == 1) {
            System.out.println(c.mark + " A");
        } else if (c.num == 11) {
            System.out.println(c.mark + " J");
        } else if (c.num == 12) {
            System.out.println(c.mark + " Q");
        } else if (c.num == 13) {
            System.out.println(c.mark + " K");
        } else {
            System.out.println(c.mark + " " + c.num);
        }
    }

    public static int Point(Card c, List<Card> hand) {

        //Aは基本11と数える
        if (c.num == 1) {
            c.point = 11;
        }

        //J,Q,Kを10と数える
        if (c.num >= 11) {
            c.point = 10;
        }

        return c.point;

    }

}
