package GroceryPackage;

import java.util.*;// Я СТАРАЛСЯ КЛЯНУС

public class Main {
    public static void main(String[] args) {
        Products pomidor = new Products(3, "Помидор");
        Products yabloko = new Products(10, "Яблоко");
        Products grusha = new Products(20, "Груша");
        Products moloko = new Products(60, "Молоко");
        Products myaso = new Products(90, "Мясо");
        ArrayList<Products> productsList = new ArrayList<>();
        productsList.add(pomidor);
        productsList.add(yabloko);
        productsList.add(grusha);
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
            System.out.println("1. Продолжить\n" + "2. Выйти");
            int cont = console.nextInt();
            if (cont == 2) {
                System.out.println("Программа завершила работу");
                System.exit(0);
            }
            printMenu();
            menuNum = console.nextInt();
        }
    }

    public static void printMenu() {
        System.out.println("Меню действий:\n" + "1. Купить товар\n" +
                "2. Посмотреть каталог\n" + "3. Изменить цену\n" +
                "4. Выход");
    }

    public static String priceChanger(String productName, int newPrice, ArrayList<Products> products) {
        for (Products product : products) {
            if (product.getProductName().equals(productName) || product.getProductName().toLowerCase().equals(productName)
                    || product.getProductName().toUpperCase().equals(productName)) {
                product.setPrice(newPrice);
                return String.format("Цена товара %s изменена на %d", productName, newPrice);
            }
        }
        return "Товара не существует";
    }

    public static void showCatalog(ArrayList<Products> products) {
        StringBuilder catalog = new StringBuilder();
        for (Products product : products) {
            catalog.append(product.getProductName()).append(" ").append(product.getPrice()).append("р\n");
        }
        System.out.println(catalog);
    }

    public static String purchase(String productName, ArrayList<Products> products) {
        for (Products product : products) {
            if (product.getProductName().equals(productName) || product.getProductName().toLowerCase().equals(productName)
                    || product.getProductName().toUpperCase().equals(productName)) ;
            {
                return String.format("Вы купили %s с вас %d рублей", productName, product.getPrice());
            }
        }
        return String.format("Товара %s не существует", productName);
    }
}

class Products {
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

    public Products(int price, String productName) {
        this.price = price;
        this.productName = productName;
    }

}