import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int peoples = readCounter();
        ArrayList<Product> productsList = readProducts();
        printConclusion(productsList, calculate(peoples, productsList));
    }

    public static int readCounter() {
        int n;
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n > 1) {
                return n;
            }
            if (n == 1) {
                System.out.println("Нет смысла делить счёт");
            } else {
                System.out.println("Неверное количество людей");
            }

        }
    }

    public static ArrayList<Product> readProducts() {
        ArrayList<Product> productsList = new ArrayList<>();
        String end = "завершить";
        String add1;
        String add2;

        for (; ; ) {
            System.out.println("введите имя");
            add1 = scanner.nextLine();
            System.out.println("введите стоимость");
            add2 = scanner.nextLine();
            boolean err = false;
            for (int i = 0; i < add2.length(); i++) {
                if ((!Character.isDigit(add2.charAt(i))) && (i != add2.length() - 3)) {
                    err = true;
                }
            }
            if ((add2.charAt(add2.length() - 3) == '.') && !err) {
                productsList.add(new Product(add1, Float.parseFloat(add2)));
                System.out.println("Товар успешно добавлен. Хотите ввсти ещё товар?");
                if (end.equalsIgnoreCase(scanner.nextLine())) {
                    break;
                }
            } else {
                System.out.println("Товар введён неверно");
            }

        }
        return productsList;
    }


    public static float calculate(int n, ArrayList<Product> productsList) {
        float sum = 0;
        for (int i = 0; i < productsList.size(); i++) {
            sum += productsList.get(i).cost;
        }
        return sum / n;
    }

    public static void printConclusion(ArrayList<Product> productsList, float output) {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println(productsList.get(i).name);
        }
        int rub = (int) output;
        if ((rub % 10 == 1) && (rub / 10 != 1)) {
            System.out.println(String.format("%.2f", output) + " рубль");
        } else if ((rub % 10 >= 2) && (rub % 10 <= 4) && (rub / 10 != 1)) {
            System.out.println(String.format("%.2f", output) + " рубля");
        } else {
            System.out.println(String.format("%.2f", output) + " рублей");
        }

    }

}