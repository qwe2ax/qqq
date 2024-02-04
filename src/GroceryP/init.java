package GroceryP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class init {
    void writer() throws IOException {
        FileWriter fileWriter = new FileWriter("yabloki.txt");
        for (Product product : Main.productsList) {
            fileWriter.write(String.valueOf(product));
        }
        fileWriter.close();

    }

    int priceChanger(String product) throws IOException {
        File file = new File("yabloki.txt");
        if (file.toString().isEmpty()) {
            writer();
        }
        Scanner scanner = new Scanner(file);
        product = product.toLowerCase();
        while (scanner.hasNextLine()) {
            StringBuilder result = new StringBuilder();
            String str = scanner.nextLine().toLowerCase();
            if (str.contains(product)) {
                String[] ar = str.split("\\D+");
                return Integer.parseInt(ar[1]);
            }
        }
        return -1;
    }
    int storageChanger(String product) throws IOException {
        File file = new File("yabloki.txt");
        if (file.toString().isEmpty()) {
            writer();
        }
        Scanner scanner = new Scanner(file);
        product = product.toLowerCase();
        while (scanner.hasNextLine()) {
            StringBuilder result = new StringBuilder();
            String str = scanner.nextLine().toLowerCase();
            if (str.contains(product)) {
                String[] ar = str.split("\\D+");
                return Integer.parseInt(ar[2]);
                }
            }
        return -1;
    }
}
