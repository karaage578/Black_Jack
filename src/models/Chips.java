package models;

public class Chips {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Chips() {

    }

    public Chips(int amount) {
        setAmount(amount);
    }
}
