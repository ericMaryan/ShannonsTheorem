package network;						/*	Package for class placement	*/

import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class represents the third GUI view
 * of the Shannons' Theorem program.
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-14
 */
public class ShannonsPanel3 extends JPanel implements Observer{

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**	Default constructor.
	 * 
	 * @param ctl Instance of ShannonsController.
	 */
	public ShannonsPanel3 (ShannonsController ctl){
		setController(ctl);
		setMaxDataRateLBL(new JLabel("Maximum data rate via Shannons Theorem = 0.00"));
		initGUI();
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/
	/** This method returns the maximum data rate JLabel.
	 * 
	 * @return The JLabel representing maximum data rate.
	 */
	public JLabel getMaxDataRateLBL(){
		return maxDataRateLBL;
	}
	
	/* MODIFIERS	-----------------------------------------------------	*/
	/** This method set the value of the maximum data rate JLabel.
	 * 
	 * @param mdrlbl The value of the JLabel.
	 */
	public void setMaxDataRateLBL (JLabel mdrlbl){
		maxDataRateLBL = mdrlbl;
	}
	
	/** This method sets the value of the controller.
	 * 
	 * @param ctl The value of the the controller to be set.
	 */
	public void setController (ShannonsController ctl){
		this.controller = ctl;
	}
	
	/*	NORMAL BEHAVIOR -------------------------------------------------	*/
	/** This method updates the values for the maximum data rate JLabel and the JTextField inputs.
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Cast observable as ShannonsModel.
		ShannonsModel model = (ShannonsModel) o;
		
		// Update new values.
		snrSpinner.setValue(model.getSignalToNoise());
		bwSpinner.setValue(model.getBandwidth());
		maxDataRateLBL.setText(String.format("Maximum data rate via Shannons Theorem = %.2f", model.getMaximumDataRate()));
	}
	
	/* HELPER METHODS	--------------------------------------------------	*/
	/** This method adds the bandwidth and signal to noise ratio 
	 *  JPanels to a new JPanel.
	 */
	private void initGUI(){
		// Set layout and add JPanels
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(getMaxDataRateLBL());
		this.add(createBandwidthPanel());
		this.add(createSignalToNoisePanel());
	}
	
	/** This method creates a panel for the signal to noise ratio components.
	 *  It also handles action events for the panel.
	 * 
	 * @return A JPanel containing elements relating to the signal to noise ratio.
	 */
	private JPanel createSignalToNoisePanel() {
		JPanel snrPanel = new JPanel();
		JLabel snrLabel = new JLabel("SignalToNoise (in DB):");
		
		// New spinner with limit of 3000 and increment size of 10.
		SpinnerModel sModel = new SpinnerNumberModel(0.0, 0.0, 3000.0, 10.0);
		snrSpinner = new JSpinner(sModel);
		
		// When the user hits enter, set the signal to noise ratio to the value entered by the user.
		snrSpinner.addChangeListener(new ChangeListener(){
			@Override
	        public void stateChanged(ChangeEvent event) {
				controller.setSignalToNoise((double)snrSpinner.getValue());
	        }
		});
		
		// Add components to JPanel.
		snrPanel.add(snrLabel);
		snrPanel.add(snrSpinner);
		return snrPanel;}
	
	/** This method creates a panel for bandwidth components.
	 *  It also handles action events for the panel.
	 * 
	 * @return A JPanel containing elements relating to bandwidth.
	 */
	private JPanel createBandwidthPanel() {
		JPanel bwPanel = new JPanel();
		JLabel bwLabel = new JLabel("Bandwidth (in hertz):");
		
		// New spinner with limit of 10,000 and increment size of 10.
		SpinnerModel sModel = new SpinnerNumberModel(0.0, 0.0, 10000.0, 10.0);
		bwSpinner = new JSpinner(sModel);
		
		// When the user hits enter, set the bandwidth to the value entered by the user.
		bwSpinner.addChangeListener(new ChangeListener(){
			@Override
	        public void stateChanged(ChangeEvent event) {
				controller.setBandwidth((double)bwSpinner.getValue());
	        }
		});
		
		// Add components to JPanel.
		bwPanel.add(bwLabel);
		bwPanel.add(bwSpinner);
		return bwPanel;}
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** A JLabel used to display the maximum data rate.*/
	private JLabel maxDataRateLBL;
	
	/** A reference attribute that represents the ShannonsController interface.*/
	private ShannonsController controller;
	
	/** A JSpinner that receives user input for the signal to noise ratio.*/
	protected JSpinner snrSpinner;
	
	/** A JSpinner that receives user input for bandwidth.*/
	protected JSpinner bwSpinner;
}
