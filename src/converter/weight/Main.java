package converter.weight;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select your app:\n" +
                "1. Weight Converter\n" +
                "2. Temperature Converter\n" +
                "3. TBD");

        int choice = scanner.nextInt();

        if (choice == 1) {
            WeightConverter weightConverter = new WeightConverter();
            weightConverter.run();
        } else {
            System.out.println("Functionality under construction");
        }
    }
}

