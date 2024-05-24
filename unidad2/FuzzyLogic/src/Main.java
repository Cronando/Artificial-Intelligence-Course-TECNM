public class Main {
    public static void main(String[] args) throws Exception {
        // Initialize Room Comfort Processor
        String filename = "roomcomfort.fcl";
        FuzzyLogic fuzz = new FuzzyLogic(filename);

        // Get user input
        Input input = new Input();
        double temperature = input.getTemperature();
        double humidity = input.getHumidity();
        input.close();

        // Set input variables and evaluate
        fuzz.setInputVariables(temperature, humidity);
        fuzz.evaluate();

        // Get and print the comfort level
        double comfortLevel = fuzz.getComfortLevel();
        System.out.println(fuzz);
        System.out.println("Comfort Level: " + comfortLevel);
    }
}
