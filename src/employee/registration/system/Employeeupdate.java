package  employee.registration.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
 

public class Employeeupdate extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    Employeeupdate() {
        
        super("Employee Registration System");
        getContentPane().setBackground(Color.orange);
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/w.jpg"));
        Image i2 = i1.getImage().getScaledInstance( 1750, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1750, 820);
        add(image);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(250, 30, 200, 20);
        searchlbl.setFont(new Font("Arial", Font.PLAIN, 18));
        image.add(searchlbl);
        cemployeeId = new Choice();
        cemployeeId.setBounds(470, 30, 150, 20);
        image.add(cemployeeId);
        
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
        table.setBackground(Color.white);
        table.setRowHeight(35);
        table.setForeground(Color.BLUE);
         
        
       // table.setBorder(BorderFactory.createLineBorder(Color.black));
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 150, 700, 500);
 jsp.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        image.add(jsp);
        
        search = new JButton("Search");
        search.setBounds(50, 70, 80, 40); 
        search.addActionListener(this);
       image.add(search);
        
       
        print = new JButton("Print"); 
//        print.setBackground(Color.cyan);
//        print.setForeground(Color.red);
        print.setBounds(150, 70, 80, 40);
        print.setFocusable(false);
        print.addActionListener(this); 
        image.add(print);
        
        update = new JButton("Update");
        update.setBounds(250, 70, 80, 40);
        update.addActionListener(this);
        update.setFocusable(false);
        image.add(update);
 
        back = new JButton("Back");
        back.setBounds(650, 70, 80, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
       
        image.add(back);
setSize(1750, 820);
        setLocation(0, 0);
         
        setVisible(true);
    }
    
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
 