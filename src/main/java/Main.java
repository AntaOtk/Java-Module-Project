import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int peoples = readCounter();
        ProductList products = new  ProductList();
        products.readProducts(scanner);
        printConclusion(products, products.calculate(peoples));
        scanner.close();
    }

    public static int readCounter() {
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number > 1) {
                    return number;
                }
                if (number == 1) {
                    System.out.println("Нет смысла делить счёт");
                } else {
                    System.out.println("Неверное количество людей");
                }
            } else {
                System.out.println("Введите пожалуйста число");
                scanner.next();
            }
        }
    }

    public static void printConclusion(ProductList products, float output) {
        System.out.println("Добавленные товары:");
        products.writeNameList();
        System.out.println(String.format("%.2f", output) + Spelling.writeRub(output));
    }

}