
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) {

        long first = 0;
        long second = 1;

        try {
            // Create CSV file
            FileWriter writer = new FileWriter("fibonacci.csv");

            // Write column names
            writer.write("Number;Fibonacci\n");

            // Generate 60 Fibonacci numbers
            for (int i = 1; i <= 60; i++) {

                writer.write(i + ";" + first + "\n");

                long next = first + second;

                first = second;
                second = next;
            }

            // Close the file
            writer.close();

            System.out.println("60 Fibonacci numbers generated!");
            System.out.println("Saved to fibonacci.csv");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
