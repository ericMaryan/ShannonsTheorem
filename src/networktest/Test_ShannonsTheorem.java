package networktest;			/*	Package for class placement	*/

import java.util.Observer;

import junit.framework.*;
import network.ShannonsModel;
import network.ShannonsTheorem;

/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author Eric Maryan
 * @version 1.0.0
 */
public class Test_ShannonsTheorem extends TestCase {
	
	public Test_ShannonsTheorem(String name) {super(name);}
	
	public static Test suite() { 
		return new TestSuite(Test_ShannonsTheorem.class);
	}

	protected void setUp() throws Exception{
		shannonsTheorem = new ShannonsTheorem();
		System.out.println("Test_ShannonsTheorem Begin");
	}

	protected void tearDown() throws Exception { 
		System.out.println("Test_ShannonsTheorem End");	
	}

	/**
 	 * Test the constructors.
 	 */
	public void testConstructors(){
		 System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
		 assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
	}
	
	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
        System.out.println("\tExecuting Test_ShannonsTheorem.testAccessors");
		shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testAccessors: ShannonsTheorem is null", shannonsTheorem);
		shannonsTheorem.setBandwidth(3000.0);
		assertEquals("\t\t\t: getBandwidth() = 3000.0 ", 3000.0, shannonsTheorem.getBandwidth(), 0.0);
        shannonsTheorem.setSignalToNoise(30.0);
        assertEquals("\t\t\t: getSignalToNoise() = 30.0 ", 30.0, shannonsTheorem.getSignalToNoise(), 0.0);
        assertEquals("\t\t\t: getMaximumDataRate() = 29901.67877650798 ", 29901.67877650798, shannonsTheorem.getMaximumDataRate(), 0.0);
	}

	/**
	 * Test the mutators/modifiers.
	 */
	public void testMutators() {
        System.out.println("\tExecuting Test_ShannonsTheorem.testMutators");
		shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testMutators: ShannonsTheorem is null", shannonsTheorem);
		shannonsTheorem.setBandwidth(3000.0);
		assertEquals("\t\t\t: getBandwidth() = 3000.0 ", 3000.0, shannonsTheorem.getBandwidth(), 0.0);
        shannonsTheorem.setSignalToNoise(30.0);
	}
	
	/**
	 * Test behaviors.
	 */
	public void testBehaviors() {
        System.out.println("\tExecuting Test_ShannonsTheorem.testBehaviors");
        shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testBehaviors: ShannonsTheorem is null", shannonsTheorem);
		shannonsTheorem.setBandwidth(3000.0);
		shannonsTheorem.setSignalToNoise(30.0);
        assertEquals("\t\t\t: getMaximumDataRate() = 29901.67877650798 ", 29901.67877650798, shannonsTheorem.getMaximumDataRate(), 0.0);
	}

	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
		 System.out.println("Executing Test_ShannonsTheorem suite");
	     junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES	-----------------------------------------------	*/
	/** A reference attribute that represents the ShannonsTheorem class.*/
	private ShannonsTheorem shannonsTheorem = null;
}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/