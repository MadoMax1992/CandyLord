package de.materna.candyLord;

public class Candy {
    String name;
    int price;
    int amount;

    //TODO prüfen das preis und menge nicht negativ sein kann
    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


    public Candy(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void shuffelprice() {
        this.setPrice((int) (this.getPrice() * (Math.random() + GameManager.PRICE_SHUFFEL_FACTOR)));
    }
}
