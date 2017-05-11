package network;						/*	Package for class placement	*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class represents the first GUI view
 * of the Shannons' Theorem program.
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-14
 */
public class ShannonsPanel extends JPanel implements Observer{

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**	Default constructor.
	 * 
	 * @param ctl Instance of ShannonsController.
	 */
	public ShannonsPanel (ShannonsController ctl){
		bwField = new JTextField("", 40);
		snrField = new JTextField("", 40);
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
		// Cast observable as ShannonsModel .
		ShannonsModel model = (ShannonsModel) o;
		
		// Update new values.
		snrField.setText(String.valueOf(model.getSignalToNoise()));
		bwField.setText(String.valueOf(model.getBandwidth()));
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
		
		// When the user hits enter, set the signal to noise ratio to the value entered by the user.
		snrField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				//Check if input is valid.
				if (Double.parseDouble(snrField.getText()) < 0 || Double.parseDouble(snrField.getText()) > 3000)
					JOptionPane.showMessageDialog(ShannonsPanel.this, "Please enter a number between 0 and 3000", "Error", JOptionPane.ERROR_MESSAGE);
				else
					controller.setSignalToNoise(Double.parseDouble(snrField.getText()));		
			}
		});
		
		// Add components to JPanel.
		snrPanel.add(snrLabel);
		snrPanel.add(snrField);
		return snrPanel;}
	
	/** This method creates a panel for bandwidth components.
	 *  It also handles action events for the panel.
	 * 
	 * @return A JPanel containing elements relating to bandwidth.
	 */
	private JPanel createBandwidthPanel() {
		JPanel bwPanel = new JPanel();
		JLabel bwLabel = new JLabel("Bandwidth (in hertz):   ");
		
		// When the user hits enter, set the bandwidth to the value entered by the user.
		bwField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				//Check if input is valid.
				if (Double.parseDouble(bwField.getText()) < 0 || Double.parseDouble(bwField.getText()) > 10000)
					JOptionPane.showMessageDialog(ShannonsPanel.this, "Please enter a number between 0 and 10,000", "Error", JOptionPane.ERROR_MESSAGE);
				else
					controller.setBandwidth(Double.parseDouble(bwField.getText()));
			}
		});
		
		// Add components to JPanel.
		bwPanel.add(bwLabel);
		bwPanel.add(bwField);
		return bwPanel;}
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** A JLabel used to display the maximum data rate.*/
	private JLabel maxDataRateLBL;
	
	/** A reference attribute that represents the ShannonsController interface.*/
	private ShannonsController controller;
	
	/** A JTextField that receives user input for bandwidth. Approved design change.*/
	protected JTextField bwField;
	
	/** A JTextField that receives user input for the signal to noise ratio. Approved design change.*/
	protected JTextField snrField;
}			/*	End of CLASS:	ShannonsPanel.java			*/