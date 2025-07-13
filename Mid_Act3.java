import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mid_Act3 extends JFrame implements ActionListener {

    private static JFrame giraffe;
    private static JPanel centerPanel, westPanel, southPanel;
    private static JCheckBox head, mouth, body, urine;
    private static JButton computeBtn;
    private static JTextField amountField;
    private static JTextField numOfExam;
    private static JRadioButton ctScan, xRay, physicalExam;
    private static ButtonGroup group;

    public Mid_Act3() {
//--------------------------------------------------------------------------------------//
        giraffe = new JFrame("panel example");											//
        giraffe.setSize(400, 300);														//
        giraffe.setLayout(new BorderLayout());										    //
        centerPanel = new JPanel();														//
        centerPanel.setLayout(new GridLayout(5, 1));									//
																						//
        centerPanel.setBorder(BorderFactory.createTitledBorder("Medical Exam"));		//
        ctScan = new JRadioButton("CT-Scan");											//
        xRay = new JRadioButton("X-Ray");												//
																						//
        physicalExam = new JRadioButton("Physical Exam");								//
        ctScan.addActionListener(this);													//
        xRay.addActionListener(this);													//
        physicalExam.addActionListener(this);											//
        group = new ButtonGroup();														//
        group.add(ctScan);																//
        group.add(xRay);																//
        group.add(physicalExam);														//
        centerPanel.add(ctScan);														//
        centerPanel.add(xRay);															//
        centerPanel.add(physicalExam);													//
        JPanel inputPanel = new JPanel();												//
																						//
        inputPanel.add(new JLabel("Number of Medical Exam:"));							//
        numOfExam = new JTextField(5);													//
        inputPanel.add(numOfExam);														//
        centerPanel.add(inputPanel);													//
																						//
        giraffe.add(centerPanel, BorderLayout.CENTER);									//
																						//
//--------------------------------------------------------------------------------------//

//---------------------------------------------------------------------------------------//
																						 //
        westPanel = new JPanel();														 //
        westPanel.setLayout(new GridLayout(4, 1));										 //
        westPanel.setBorder(BorderFactory.createTitledBorder("Body Parts"));			 //
																						 //
        head = new JCheckBox("Head");													 //
        mouth = new JCheckBox("Mouth");													 //
        body = new JCheckBox("Body");													 //
        urine = new JCheckBox("Urine");													 //
																						 //
        head.setEnabled(false);															 //
        mouth.setEnabled(false);														 //
        body.setEnabled(false);															 //
        urine.setEnabled(false);														 //
																						 //
        westPanel.add(head);															 //
        westPanel.add(mouth);															 //
        westPanel.add(body);															 //
        westPanel.add(urine);															 //
																						 //
        giraffe.add(westPanel, BorderLayout.WEST);										 //
																						 //
//---------------------------------------------------------------------------------------//

//---------------------------------------------------------------------------------------//
																						 //
																						 //
        southPanel = new JPanel();														 //
        southPanel.setLayout(new GridLayout(2, 1));										 //
        southPanel.setBorder(BorderFactory.createTitledBorder("COMPUTE"));				 //
																						 //
        computeBtn = new JButton("Compute");											 //
        southPanel.add(computeBtn);														 //
																						 //
        computeBtn.setEnabled(false);													 //
        computeBtn.addActionListener(this);												 //
																						 //
        JPanel amountPanel = new JPanel();												 //
        amountPanel.add(new JLabel("Amount:"));											 //
        amountField = new JTextField(10);												 //
        amountField.setEditable(false);													 //
        amountPanel.add(amountField);													 //
																						 //
        southPanel.add(amountPanel);													 //
        																				 //
        giraffe.add(southPanel, BorderLayout.SOUTH);									 //
																						 //
        giraffe.setVisible(true);														 //
        giraffe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							 //
//---------------------------------------------------------------------------------------//

   }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ctScan) {
            head.setEnabled(true);
            mouth.setEnabled(false);
            body.setEnabled(false);
            urine.setEnabled(false);

            head.setSelected(true);
            mouth.setSelected(false);
            body.setSelected(false);
            urine.setSelected(false);

            computeBtn.setEnabled(true);
        }

        if (e.getSource() == xRay) {
            head.setEnabled(false);
            mouth.setEnabled(false);
            body.setEnabled(true);
            urine.setEnabled(false);

            head.setSelected(false);
            mouth.setSelected(false);
            body.setSelected(true);
            urine.setSelected(false);

            computeBtn.setEnabled(true);
        }

        if (e.getSource() == physicalExam) {
            head.setEnabled(true);
            mouth.setEnabled(true);
            body.setEnabled(true);
            urine.setEnabled(true);

            head.setSelected(true);
            mouth.setSelected(true);
            body.setSelected(true);
            urine.setSelected(true);

            computeBtn.setEnabled(true);
        }

        if (e.getSource() == computeBtn) {
            String input = numOfExam.getText();
            int num = 0;

            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(giraffe, "Please enter a number.");
                return;
            }

            int price = 0;
            if (ctScan.isSelected()) {
                price = 12000;
            }
            if (xRay.isSelected()) {
                price = 1000;
            }
            if (physicalExam.isSelected()) {
                price = 700;
            }

            int total = num * price;
            amountField.setText(String.valueOf(total));
        }
    }

    public static void main(String[] args) {
        new Mid_Act3();
    }
}
