package bsu.rfe.java.group10.lab2.anufriev;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame{
    private JButton buttonApply = new JButton("Apply");
    private JButton buttonCount = new JButton("Count");
    private JButton button1 = new JButton("M+");
    private JButton button2 = new JButton("MC");
    private JLabel label1 = new JLabel("Choose equation: ");
    private JLabel label2 = new JLabel("Choose variable");
    private JLabel label3 = new JLabel("Result: ");
    private JTextField textField = new JTextField("Something",10);
    private JTextField textDisplay = new JTextField("Smth",10);
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons2 = new ButtonGroup();
    private Box buttonsGroup = Box.createHorizontalBox();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxVariable = Box.createHorizontalBox();
    private Box textArea = Box.createHorizontalBox();
    private Box countButton = Box.createHorizontalBox();
    private Box displayBox = Box.createHorizontalBox();
    private int formulaActive  = 1;
    private int variableActive = 1;
    private double varX = 0;
    private double varY = 0;
    private double varZ = 0;
    private double answer = 0;

    public Double calculate1(Double x, Double y,double z) {
        return (Math.sin(y)+y*y+Math.exp(Math.cos(y)))*Math.pow(Math.log(z)+Math.sin(3.14*x*x),1/4);
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y,double z) {
        return Math.pow(y+x*x*x,z)/Math.log(z);
    }


    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
            GUI.this.formulaActive = formulaId;    }      });
        radioButtons.add(button);
        hboxFormulaType.add(button);  }

    private void addRadioButton1(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                GUI.this.variableActive = formulaId;

            }
        });
        radioButtons2.add(button);
        hboxVariable.add(button);  }



    public GUI() {
        super("Lab1");
        this.setBounds(100,100,320,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container1 = new JPanel();

        container1.setLayout(new FlowLayout());
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.add(label1);
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxVariable.add(Box.createHorizontalGlue());
        hboxVariable.add(label2);
        addRadioButton1("option 1",1);
        addRadioButton1("option 2",2);
        addRadioButton1("option 3",3);
        radioButtons2.setSelected(radioButtons2.getElements().nextElement().getModel(), true);
        hboxVariable.add(Box.createHorizontalGlue());
        buttonsGroup.add(button1);
        buttonsGroup.add(button2);

        textField.setSize(100,100);
        textArea.add(textField);
        textArea.add(buttonApply);
        countButton.add(Box.createHorizontalGlue());
       countButton.add(buttonCount);
        countButton.add(Box.createHorizontalGlue());
       textDisplay.setSize(100,100);
       displayBox.add(Box.createHorizontalGlue());
       displayBox.add(label3);
       displayBox.add(textDisplay);

        buttonApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println(variableActive);
                switch(variableActive) {
                    case (1) : {
                       // System.out.println(variableActive);
                        varX = Double.parseDouble(textField.getText());
                        textField.setText("0");
                    }
                        break;
                    case (2) :
                        varY = Double.parseDouble(textField.getText());
                        textField.setText("0");
                        break;
                    case (3) :
                        varZ = Double.parseDouble(textField.getText());
                        textField.setText("0");
                        break;
                }

                try {

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            GUI.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        buttonCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println(variableActive);

                switch(formulaActive) {
                    case (1) : {
                       textDisplay.setText(calculate1(varX,varY,varZ).toString());
                       answer = calculate1(varX,varY,varZ);
                    }
                    break;
                    case (2) :
                        textDisplay.setText(calculate2(varX,varY,varZ).toString());
                        answer = calculate2(varX,varY,varZ);

                }

                try {

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            GUI.this, "Ошибка в формате записи числа с плавающей точкой",
                            "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(variableActive) {
                    case (1) : {
                        // System.out.println(variableActive);
                        varX = 0;
                        textField.setText("0");
                    }
                    break;
                    case (2) :
                        varY = 0;
                        textField.setText("0");
                        break;
                    case (3) :
                        varZ = 0;
                        textField.setText("0");
                        break;
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // double temp = 0;
                switch(variableActive) {
                    case (1) : {
                        // System.out.println(variableActive);
                        varX += answer;
                        textDisplay.setText(Double.toString(varX));

                    }
                    break;
                    case (2) :
                        varY += answer;
                        textDisplay.setText(Double.toString(varY));

                        break;
                    case (3) :
                        varZ += answer;
                        textDisplay.setText(Double.toString(varZ));

                        break;
                }
            }
        });

        container1.add(hboxFormulaType);
        container1.add(hboxVariable);
        container1.add(buttonsGroup);
        container1.add(textArea);
        container1.add(buttonCount);
        container1.add(displayBox);




        setContentPane(container1);

    }

}
