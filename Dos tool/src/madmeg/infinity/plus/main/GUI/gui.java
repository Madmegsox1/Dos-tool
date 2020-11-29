package madmeg.infinity.plus.main.GUI;

import madmeg.infinity.plus.main.Multithread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {

    private JTextField textField;
    private JTextField tf;
    private JTextField tf2;
    private JTextField tf3;


    public static JLabel lbl;
    public static JLabel lbl1;
    public static JLabel lbl2;
    public static JLabel lbl3;
    public static JLabel lbl4;

    private String ip;
    private String port;
    private String threads;
    private String Timeout;


    private static JPanel panel;

    public static Color c3 = Color.BLACK;
    public static Color btnColor = Color.WHITE;
    public static Color textColor = Color.white;

    private static JButton button;
    private static JButton btn2;


    public gui(){
        JFrame frame = new JFrame("Infinity+ DOS tool");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,250);


        button = new JButton("Start");
        button.setBackground(btnColor);
        button.addActionListener(this);

        btn2 = new JButton("GUI Editor");
        btn2.setBackground(btnColor);
        btn2.addActionListener(this);


        panel = new JPanel();
        panel.setBackground(c3);
        textField = new JTextField(10);
        tf = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);



        lbl = new JLabel("IP");
        lbl1 = new JLabel("Port");
        lbl2 = new JLabel("Threads");
        lbl3 = new JLabel("TimeOut (s)");

        lbl4 = new JLabel();



        lbl.setForeground(textColor);
        lbl1.setForeground(textColor);
        lbl2.setForeground(textColor);
        lbl3.setForeground(textColor);
        lbl4.setForeground(textColor);

        panel.setLayout(null);

        lbl.setBounds(50, 20, 80, 25);
        textField.setBounds(100, 20, 165, 25);

        tf.setBounds(100, 60, 80, 25);
        lbl1.setBounds(50,60, 80, 25);
        lbl2.setBounds(210, 60, 80, 25);
        tf2.setBounds(280, 60, 80, 25);

        lbl3.setBounds(50 , 100, 80, 25);
        tf3.setBounds(150, 100, 80, 25);

        lbl4.setBounds(180, 150, 150, 25);

        button.setBounds(180, 180, 80, 25);
        btn2.setBounds(300, 180, 100, 25);

        panel.add(lbl);
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(textField);
        panel.add(tf);
        panel.add(tf2);
        panel.add(lbl3);
        panel.add(lbl4);
        panel.add(tf3);

        panel.add(button);
        panel.add(btn2);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void main(String args[]){
        new gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                ip = textField.getText();
                port = tf.getText();
                threads = tf2.getText();
                Timeout = tf3.getText();
                lbl4.setText("Error");

                Multithread.main(ip, port, threads, Timeout);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (e.getSource() == btn2){
            new guiEditor();
        }
    }



    public static Color getC3(){
        return c3;
    }


    public static void setC3(Color _c3){
        c3 = _c3;
        panel.setBackground(c3);
    }

    public static Color getBtnColor(){
        return btnColor;
    }

    public static void setBtnColor(Color _btnColor){
        btnColor = _btnColor;
        button.setBackground(btnColor);
        btn2.setBackground(btnColor);
    }

    public static Color getTextColor(){
        return textColor;
    }

    public static void setTextColor(Color _textColor){
        textColor = _textColor;
        lbl.setForeground(textColor);
        lbl1.setForeground(textColor);
        lbl2.setForeground(textColor);
        lbl3.setForeground(textColor);
        lbl4.setForeground(textColor);
    }


}
