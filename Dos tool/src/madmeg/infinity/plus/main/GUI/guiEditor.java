package madmeg.infinity.plus.main.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiEditor extends JFrame implements ActionListener {

    private JButton btn1;
    private JButton btn2;
    private JButton btn3;

    private static Color c1;
    private static Color btncol;
    private static Color textCol;

    private static JPanel panel;



    public guiEditor(){
        JFrame frame = new JFrame("GUI editor");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(450,200);
        frame.setResizable(false);
        frame.setVisible(true);


        panel = new JPanel();
        panel.setBackground(gui.getC3());
        panel.setLayout(null);


        btn1 = new JButton("BG Color");

        btn2 = new JButton("Button Color");

        btn3 = new JButton("Text Color");

        btn1.addActionListener(this);
        btn1.setBackground(gui.getBtnColor());

        btn2.addActionListener(this);
        btn2.setBackground(gui.getBtnColor());

        btn3.addActionListener(this);
        btn3.setBackground(gui.getBtnColor());

        btn1.setBounds(180, 20, 100, 25);

        btn2.setBounds(180, 60, 100, 25);

        btn3.setBounds(180, 100, 100, 25);

        panel.add(btn1);
        panel.add(btn3);
        panel.add(btn2);

        frame.getContentPane().add(BorderLayout.CENTER, panel);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1){
            c1 = JColorChooser.showDialog(this, "Select a color", gui.getC3());
            gui.setC3(c1);
            panel.setBackground(c1);
        }
        if (e.getSource() == btn2){
            btncol = JColorChooser.showDialog(this, "Select a color", gui.getBtnColor());
            gui.setBtnColor(btncol);
            btn1.setBackground(btncol);
            btn2.setBackground(btncol);
            btn3.setBackground(btncol);
        }

        if (e.getSource() == btn3){
            textCol = JColorChooser.showDialog(this, "Select a color", gui.getTextColor());
            gui.setTextColor(textCol);
        }

    }
}
