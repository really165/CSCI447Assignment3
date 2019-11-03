import java.util.ArrayList;

public class MLPNeuralNetwork {
	private int numInputs;
	private int numOutputs;
	private int numHiddenNodes;
	private double[] weights;
	private ClusteringAlgorithm clusteringAlgorithm;
	private RadialBasisFunction radialBasisFunction;
	
	public MLPNeuralNetwork(int inputs, int outputs, int hiddenNodes) {
		this.numInputs = inputs;
        this.numOutputs = outputs;
        this.numHiddenNodes = hiddenNodes;
	}
	
	public void train(ArrayList<Example> trainingSet, boolean a) {
		
	}
	
	public int classify(Example example) {
		return 0;
	}
	
	public double regress(Example example) {
		return 0;
	}
	
	public void setClusteringAlgorithm(ClusteringAlgorithm algorithm) {
		
	}
	
	public void setRadialBasisFunction(RadialBasisFunction function) {
		
	}
}
