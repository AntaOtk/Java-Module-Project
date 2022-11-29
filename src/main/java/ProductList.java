import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {

    private ArrayList<Product> productsList = new ArrayList<>();

    public void readProducts(Scanner scanner) {
        String end = "завершить";
        String nameOfProduct;
        float costOfProduct;
        while(true) {
            System.out.println("введите имя товара");
            nameOfProduct = scanner.nextLine();
            System.out.println("введите стоимость");
            if (scanner.hasNextFloat()) {
                costOfProduct = scanner.nextFloat();
                scanner.nextLine();
                if (costOfProduct > 0) {
                    productsList.add(new Product(nameOfProduct, costOfProduct));
                    System.out.println("Товар успешно добавлен. Хотите ввести ещё товар? \nЕсли нет, то введите ''Завершить''");
                    if (end.equalsIgnoreCase(scanner.nextLine())) {
                        break;
                    }
                } else {
                    System.out.println("Товар введён неверно");
                }
            } else {
                System.out.println("Товар введён неверно");
                scanner.nextLine();
            }
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
