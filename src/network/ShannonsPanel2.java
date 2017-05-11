package network;						/*	Package for class placement	*/

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * This class represents the second GUI view
 * of the Shannons' Theorem program.
 * @author    Eric Maryan
 * @version   1.0.0 2016-10-14
 */
public class ShannonsPanel2 extends JPanel implements Observer{

	/* CONSTRUCTORS	--------------------------------------------------	*/
	/**	Default constructor.
	 * 
	 * @param ctl Instance of ShannonsController.
	 */
	public ShannonsPanel2(ShannonsController ctl) {
		data = new DefaultCategoryDataset();
		chart = ChartFactory.createBarChart("Shannons' Theorem", "", "Value", data);
		bwSlider = new JSlider(JSlider.HORIZONTAL, 0, 10000, 0);
		snrSlider = new JSlider(JSlider.HORIZONTAL, 0, 3000, 0);
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
		controller = ctl;
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
		snrSlider.setValue((int) model.getSignalToNoise());
		bwSlider.setValue((int) model.getBandwidth());
		maxDataRateLBL.setText(String.format("Maximum data rate via Shannons Theorem = %.2f", model.getMaximumDataRate()));
		
		// Update values of bar chart
		data.addValue(model.getBandwidth(), series1, column1);
		data.addValue(model.getSignalToNoise(), series2, column1);
		data.addValue(model.getMaximumDataRate(), series3, column1);
	}
	
	/* HELPER METHODS	--------------------------------------------------	*/
	/** This method adds the bandwidth and signal to noise ratio 
	 *  JPanels to a new JPanel, as well as a bar chart. 
	 */
	private void initGUI(){
		JPanel panel = new JPanel();
		ChartPanel cPanel = new ChartPanel(chart);
		chart.setBackgroundPaint(new Color(238, 238, 238));
		
		// Set layouts and sizes.
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		cPanel.setPreferredSize(new Dimension(200, 300));
		
		// Add components to JPanels.
		panel.add(getMaxDataRateLBL());
		this.add(cPanel);
		
		// JOptionPane.showMessageDialog(this, cPanel);
		this.add(panel);
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
		JLabel snrLabel = new JLabel();
		
		// Set the layout and JSlider settings.
		snrPanel.setLayout(new BoxLayout(snrPanel, BoxLayout.X_AXIS));
		snrLabel.setText("SignalToNoise (in DB):");
		snrSlider.setMajorTickSpacing(1000);
		snrSlider.setMinorTickSpacing(100);
		snrSlider.setPaintTicks(true);
		snrSlider.setPaintLabels(true);
		
		// When the user hits enter, set the signal to noise ratio to the value entered by the user.
		snrSlider.addChangeListener(new ChangeListener(){
			@Override
	        public void stateChanged(ChangeEvent event) {
				controller.setSignalToNoise(snrSlider.getValue());
	        }
		});
		
		// Add components to JPanel.
		snrPanel.add(snrLabel);
		snrPanel.add(snrSlider);
		return snrPanel;
	}
	
	/** This method creates a panel for bandwidth components.
	 *  It also handles action events for the panel.
	 * 
	 * @return A JPanel containing elements relating to bandwidth.
	 */
	private JPanel createBandwidthPanel() {
		JPanel bwPanel = new JPanel();
		JLabel bwLabel = new JLabel();
		
		// Set the layout and JSlider settings.
		bwPanel.setLayout(new BoxLayout(bwPanel, BoxLayout.X_AXIS));
		bwLabel.setText("Bandwidth (in hertz):   ");
		bwSlider.setMajorTickSpacing(1000);
		bwSlider.setMinorTickSpacing(100);
		bwSlider.setPaintTicks(true);
		bwSlider.setPaintLabels(true);
		
		// When the user hits enter, set the bandwidth to the value entered by the user.
		bwSlider.addChangeListener(new ChangeListener(){
			@Override
	        public void stateChanged(ChangeEvent event) {
				controller.setBandwidth(bwSlider.getValue());
	        }
		});
		
		// Add components to JPanel.
		bwPanel.add(bwLabel);
		bwPanel.add(bwSlider);
		return bwPanel;
	}
	
	/* ATTRIBUTES	-----------------------------------------------------	*/
	/** A JLabel used to display the maximum data rate.*/
	private JLabel maxDataRateLBL;
	
	/** A reference attribute that represents the ShannonsController interface.*/
	private ShannonsController controller;
	
	/** A JSlider that receives user input for bandwidth.*/
	protected JSlider bwSlider;
	
	/** A JSldier that receives user input for the signal to noise ratio.*/
	protected JSlider snrSlider;
	
	/** A JFreeChart that displays the three different values for Shannons' Theorem.*/
	private JFreeChart chart;
	
	/** A data set used to hold the data displayed on the JFreeChart. */
	private DefaultCategoryDataset data;
	
	/** A String that stores the title of the bandwidth bar on the JFreeChart. */
	private String series1 = "Bandwidth";
	
	/** A String that stores the title of the signal to noise ratio bar on the JFreeChart. */
	private String series2 = "Signal to Noise Ratio";
	
	/** A String that stores the title of the maximum data rate bar on the JFreeChart. */
	private String series3 = "Maximum Data Rate";
	
	/** A String that stores the title of the columns used in the JFreeChart. */
	private String column1 = "";
}			/*	End of CLASS:	ShannonsPanel.java			*/