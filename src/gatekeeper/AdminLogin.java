/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatekeeper;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author E7240
 */
public class AdminLogin extends JFrame implements ActionListener {
    
    Container container=getContentPane();
    JLabel adminLabel=new JLabel("Admin ID");
    JLabel adminpassLabel=new JLabel("Password");
    JTextField adminTextField=new JTextField();
    JPasswordField adminpassField=new JPasswordField();
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JCheckBox showPassword=new JCheckBox("Show Password");
    
    
    AdminLogin()
    { 
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager()
    {
       container.setLayout(null);
    }
    public void setLocationAndSize()
    {   //setBounds  = (x:,y:,width:,height:)
        adminLabel.setBounds(50,150,100,30);
        adminpassLabel.setBounds(50,220,100,30);
        adminpassField.setBounds(150,220,100,30);
        adminTextField.setBounds(150,150,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
    }
    public void addComponentsToContainer()
    {
        container.add(adminLabel);
        container.add(adminpassLabel);
        container.add(adminTextField);
        container.add(adminpassField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    
    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==loginButton)
        {
            String userText;
            String passwordText;
            userText=adminTextField.getText();
            passwordText=adminpassField.getText();
            
            //User Verification goes here.
            if(userText.equalsIgnoreCase("Aidan")&&passwordText.equalsIgnoreCase("1234"))
            {
                JOptionPane.showMessageDialog(this, "Login Successful");
                // Add link to employee database
                //opens employee database
                 {
                    EmployeeDatabaseFrame frame = new EmployeeDatabaseFrame();
                    frame.setTitle("Employee Database");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid Username/Password or User does not exist");
            }
        }
        if(e.getSource()==resetButton)
        {
        adminLabel.setText("");
        adminpassField.setText("");
        }
        if(e.getSource()==showPassword)
        {
            if(showPassword.isSelected())
            {
            adminpassField.setEchoChar((char) 0);
            
            }
            else
            {
            adminpassField.setEchoChar('*');
            }
        }
    }
 
}
