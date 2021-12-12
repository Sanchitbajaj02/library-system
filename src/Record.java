import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Record implements ActionListener {
    JFrame frame;
    JLabel LoginLabel= new JLabel("Library System");

    JLabel bookNameLabel = new JLabel("Book name: ");
    JLabel authorNameLabel = new JLabel("Author name: ");
    JLabel date = new JLabel("Publish Date");
    JLabel pageCount = new JLabel("Page count");
    JLabel description = new JLabel("Description");

    JTextField bookNameTF = new JTextField();
    JTextField authorNameTF = new JTextField();
    JTextField dateTF = new JTextField();
    JTextField pageCountTF = new JTextField();
    JTextField descriptionTF = new JTextField();

    JButton registerButton = new JButton("Save");
    JButton resetButton=new JButton("Reset");

    public static void main(String[] args) {
        new Record();
    }

    Record()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow()
    {
        frame = new JFrame();
        frame.setTitle("Record Entry");
        frame.setBounds(40,40,600,500);
//        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize()
    {
        LoginLabel.setBounds(210,30,400,50);
        LoginLabel.setFont(LoginLabel.getFont().deriveFont(Float.parseFloat("24")));

        bookNameLabel.setBounds(120,100,100,30);
        bookNameTF.setBounds(250,100,200,30);

        authorNameLabel.setBounds(120,150,100,30);
        authorNameTF.setBounds(250,150,200,30);

        date.setBounds(120,200,100,30);
        dateTF.setBounds(250,200,200,30);

        pageCount.setBounds(120,250,100,30);
        pageCountTF.setBounds(250,250,200,30);

        description.setBounds(120,300,100,30);
        descriptionTF.setBounds(250,300,200,30);

        registerButton.setBounds(120,400,100,30);
        resetButton.setBounds(350,400,100,30);
    }

    public void addComponentsToFrame()
    {
        frame.add(LoginLabel);

        frame.add(bookNameLabel);
        frame.add(bookNameTF);

        frame.add(authorNameLabel);
        frame.add(authorNameTF);

        frame.add(date);
        frame.add(dateTF);

        frame.add(pageCount);
        frame.add(pageCountTF);

        frame.add(description);
        frame.add(descriptionTF);

        frame.add(registerButton);
        frame.add(resetButton);
    }

    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton)
        {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
                PreparedStatement Pstatement = connection.prepareStatement("insert into book values(?,?,?,?,?)");
                Pstatement.setString(1,bookNameTF.getText());
                Pstatement.setString(2,authorNameTF.getText());
                Pstatement.setString(3,dateTF.getText());
                Pstatement.setString(4,pageCountTF.getText());
                Pstatement.setString(5,descriptionTF.getText());

                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Book record added successfully");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if(e.getSource() == resetButton)
        {
            bookNameTF.setText("");
            authorNameTF.setText("");
            dateTF.setText("");
            pageCountTF.setText("");
            descriptionTF.setText("");
        }

    }
}

