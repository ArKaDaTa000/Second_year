import javax.swing.*;
import java.awt.*;

public class OOP1_Midterm_Dorado_BSCS2B {

    //=====> Added static declarations
    private static JFrame Giraffe;
    private static JPanel westPl, carModePL, cpl, eastPl;
    private static JTextField amountField, monthlyField;
    private static JRadioButton fullPayment, twoYear, fourYear;
    private static ButtonGroup paymentOptions;

    public static void main(String[] args) {
//------------------------------------------------------------------------------------------------//
		Giraffe = new JFrame("CAR INVENTORY (MIDTERM LAB EXAM)");
		Giraffe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Giraffe.setSize(1300, 700);
		Giraffe.setLayout(new GridLayout(1, 2));


		westPl = new JPanel(new BorderLayout(10, 10));
		westPl.setBorder(BorderFactory.createTitledBorder("Car Brands and Unit Colors"));


		cpl= new JPanel(new GridLayout(5, 2, 5, 5));
		String[] colorName = {
		"RED", "ORANGE", "YELLOW", "CYAN", "GRAY",
		"MAGENTA", "BLUE", "WHITE", "PINK", "BLACK"  };


		Color[] color = {
		Color.RED, Color.ORANGE, Color.YELLOW, Color.CYAN, Color.GRAY,
		Color.MAGENTA, Color.BLUE, Color.WHITE, Color.PINK, Color.BLACK };

		for (int i = 0; i < colorName.length; i++) {
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(color[i]);
		colorPanel.setBorder(BorderFactory.createTitledBorder(colorName[i]));
		cpl.add(colorPanel); }

westPl.add(cpl, BorderLayout.CENTER);
//-----------------------------------------------------------------------------------------------------------//



			carModePL = new JPanel(new GridLayout(1, 5, 5, 5));
			carModePL.setBorder(BorderFactory.createTitledBorder("Available Car Model"));

			String[] BrandL = {"Toyota", "Mitsubishi", "Honda", "Subaru", "Mazda"};
					String[][] modelPL= {
				{"Hilux", "Conquest", "Raize", "Fortuner", "Vios"},
				{"Montero", "Mirage", "Expander", "Misubishi", "Strada"},
				{"Honda-CRV", "Honda-City", "Honda-Civic", "Honda-Urban", "Honda-GT Sport"},
				{"Subaru-Trek", "Subaru-Urban", "Subaru-Trail", "S-Speed-City", "Subaru-GT Sport"},
				{"Mazda-GT", "Mazda-Urban", "Mazda-Velocity", "Mazda High-Speed", "Mazda-GT Sport"}
				};

				   for (int i = 0; i < BrandL.length; i++) {
				   JPanel brandPanel = new JPanel(new GridLayout(6, 1));
				   brandPanel.setBorder(BorderFactory.createTitledBorder(BrandL[i]));


				   for (String model : modelPL[i]) {
					   brandPanel.add(new JLabel(model, SwingConstants.CENTER));
				   }
				   carModePL.add(brandPanel);
				   }

				 westPl.add(new JLabel("Available Car Finish", SwingConstants.LEFT), BorderLayout.NORTH);

  westPl.add(carModePL, BorderLayout.SOUTH);

//-----------------------------------------------------------------------------------------------------------//



   eastPl= new JPanel();
   eastPl.setLayout(new BoxLayout(eastPl, BoxLayout.Y_AXIS));
   eastPl.setBorder(BorderFactory.createTitledBorder("MODE OF PURCHASE"));

   JLabel modeLabel = new JLabel("Modes of Payment:");
   JLabel amountLabel = new JLabel("Amount of Full Payment / Downpayment:");
   amountField = new JTextField(15);
   amountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, amountField.getPreferredSize().height));

   fullPayment = new JRadioButton("Full Payment (10% Discount)");
   twoYear = new JRadioButton("Two (2) Years to pay (5% Interest less rebate)");
   fourYear = new JRadioButton("Four (4) Years to pay (10% Interest less rebate)");

   paymentOptions = new ButtonGroup();
   paymentOptions.add(fullPayment);
   paymentOptions.add(twoYear);
   paymentOptions.add(fourYear);

   JLabel monthlyLabel = new JLabel("Your monthly amortization is:");
   monthlyField = new JTextField(15);
   monthlyField.setMaximumSize(new Dimension(Integer.MAX_VALUE, monthlyField.getPreferredSize().height));


			   eastPl.add(Box.createRigidArea(new Dimension(0, 10)));
			   eastPl.add(modeLabel);
			   eastPl.add(Box.createRigidArea(new Dimension(0, 10)));
			   eastPl.add(amountLabel);
			   eastPl.add(amountField);
			   eastPl.add(Box.createRigidArea(new Dimension(0, 10)));
			   eastPl.add(fullPayment);
			  eastPl.add(twoYear);
			   eastPl.add(fourYear);
			  eastPl.add(Box.createRigidArea(new Dimension(0, 10)));
			  eastPl.add(monthlyLabel);
			  eastPl.add(monthlyField);



  Color softBlue = new Color(173, 216, 230);
 	   westPl.setBackground(softBlue);
 	   cpl.setBackground(softBlue);
 	   carModePL.setBackground(softBlue);
 	   eastPl.setBackground(softBlue);
	   Giraffe.getContentPane().setBackground(softBlue);

 Giraffe.add(westPl);
 Giraffe.add(eastPl);
 Giraffe.setVisible(true);

 }
}
