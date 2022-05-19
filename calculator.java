//package com.mycompany.mid_calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.text.DecimalFormat;

public class calculator implements ActionListener {

//Declaring variable as global
    DecimalFormat f = new DecimalFormat(".######");
    double num1 = 0.0;
    double num2 = 0.0;
    double result = 0.0;
    JFrame frame;
    JPanel panel1, panel2, panel3, panel4, panel5, panel0, panel_alpha, panel_trigno;
    JTextField tfield, tfield2, tfield_num2, tfield_operator;
    JTextField test_field;

//Number buttons
    JButton[] num = new JButton[10];
//algebric Function Buttons
    JButton addButton, subButton, multiButton, divButton, equButton, delButton;
    JButton[] fun_button = new JButton[6];

//Alphabetical BUttons
    JButton[] alphabets = new JButton[6];
//other function buttons
    JButton sqrt, fictorial, one_over_x, ee, sqr, cube, x_y_power, clr, dec, bin, oct, hex, c_to_f, f_to_c, dot;
//Trignometric functions
    JButton sin, cos, tan, mod, log, ln, cosec, sec, cot, sinh, cosh, tanh;

    JButton o_functions[] = new JButton[27];

//counting variables for no of times buttons are pressed
    int hex_count = 0;
    int binary_count = 0;
    boolean binary = false;
    boolean hexa = false;
    boolean octal = false;
    String trigno_operator;
    char operator;
    int tfield_count = 0;
    int xy_power_count = 0;
    double temp;
    int tempo;
    int mod_count = 0;
//*********************************************************************Method calculator ***************************************************************

    calculator() {
        JFrame frame = new JFrame();
//BorderLayout for panels to be used
        frame.setLayout(new BorderLayout(15, 15));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 600);
        frame.setTitle("Heavy shit");
//****************************************************************************Panels********************************************************************
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel_trigno = new JPanel();
//for Alphabets To appear when hex button is pressed
        JPanel panel_alpha = new JPanel();
//panel zero for whole frame
        JPanel panel0 = new JPanel();

        panel1.setBackground(Color.green);
        panel2.setBackground(Color.red);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.yellow);
        panel5.setBackground(Color.CYAN);
        panel6.setBackground(Color.white);
        panel_trigno.setBackground(Color.white);
        panel_alpha.setBackground(Color.red);
//panel0 for background
        panel0.setBackground(Color.decode("#04293A"));

//Setting bounds for panel to contain different buttons
//panel1 last 4 rows
        panel1.setBounds(0, 342, 75, 215);
//panel2 for left column
        panel2.setBounds(75, 342, 261, 215);
//panel3 for right column
        panel3.setBounds(336, 342, 75, 215);
//panel4 for upper two rows
        panel4.setBounds(0, 180, 412, 98);
        /*(When Hex button is pressed)
        panel_alpha.setBounds(0, 180, 412, 49); */
//panel 5 for single row(Number system)
        panel5.setBounds(0, 279, 335, 64);
//panel6 for divide button
        panel6.setBounds(336, 279, 75, 64);
//panel_trigno for trignometric single row
        panel_trigno.setBounds(0, 130, 412, 49);
//backgoround
        panel0.setBounds(0, 360, 90, 240);

//**************************************************************************Butttons*********************************************************************
//Initializing Alphabetical buttons
        for (int i = 'A', j = 0; i < 'G'; i++, j++) {
            alphabets[j] = new JButton(String.valueOf(i));
            alphabets[j].addActionListener(this);
            alphabets[j].setBackground(Color.decode("#04293A"));
            alphabets[j].setForeground(Color.white);
//          alphabets[i].setBorder(new EmptyBorder(0, 0, 0, 0));
            alphabets[j].setFocusable(false);
        }

