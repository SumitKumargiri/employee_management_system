package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    JLabel lblusername,lblpassword;
    JButton login,close;
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 750);
        add(image);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(450, 200, 100, 30);
        lblusername.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        lblusername.setForeground(Color.WHITE);
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(550, 200, 250, 30);
        tfusername.setBackground(Color.WHITE);
        image.add(tfusername);
        
        lblpassword = new JLabel("Password");
        lblpassword.setBounds(450, 300, 100, 30);
        lblpassword.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        lblpassword.setForeground(Color.WHITE);
        image.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(550, 300, 250, 30);
        tfpassword.setBackground(Color.WHITE);
       // tfpassword.setEchoChar("*");
        image.add(tfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(600, 350, 100, 50);
        login.setBackground(Color.blue);
        login.setForeground(Color.WHITE);
        login.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        login.addActionListener(this);
        image.add(login);
        
        close = new JButton("CLOSE");
        close.setBounds(750, 350, 100, 50);
        close.setBackground(Color.RED);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        image.add(close); 
        
      /*  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(800, 170, 200, 200);
        add(image);  */
        
      /*  JPanel panel = new JPanel();
        panel.setBounds(430, 100, 570, 350);
        panel.setBackground(Color.WHITE);
        add(panel);  */
        
        setSize(1100, 750);
        setLocation(450, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
               new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        else {
            setVisible(false);
            }
    }
    
    
    public static void main(String[] args) {
        new Login();
    }
}
