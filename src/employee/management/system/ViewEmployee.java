package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    JLabel searchlbl;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        setTitle("Employee Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 10, 220, 30);
        searchlbl.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(250, 10, 150, 30);
        cemployeeId.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        add(cemployeeId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10, 120, 1050, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 50, 100, 40);
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(140, 50, 100, 40);
        print.setBackground(Color.BLUE);
        print.setForeground(Color.WHITE);
        print.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(260, 50, 100, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(380, 50, 100, 40);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        back.addActionListener(this);
        add(back);
        
        setSize(1080, 700);
        setLocation(410, 80);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