//******************************Other function buttons
        sqrt = new JButton("√");
        fictorial = new JButton("x!");
        one_over_x = new JButton("1/x");
        ee = new JButton("e");
        dot = new JButton(".");
        clr = new JButton("clr");
        c_to_f = new JButton("°C");
        f_to_c = new JButton("°F");
        sqr = new JButton("x^2");
        cube = new JButton("x^3");
        x_y_power = new JButton("x^y");
        log = new JButton("log");
        mod = new JButton("%");
        ln = new JButton("ln");
        tan = new JButton("Tan");
        sin = new JButton("Sin");
        cos = new JButton("Cos");
        hex = new JButton("Hex");
        oct = new JButton("Oct");
        bin = new JButton("Bin");
        dec = new JButton("Dec");
        cosec = new JButton("Csc");
        sec = new JButton("Sec");
        cot = new JButton("Cot");
        sinh = new JButton("Sinh");
        cosh = new JButton("Cosh");
        tanh = new JButton("Tanh");

        o_functions[0] = sqrt;
        o_functions[1] = fictorial;
        o_functions[2] = one_over_x;
        o_functions[3] = ee;

        o_functions[4] = dot;
        o_functions[5] = clr;
        o_functions[6] = c_to_f;
        o_functions[7] = f_to_c;
        o_functions[8] = sqr;
        o_functions[9] = cube;
        o_functions[10] = x_y_power;
        o_functions[11] = log;
        o_functions[12] = mod;
        o_functions[13] = ln;
//Trignometric 
        o_functions[14] = tan;
        o_functions[15] = sin;
        o_functions[16] = cos;
        o_functions[17] = cosec;
        o_functions[18] = sec;
        o_functions[19] = cot;
        o_functions[20] = sinh;
        o_functions[21] = cosh;
        o_functions[22] = tanh;
//Number system
        o_functions[23] = hex;
        o_functions[24] = oct;
        o_functions[25] = bin;
        o_functions[26] = dec;

//left column and uppr two rows
        for (int i = 0; i < 23; i++) {
            o_functions[i].setBackground(Color.decode("#04293A"));
            o_functions[i].setForeground(Color.white);
        }
        clr.setBackground(Color.decode("#950101"));
//For Number system
        for (int i = 23; i < o_functions.length; i++) {
            o_functions[i].setBackground(Color.decode("#27496D"));
            o_functions[i].setForeground(Color.white);
        }

//Adding to actionListeners
        for (int i = 0; i < o_functions.length; i++) {
            o_functions[i].addActionListener(this);
        }
//Integers(with dot and neg button)
        for (int i = 0; i < 10; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(this);
            num[i].setBackground(Color.decode("#04293A"));
            num[i].setForeground(Color.white);
            num[i].setBorder(new EmptyBorder(0, 0, 0, 0));
            num[i].setFocusable(false);
        }

//algebric Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("x");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Del");

        fun_button[0] = addButton;
        fun_button[1] = subButton;
        fun_button[2] = multiButton;
        fun_button[3] = divButton;
        fun_button[4] = equButton;
        fun_button[5] = delButton;

        subButton.setForeground(Color.decode("#03C4A1"));
        multiButton.setForeground(Color.decode("#03C4A1"));
        addButton.setForeground(Color.decode("#03C4A1"));

        divButton.setForeground(Color.decode("#03C4A1"));
        //  equButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        addButton.addActionListener(this);
//right column
        for (int i = 0; i < 6; i++) {
            fun_button[i].addActionListener(this);
            fun_button[i].setBackground(Color.decode("#04293A"));
            fun_button[i].setForeground(Color.white);
            //         fun_button[i].setBorder(new EmptyBorder(0, 0, 0, 0));
        }
        divButton.addActionListener(this);
        equButton.setBackground(Color.white);
        equButton.setForeground(Color.black);
//***************************************************************Buttons position in panels*************************************************************
//****************************************Panel2(The integers from 1 to 9 and below row)
//no of rows and column and horizontal and vertical spaces
        panel2.setLayout(new GridLayout(4, 3, 3, 3));
        panel2.setBackground(Color.decode("#04293A"));
        panel2.add(num[1]);
        panel2.add(num[2]);
        panel2.add(num[3]);
        panel2.add(num[4]);
        panel2.add(num[5]);
        panel2.add(num[6]);
        panel2.add(num[7]);
        panel2.add(num[8]);
        panel2.add(num[9]);
        panel2.add(fun_button[5]);
        panel2.add(num[0]);
        panel2.add(dot);

//********************************************************panel_3(left column)
        panel3.setLayout(new GridLayout(4, 1, 3, 3));
        panel3.setBackground(Color.decode("#04293A"));
//Multiply
        panel3.add(fun_button[2]);
//Subtract
        panel3.add(fun_button[1]);
//Add
        panel3.add(fun_button[0]);
//Equal
        panel3.add(fun_button[4]);

//********************************************************panel_2(For e,fictorial,1/x,sqrt)
        panel1.setLayout(new GridLayout(4, 1, 3, 3));
        panel1.setBackground(Color.decode("#04293A"));
        panel1.add(sqrt);
        panel1.add(fictorial);
        panel1.add(one_over_x);
        panel1.add(ee);
