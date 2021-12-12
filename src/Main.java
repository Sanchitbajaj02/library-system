import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame frame;
    JLabel LoginLabel= new JLabel("Library System");
    JButton bt1 = new JButton("Add Record");
    JButton bt2 = new JButton("Entries");

    Main()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Library");
        frame.setBounds(40,40,600,500);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        LoginLabel.setBounds(210,100,400,50);
        LoginLabel.setFont(LoginLabel.getFont().deriveFont(Float.parseFloat("24")));

        bt1.setBounds(90,200,400,50);
        bt1.setFont(bt1.getFont().deriveFont(Float.parseFloat("18")));

        bt2.setBounds(90,300,400,50);
        bt2.setFont(bt2.getFont().deriveFont(Float.parseFloat("18")));

    }
    public void addComponentsToFrame(){
        frame.add(LoginLabel);
        frame.add(bt1);
        frame.add(bt2);
    }
    public void actionEvent()
    {
        bt1.addActionListener(this);
        bt2.addActionListener(this);

    }

    public static void main(String[] args)
    {
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent a){
        System.out.println(a.getActionCommand());

        if (a.getActionCommand().equals("Add Record")) {
            Record recordObj = new Record();
            frame.dispose();
        } else if (a.getActionCommand().equals("Entries")) {
            Entries entriesObj = new Entries();
            frame.dispose();

        }
    }
}


