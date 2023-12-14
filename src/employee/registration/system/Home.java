package  employee.registration.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove , logout;
    
    Home() {
        
        super("Employee Registration System");
        setLayout(null); 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 850);
        add(image);
        
        JLabel heading = new JLabel("Employee Registration System");
        heading.setBounds(900, 30, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 26));
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(930, 80, 150, 40);
        add.addActionListener(this);
        add.setFocusable(false);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(1090, 80, 150, 40);
        view.addActionListener(this);
        view.setFocusable(false);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(930, 140, 150, 40);
        update.addActionListener(this);
        update.setFocusable(false);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(1090, 140, 150, 40);
        remove.addActionListener(this);
        remove.setFocusable(false);
        image.add(remove); 
        
        
      
        logout = new JButton("LOGOUT"); 
        logout.setFocusable(false);
        logout.setForeground(Color.WHITE);
        logout.setBackground(new Color(255,69,0));
        logout.setBounds(1020,200,150,35);
        logout.addActionListener(this);
        image.add(logout);
        
        
        setSize(1550, 850);
        setLocation(0, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new Employeeupdate();
        } else if(ae.getSource()==logout){
            System.exit(0);
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
