import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CurrencyConverterGUI implements ActionListener
{
    private JFrame frame1, frame2;
    private JPanel p8, p9, p10, p11, p12, p13, p14, mp2;
    private JButton exitbtn, convertbtn, switchbtn;
    //private JLabel
    private JComboBox from, to;
    private JTextField fromtf, totf;
    /*public void startScreen1()
    {  
        
        
        .setContentPane();
        .setSize(600, 450);
        .setVisible(true);
        .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        .setResizable(true);
    }
    */
    public void startScreen2()
    {   
        frame2 = new JFrame("Currency Converter");
        switchbtn = new JButton("Swap");
        switchbtn.addActionListener(this);
        exitbtn = new JButton("Exit");
        exitbtn.addActionListener(this);
        convertbtn = new JButton("Convert");
        convertbtn.addActionListener(this);

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
        fromtf = new JTextField();
        totf = new JTextField();

        p8.setLayout(new GridLayout(1,1));
        //p8.add();
        p9.setLayout(new GridLayout(1,1));
        //p9.add();
        p10.setLayout(new GridLayout(1,1));
        //p10.add();
        p11.setLayout(new GridLayout(1,5));
        p11.add(fromtf);
        p11.add(from);
        p11.add(switchbtn);
        p11.add(totf);
        p11.add(to);
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
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == exitbtn)
        {
            System.exit(0);
        }
    }
}

