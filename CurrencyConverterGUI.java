import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class CurrencyConverterGUI
{
    public JFrame frame1, frame2;
    private JPanel p8, p9, p10, p11, p12, p13, p14, mp2, panel;
    public JButton Startbtn, exitbtn, convertbtn, switchbtn;
    private JLabel label1, label2, label3, dummylabel;
    public JComboBox<String> from = new JComboBox<>();
    public JComboBox<String> to = new JComboBox<>();
    private JTextField fromtf, totf;
    public void startScreen1()
    {       
            frame1 = new JFrame("Philippine Peso Exchange System");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(600, 350);
            frame1.setLocation(650, 300);

            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2),new EmptyBorder(40, 40, 40, 40)));

            JLabel title = new JLabel("Philippine Peso Exchange System");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);
            title.setFont(new Font("SansSeriff", Font.PLAIN, 22));

            Startbtn = new JButton("Start");
            Startbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            Startbtn.setBackground(new Color(0, 200, 120));
            Startbtn.setForeground(Color.BLACK);
            Startbtn.setFocusPainted(false);
            Startbtn.setFont(new Font("SansSeriff", Font.PLAIN, 22));
            Startbtn.setPreferredSize(new Dimension(120, 40));


            panel.add(Box.createRigidArea(new Dimension(0, 60)));
            panel.add(title);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            panel.add(Startbtn);

            frame1.add(panel);
            frame1.setVisible(true);

            exitbtn = new JButton("Exit");
    }

    public void startScreen2()
    {   
        frame1.setVisible(false);
        frame2 = new JFrame("Currency Converter");
        mp2 = new JPanel();
        switchbtn = new JButton("⇆");        
        
        convertbtn = new JButton("Convert");
        label2 = new JLabel("Convert from: ");
        label3 = new JLabel("Convert to: ");

        //panels 8 to 14
        p8 = new JPanel();
        p9 = new JPanel();
        p10 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel();
        p13 = new JPanel();
        p14 = new JPanel();
        mp2 = new JPanel();

        //Combo Boxes
        //from = new JComboBox<>();
        //to = new JComboBox<>();
        fromtf = new JTextField("");
        totf = new JTextField("");
        dummylabel = new JLabel("");


        p8.setLayout(new GridLayout(1,1));
        //p8.add();
        p9.setLayout(new GridLayout(1,1));
        p10.setLayout(new GridLayout(1,5));
        p10.add(label2);
        p10.add(dummylabel);
        p10.add(label3);
        p11.setLayout(new GridLayout(1,5));
        p11.add(fromtf);
        p11.add(from);
        p11.add(switchbtn);
        p11.add(totf);
        p11.add(to);
        p13.add(convertbtn);
        p13.add(exitbtn);
        p12.setLayout(new GridLayout(1,1));
        p13.setLayout(new GridLayout(1,2));
        p14.setLayout(new GridLayout(1,1));

        mp2.setLayout(new GridLayout(7,5));
        mp2.add(p8);
        mp2.add(p9);
        mp2.add(p10);
        mp2.add(p11);
        mp2.add(p12);
        mp2.add(p13);
        mp2.add(p14);
        frame2.setLocation(650, 300);
        frame2.setContentPane(mp2);
        frame2.setSize(800, 400);
        frame2.setVisible(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.pack();
        frame2.setVisible(true);
        totf.setEditable(false);
        
    }
    public void setCombobox(String a)
    {
        from.addItem(a);
        to.addItem(a);
    }
}