//********************************************Panel_5(Number systems)
        panel5.setLayout(new GridLayout(1, 4, 3, 3));
        panel5.setBackground(Color.decode("#27496D"));
        panel5.add(dec);
        panel5.add(bin);
        panel5.add(oct);
        panel5.add(hex);
//********************************* panel_6(divide button only)
        panel6.setLayout(new GridLayout(1, 1, 2, 2));
        panel6.setBackground(Color.decode("#5D8BF4"));
        panel6.add(fun_button[3]);

//*********************************Panel4(Upper 2 rows)****************
        panel4.setLayout(new GridLayout(2, 6, 3, 3));
        panel4.setBackground(Color.decode("#04293A"));
        panel4.add(sin);
        panel4.add(cos);
        panel4.add(tan);
        panel4.add(mod);
        panel4.add(log);
        panel4.add(ln);
        panel4.add(sqr);
        panel4.add(cube);
        panel4.add(x_y_power);
        panel4.add(c_to_f);
        panel4.add(f_to_c);
        panel4.add(clr);

//*********************************Panel_Trignometric(Upper Singal row)
        panel_trigno.setLayout(new GridLayout(1, 6, 3, 3));
        panel_trigno.setBackground(Color.decode("#04293A"));
        panel_trigno.add(cosec);
        panel_trigno.add(sec);
        panel_trigno.add(cot);
        panel_trigno.add(sinh);
        panel_trigno.add(cosh);
        panel_trigno.add(tanh);
//panel1(The hexadecimal values)
//**************************************************************************txtfield********************************************************************
//For num1      
        tfield = new JTextField();
        tfield.setBounds(0, 0, 185, 60);
        //tfield.setBackground(Color.yellow);
        tfield.setBackground(Color.decode("#04293A"));
        tfield.setForeground(Color.white);
        tfield.setFont(new Font("Consolas", Font.ITALIC, 30));
        tfield.setBorder(new EmptyBorder(0, 0, 0, 0));
        tfield.setHorizontalAlignment(JTextField.CENTER);
//For operator      
        tfield_operator = new JTextField();
        tfield_operator.setBounds(185, 0, 42, 60);
        //tfield_operator.setBackground(Color.red);
        tfield_operator.setBackground(Color.decode("#04293A"));
        tfield_operator.setForeground(Color.white);
        tfield_operator.setFont(new Font("Consolas", Font.ITALIC, 30));
        tfield_operator.setBorder(new EmptyBorder(0, 0, 0, 0));
        tfield_operator.setHorizontalAlignment(JTextField.CENTER);
//For num2      
        tfield_num2 = new JTextField();
        tfield_num2.setBounds(227, 0, 185, 60);
        //tfield.setBackground(Color.white);
        tfield_num2.setBackground(Color.decode("#04293A"));
        tfield_num2.setForeground(Color.white);
        tfield_num2.setFont(new Font("Consolas", Font.ITALIC, 30));
        tfield_num2.setBorder(new EmptyBorder(0, 0, 0, 0));
        tfield_num2.setHorizontalAlignment(JTextField.CENTER);

//Result
        tfield2 = new JTextField();
        tfield2.setBounds(0, 60, 412, 60);
        tfield2.setBackground(Color.red);
        tfield2.setBackground(Color.decode("#950101"));
        tfield2.setForeground(Color.white);
        tfield2.setFont(new Font("Consolas", Font.BOLD, 30));
        tfield2.setHorizontalAlignment(JTextField.CENTER);
        tfield2.setBorder(new EmptyBorder(0, 0, 0, 0));

//Adding all elements in frame
        frame.add(tfield);
        frame.add(tfield2);
        frame.add(tfield_num2);
        frame.add(tfield_operator);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        //frame.add(panel_alpha);
        // panel_alpha.setVisible(false);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel_trigno);
        frame.add(panel0);

        frame.setVisible(true);
    }

//**********************************************************************Main method********************************************************
    public static void main(String[] args) {
        calculator cal = new calculator();
    }

//***********************************************************Actions performed on clicking button********************************************
    public void actionPerformed(ActionEvent e) {
//For Number Buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == num[i]) {
                if (tfield_count % 2 == 0) {
                    tfield.setText(tfield.getText().concat(String.valueOf(i)));
                } else {
                    tfield_num2.setText(tfield_num2.getText().concat(String.valueOf(i)));
                }
            }

        }

