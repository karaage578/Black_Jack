package models;

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

    public cards() {

    }

    public cards(int num, String mark) {
    setVisible(false);
    this.num = num;
    this.mark = mark;
    }


}
