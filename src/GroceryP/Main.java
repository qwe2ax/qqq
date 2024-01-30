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
            } else if (menuNum == 5) {
                System.out.println("Действия со складом:\n" +
                        "1. Посмотреть склад \n" +
                        "2. Добавить продукт\n" +
                        "3. Посчитать общую стоимость продукта\n" +
                        "4. Посчитать общую стоимость всех продуктов\n" +
                        "0. Выйти");
                int action = console.nextInt();

                if (action == 1) {
                    System.out.println(showStorage(productsList));

                } else if (action == 2) {
                    System.out.println("Введите название продукта:");
                    String productName = console.next();
                    System.out.println("Введите количество добавляемых продуктов: ");
                    int addedProducts = console.nextInt();
                    System.out.println(editStorage(productsList, productName, addedProducts));

                } else if (action == 3) {
                    System.out.println("Введите название продукта:");
                    String productName = console.next();
                    System.out.println(sumOfProduct(productsList, productName));
                } else if (action == 4) {
                    System.out.println(sumOfAllProducts(productsList));
                }

            } else if (menuNum == 0) {
                System.out.println("Программа завершила свою работу");
                System.exit(0);
            }
            printMenu();
            menuNum = console.nextInt();

        }
    }


    public static final ArrayList<Product> productsList = new ArrayList<>();

    static {
        Product yabloko = new Product(10, "Яблоко", 5);
        Product pomidor = new Product(3, "Помидор", 5);
        Product grusha = new Product(20, "Груша", 5);
        Product moloko = new Product(60, "Молоко", 5);
        Product myaso = new Product(90, "Мясо", 5);
        productsList.add(pomidor);
        productsList.add(yabloko);
        productsList.add(grusha);
        productsList.add(moloko);
        productsList.add(myaso);
    }

    public static String sumOfAllProducts(ArrayList<Product> products) {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice() * product.getStorage();
        }
        return String.format("Общая стоимость всех продуктов равна %dр", sum);
    }

    public static String sumOfProduct(ArrayList<Product> products, String productName) {
        long sum = 0;
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                sum = (long) product.storage * product.price;
                return String.format("Общая стоимость продукта %s равна %dр", productName, sum);
            }
        }
        return "Товар не найден";
    }

    public static String editStorage(ArrayList<Product> products, String productName, int addedProducts) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.setStorage(product.storage + addedProducts);
                return String.format("Добавлено %d %s текущее количество %s равно %d", addedProducts, productName, productName, product.getStorage());
            }
        }
        return "Продукт не найден";
    }

    public static String showStorage(ArrayList<Product> products) {
        StringBuilder result = new StringBuilder();
        for (Product s : products) {
            result.append(s).append("\n");
        }
        return result.toString();
    }

    public static int cashCounter(String[] num) {
        String result = num[num.length - 1];
        return Integer.parseInt(result);
    }


    public static void printMenu() {
        System.out.println("Меню действий:\n" + "1. Купить товар\n" +
                "2. Посмотреть каталог\n" + "3. Изменить цену\n" +
                "4. Посмотреть кассу\n" +
                "5. Склад\n" +
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
                product.setStorage(product.storage - 1);
                return String.format("Вы купили %s с вас %dр", productName, product.getPrice());
            }
        }
        return String.format("Товара %s не существует", productName);
    }
}

class Product {
    int price;

    String productName;

    int storage;

    public Product(int price, String productName, int storage) {
        this.price = price;
        this.productName = productName;
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
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
        return "Название товара: " + productName +
                ", Стоимость: " + price +
                ", Количество на складе: " + storage + ";";
    }
}