package networktest;		/*	Package for class placement	*/

import junit.framework.*;
import networktest.Test_ShannonsTheorem;
import networktest.Test_ShannonsModel;

/**
 * JUnit test class to execute all JUNIT tests for the "Shannons Theorem" project.
 *	@author Eric Maryan
 * 	@version 1.0.0 
 */
public class AllTests extends TestCase {

	public AllTests(String name) {super(name);}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(Test_ShannonsTheorem.suite());
		suite.addTest(Test_ShannonsModel.suite()); 
		return suite;
	}
	
	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for stand alone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing AllTests ...");
        junit.textui.TestRunner.run(suite());
	}

}	/*	End of CLASS:	AllTests.java			*/