import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public double getTemperature() {
        System.out.print("Enter the room temperature in Celsius: ");
        return scanner.nextDouble();
    }

    public double getHumidity() {
        System.out.print("Enter the room humidity in percentage: ");
        return scanner.nextDouble();
    }

    public void close() {
        scanner.close();
    }
}