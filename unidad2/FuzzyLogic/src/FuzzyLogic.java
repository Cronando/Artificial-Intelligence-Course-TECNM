import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import java.util.Scanner;
public class FuzzyLogic {
    public static void main(String[] args) throws Exception {
        String filename = "imc.fcl";
        FIS fis = FIS.load(filename, true);

        Scanner scanner = new Scanner(System.in);
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Entradas
        System.out.print("Introduce la altura en CM:");
        int altura = scanner.nextInt();
        System.out.print("Introduce el peso en KG");
        int peso = scanner.nextInt();
        fb.setVariable("altura", altura);
        fb.setVariable("peso", peso);
        // Evaluar
        fb.evaluate();


        fb.getVariable("categoria").defuzzify();


        System.out.println(fb);
        System.out.println("categoria: " + fb.getVariable("categoria").getValue());
        JFuzzyChart.get().chart(fb);
    }
}