//For Decimal point
        if (e.getSource() == dot) {
            if (tfield_count % 2 == 0) {
                tfield.setText(tfield.getText().concat("."));
            } else if (tfield_count % 2 != 0) {
                tfield_num2.setText(tfield_num2.getText().concat("."));
            }
        }
//For Function Buttons

        if (e.getSource() == subButton) {
            operator = '-';
            tfield_operator.setText("-");
            tfield_count = 1;
            hex_count = 1;
        } else if (e.getSource() == multiButton) {
            operator = 'x';
            tfield_operator.setText("x");
            tfield_count = 1;
            hex_count = 1;
        } else if (e.getSource() == divButton) {

            operator = '/';
            tfield_operator.setText("/");
            tfield_count = 1;
            hex_count = 1;
        } else if (e.getSource() == addButton) {
            operator = '+';
            tfield_operator.setText("+");
            tfield_count = 1;
            hex_count = 1;
        }
//***************************************************EqualButton
        if (e.getSource() == equButton) {
            hex_count = 0;
            tfield_count = 0;
            if (binary == false && octal == false && hexa == false) {
                num1 = Double.parseDouble(tfield.getText());
                num2 = Double.parseDouble(tfield_num2.getText());

//****************For Number Systems to perform the operations
//BInary
            } else if (binary == true && octal == false && hexa == false) {

                String temp_num1 = tfield.getText();
                num1 = Integer.parseInt(temp_num1, 2);
                System.out.println(num1);
                String temp_num2 = tfield_num2.getText();
                num2 = Integer.parseInt(temp_num2, 2);
                System.out.println(num2);
            } //Octal
            else if (binary == false && octal == true && hexa == false) {

                String temp_num1 = tfield.getText();
                num1 = Integer.parseInt(temp_num1, 8);
                System.out.println(num1);
                String temp_num2 = tfield_num2.getText();
                num2 = Integer.parseInt(temp_num2, 8);
                System.out.println(num2);
            } //**Hexa
            else if (binary == false && octal == false && hexa == true) {

                String temp_num1 = tfield.getText();
                num1 = Integer.parseInt(temp_num1, 16);
                System.out.println(num1);
                String temp_num2 = tfield_num2.getText();
                num2 = Integer.parseInt(temp_num2, 16);
                System.out.println(num2);
            }
            tfield_count = 1;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;

                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:

            }
            hex_count = 0;
            if (binary == false && octal == false && hexa == false) {
                tfield2.setText(String.valueOf(f.format(result)));
            } else if (binary == true && octal == false && hexa == false) {
                System.out.println(result);
                int temp_result = (int) result;
                System.out.println(temp_result);
                tfield2.setText(Integer.toBinaryString(temp_result));
                if (operator == '/' && num2 == 0) {
                    tfield2.setText("Infinity");
                }
//Octal
            } else if (binary == false && octal == true && hexa == false) {
                System.out.println(result);
                int temp_result = (int) result;
                System.out.println(temp_result);
                tfield2.setText(Integer.toOctalString(temp_result));
                if (operator == '/' && num2 == 0) {
                    tfield2.setText("Infinity");
                }
            } //Hexa
            else if (binary == false && octal == false && hexa == true) {
                System.out.println(result);
                int temp_result = (int) result;
                System.out.println(temp_result);
                tfield2.setText(Integer.toHexString(temp_result));
                if (operator == '/' && num2 == 0) {
                    tfield2.setText("Infinity");
                }
            }
        }

//Clear Button
        if (e.getSource() == clr) {
            tfield.setText("");
            tfield2.setText("");
            tfield_operator.setText("");
            tfield_num2.setText("");
            tfield_count = 0;
            hex_count = 0;
//Enabling the disabled buttons if any
            num[2].setEnabled(true);
            num[3].setEnabled(true);
            num[4].setEnabled(true);
            num[5].setEnabled(true);
            num[6].setEnabled(true);
            num[7].setEnabled(true);
            num[8].setEnabled(true);
            num[9].setEnabled(true);
            sin.setEnabled(true);
            cos.setEnabled(true);
            tan.setEnabled(true);
            log.setEnabled(true);
            ln.setEnabled(true);
            sqr.setEnabled(true);
            cube.setEnabled(true);
            f_to_c.setEnabled(true);
            c_to_f.setEnabled(true);
            x_y_power.setEnabled(true);
            sqrt.setEnabled(true);
            fictorial.setEnabled(true);
            one_over_x.setEnabled(true);
        }
