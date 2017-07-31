package JUnit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import AlternateGraph.ACO;

public class JUnit_ACO {

	public class ACO_AlgorithmTest {
	    @Test
	    public void GenerateRandMatrix() {
	        ACO GRM = new ACO(6);
	        Assert.assertNotNull(GRM.generateRandomMatrix(6));
	    }

	    @Test
	    public void AntOptimization() {
	       ACO SaO = new ACO(3);
	        Assert.assertNotNull(SaO.solve());
	    }
	}

}
