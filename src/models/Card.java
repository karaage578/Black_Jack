package models;

public class Card {
    private Integer num;
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

}
