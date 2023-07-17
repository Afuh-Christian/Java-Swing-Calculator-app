package com.company;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class calculator implements ActionListener {
    JPanel pA;
    JPanel pText,pnumber,pOperators ;
    JTextField textField;


    JButton[] numButtons = new JButton[10];
    JButton[] operators = new JButton[8];
    JButton addBtn,subBtn,mulBtn,divBtn,decimalBtn,equBtn,   clrBtn,delBtn;
    char operatorSign;
    Double num1,num2,result;


    Font myFont = new Font("Ink Free",Font.BOLD,30);//creating a single font to use with all




    calculator(){
            JFrame frame = new JFrame();
            frame.setTitle("Calculator");
            frame.setSize(415,538);
            frame.setBackground(Color.white);
//            frame.setLayout(null);
            frame.setResizable(false);



            //...........parent.........................

            pA = new JPanel();
            pA.setBounds(0,0,400,500);
            pA.setBackground(Color.gray);
           pA.setBorder(new EmptyBorder(10,10,10,10));
            pA.setLayout(new BorderLayout(10,10));


            //..........second parents.................................

            pText = new JPanel();
            pnumber = new JPanel();
            pOperators = new JPanel();


            pText.setBackground(Color.green);
            pnumber.setBackground(Color.green);
            pOperators.setBackground(Color.darkGray);

            pText.setPreferredSize(new Dimension(300,100));
            pnumber.setPreferredSize(new Dimension(290,350));
            pOperators.setPreferredSize(new Dimension(80,350));

            pnumber.setLayout(new GridLayout(4,3,10,10));
            pnumber.setBorder(new EmptyBorder(10,10,10,10));

            pOperators.setLayout(new GridLayout(6,1,10,10));
            pOperators.setBorder(new EmptyBorder(10,10,10,10));

            pText.setLayout(null);

            //border radius for button............


            //numbers....


            //operators...
            addBtn = new JButton("+");
            subBtn = new JButton("-");
            mulBtn = new JButton("*");
            divBtn = new JButton("/");
            decimalBtn = new JButton(".");
            equBtn = new JButton("=");

            clrBtn = new JButton("cl");
            delBtn = new JButton("dl");
//
//            for(int i=0;i<7;i++){
//                pOperators[]
//            }
            operators[0] = addBtn;
            operators[1] = subBtn;
            operators[2] = mulBtn;
            operators[3] = divBtn;
            operators[4] = decimalBtn;
            operators[5] = equBtn;

            operators[6] = clrBtn;
            operators[7] = delBtn;

            for(int i=0;i<8;i++){
                operators[i].addActionListener(this);
                operators[i].setFont(myFont);
                operators[i].setFocusable(false);
            }

            //text....................
            textField = new JTextField();
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
//            textField.setEditable(false);
            textField.setBounds(10,10,360,80);
            textField.setFont(myFont);

            for(int i=0;i<10;i++){
                numButtons[i] = new JButton(String.valueOf(i));
                numButtons[i].addActionListener(this);
                numButtons[i].setFont(myFont);
                numButtons[i].setFocusable(false);
                numButtons[i].setSize(20,20);

            }




            pnumber.add(numButtons[7]);
            pnumber.add(numButtons[8]);
            pnumber.add(numButtons[9]);

            pnumber.add(numButtons[4]);
            pnumber.add(numButtons[5]);
            pnumber.add(numButtons[6]);

            pnumber.add(numButtons[1]);
            pnumber.add(numButtons[2]);
            pnumber.add(numButtons[3]);

            pnumber.add(decimalBtn);
            pnumber.add(numButtons[0]);
            pnumber.add(equBtn);

            pOperators.add(clrBtn);
            pOperators.add(delBtn);

            pOperators.add(divBtn);
            pOperators.add(mulBtn);
            pOperators.add(subBtn);
            pOperators.add(addBtn);

        pText.add(textField);

        pA.add(pText,BorderLayout.NORTH);
        pA.add(pnumber,BorderLayout.WEST);
        pA.add(pOperators,BorderLayout.EAST);


        frame.add(pA);


//

            frame.setVisible(true);
        }




    @Override
    public void actionPerformed(ActionEvent e) {

        String number;

        for(int i=0;i<10;i++){
            if(e.getSource()==numButtons[i]){

                textField.setText(textField.getText().concat(String.valueOf(i)));
                number = textField.getText();
            }
        }

        if(e.getSource()==decimalBtn){
            textField.setText(textField.getText().concat("."));
            number = textField.getText();


        }
        if(e.getSource()==addBtn){
//            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("+"));

            number = textField.getText();

//            textField.setText("");
        }
        if(e.getSource()==subBtn){
//            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("-"));

            number = textField.getText();
//            textField.setText("");
        }
        if(e.getSource()==mulBtn){
//            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("*"));

            number = textField.getText();
//            textField.setText("");
        }
        if(e.getSource()==divBtn){
//            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("/"));

            number = textField.getText();
//            textField.setText("");
        }
        if(e.getSource()==equBtn){
//            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("="));

            number = textField.getText();
        }

//        //equell btn
//        if(e.getSource()==equBtn){
//            num2 = Double.parseDouble(textField.getText());
//
//            switch (operatorSign){
//                case '+':
//                    result = num1 + num2;
//                    break;
//                case '-':
//                    result = num1 - num2;
//                    break;
//                case '*':
//                    result = num1 * num2;
//                    break;
//                case '/':
//                    result = num1 / num2;
//                    break;
//            }
//
//            textField.setText(String.valueOf(result));
//            num1=result; //so that we can continue
//        }

        //clear button

        if(e.getSource()==clrBtn){
            textField.setText("");
        }

        //Delete button
        if(e.getSource()==delBtn){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));//+
//                System.out.println(string.charAt(i));
            }
        }
        //negButton
//        if(e.getSource()==negButton){
//            double temp = Double.parseDouble(textField.getText());
//            temp *= -1;
//            textField.setText(String.valueOf(temp));
//        }



    }




    public static void main(String[] args) {
        calculator calculatorp = new calculator();
    }



}
