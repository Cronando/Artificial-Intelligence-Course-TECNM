import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class FuzzyLogic {
    private FunctionBlock functionBlock;

    public FuzzyLogic(String filename) throws Exception {
        FIS fis = FIS.load(filename, true);
        this.functionBlock = fis.getFunctionBlock(null);
    }

    public void setInputVariables(double temperature, double humidity) {
        functionBlock.setVariable("temperature", temperature);
        functionBlock.setVariable("humidity", humidity);
    }

    public void evaluate() {
        functionBlock.evaluate();
    }

    public double getComfortLevel() {
        functionBlock.getVariable("comfort").defuzzify();
        return functionBlock.getVariable("comfort").getValue();
    }

    @Override
    public String toString() {
        return functionBlock.toString();
    }
}