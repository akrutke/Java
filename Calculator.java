/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 /**
 *
 * @author andrew krutke Java csci 470 Assignment 2
 *  Hey robert - could you possibly edit this in any free time to show me how to get my error portion working correctly?
  * I tried and tried but I'm running in circles now. If you can't find the time to, that's also okay. Thanks.
 */
package democalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

    private JFrame frame;
    private JTextField xfield, yfield;
    private JLabel rslt;
    private JButton multiButton, divButton, addButton, subButton, clearButton;
    private JPanel xpanel, butPanel, rsltPanel;

    public Calculator() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        xpanel = new JPanel();
        xpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        xpanel.setLayout(new GridLayout(3, 2));

        xpanel.add(new JLabel("x: ", SwingConstants.RIGHT));     //right justify
        xfield = new JTextField("0", 5);
        xpanel.add(xfield);

        xpanel.add(new JLabel("y: ", SwingConstants.RIGHT));   //right justify
        yfield = new JTextField("0", 5);
        xpanel.add(yfield);
        frame.add(xpanel, BorderLayout.NORTH);

        //result field
        rsltPanel = new JPanel();
        frame.add(rsltPanel);
        //what result will look like
        rsltPanel.setBackground(Color.getHSBColor(56, 48, 70));
        rsltPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rslt = new JLabel("0");
        rsltPanel.add(rslt);
        frame.add(rsltPanel, BorderLayout.SOUTH);

        //button panel section 
        butPanel = new JPanel();
        frame.add(butPanel);
        butPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //multiply button
        multiButton = new JButton("Multiply");
        butPanel.add(multiButton);
        multiButton.addActionListener(this);

        //divide button
        divButton = new JButton("Divide");
        butPanel.add(divButton);
        divButton.addActionListener(this);

        //add button
        addButton = new JButton("Add");
        butPanel.add(addButton);
        addButton.addActionListener(this);

        //subtract button
        subButton = new JButton("Subtract");
        butPanel.add(subButton);
        subButton.addActionListener(this);

        //clear button
        clearButton = new JButton("Clear");
        butPanel.add(clearButton);
        clearButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {       //click the buttons!
        double answer = 0;
        String error = "Error";
        double x = 0, y = 0;

        String xText = xfield.getText();
        String yText = yfield.getText();

        //check for proper input
        try {
            x = Double.parseDouble(xText);
        } catch (NumberFormatException e) {
            xfield.setText(Double.toString(x));     //change the field to red
            xfield.setForeground(Color.red);
            rslt.setText(error);

        }
        //check for proper input
        try {
            y = Double.parseDouble(yText);
        } catch (NumberFormatException e) {
            yfield.setText(Double.toString(y));     //change the field to red
            yfield.setForeground(Color.red);
            rslt.setText(error);
        }
        
        //cascading if statements to check the event passed in
        if (ae.getSource().equals(multiButton)) {
            answer = x * y;
            rslt.setText(Double.toString(answer));
        } else if (ae.getSource().equals(divButton)) {
            answer = x / y;
            if (y == 0) {
                rslt.setText("Divide by zero");             //check the denominator for zero
            } else {
                rslt.setText(Double.toString(answer));
            }

        } else if (ae.getSource().equals(addButton)) {
            answer = x + y;
            rslt.setText(Double.toString(answer));
        } else if (ae.getSource().equals(subButton)) {
            answer = x - y;
            rslt.setText(Double.toString(answer));
        } else if (ae.getSource().equals(clearButton)) {     //clear all the stuff
            xfield.setText(Double.toString(0));
            yfield.setText(Double.toString(0));
            rslt.setText(Double.toString(0));
        }

    }

}
