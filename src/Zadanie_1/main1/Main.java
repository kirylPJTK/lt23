package Zadanie_1.main1;

public class Main {
    public static void main(String[] args) {
        Prostokat prostokat[] = {
            new Prostokat(2, 3),
            new Prostokat(-2, 3),
            new Prostokat(1, 4),
            new ZProstokat(4, 'e', 'a'),
            new ZProstokat(7, '0', '1'),
            new ZProstokat(3, 4,  'i', '0'),
            new ZProstokat(7, 6, 'w', 'v')
        };

        for (Prostokat p : prostokat) {
            try {
                p.rysuj();
            } catch (ProstokatExeption e) {
                System.out.println(e.getMessage());;
            }
        }
    }
}