//DeleteButton
        if (e.getSource() == delButton) {
            if (tfield_count == 0) {
                String string = tfield.getText();
                tfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    tfield.setText(tfield.getText() + string.charAt(i));
                }
            } else if (tfield_count == 1) {
                String string = tfield_num2.getText();
                tfield_num2.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    tfield_num2.setText(tfield_num2.getText() + string.charAt(i));
                }
            }
        }
//1/x Button
        if (e.getSource() == one_over_x) {
            if (tfield_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                num1 = 1 / num1;
                tfield.setText(String.valueOf(f.format(num1)));
            } else if (tfield_count == 1) {
                num2 = Double.parseDouble(tfield.getText());
                num2 = 1 / num2;
                tfield.setText(String.valueOf(f.format(num2)));
            }
        }
//Fictorial
        if (e.getSource() == fictorial) {
            if (tfield_count % 2 == 0) {
                num1 = Double.parseDouble(tfield.getText());
                int temp1 = (int) num1;
                //    System.out.println(temp);
                for (int i = temp1 - 1; i > 0; i--) {
                    temp1 *= i;
                    System.out.println(temp1);
                }
                tfield_count = 1;
                tfield.setText(String.valueOf(temp1));
            } else if (tfield_count % 2 != 0) {
                num2 = Double.parseDouble(tfield_num2.getText());
                int temp1 = (int) num1;
                //    System.out.println(temp);
                for (int i = temp1 - 1; i > 0; i--) {
                    temp1 *= i;
                    System.out.println(temp1);
                }
                tfield_count = 0;
                tfield_num2.setText(String.valueOf(temp1));
            }
        }
//Sqrt
        if (e.getSource() == sqrt) {
            if (tfield_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                num1 = Math.sqrt(num1);
                num1 = (float) num1;
                tfield.setText(String.valueOf(f.format(num1)));
            } else {
                num2 = Double.parseDouble(tfield_num2.getText());
                num2 = Math.sqrt(num2);
                // String num = Double.toString(num2);
                //   num = String.format("%.4f", num);
                tfield_num2.setText(String.valueOf(f.format(num2)));
            }
        }
//square
        if (e.getSource() == sqr) {
            if (tfield_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                num1 = Math.pow(num1, 2);
                num1 = (float) num1;
                tfield.setText(String.valueOf(num1));
            } else {
                num2 = Double.parseDouble(tfield_num2.getText());
                num2 = Math.pow(num2, 2);
                // String num = Double.toString(num2);
                //   num = String.format("%.4f", num);
                tfield_num2.setText(String.valueOf(num2));
            }
        }
//cube
        if (e.getSource() == cube) {
            if (tfield_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                num1 = Math.pow(num1, 3);
                num1 = (float) num1;
                tfield.setText(String.valueOf(num1));
            } else {
                num2 = Double.parseDouble(tfield_num2.getText());
                num2 = Math.pow(num2, 3);
                tfield_num2.setText(String.valueOf(num2));
            }
        }
//x_y_power

        if (e.getSource() == x_y_power) {
            if (tfield_count == 0 && xy_power_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                tfield.setText("");
                tfield_operator.setText("x^y");

            } else if (tfield_count == 0 && xy_power_count == 1) {
                temp = Double.parseDouble(tfield.getText());
                double xy_power = Math.pow(num1, temp);
                tfield.setText(String.valueOf(xy_power));
                tfield_operator.setText("");
                num1 = xy_power;
                xy_power_count = -1;
//
            } else if (tfield_count == 1 && xy_power_count == 0) {
                num2 = Double.parseDouble(tfield_num2.getText());
                tfield_num2.setText("");
            } else if (tfield_count == 1 && xy_power_count == 1) {
                temp = Double.parseDouble(tfield_num2.getText());
                double xy_power = Math.pow(num2, temp);
                tfield_num2.setText(String.valueOf(xy_power));
                num2 = xy_power;
                xy_power_count = -1;
            }

            xy_power_count++;
        }
// F to Calsius
        if (e.getSource() == f_to_c) {
            num1 = Double.parseDouble(tfield.getText());
            double c = ((num1 - 32) * 5) / 9;
            tfield_operator.setText("°F");
            tfield2.setText(String.valueOf(f.format(c)) + "°C");
        }
