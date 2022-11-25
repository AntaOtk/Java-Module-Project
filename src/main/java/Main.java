import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int peoples = readCounter();
        ProductList products = new  ProductList();
        products.readProducts();
        printConclusion(products, products.calculate(peoples));
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

    public static void printConclusion(ProductList products, float output) {
        System.out.println("Добавленные товары:");
        products.writeNameList();
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