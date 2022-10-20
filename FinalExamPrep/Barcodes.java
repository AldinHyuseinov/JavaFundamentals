package FinalExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Barcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfBarcodes = Integer.parseInt(scanner.nextLine());
        Pattern barcodePattern = Pattern.compile("^@#+(?<item>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+$");
        Pattern digits = Pattern.compile("\\d");
        StringBuilder productGroup = new StringBuilder();

        for (int i = 0; i < countOfBarcodes; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = barcodePattern.matcher(barcode);

            if (matcher.find()) {
                Matcher matchDigits = digits.matcher(matcher.group("item"));

                while (matchDigits.find()) {
                    productGroup.append(matchDigits.group());
                }

                if (productGroup.length() == 0) {
                    productGroup.append("00");
                }
                System.out.println("Product group: " + productGroup);
                productGroup.setLength(0);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
