package models;

public class cards {
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

    public cards(int deck) {

        setVisible(true);

        switch (deck) {
        case 1:
            setNum(1);
            setMark("スペード");
        case 2:
            setNum(2);
            setMark("スペード");
        case 3:
            setNum(3);
            setMark("スペード");
        case 4:
            setNum(4);
            setMark("スペード");
        case 5:
            setNum(5);
            setMark("スペード");
        case 6:
            setNum(6);
            setMark("スペード");
        case 7:
            setNum(7);
            setMark("スペード");
        case 8:
            setNum(8);
            setMark("スペード");
        case 9:
            setNum(9);
            setMark("スペード");
        case 10:
            setNum(10);
            setMark("スペード");
        case 11:
            setNum(11);
            setMark("スペード");
        case 12:
            setNum(12);
            setMark("スペード");
        case 13:
            setNum(13);
            setMark("スペード");
        case 14:
            setNum(1);
            setMark("ハート");
        case 15:
            setNum(2);
            setMark("ハート");
        case 16:
            setNum(3);
            setMark("ハート");
        case 17:
            setNum(4);
            setMark("ハート");
        case 18:
            setNum(5);
            setMark("ハート");
        case 19:
            setNum(6);
            setMark("ハート");
        case 20:
            setNum(7);
            setMark("ハート");
        case 21:
            setNum(8);
            setMark("ハート");
        case 22:
            setNum(9);
            setMark("ハート");
        case 23:
            setNum(10);
            setMark("ハート");
        case 24:
            setNum(11);
            setMark("ハート");
        case 25:
            setNum(12);
            setMark("ハート");
        case 26:
            setNum(13);
            setMark("ハート");
        case 27:
            setNum(1);
            setMark("クローバー");
        case 28:
            setNum(2);
            setMark("クローバー");
        case 29:
            setNum(3);
            setMark("クローバー");
        case 30:
            setNum(4);
            setMark("クローバー");
        case 31:
            setNum(5);
            setMark("クローバー");
        case 32:
            setNum(6);
            setMark("クローバー");
        case 33:
            setNum(7);
            setMark("クローバー");
        case 34:
            setNum(8);
            setMark("クローバー");
        case 35:
            setNum(9);
            setMark("クローバー");
        case 36:
            setNum(10);
            setMark("クローバー");
        case 37:
            setNum(11);
            setMark("クローバー");
        case 38:
            setNum(12);
            setMark("クローバー");
        case 39:
            setNum(13);
            setMark("クローバー");
        case 40:
            setNum(1);
            setMark("ダイヤ");
        case 41:
            setNum(2);
            setMark("ダイヤ");
        case 42:
            setNum(3);
            setMark("ダイヤ");
        case 43:
            setNum(4);
            setMark("ダイヤ");
        case 44:
            setNum(5);
            setMark("ダイヤ");
        case 45:
            setNum(6);
            setMark("ダイヤ");
        case 46:
            setNum(7);
            setMark("ダイヤ");
        case 47:
            setNum(8);
            setMark("ダイヤ");
        case 48:
            setNum(9);
            setMark("ダイヤ");
        case 49:
            setNum(10);
            setMark("ダイヤ");
        case 50:
            setNum(11);
            setMark("ダイヤ");
        case 51:
            setNum(12);
            setMark("ダイヤ");
        case 52:
            setNum(13);
            setMark("ダイヤ");
        }
    }

}
