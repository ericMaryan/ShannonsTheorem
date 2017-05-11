package network;					/*	Package for class placement	*/

import java.awt.GridLayout;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class assembles the GUI views
 * and delegates tasks to the 
 * ShannonsModel class. 
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-08
 */
public class ShannonsTheorem implements ShannonsController{

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**	Default constructor.*/
	public ShannonsTheorem(){
		super();
		setModel(new ShannonsModel());
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/
	/** This method returns the bandwidth in hertz. 
	 * 
	 * @return The getBandwidth method from ShannonsModel.
	 */
	public double getBandwidth(){
		return getModel().getBandwidth();	
	}
	
	/** This method returns the signal to noise ratio in decibels. 
	 * 
	 * @return The getSignalToNoise method from ShannonsModel.
	 */
	public double getSignalToNoise(){
		return getModel().getSignalToNoise();		
	}
	
	/** This method returns the maximum data rate. 
	 * 
	 * @return The maximumDataRate method from ShannonsModel.
	 */
	public double getMaximumDataRate(){
		return getModel().getMaximumDataRate();		
	}
	
	/** This method returns the attribute of ShannonsModel. 
	 * 
	 * @return ShannonsModel attribute.
	 */
	private ShannonsModel getModel(){
		return model;}
	
	/* MODIFIERS	-----------------------------------------------------	*/
	/** This method sets the value of bandwidth as entered by the user. 
	 * 
	 * @param	bw	Stores the value of the bandwidth in hertz. 
	 */
	public void setBandwidth(double bw){
		getModel().setBandwidth(bw);;
	}
	
	/** This method sets the value of the signal to noise ratio as entered by the user. 
	 * 
	 * @param	snr	 Stores the signal to noise ratio in decibels.
	 */
	public void setSignalToNoise(double snr){
		getModel().setSignalToNoise(snr);;
	}
	
	/** This method sets the value of the ShannonsModel attribute.
	 * 
	 * @param	model	Represents ShannonsModel.
	 */
	private void setModel(ShannonsModel model){
		this.model = model;
	}
	
	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	/** This method adds an observer to ShannonsModel.
	 * 
	 * @param  o	An object of the observer class.
	 */
	public void addObserver(Observer o){
		getModel().addObserver(o);
	}
	
	/* HELPER METHODS	--------------------------------------------------	*/
	/** This method assembles the GUI by adding 3 separate JPanels to a single JFrame.
	 * 
	 */
	private void initGUI(){
		// Instantiate panels and create frame
		ShannonsPanel sPanel = new ShannonsPanel(this);
		ShannonsPanel2 sPanel2 = new ShannonsPanel2(this);
		ShannonsPanel3 sPanel3 = new ShannonsPanel3(this);
		JFrame frame = new JFrame();
		JPanel layout = new JPanel();
		JPanel layout2 = new JPanel();
		
		// Add the three panels as observers to ShannonsTheorem
		try{
			this.addObserver(sPanel);
			this.addObserver(sPanel2);
			this.addObserver(sPanel3);
		}catch(NullPointerException e){ e.getMessage();}
		
		// adds the 3 panels to the frame and prepare the frame for use
		frame.setLayout(new GridLayout(1,1));
		layout.setLayout(new  GridLayout(2,1));
		layout2.setLayout(new BoxLayout(layout2, BoxLayout.PAGE_AXIS));
		layout.add(sPanel);
		layout2.add(sPanel2);
		layout.add(sPanel3);
		frame.add(layout);
		frame.add(layout2);
		frame.setSize(1200, 400);
		frame.setVisible(true);
	}
	
	/*	ENTRY POINT for STAND-ALONE OPERATION ---------------------------	*/
	/**
	 *  Entry point "main()" as required by the JVM.
	 *  @param  args   Standard command line parameters (arguments) as a
	 *	string array.
	 */
	public static void main(String[] args) {
		// Calls the initGUI() method to set up and display GUI
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem();
		shannonsTheorem.initGUI();
	}
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** A reference attribute that represents the ShannonsModel class.*/
	private ShannonsModel model; 
} 		/*	End of CLASS:	ShannonsTheorem.java			*/