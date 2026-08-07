package org.example.task3;

public class Product extends Money{

    private String name;

    public Product(String name, int partMoney, int coins) {
        super(partMoney, coins);
        this.name = name;
    }

    public void discount(int whole, int coin) {

        int totalCoins = getPartMoney() * 100 + getCoins();
        int discountCoins = whole * 100 + coin;

        totalCoins -= discountCoins;

        if (totalCoins < 0) {
            totalCoins = 0;
        }

        setPartMoney(totalCoins / 100);
        setCoins(totalCoins % 100);
    }

    @Override
    public String outputData() {
        return "Product: " + name +
                "\n" + super.outputData();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
