package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    JButton bt1,bt2;
    JLabel heading;
    
    Splash() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        bt1 = new JButton("LOGIN");
        bt1.setBounds(400, 400, 150, 50);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setFont(new Font("serif", Font.BOLD, 20));
        bt1.addActionListener(this);
        image.add(bt1);
        
        bt2= new JButton("SINGUP");
        bt2.setBounds(600, 400, 150, 50);
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setFont(new Font("serif", Font.BOLD, 20));
        bt2.addActionListener(this);
        image.add(bt2);
        
        setSize(1170, 650);
        setLocation(300, 100);
        setVisible(true);
        
        while(true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            setVisible(false);
            new Login();
    }else {
        setVisible(false);
        new Singup();
    }
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
