
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Activity1_Mid {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Compute Final Grade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JPanel markPanel = new JPanel();
        markPanel.setLayout(new GridLayout(4, 2, 5, 5));
        markPanel.setBorder(BorderFactory.createTitledBorder("MARK"));


        JTextField prelimField = new JTextField();
        JTextField midtermField = new JTextField();
        JTextField finalField = new JTextField();

        markPanel.add(new JLabel("Enter prelim grade:"));
        markPanel.add(prelimField);

        markPanel.add(new JLabel("Enter midterm grade:"));
        markPanel.add(midtermField);

        markPanel.add(new JLabel("Enter final grade:"));
        markPanel.add(finalField);


        JButton computeButton = new JButton("Compute");
        markPanel.add(computeButton);


        JPanel outcomePanel = new JPanel();
        outcomePanel.setLayout(new BorderLayout());
        outcomePanel.setBorder(BorderFactory.createTitledBorder("Outcome"));
        JLabel outcomeLabel = new JLabel("Final grade is:");
        outcomePanel.add(outcomeLabel, BorderLayout.CENTER);


        panel.add(markPanel, BorderLayout.CENTER);
        panel.add(outcomePanel, BorderLayout.SOUTH);


        frame.add(panel, BorderLayout.CENTER);

        computeButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                try {
                    double prelim = Double.parseDouble(prelimField.getText());
                    double midterm = Double.parseDouble(midtermField.getText());
                    double finals = Double.parseDouble(finalField.getText());


                    double finalGrade = (prelim + midterm + finals) / 3;
                    outcomeLabel.setText("Final grade is: " + String.format("%.2f", finalGrade));
                } catch (NumberFormatException ex) {
                    outcomeLabel.setText("Invalid input. Please enter numeric grades.");
                }
            }
        });


        frame.setVisible(true);
    }
}
