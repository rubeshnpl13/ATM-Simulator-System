import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    JButton login, clear, register;
    JTextField cardTextField;
    JPasswordField pinField;
    public Login(){
        setTitle("NISHANT BANKING SYSTEM");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("WELCOME TO BANKING ");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,600,30);
        add(text);
        JLabel text2 = new JLabel("SYSTEM");
        text2.setFont(new Font("Osward", Font.BOLD, 38));
        text2.setBounds(345,70,600,30);
        add(text2);

        JLabel cardno = new JLabel("Card No");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(120,150,400,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120,220,250,40);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(300,220,230,30);
        add(pinField);

        login = new JButton("Login");
        login.setBounds(300, 300,100,30);
//        login.setBackground(Color.RED);
//        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300,100,30);
//        login.setBackground(Color.RED);
//        login.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        JLabel newuser = new JLabel("New User?");
        newuser.setBounds(390,345,100,20);
        newuser.setFont(new Font("Raleway", Font.BOLD, 12));
        add(newuser);

        register = new JButton("Create Account");
        register.setBounds(300, 365,230,30);
//        login.setBackground(Color.RED);
//        login.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinField.setText("");
        } else if (e.getSource() == login) {
            DBCon c = new DBCon();
            String cardnumber = cardTextField.getText();
            String pin = pinField.getText();
            String query = "select * from login where cardno = '"+cardnumber +"' and pin = '"+pin +"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }
        } else if (e.getSource() == register) {
            setVisible(false);
            new Register().setVisible(true);
        }
    }
}
