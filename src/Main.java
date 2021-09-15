import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame frame;
    JLabel LoginLabel= new JLabel("Library System");
    JButton bt1 = new JButton("Enter a record");

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

    }
    public void addComponentsToFrame(){
        frame.add(LoginLabel);
        frame.add(bt1);
    }
    public void actionEvent()
    {
        bt1.addActionListener(this);
    }

    public static void main(String[] args)
    {
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent a){
        Record recordObj = new Record();
        frame.hide();
    }
}


