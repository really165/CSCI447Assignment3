import java.util.ArrayList;

public abstract class ClusteringAlgorithm {

	abstract ArrayList<Example> cluster(ArrayList<Example> trainingSet, int k);
	
}
