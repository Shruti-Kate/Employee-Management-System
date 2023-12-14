package employee.registration.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        
        super("Employee Registration System");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("EMPLOYEE REGISTRATION SYSTEM");
        heading.setBounds(270, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.BOLD, 60));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first_page.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 100, 1550, 870);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(650, 530, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.setFocusable(false);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1550, 870);
        setLocation(0, 0);
        setVisible(true);    
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
