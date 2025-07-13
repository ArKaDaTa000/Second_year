import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Activity2_Mid extends JFrame implements ActionListener {


    private JTextField inputFeeField;
    private JTextField outputTotalField;


    private JRadioButton optionFull, optionTwo, optionThree;
    private ButtonGroup paymentOptionsGroup;


    public Activity2_Mid() {
        setTitle("Tuition Fee Assessment System");
        setSize(450, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));


        JPanel panelTop = new JPanel();
        panelTop.setBorder(BorderFactory.createTitledBorder("P1"));
        JLabel labelPrompt = new JLabel("Enter tuition fee amount: ");
        inputFeeField = new JTextField(10);
        panelTop.add(labelPrompt);
        panelTop.add(inputFeeField);


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setBorder(BorderFactory.createTitledBorder("P2"));

        JLabel labelPayment = new JLabel("Select Mode of Payment:");
        optionFull = new JRadioButton("Full Payment (10% Discount)");
        optionTwo = new JRadioButton("Two Payments (5% Interest)");
        optionThree = new JRadioButton("Three Payments (10% Interest)");


        paymentOptionsGroup = new ButtonGroup();
        paymentOptionsGroup.add(optionFull);
        paymentOptionsGroup.add(optionTwo);
        paymentOptionsGroup.add(optionThree);


        optionFull.addActionListener(this);
        optionTwo.addActionListener(this);
        optionThree.addActionListener(this);


        panelCenter.add(labelPayment);
        panelCenter.add(optionFull);
        panelCenter.add(optionTwo);
        panelCenter.add(optionThree);


        JPanel panelBottom = new JPanel();
        panelBottom.setBorder(BorderFactory.createTitledBorder("P3"));
        JLabel labelTotal = new JLabel("Your total tuition fee is: ");
        outputTotalField = new JTextField(10);
        outputTotalField.setEditable(false);
        panelBottom.add(labelTotal);
        panelBottom.add(outputTotalField);

        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String feeInput = inputFeeField.getText().trim();

            if (feeInput.isEmpty()) {
                throw new NumberFormatException();
            }

            double baseFee = Double.parseDouble(feeInput);
            if (baseFee <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero.");
            }

            double finalAmount = baseFee;


            if (optionFull.isSelected()) {
                finalAmount = baseFee * 0.90;
            } else if (optionTwo.isSelected()) {
                finalAmount = baseFee * 1.05;
            } else if (optionThree.isSelected()) {
                finalAmount = baseFee * 1.10;
            }


            outputTotalField.setText("Php " + String.format("%.2f", finalAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please input a valid number.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }


    public static void main(String[] args) {
        new Activity2_Mid();
    }
}
