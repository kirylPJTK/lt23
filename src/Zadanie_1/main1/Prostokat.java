package Zadanie_1.main1;

public class Prostokat {
    private int szerokosc;
    private int wysokosc;

    public Prostokat(int szerokosc, int wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public boolean isKwadrat() {
        return this.wysokosc == this.szerokosc;
    }

    public void rysuj() throws ProstokatExeption {
        System.out.println();
        System.out.println("Prostokat rozmiaru " + this.getSzerokosc() + "x" + this.getWysokosc());
        if(!isPoprawny()) {
            throw new ProstokatExeption("Błędny Prostokat!");
        }
    }

    public boolean isPoprawny(){
        return this.wysokosc>=1 &&
            this.szerokosc>=1;
    }
}
