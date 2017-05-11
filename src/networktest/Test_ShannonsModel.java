package networktest;			/*	Package for class placement	*/

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import network.ShannonsModel;

/**
 *	JUnit tests for the ShannonsModel class from the "network" project.
 * @author Eric Maryan
 * @version 1.0.0
 */
public class Test_ShannonsModel extends TestCase {

	public Test_ShannonsModel(String name) {super(name);}
	
	public static Test suite() { 
		return new TestSuite(Test_ShannonsModel.class);
	}

	protected void setUp() throws Exception{
		model = new ShannonsModel();
		System.out.println("Test_ShannonsModel Begin");
	}

	protected void tearDown() throws Exception { 
		System.out.println("Test_ShannonsModel End");	
	}

	/**
 	 * Test the constructors.
 	 */
	public void testConstructors(){
		 System.out.println("\tExecuting Test_ShannonsModel.testConstructors");
		 assertNotNull("\t\tTest_ShannonsModel.testConstructors: ShannonsModel is null", model);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ShannonsModel.testAccessors");
		model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testAccessors: ShannonsModel is null", model);
		model.setBandwidth(3000.0);
		assertEquals("\t\t\t: getBandwidth() = 3000.0 ", 3000.0, model.getBandwidth(), 0.0);
		model.setSignalToNoise(30.0);
        assertEquals("\t\t\t: getSignalToNoise() = 30.0 ", 30.0, model.getSignalToNoise(), 0.0);;
        assertEquals("\t\t\t: getMaximumDataRate()) = 29901.67877650798 ", 29901.67877650798, model.getMaximumDataRate(), 0.0);;
	}

	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
      System.out.println("\tExecuting Test_ShannonsModel.testMutators");
      	model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testMutators: ShannonsModel is null", model);
		model.setBandwidth(3000.0);
		assertEquals("\t\t\t: getBandwidth() = 3000.0 ", 3000.0, model.getBandwidth(), 0.0);
		model.setSignalToNoise(30.0);
	}
		
	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
        System.out.println("\tExecuting Test_ShannonsModel.testBehaviors");
      	model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsModel.testBehaviors: ShannonsModel is null", model);
		model.setBandwidth(3000.0);
		model.setSignalToNoise(30.0);
        assertEquals("\t\t\t: getMaximumDataRate()) = 29901.67877650798 ", 29901.67877650798, model.getMaximumDataRate(), 0.0);;
		assertEquals("The maximum data rate is 29901.68", model.toString());
	}

	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
		 System.out.println("Executing Test_ShannonsModel suite");
	     junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	/** A reference attribute that represents the ShannonsModel class.*/
	private ShannonsModel model = null;
}		/*	End of CLASS:	Test_ShannonsModel.java				*/