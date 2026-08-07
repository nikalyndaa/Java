package org.example.task3;

public class Money {
    private int partMoney;
    private int coins;

    public Money(int partMoney, int coins){
        this.partMoney = partMoney;
        this.coins = coins;

        if(this.coins >=100){
            this.partMoney += this.coins /100; //150 1uah
            this.coins += this.coins % 100; // 150 50coins
        }
    }

    public String outputData() {
        return "Price: " + partMoney + "." + String.format("%02d", coins);
    }

    public int getPartMoney() {
        return partMoney;
    }

    public int getCoins() {
        return coins;
    }

    public void setPartMoney(int partMoney) {
        this.partMoney = partMoney;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
