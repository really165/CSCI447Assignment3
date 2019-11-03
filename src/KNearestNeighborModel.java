import java.util.ArrayList;
import java.util.Collections;

public class KNearestNeighborModel {
	
	public final int numClasses;
    
    private final ArrayList<Example> examples;
    public ArrayList<Example> trainingSet;
    private ArrayList<Example> testSet;
    
    private final boolean regression;
    
    public KNearestNeighborModel(ArrayList<Example> examples, int numClasses) {
        this.examples = examples;
        this.numClasses = numClasses;
        this.regression = false;
    }
    
    public KNearestNeighborModel(ArrayList<Example> examples, boolean regression) {
        this.examples = examples;
        this.numClasses = 0;
        this.regression = true;
    }
    
    public boolean isClassification() {
        return !regression;
    }
    
    public void editTrainingSet() {
    	
    }
    
    public int classify(Example example, int k) {
        trainingSet.forEach(e -> e.distanceFrom(example));
        Collections.sort(trainingSet);
        
        int[] counts = new int[numClasses];
        
        for (int i = 0; i < k && i < trainingSet.size(); i++) {
            int val = (int)trainingSet.get(i).c;
            counts[val]++;
        }

        int count = 0;
        int predicted = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > count) {
                count = counts[i];
                predicted = i;
            }
        }
        
        return predicted;
    }
    
    public double regression(Example example, int k) {
        for (Example e : trainingSet) e.distanceFrom(example);
        Collections.sort(trainingSet);
        
        //System.out.println("Example: \n\t" + example);
        //System.out.println("Nearest Neighbors: ");
        //for (Example e : trainingSet.subList(0, k)) System.out.println("\t" + e);
        
        int size = trainingSet.size();
        double sum = 0;

        for (int i = 0; i < k && i < size; i++) {
            double value = trainingSet.get(i).c;
            sum += value;
        }
        
        //System.out.println("Predicted: " + sum/k);
        //System.out.println("Actual: " + example.c + "\n");
        
        return sum/(k < size ? k : size);
    }
}
