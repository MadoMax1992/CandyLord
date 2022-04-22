package de.materna.candyLord.Enums;

public enum CandyEnum {
    CHOCLATE(10, 100),
    CAKE(5, 20);

    @Override
    public String toString() {
        return "CandyEnum{" +
                "basePrice=" + basePrice +
                ", baseAmount=" + baseAmount +
                '}';
    }

    private int basePrice;
    private int baseAmount;

    CandyEnum(int basePrice, int baseAmount) {
        this.basePrice = basePrice;
        this.baseAmount = baseAmount;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }
}
