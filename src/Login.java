import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class Login implements ActionListener {
    JFrame frame;
    JLabel LoginLabel= new JLabel("Library System");

    JLabel emailLabel = new JLabel("Email Address:");
    JLabel passwordLabel = new JLabel("Password:");

    JTextField emailField = new JTextField();
    JPasswordField passField = new JPasswordField();

    JButton loginBtn = new JButton("Login");

    Login() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Library");
        frame.setBounds(40,40,600,500);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        LoginLabel.setBounds(210,30,400,50);
        LoginLabel.setFont(LoginLabel.getFont().deriveFont(Float.parseFloat("24")));

        emailLabel.setBounds(120,100,100,30);
        emailField.setBounds(250,100,200,30);

        passwordLabel.setBounds(120,200,100,30);
        passField.setBounds(250,200,200,30);

        loginBtn.setBounds(230, 300, 100, 40);
    }

    public void addComponentsToFrame() {
        frame.add(LoginLabel);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(passwordLabel);
        frame.add(passField);

        frame.add(loginBtn);
    }

    public void actionEvent() {
        loginBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginBtn)) {
            System.out.println("success");

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
                Statement stmt = conn.createStatement();
                String query = "SELECT * FROM users WHERE email='" + emailField.getText() + "' AND password='" + String.valueOf(passField.getPassword()) + "'";

                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println("login success");
                    JOptionPane.showMessageDialog(null,"Book record added successfully");
                    Record rObj = new Record();
                    frame.dispose();
                }

            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        } else {
            System.out.println("Fail");
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}