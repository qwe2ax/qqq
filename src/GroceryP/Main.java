package GroceryP;

import java.util.*;// Я СТАРАЛСЯ КЛЯНУС

public class Main {
    public static void main(String[] args) {
        printMenu();
        System.out.println(productsList);
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();
        while (true) {
            if (menuNum == 1) {
                System.out.println("Введите название товара");
                System.out.println(purchase(console.next(), productsList));
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
                System.out.println("Программа завершила свою работу");
                System.exit(0);
            }
            printMenu(); // ЭТА ЧЕПУХА ВЫЗЫВАЕТСЯ ПОСЛЕ ДЕЙСТВИЯ В МЕНЮ КАК ЭТО ПОФИКСИТ Я ЕЩЕ НЕ ГУГЛИЛ
            menuNum = console.nextInt();
        }
    }

    public final static ArrayList<Product> productsList = new ArrayList<>();

    static {
        Product pomidor = new Product(3, "Помидор");
        Product yabloko = new Product(10, "Яблоко");
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
                "4. Выход");
    }

    public static String priceChanger(String productName, int newPrice, ArrayList<Product> products) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.setPrice(newPrice);
                return String.format("Цена товара %s изменена на %d", productName, newPrice);
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
            if (product.getProductName().equalsIgnoreCase(productName)) ;
            {
                return String.format("Вы купили %s с вас %d рублей", productName, product.getPrice());
            }
        }
        return String.format("Товара %s не существует", productName);
    }
}

class Product {
    int price;
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

    public Product(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

}