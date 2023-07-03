package Zadanie_1.main1;

public class ZProstokat extends Prostokat{
    private char b;
    private char c;

    private int count;

    public static int p = 1; // Prostokat
    public static int k = 1; // Kwadrat

    public ZProstokat(int szerokosc, int wysokosc, char b, char c) {
        super(szerokosc, wysokosc);
        this.b = b;
        this.c = c;
        this.count = isKwadrat() ? k++ : p++;
    }

    public ZProstokat(int w, char b, char c) {
        this(w, w, b, c);
    }

    public char getB() {
        return b;
    }

    public char getC() {
        return c;
    }

    public int getCount() {
        return count;
    }

    private int borderCounter(){
        return (this.getSzerokosc()*this.getWysokosc()) - (this.getSzerokosc()-2)*(this.getWysokosc()-2);
    }

    private int insideCounter(){
        return (this.getSzerokosc()*this.getWysokosc()) - this.borderCounter();
    }

    @Override
    public boolean isPoprawny() {
        if (this.b == this.c)
            return super.isPoprawny();
        return this.getWysokosc() >= 1 &&
                this.getSzerokosc() >= 1;
    }

    @Override
    public void rysuj() throws ProstokatExeption {
        System.out.print(isKwadrat() ? "Kwadrat" : "Prostokat" + "(" +
                this.getCount() + ")" );
        if (this.isPoprawny() == false) {
            throw new ProstokatExeption("Błędny prostokąt!");
        }

        System.out.println(", " +
                this.getC() + " = " + this.insideCounter() + ", " +
                this.getB() + " = " + this.borderCounter());

        for (int i = 0; i < this.getWysokosc(); i++) {
            for (int j = 0; j < this.getSzerokosc(); j++) {
                if (j == 0 || j == this.getSzerokosc()-1 || i == 0 || i == this.getWysokosc()-1)
                    System.out.print(getB() + " ");
                else
                    System.out.print(getC() + " ");
            }
            System.out.println();
        }

        super.rysuj();
    }
}











