package TasksFromLeetCodeORother.LinkedListClass;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList<Integer> arr1 = new LinkedList<>();
        LinkedList<Integer> arr2 = new LinkedList<>();

        arr1.add(2);
        arr1.add(4);
        arr1.add(3);

        arr2.add(5);
        arr2.add(6);
        arr2.add(4);

        System.out.println(arr1.toString());

        reverseList(arr1);
        reverseList(arr2);

        System.out.println(arr1.toString() + " - " + arr2.toString());

        System.out.println(makeItNum(arr1) + makeItNum(arr2));

        int resNum = makeItNum(arr1) + makeItNum(arr2);

        System.out.println(makeNotNum(resNum).toString());


    }

    public static void reverseList(LinkedList<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int left = 0;
        int right = list.size()-1;

        while (left < right) {
            // Меняем местами элементы с обоих концов списка
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            // Переходим к следующим элементам
            left++;
            right--;
        }
    }

    public static int makeItNum(LinkedList<Integer> list) {
        int result = 0;

        for(Integer num : list) {
            result = result*10+num;
        }
        return result;
    }

    public static LinkedList<Integer> makeNotNum(int num) {
        int tmp = num;
        int count = 0;

        while(tmp > 0) {
            tmp /=10;
            count++;
        }

        LinkedList<Integer> result = new LinkedList<>();

        for (int i = count - 1; i >= 0; i--) {
            result.add(num%10);
            num /= 10;
        }

        return result;

    }
}
