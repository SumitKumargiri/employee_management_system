package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Singup extends JFrame implements ActionListener{
    
    JTextField tf1,tf3,tf4,tf5;
    JButton singup,close;
    JLabel f_name,password,m_no,email;
    Singup(){
     
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/singup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1050, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1050, 700);
        add(image);
        
        f_name = new JLabel("Username");
        f_name.setBounds(550, 50, 100, 30);
        f_name.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        f_name.setForeground(Color.WHITE);
        image.add(f_name);
        tf1= new JTextField();
        tf1.setBounds(700, 50, 250, 30);
        tf1.setBackground(Color.WHITE);
        image.add(tf1);
        
        password = new JLabel("Password");
        password.setBounds(550, 100, 100, 30);
        password.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        password.setForeground(Color.WHITE);
        image.add(password);
        tf3= new JTextField();
        tf3.setBounds(700, 100, 250, 30);
        tf3.setBackground(Color.WHITE);
        image.add(tf3);
        
        m_no = new JLabel("Mobile Number");
        m_no.setBounds(550, 150, 150, 30);
        m_no.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        m_no.setForeground(Color.WHITE);
        image.add(m_no);
        tf4= new JTextField();
        tf4.setBounds(700, 150, 250, 30);
        tf4.setBackground(Color.WHITE);
        image.add(tf4);
        
        email = new JLabel("Email");
        email.setBounds(550, 200, 100, 30);
        email.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        email.setForeground(Color.WHITE);
        image.add(email);
        tf5= new JTextField();
        tf5.setBounds(700, 200, 250, 30);
        tf5.setBackground(Color.WHITE);
        image.add(tf5);
        
       /* JPanel panel = new JPanel();
        panel.setBounds(500, 100, 470, 450);
        panel.setBackground(Color.CYAN);
        add(panel);  */
        
        singup = new JButton("SingUP");
        singup.setBounds(620, 280, 100, 50);
        singup.setBackground(Color.blue);
        singup.setForeground(Color.WHITE);
        singup.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        singup.addActionListener(this);
        image.add(singup);
        
        close = new JButton("Close");
        close.setBounds(770, 280, 100, 50);
        close.setBackground(Color.RED);
        close.setForeground(Color.WHITE);
        close.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        close.addActionListener(this);
        image.add(close);
        
        setSize(1100, 750);
        setLocation(450, 100);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == singup) {
            String username = tf1.getText();
            String password = tf3.getText();
            String mobileno = tf4.getText();
            String email = tf5.getText();
        try {
                Conn c = new Conn();
                String query = "insert into singup values('"+username+"', '"+password+"', '"+mobileno+"', '"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      }
        else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Singup();
    }
    
}
