package Junior_java_develop.TASK6.NO1;

public enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(8), Winesap(7), Cortland(6);

    private int price;

    Apple(int p) {
        this.price = p;
    }

    public int getPrice() {
        return price;
    }
}
