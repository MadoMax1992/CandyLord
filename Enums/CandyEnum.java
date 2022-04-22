package de.materna.candyLord.Enums;

public enum CandyEnum {
    CHOCLATE(10, 100),
    SALTEDCARMEL(8,0),
    CINNAMONROLL(7, 0),
    GUMMYSNAKES(4, 0),
    JELLYBEANS(2,0);

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
