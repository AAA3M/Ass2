import java.io.IOError;
import java.io.IOException;
//import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

/**
 * LSBSTApp is a GUI app that the user can interact with.
 * The user will be able to pick the file the app reads from, and pick the stage, day, and time which the user wants to check.
 * The Working directory for this app meant to be Ass2. This is only the case when running from the makefile. or using the -cp bin command in terminal.
 * This is where the DataFiles, which are .txt files should be stored.
 * The user will have 2 options apart from chagning the File. The user can Print All Areas, or Print current Area. These will be written to the screen. 
 * The terminal will also output the results from the user when the user presses buttons. This is in order to write the output to textFiles for later analysis.
 */
public class LSBSTApp extends JFrame{
    private JPanel newPanel ;
    private JPanel panel1 ;
    private JTextField textField2, textField1;
    private JPanel panelimage ;
    private String output = "";

    private String[] StageStrings = { "1", "2", "3", "4", "5", "6", "7", "8"};
    private String[] DayStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
     "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] TimeStrings = { "00", "02", "04", "06", "08", "10", "12", "14", "16", "18", "20", "22"};

    private JComboBox StageList = new JComboBox(StageStrings);
    private JComboBox DayList = new JComboBox(DayStrings);
    private JComboBox TimeList = new JComboBox(TimeStrings);
    private JLabel slabel = new JLabel("Stage: ");
    private JLabel dlabel = new JLabel("Day: ");
    private JLabel tlabel = new JLabel("Time: ");

    private JLabel kklabel = new JLabel("Files loaded from current Directory (Ass2). Reading data from:");

    private JTextPane tp = new JTextPane();

    
    private JScrollPane sp = new JScrollPane(tp);

    //static String currentpath = System.getProperty("user.dir");
    //static String path = Paths.get(currentpath).getParent().toString() + "/";

    public LSBSTApp(){

        super("LSBSTApp");


        tp.setEditable(false);
        StageList.setSelectedIndex(0);
        DayList.setSelectedIndex(0);
        TimeList.setSelectedIndex(0);
        //StageList.addActionListener(this);
        setLocation(440, 50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newPanel = new JPanel();
        panel1 = new JPanel();
        panelimage = new JPanel();

        panel1.setBackground(Color.BLACK);
        panel1.setPreferredSize( new Dimension(500, 500));
        newPanel.setPreferredSize( new Dimension(480, 480));
        panelimage.setPreferredSize( new Dimension(350, 300));
        sp.setPreferredSize(new Dimension(300, 350));


        add(panel1);

        panel1.add(newPanel, BorderLayout.SOUTH);
        
        newPanel.add(slabel, BorderLayout.NORTH);
        newPanel.add(StageList, BorderLayout.NORTH);
        newPanel.add(dlabel, BorderLayout.NORTH);
        newPanel.add(DayList, BorderLayout.NORTH);
        newPanel.add(tlabel, BorderLayout.NORTH);
        newPanel.add(TimeList, BorderLayout.NORTH);
        

        final ActionListener listener = new ButtonListen();
        final JButton buttonA = new JButton("Print All Areas");
        buttonA.addActionListener(listener);

        final JButton buttonB = new JButton("Print Current Area");
        buttonB.addActionListener(listener);

        textField2 = new JTextField(25);
        textField2.setText("DataFile.txt");
        textField2.setHorizontalAlignment(JTextField.CENTER);
        Font font = new Font("SansSerif", Font.BOLD, 25);
        textField2.setFont(font);
        newPanel.add(kklabel, BorderLayout.CENTER);
        newPanel.add(textField2, BorderLayout.CENTER);
        newPanel.add(buttonA, BorderLayout.WEST);
        newPanel.add(buttonB, BorderLayout.WEST);
        newPanel.add(sp, BorderLayout.SOUTH);

        //Container c = window.getContentPane();
        //c.setBackground(Color.BLACK);

        pack();
        setVisible(true);

    }


       public static void main(String[] args) throws IOException{

        new LSBSTApp();
            
    }

    public class ButtonListen implements ActionListener {

        public  void actionPerformed(ActionEvent e) {
            String buttonText = ((JButton)e.getSource()).getText();
            ((JButton)e.getSource()).setEnabled(true);
            String letterType = buttonText;
            try {
                if (letterType.equals("Print All Areas")){
                    MyBinTree x  = new MyBinTree(textField2.getText());
                    x.printAllAreas();
                    output = x.getOutPutString();
                    tp.setText(output);
                }
    
                if (letterType.equals("Print Current Area")){

                    MyBinTree x  = new MyBinTree(textField2.getText());
                    String sl = StageList.getSelectedItem().toString();
                    String dl = DayList.getSelectedItem().toString();
                    String tl = TimeList.getSelectedItem().toString();
                    x.printAreas(sl, dl, tl);
                    output = x.getOutPutString();
                    tp.setText(output);
                    

            } 
        }
            catch (IOException er) {
                er.printStackTrace();
            }

        }
    }
}



                //x.printAreas(StageList.toString(), DayList.toString(), TimeList.toString());

            



            
        