// C to Fahrenheit
        if (e.getSource() == c_to_f) {
            num1 = Double.parseDouble(tfield.getText());
            double fo = num1 * 9 / 5 + 32;
            tfield_operator.setText("°C");
            tfield2.setText(String.valueOf(f.format(fo)) + "°F");
        }

//Log
        if (e.getSource() == log && hex_count%2==0) {
            if (tfield_count % 2 == 0) {
                num1 = Double.parseDouble(tfield.getText());
                temp = Math.log10(num1);
                tfield.setText(String.valueOf(f.format(temp))); 
            } else if (tfield_count % 2 != 0) {
                num2 = Double.parseDouble(tfield_num2.getText());
                temp = Math.log10(num2);
                tfield_num2.setText(String.valueOf(f.format(temp)));
                tfield_count = 0;
            }
        }
//Ln
        if (e.getSource() == ln && hex_count%2==0) {
            if (tfield_count % 2 == 0) {
                num1 = Double.parseDouble(tfield.getText());
                temp = Math.log(num1);
                tfield.setText(String.valueOf(f.format(temp)));

            } else if (tfield_count % 2 != 0) {
                num2 = Double.parseDouble(tfield_num2.getText());
                temp = Math.log(num2);
                tfield_num2.setText(String.valueOf(f.format(temp)));
                tfield_count = 0;
            }
        }
//MOD

        if (e.getSource() == mod && hex_count%2==0) {
            if (tfield_count == 0 && mod_count == 0) {
                tempo = Integer.parseInt(tfield.getText());
                tfield.setText("");
                tfield_operator.setText("%");

            } else if (tfield_count == 0 && mod_count == 1) {
                int temp_temp = Integer.parseInt(tfield.getText());
                int modd = tempo % temp_temp;
                tfield.setText(String.valueOf(modd));
                tfield_operator.setText("");
                num1 = modd;
                mod_count = -1;
//
            } else if (tfield_count == 1 && mod_count == 0) {
                tempo = Integer.parseInt(tfield_num2.getText());
                tfield_num2.setText("");
            } else if (tfield_count == 1 && mod_count == 1) {
                int temp_temp = Integer.parseInt(tfield_num2.getText());
                int modd = tempo % temp_temp;
                tfield_num2.setText(String.valueOf(modd));
                num2 = modd;
                mod_count = -1;
            }

            mod_count++;
        }
//Trignometric functions

        if ((e.getSource() == sin || e.getSource() == cos || e.getSource() == tan ||e.getSource() == mod || e.getSource() == log || e.getSource() == ln )) {
//For operator 1
            if (tfield_count % 2 == 0 && hex_count % 2 == 0) {
                if (e.getSource() == sin) {
                    trigno_operator = "sin";
                } else if (e.getSource() == cos) {
                    trigno_operator = "cos";
                } else if (e.getSource() == tan) {
                    System.out.println("Choti Tachi ho kia?");
                    trigno_operator = "tan";
                }

                num1 = Double.parseDouble(tfield.getText());
                temp = num1;
                num1 = Math.toRadians(num1);
                switch (trigno_operator) {
                    case "sin":
                        num1 = Math.sin(num1);
                        break;
                    case "cos":
                        num1 = Math.cos(num1);
                        break;
                    case "tan":
                        num1 = Math.tan(num1);
                        break;
                    default:
                }

                tfield.setText(String.valueOf(f.format(num1)));
                if (e.getSource() == tan && temp == 90) {
                    tfield.setText("Undefined");
                }
            } //operator2 Trigno
            else if (tfield_count % 2 != 0 && hex_count % 2 == 0) {
                if (e.getSource() == sin) {
                    trigno_operator = "sin";
                } else if (e.getSource() == cos) {
                    trigno_operator = "cos";
                } else if (e.getSource() == tan) {
                    System.out.println("Choti Tachi ho kia?");
                    trigno_operator = "tan";
                }

                if (tfield_count % 2 != 0) {
                    num2 = Double.parseDouble(tfield_num2.getText());
                    temp = num2;
                    num2 = num2 * (Math.PI / 180);
                    switch (trigno_operator) {
                        case "sin":
                            num2 = Math.sin(num2);
                            break;
                        case "cos":
                            num2 = Math.cos(num2);
                            break;
                        case "tan":
                            num2 = Math.tan(num2);
                            break;
                        default:
                    }
                    tfield_num2.setText(String.valueOf(f.format(num2)));
                    if (e.getSource() == tan && temp == 90) {
                        tfield_num2.setText("Undefined");
                    }
                    hex_count = 0;
                }
            } //FOR Hexadecimal buttons
            else if (tfield_count % 2 == 0 && hex_count % 2 != 0) {
                if (e.getSource() == sin) {
                    tfield.setText(tfield.getText().concat("A"));
                } else if (e.getSource() == cos) {
                    tfield.setText(tfield.getText().concat("B"));
                } else if (e.getSource() == tan) {
                    System.out.println("Choti bachi ho kia?");
                    tfield.setText(tfield.getText().concat("C"));
                } else if (e.getSource() == mod) {
                    tfield.setText(tfield.getText().concat("D"));
                } else if (e.getSource() == log) {
                    tfield.setText(tfield.getText().concat("E"));
                } else if (e.getSource() == ln) {
                    tfield.setText(tfield.getText().concat("F"));
                }
            } else if (tfield_count % 2 != 0 && hex_count % 2 != 0) {
                if (e.getSource() == sin) {
                    tfield_num2.setText(tfield_num2.getText().concat("A"));
                } else if (e.getSource() == cos) {
                    tfield_num2.setText(tfield_num2.getText().concat("B"));
                } else if (e.getSource() == tan) {
                    tfield_num2.setText(tfield_num2.getText().concat("C"));
                } else if (e.getSource() == mod) {
                    tfield_num2.setText(tfield_num2.getText().concat("D"));
                } else if (e.getSource() == log) {
                    tfield_num2.setText(tfield_num2.getText().concat("E"));
                } else if (e.getSource() == ln) {
                    tfield_num2.setText(tfield_num2.getText().concat("F"));
                }
            }
        }

