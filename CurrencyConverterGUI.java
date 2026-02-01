import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CurrencyConverterGUI implements ActionListener
{
    private JFrame frame1, frame2;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, mp1, mp2;
    private JButton Startbtn, exitbtn, convertbtn, switchbtn;
    private JLabel label1, label2, label3, dummylabel;
    public JComboBox from, to;
    private JTextField fromtf, totf;
    public void startScreen1()
    {  
        Startbtn = new JButton("Start");
        Startbtn.addActionListener(this);
        label1 = new JLabel("Philippine Peso Exchange System");
        label1.setHorizontalAlignment(JLabel.CENTER);
        frame1 = new JFrame("Currency Converter");
        mp1 = new JPanel();
        mp1.setLayout(new GridLayout(7, 1));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1));
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1));
        p4 = new JPanel();
        p4.setLayout(new GridLayout(1, 1));
        p5 = new JPanel();
        p5.setLayout(new GridLayout(1, 1));
        p6 = new JPanel();
        p6.setLayout(new GridLayout(1, 1));
        p7 = new JPanel();
        p7.setLayout(new GridLayout(1, 1));

        p3.add(label1);
        p4.add(Startbtn);
        
        mp1.add(p1);
        mp1.add(p2);
        mp1.add(p3);
        mp1.add(p4);
        mp1.add(p5);
        mp1.add(p6);
        mp1.add(p7);
        frame1.setContentPane(mp1);
        frame1.setSize(600, 450);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(true);
    }

    public void startScreen2()
    {   
        frame2 = new JFrame("Currency Converter");
        mp2 = new JPanel();
        switchbtn = new JButton("⇆");
        switchbtn.addActionListener(this);
        exitbtn = new JButton("Exit");
        exitbtn.addActionListener(this);
        convertbtn = new JButton("Convert");
        convertbtn.addActionListener(this);
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
        from = new JComboBox();
        to = new JComboBox();
        from.addItem("USD");
        from.addItem("EUR");
        from.addItem("AUD");
        from.addItem("SGD");
        from.addItem("MYR");
        from.addItem("INR");
        from.addItem("CAD");
        from.addItem("BRP");
        from.addItem("CHF");
        from.addItem("JPY");
        from.addItem("PHP");
        to.addItem("USD");
        to.addItem("EUR");
        to.addItem("AUD");
        to.addItem("SGD");
        to.addItem("MYR");
        to.addItem("INR");
        to.addItem("CAD");
        to.addItem("BRP");
        to.addItem("CHF");
        to.addItem("JPY");
        to.addItem("PHP");
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
        frame2.setContentPane(mp2);
        frame2.setSize(600, 450);
        frame2.setVisible(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Startbtn)
        {
            frame1.setVisible(false);
            frame2.setVisible(true);
        }
        else if (e.getSource() == switchbtn)
        {
            System.out.println("Switch button has been pressed");
        }
        else if(e.getSource() == convertbtn)
        {
            System.out.println("Convert button has been pressed");
        }
        else if(e.getSource() == exitbtn)
        {
            System.exit(0);
        }
    }
}

