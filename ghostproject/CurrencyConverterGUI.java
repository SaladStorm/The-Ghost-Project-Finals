package ghostproject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class CurrencyConverterGUI
{
    public JFrame frame1, frame2;
    private JPanel p8, p9, p10, p11, p12, p13, p14, mp2, panel, historyp;
    public JButton Startbtn, exitbtn, convertbtn, switchbtn, historybtn, historyexit, Clear;
    public JLabel label1, label2, label3, dummylabel, label4;
    public JComboBox<String> from = new JComboBox<>();
    public JComboBox<String> to = new JComboBox<>();
    public JTextField fromtf, totf;
    private DefaultListModel<String> historyModel;
    private JList<String> historyJList;
    private List<String> historyEntries = new ArrayList<>();
    private JFrame historyFrame;
    private final int HISTORY_CAP = 10;
    public void startScreen1()
    {       
            frame1 = new JFrame("Philippine Currency Exchange System");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setSize(600, 350);
            frame1.setLocationRelativeTo(null);

            panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2),new EmptyBorder(40, 40, 40, 40)));

            JLabel title = new JLabel("Philippine Currency Exchange System");
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
                convertbtn = new JButton("Convert");
                switchbtn = new JButton("⇆");
                historybtn = new JButton("History");
                Clear = new JButton("Clear");
    }

    public void startScreen2()
    {   
        frame1.setVisible(false);
        frame2 = new JFrame("Currency Converter");
        mp2 = new JPanel();
                
        label2 = new JLabel("Convert from: ");
        label3 = new JLabel("Convert to: ");
        label4 = new JLabel("Updates are made every 24 hours, last updated: 4:00 PM PHT");

        //panels 8 to 14
        p8 = new JPanel();
        p9 = new JPanel();
        p10 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel();
        p13 = new JPanel();
        p14 = new JPanel();
        mp2 = new JPanel();

        fromtf = new JTextField("");
        totf = new JTextField("");
        dummylabel = new JLabel("");

        p8.setLayout(new GridLayout(1,1));
        p8.add(label4);
        p9.setLayout(new GridLayout(1,1));
        p10.setLayout(new GridLayout(1,5));
        p10.add(label2);
        p10.add(dummylabel);
        p10.add(label3);
        p11.setLayout(new GridLayout(1,5));
        p11.add(fromtf);
        p11.add(from);
        p11.add(switchbtn);
        p11.add(to);
        p11.add(totf);
        p13.add(convertbtn);
        p13.add(Clear);
        p13.add(historybtn);
        p13.add(exitbtn);
        p12.setLayout(new GridLayout(1,1));
        p13.setLayout(new GridLayout(1,4));
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
        frame2.setSize(600, 350);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setVisible(true);
        totf.setEditable(false);
     
        historyp = new JPanel();
        historyexit = new JButton("Back");
        historyp.add(historyexit);
        historyModel = new DefaultListModel<>();
        historyJList = new JList<>(historyModel);
        historyFrame = new JFrame("Conversion History");
        JPanel historyMainPanel = new JPanel();
        historyMainPanel.setLayout(new java.awt.BorderLayout());
        historyMainPanel.add(new JScrollPane(historyJList), java.awt.BorderLayout.CENTER);
        historyMainPanel.add(historyp, java.awt.BorderLayout.SOUTH);
        historyFrame.add(historyMainPanel);
        historyFrame.setSize(600, 350);
        historyFrame.setLocationRelativeTo(null);
        historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        historybtn.addActionListener(e ->{
            historyModel.clear();
            for (String s : historyEntries) historyModel.addElement(s);
            historyFrame.setVisible(true);
            frame2.setVisible(false);
        });
         historyexit.addActionListener(e ->{
            historyFrame.setVisible(false);
            frame2.setVisible(true);
        });

       
        
    }
    public void setCombobox(String a)
    {
        from.addItem(a);
        to.addItem(a);
    }

    private void addHistoryEntry(String entry) {
       
        historyEntries.add(0, entry);
        if (historyEntries.size() > HISTORY_CAP) historyEntries.remove(historyEntries.size() - 1);

        if (historyModel != null) {
            historyModel.clear();
            for (String s : historyEntries) historyModel.addElement(s);
        }
    }

    public void recordConversion()
    {
            double amount = Double.parseDouble(fromtf.getText());
            double result = Double.parseDouble(totf.getText());
            String fromCode = from.getSelectedItem() != null ? from.getSelectedItem().toString() : "";
            String toCode = to.getSelectedItem() != null ? to.getSelectedItem().toString() : "";
            String fromName = label2 != null ? label2.getText().replace("Convert from: ", "") : fromCode;
            String toName = label3 != null ? label3.getText().replace("Convert to: ", "") : toCode;
            String entry = String.format("%s (%s) → %s (%s): %.2f → %.2f", fromName, fromCode, toName, toCode, amount, result);
            addHistoryEntry(entry);
    }
}