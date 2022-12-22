import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int number = inputNumber();
        int resultNumber = inputNumber();
        countIs(number, resultNumber);
    }

    public static int inputNumber() {
        System.out.println("Введите число: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static int[] fillArray(int a, int b) {
        int[] numbers = new int[b - a + 1];
        int num = a;
        for (int i = 1; i < b - a + 1; i++) {
            num += 1;
            numbers[i] = num;
        }
        numbers[0] = a;
        return numbers;
    }

    public static void countIs(int a, int b) {
        if (a > b) {
            int helpVal = a;
            a = b;
            b = helpVal;
        }
        int[] numbers = fillArray(a, b);
        System.out.println(Arrays.toString(numbers));
        Map<Integer, Integer> counts = new HashMap<>();
        if (b == a) {
            System.out.println(a + " -> " + b + " количество путей = " + 1);
            return;
        }
        int count = 1;
        counts.putIfAbsent(a, count);
        for (int i = 1; i < b - a + 1; i++) {
            if (numbers[i] % 2 != 0) {
                count = counts.get(numbers[i - 1]);
                counts.put(numbers[i], count);
            } else {
                try {
                    count = counts.get(numbers[i - 1]) + counts.get(numbers[i] / 2);
                    counts.put(numbers[i], count);
                } catch (Exception ex) {
                    count = counts.get(numbers[i - 1]);
                    counts.put(numbers[i], count);
                }
            }
        }
        System.out.println(a + " -> " + b + " количество путей = " + count);
    }
}