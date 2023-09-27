package Junior_java_develop.TASK1;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 2, 9, 7, 8, 10, 5};

        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println(result);
        System.out.println(arr.length);

        System.out.println(result % arr.length);


        int var;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    var = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = var;
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.print("{");
        for (int x : arr) {
            System.out.print(x + ", ");
        }
        System.out.println("}");
    }
}
