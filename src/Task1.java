
import java.io.*;
import java.net.URL;

public class Task1 {

    public static void main(String[] args) {

        double sum = 0;
        int count = 0;

        try {
            // Read CSV file directly from the internet
            URL url = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            // Read the first line (column names)
            String line = reader.readLine();

            // Read the CSV file line by line
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                String date = data[0];
                String temperature = data[1];

                // Check for January 1, 2023
                if (date.startsWith("01.01.2023")) {

                    // Convert comma to decimal point
                    temperature = temperature.replace(",", ".");

                    double temp = Double.parseDouble(temperature);

                    sum = sum + temp;
                    count++;
                }
            }

            reader.close();

            // Calculate the average temperature
            if (count > 0) {

                double average = sum / count;

                System.out.println("Measurements: " + count);
                System.out.printf("Average temperature: %.2f C%n", average);

            } else {
                System.out.println("No data found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
