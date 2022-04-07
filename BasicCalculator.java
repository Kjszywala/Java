package com.mycompany.calculator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 *
 * @author Kamil Szywala
 */
public class Calculator extends JFrame implements ActionListener{
    public static void main(String[] args) {
        new Calculator();
    }
    /**
     * Variables
     * results1 is a text in JTextField results
     */
    private String results1 = "";
    private JTextField results;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton plus;
    private JButton minus;
    private JButton multiple;
    private JButton divide;
    private JButton clear;
    private JButton dot;
    private JButton negative;
    private JButton equal;
    /**
     * Constructor with function to get interface
     */
    public Calculator(){
        super("Calculator");
        initInterface();
    }
    /**
     * Add interface screen
     */
    public void initInterface(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JPanel header = new JPanel(new FlowLayout());
        results = new JTextField();
        results.setHorizontalAlignment(SwingConstants.RIGHT);
        results.setEditable(false);
        results.setBorder(new LineBorder(Color.GRAY));
        results.setFont(new Font("Serif",Font.BOLD,16));
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        plus = new JButton("+");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        minus = new JButton("-");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        multiple = new JButton("*");       
        button0 = new JButton("0");
        clear = new JButton("C");
        dot = new JButton(".");
        divide = new JButton("/");
        negative = new JButton("+/-");
        equal = new JButton("=");
        panel.add(results, BorderLayout.NORTH);
        header.add(button1);
        header.add(button2);
        header.add(button3);
        header.add(plus);
        header.add(button4);
        header.add(button5);
        header.add(button6);
        header.add(minus);
        header.add(button7);
        header.add(button8);
        header.add(button9);
        header.add(multiple);
        header.add(button0);
        header.add(clear);
        header.add(dot);
        header.add(divide);
        header.add(negative);
        header.add(equal);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        plus.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        minus.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        multiple.addActionListener(this);
        button0.addActionListener(this);
        clear.addActionListener(this);
        dot.addActionListener(this);
        divide.addActionListener(this);
        negative.addActionListener(this);
        equal.addActionListener(this);
        panel.add(header, BorderLayout.CENTER);
        setContentPane(panel);
        setSize(250,270);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Logic
     */
    /**
     * Array with 2 strings, we will convert strings to numbers
     * to get some counting on them.
     * Double result is a result from counting.
     * String character - depends what we will choose (+,-,*,/)
     * it will return the result we want.
     */
    String[] numbers = new String[1];
    double result = 0;
    String character;
    /**
     * Split the results1(text from textfield) to two strings with our
     * numbers.  
     * @param e 
     */
    public void Split(String e){
        results1 = results1 + e;
        if(results1.charAt(0)=='.'){
            results1 = "0.";
        }
        results.setText(results1);
        if(character == "+")
            numbers = results1.split("\\+");
        else if(character == "-")
            numbers = results1.split("-");
        else if(character == "*")
            numbers = results1.split("\\*");
        else if(character == "/")
            numbers = results1.split("/");
    }
    /**
     * character - our +,-,*,/.
     * counter - counting how many characters we have in our textfield
     *      if we have more then one doing counting and leaving last
     *      character on the last position in text field.
     *      else just adding character to textfield.
     * @param e 
     */
    public void Character(String e){
        character = e;
        int counter = 0;
        for(int i = 0; i<results1.length()-1; i++){
            if(results1.charAt(i)=='+' || results1.charAt(i)=='-' ||
                    results1.charAt(i)=='*' || results1.charAt(i)=='/'){
                counter+=1;
                System.out.println(counter);
            }
        }
        if(counter==1){
            Equal();
            counter = 0;
            results1 = results1 + e;
        }
        else
            results1 = results1 + e;
        results.setText(results1);
    }
    /**
     * clear the textfield
     */
    public void Clear(){
        results1 = "";
        results.setText(results1);
    }
    /**
     * changing our number to negative
     */
    public void Negative(){
        double negative = Double.parseDouble(results1);
        double change;
        change = negative-negative-negative;
        results1 = Double.toString(change);
        results.setText(results1);
    }
    /**
     * changing our Array of two strings to two double numbers and
     * calculating them, then returning result as a string to text field.
     */
    public void Equal(){
        double x = Double.parseDouble(numbers[0]);
        double y = Double.parseDouble(numbers[1]);
        if(character == "+")
            result = x + y;
        else if(character == "-")
            result = x - y;
        else if(character == "*")
            result = x * y;
        else if(character == "/")
            result = x / y;
        String r;
        r = Double.toString(result);
        results1 = r;
        results.setText(r);
    }
    /**
     * ActionListener
     * @param e
    **/
    @Override
     public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "+" -> Character("+");
            case "-" -> Character("-");
            case "*" -> Character("*");
            case "C" -> Clear();
            case "." -> Split(".");
            case "/" -> Character("/");
            case "+/-" -> Negative();
            case "=" -> Equal();
            case "0" -> Split("0");
            case "1" -> Split("1");
            case "2" -> Split("2");
            case "3" -> Split("3");
            case "4" -> Split("4");
            case "5" -> Split("5");
            case "6" -> Split("6");
            case "7" -> Split("7");
            case "8" -> Split("8");
            case "9" -> Split("9");
        }
    }
}
