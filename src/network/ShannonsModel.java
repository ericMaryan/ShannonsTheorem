package network;						/*	Package for class placement	*/

import java.util.Observable;

/**
 * This class represents the data model
 * of the program and performs the 
 * calculations for the Shannons' Theorem formula.
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-08
 */
public class ShannonsModel extends Observable {

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**	Default constructor.*/
	public ShannonsModel(){
		super();
		this.bandwidth = 0;
		this.signalToNoise = 0;
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/
	/** This method returns the bandwidth in hertz. 
	 * 
	 * @return The bandwidth used for calculating Shannons' Theorem.
	 */
	public double getBandwidth(){
		return bandwidth;	
	}
	
	/** This method returns the signal to noise ratio in decibels. 
	 * 
	 * @return The signal to noise ratio used for calculating Shannons' Theorem.
	 */
	public double getSignalToNoise(){
		return signalToNoise;		
	}
	
	/** This method returns the maximum data rate. 
	 * 
	 * @return The results of the calculation.
	 */
	public double getMaximumDataRate(){
		return maximumDataRate(getBandwidth(), getSignalToNoise());		
	}
	
	/* MODIFIERS	-----------------------------------------------------	*/
	/** This method sets the value of bandwidth as entered by the user. 
	 * 
	 * @param	bandwidth	Stores the value of the bandwidth in hertz.
	 */
	public void setBandwidth(double bandwidth){
		this.bandwidth = bandwidth;
		//Notifies observers that the value has changed.
		this.setChanged();
		this.notifyObservers();
	}
	
	/** This method sets the value of the signal to noise ratio as entered by the user. 
	 * 
	 * @param	signaltonoise	 Stores the signal to noise ratio in decibels.
	 */
	public void setSignalToNoise(double signaltonoise){
		this.signalToNoise = signaltonoise;
		//Notifies observers that the value has changed.
		this.setChanged();
		this.notifyObservers();
	}
	
	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	/**
	 *	Displays a message containing the final calculations.
	 *
	 *	@return	The calculations results in string format.
	 */
	public String toString(){
		return String.format("The maximum data rate is %.2f", getMaximumDataRate());
	}
	
	/* HELPER METHODS	--------------------------------------------------	*/
	/** This method calculates the maximum data rate using the bandwidth and signal to noise ratio. 
	 * 
	 * @param	hertz	The bandwidth used for calculations.
	 * @param	snr		The signal to noise ratio used for calculations.
	 * @return  The results of the calculation.
	 */
	private static double maximumDataRate(double hertz, double snr){
		return (hertz*(Math.log(1+Math.pow(10,snr/10))/Math.log(2)));
	}
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** Holds the value of bandwidth for calculations. Accepts positive values.*/
	private double bandwidth;
	
	/** Holds the value of the signal to noise ratio for calculations. Accepts positive values.*/
	private double signalToNoise;
}		/*	End of CLASS:	ShannonsModel.java			*/