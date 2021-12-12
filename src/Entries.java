import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Entries implements ActionListener {
    JFrame frame;
    JLabel LoginLabel= new JLabel("Library System");

    JTable table = new JTable();

    Entries() {
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
        table.setBounds(40,100,500,300);
    }

    public void addComponentsToFrame() {
        frame.add(LoginLabel);
        frame.add(table);
    }

    public void actionEvent() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
            Statement stmt = conn.createStatement();
            String query = "SELECT * from book";

            ResultSet rs = stmt.executeQuery(query);

            String column[] = {"title", "author", "date"};

            while (rs.next()) {
                System.out.println(rs);
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Entries();
    }

}