//For Hexadecimal Button
        if (e.getSource() == hex) {
            hex_count += 1;
//Enabling the disabled buttons if any
            num[2].setEnabled(true);
            num[3].setEnabled(true);
            num[4].setEnabled(true);
            num[5].setEnabled(true);
            num[6].setEnabled(true);
            num[7].setEnabled(true);
            num[8].setEnabled(true);
            num[9].setEnabled(true);
            sin.setEnabled(true);
            cos.setEnabled(true);
            tan.setEnabled(true);
            log.setEnabled(true);
            ln.setEnabled(true);
            sqr.setEnabled(true);
            cube.setEnabled(true);
            f_to_c.setEnabled(true);
            c_to_f.setEnabled(true);
            x_y_power.setEnabled(true);
            sqrt.setEnabled(true);
            fictorial.setEnabled(true);
            one_over_x.setEnabled(true);
            mod.setEnabled(true);
//Condition for Changeing the text of buttons to perform hexadecimal operations
            if (hex_count % 2 != 0) {
//
                hexa = true;
                binary = false;
                octal = false;
//
                sin.setText("A");
                cos.setText("B");
                tan.setText("C");
                mod.setText("D");
                log.setText("E");
                ln.setText("F");

                sqr.setEnabled(false);
                cube.setEnabled(false);
                f_to_c.setEnabled(false);
                c_to_f.setEnabled(false);
                x_y_power.setEnabled(false);
                sqrt.setEnabled(false);
                fictorial.setEnabled(false);
                one_over_x.setEnabled(false);
                ee.setEnabled(false);

            } else if (hex_count % 2 == 0) {
//
                hexa = false;
                binary = false;
                octal = false;
//
                sin.setText("Sin");
                cos.setText("Cos");
                tan.setText("Tan");
                mod.setText("%");
                log.setText("Log");
                ln.setText("Ln");
                //  tfield2.setText("Trignometric functions");

                sin.setEnabled(true);
                cos.setEnabled(true);
                tan.setEnabled(true);
                log.setEnabled(true);
                ln.setEnabled(true);
                sqr.setEnabled(true);
                cube.setEnabled(true);
                f_to_c.setEnabled(true);
                c_to_f.setEnabled(true);
                x_y_power.setEnabled(true);
                sqrt.setEnabled(true);
                fictorial.setEnabled(true);
                one_over_x.setEnabled(true);
                ee.setEnabled(true);
            }
        }

