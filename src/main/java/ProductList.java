import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {

    private ArrayList<Product> productsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void readProducts() {
        String end = "завершить";
        String add1;
        String add2;
        for (; ; ) {
            System.out.println("введите имя");
            add1 = scanner.nextLine();
            System.out.println("введите стоимость");
            add2 = scanner.nextLine();
            boolean err = false;
            if (add2.length() > 3) {
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
            } else System.out.println("Товар введён неверно");
        }
    }


    public float calculate(int n) {
        float sum = 0;
        for (int i = 0; i < productsList.size(); i++) {
            sum += productsList.get(i).cost;
        }
        return sum / n;
    }

    public void writeNameList() {
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println(productsList.get(i).name);
        }
    }
}
