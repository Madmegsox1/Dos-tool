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

    public static JLabel lbl4;

    private String ip;
    private String port;
    private String threads;
    private String Timeout;

    public gui(){
        JFrame frame = new JFrame("Infinity+ DOS tool");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,250);


        JButton button = new JButton("Start");
        button.setBackground(Color.white);
        button.addActionListener(this);

        JPanel panel = new JPanel(){
            protected void paintComponent(Graphics g) {

                final int R = 0;
                final int G = 0;
                final int B = 0;
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(149, 95, 173, 255), getWidth(), getHeight(), new Color(R, G, B, 255), true);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        textField = new JTextField(10);
        tf = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);



        JLabel lbl = new JLabel("IP");
        JLabel icon = new JLabel();
        JLabel lbl1 = new JLabel("Port");
        JLabel lbl2 = new JLabel("Threads");
        JLabel lbl3 = new JLabel("TimeOut (s)");

        lbl4 = new JLabel();



        lbl.setForeground(Color.WHITE);
        lbl1.setForeground(Color.WHITE);
        lbl2.setForeground(Color.WHITE);
        lbl3.setForeground(Color.WHITE);
        lbl4.setForeground(Color.WHITE);

        panel.setLayout(null);

        lbl.setBounds(50, 20, 80, 25);
        textField.setBounds(100, 20, 165, 25);
        icon.setBounds(0,20, 80, 25);

        tf.setBounds(100, 60, 80, 25);
        lbl1.setBounds(50,60, 80, 25);
        lbl2.setBounds(210, 60, 80, 25);
        tf2.setBounds(280, 60, 80, 25);

        lbl3.setBounds(50 , 100, 80, 25);
        tf3.setBounds(150, 100, 80, 25);

        lbl4.setBounds(180, 150, 150, 25);

        button.setBounds(180, 180, 80, 25);

        panel.add(lbl);
        panel.add(icon);
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(textField);
        panel.add(tf);
        panel.add(tf2);
        panel.add(lbl3);
        panel.add(lbl4);
        panel.add(tf3);

        panel.add(button);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public static void main(String args[]){
        new gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
}
