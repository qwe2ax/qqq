package GroceryP;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int cashRegister = 0;
        printMenu();
        System.out.println(productsList);
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();
        while (true) {
            if (menuNum == 1) {
                System.out.println("Введите название товара");
                String resultOfPurchase = (purchase(console.next(), productsList));
                System.out.println(resultOfPurchase);
                cashRegister += cashCounter(resultOfPurchase.split("[\\D]"));
            } else if (menuNum == 2) {
                System.out.println("Каталог товаров:");
                showCatalog(productsList);
            } else if (menuNum == 3) {
                System.out.println("Введите название товара:");
                String productName = console.next();
                System.out.println("Введите новую цену:");
                int newPrice = console.nextInt();
                System.out.println(priceChanger(productName, newPrice, productsList));

            } else if (menuNum == 4) {
                System.out.println("Счёт за товары равен " + cashRegister + "р");
            } else if (menuNum == 0) {
                System.out.println("Программа завершила свою работу");
                System.exit(0);
            }
            printMenu();
            menuNum = console.nextInt();

        }
    }


    public static int cashCounter(String[] num) {
        String result = num[num.length - 1];
        return Integer.parseInt(result);
    }

    public final static ArrayList<Product> productsList = new ArrayList<>();

    static {
        Product yabloko = new Product(10, "Яблоко");
        Product pomidor = new Product(3, "Помидор");
        Product grusha = new Product(20, "Груша");
        Product moloko = new Product(60, "Молоко");
        Product myaso = new Product(90, "Мясо");
        productsList.add(pomidor);
        productsList.add(yabloko);
        productsList.add(grusha);
        productsList.add(moloko);
        productsList.add(myaso);
    }

    public static void printMenu() {
        System.out.println("Меню действий:\n" + "1. Купить товар\n" +
                "2. Посмотреть каталог\n" + "3. Изменить цену\n" +
                "4. Посмотреть кассу\n" +
                "0. Выход");
    }

    public static String priceChanger(String productName, int newPrice, ArrayList<Product> products) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.setPrice(newPrice);
                return String.format("Цена товара %s изменена на %dр", productName, newPrice);
            }
        }
        return "Товара не существует";
    }

    public static void showCatalog(ArrayList<Product> products) {
        StringBuilder catalog = new StringBuilder();
        for (Product product : products) {
            catalog.append(product.getProductName()).append(" ").append(product.getPrice()).append("р\n");
        }
        System.out.println(catalog);
    }

    public static String purchase(String productName, ArrayList<Product> products) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return String.format("Вы купили %s с вас %dр", productName, product.getPrice());
            }
        }
        return String.format("Товара %s не существует", productName);
    }
}

class Product {
    int price;

    public Product(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

    String productName;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Products{" + "price=" + price +
                ", productName='" + productName + '\'' + '}';
    }


}