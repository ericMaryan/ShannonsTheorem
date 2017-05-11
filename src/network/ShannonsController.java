package network;			/*	Package for class placement	*/

import java.util.Observer;

/**
 * This class is an interface 
 * used for setting values and 
 * adding observers to classes. 
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-13
 */
public interface ShannonsController {

	/* MODIFIERS	-----------------------------------------------------	*/
	/** This method sets the value of bandwidth.
	 * 
	 * @param bandwidth Stores the bandwidth value in hertz.
	 */
	public void setBandwidth(double bandwidth);
	
	/** This method sets the value of the signal to noise ratio.
	 * 
	 * @param signalToNoiseRatio Stores the signal to noise ratio value in decibels.
	 */
	public void setSignalToNoise (double signalToNoiseRatio);
	
	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	/** This method adds an observer to a class.
	 * 
	 * @param o An object of the observer class.
	 */
	public void addObserver (Observer o);
	
}			/*	End of CLASS:	ShannonsController.java			*/