//For Binary Button
        if (e.getSource() == bin) {
            binary_count += 1;

//
            binary = true;
            octal = false;
            hexa = false;
//
            num[2].setEnabled(false);
            num[3].setEnabled(false);
            num[4].setEnabled(false);
            num[5].setEnabled(false);
            num[6].setEnabled(false);
            num[7].setEnabled(false);
            num[8].setEnabled(false);
            num[9].setEnabled(false);
            sin.setEnabled(false);
            cos.setEnabled(false);
            tan.setEnabled(false);
            log.setEnabled(false);
            ln.setEnabled(false);
            sqr.setEnabled(false);
            cube.setEnabled(false);
            f_to_c.setEnabled(false);
            c_to_f.setEnabled(false);
            x_y_power.setEnabled(false);
            sqrt.setEnabled(false);
            fictorial.setEnabled(false);
            one_over_x.setEnabled(false);
            ee.setEnabled(false);
            mod.setEnabled(false);
        }

//For Octal Button
        if (e.getSource() == oct) {

//
            octal = true;
            binary = false;
            hexa = false;
//
            num[2].setEnabled(true);
            num[3].setEnabled(true);
            num[4].setEnabled(true);
            num[5].setEnabled(true);
            num[6].setEnabled(true);
            num[7].setEnabled(true);
            num[8].setEnabled(false);
            num[9].setEnabled(false);
            sin.setEnabled(false);
            cos.setEnabled(false);
            tan.setEnabled(false);
            log.setEnabled(false);
            ln.setEnabled(false);
            sqr.setEnabled(false);
            cube.setEnabled(false);
            f_to_c.setEnabled(false);
            c_to_f.setEnabled(false);
            x_y_power.setEnabled(false);
            sqrt.setEnabled(false);
            fictorial.setEnabled(false);
            one_over_x.setEnabled(false);
            ee.setEnabled(false);
            mod.setEnabled(false);

        }//End of octal button

//Trignometric upper row
        if (e.getSource() == cosec || e.getSource() == sec || e.getSource() == cot || e.getSource() == sinh || e.getSource() == cosh || e.getSource() == tanh) {

            if (e.getSource() == cosec) {
                trigno_operator = "cosec";
            } else if (e.getSource() == sec) {
                trigno_operator = "sec";
            } else if (e.getSource() == cot) {
                trigno_operator = "cot";
            } else if (e.getSource() == sinh) {
                trigno_operator = "sinh";
            } else if (e.getSource() == cosh) {
                trigno_operator = "cosh";
            } else if (e.getSource() == tanh) {
                trigno_operator = "tanh";
            }
            if (tfield_count == 1) {
                num2 = Double.parseDouble(tfield_num2.getText());
                temp = num2;
                num2 = num2 * (Math.PI / 180);
                switch (trigno_operator) {
                    case "cosec":
                        num2 = Math.sin(num2);
                        num2 = 1 / num2;
                        break;
                    case "sec":
                        num2 = Math.cos(num2);
                        num2 = 1 / num2;
                        break;
                    case "cot":
                        num2 = Math.tan(num2);
                        num2 = 1 / num2;
                        break;
                    case "sinh":
                        num2 = Math.sinh(num2);
                        break;
                    case "cosh":
                        num2 = Math.cosh(num2);
                        break;
                    case "tanh":
                        num2 = Math.tanh(num2);
                        break;
                    default:
                }
                tfield_num2.setText(String.valueOf(f.format(num2)));
                if (e.getSource() == cot && temp == 0) {
                    tfield_num2.setText("Undefined");
                }

            } else if (tfield_count == 0) {
                num1 = Double.parseDouble(tfield.getText());
                temp = num1;
                num1 = num1 * (Math.PI / 180);
                switch (trigno_operator) {
                    case "cosec":
                        num1 = Math.sin(num1);
                        num1 = 1 / num1;
                        break;
                    case "sec":
                        num1 = Math.cos(num1);
                        num1 = 1 / num1;
                        break;
                    case "cot":
                        num1 = Math.tan(num1);
                        num1 = 1 / num1;
                        break;
                    case "sinh":
                        num1 = Math.sinh(num1);
                        break;
                    case "cosh":
                        num1 = Math.cosh(num1);
                        break;
                    case "tanh":
                        num1 = Math.tanh(num1);
                        break;
                    default:
                }
                tfield.setText(String.valueOf(f.format(num1)));
                if (e.getSource() == cot && temp == 0) {
                    tfield.setText("Undefined");
                }

            }
        }//

//e
        if (e.getSource() == ee) {
            if (tfield_count == 0) {
                tfield.setText("2.718");
            } else if (tfield_count == 1) {
                tfield_num2.setText("2.718");
            }
        }
    }
}