import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Register extends JFrame implements ActionListener {


   // long random;
    JTextField nameTF, fnameTF, emailTF, addressTF, cityTF, stateTF, pinTF;
    JButton next;
    JRadioButton male,female,other, married, unmarried;

    JComboBox cbstate, cbcity;
    JDateChooser dateChooser;


    Random ran = new Random();
    long random = Math.abs((ran.nextLong()%9000L)+1000L);
    String first = "" + Math.abs(random);

    String[] state1 = {"Taplejung" , "Solukhumbu" , "Sankhuwasabha" , "Udayapurn" , "Morang", "Ilam","Jhapa", "Khotang",
            "Bhojpur", "Panchthar",  "Sunsari" , "Okhaldhunga","Dhankuta","Terhathum"};

    String[] state2 = {"Bara", "Dhanusa", "Mahottari", "Parsa", "Rautahat", "Saptari", "Sarlahi", "Siraha"};
    String[] state3 = {"Bhaktapur", "District", "Chitwan", "Dhading", "Dolakha","Kathmandu", "Kavrepalanchok", "Lalitpur",
            "Makawanpur", "Nuwakot", "Ramechhap", "Rasuwa", "Sindhuli", "Sindhupalchok"};
    String[] state4 = {"Baglung", "Gorkha", "Kaski", "Lamjung", "Manang", "Mustang", "Myagdi", "Nawalparasi", "Parbat", "Syangja",
            "Tanahu "};
    String[] state5 = {"Arghakhanchi", "Banke", "Bardiya", "Dang,", "Gulmi", "Kapilvastu", "Nawalparasi", "Palpa", "Pyuthan", "Rolpa",
            "Purbi Rukum", "Rupandehi"};
    String[] state6 = {"Dailekh", "Dolpa", "Humla", "Jajarkot", "Jumla", "Kalikot", "Mugu", "Rukum Paschim", "Salyan", "Surkhet"};
    String[] state7 = {"Achham", "Baitadi", "Bajhang", "Bajura", "Dadeldhura", "Darchula", "Doti", "Kailali", "Kanchanpur"};

    public Register(){
        setLayout(null);


        JLabel formno = new JLabel("Application Form no : "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetail = new JLabel("Page 1 : Personal Detail");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetail.setBounds(290,80,400,30);
        add(personalDetail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTF.setBounds(300,140,400,30);
        add(nameTF);

        JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTF.setBounds(300,190,400,30);
        add(fnameTF);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240,200,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100,290,200,30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100,340,200,30);
        add(email);
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTF.setBounds(300,340,400,30);
        add(emailTF);

        JLabel martial_status = new JLabel("Marital Status:");
        martial_status.setFont(new Font("Raleway", Font.BOLD, 22));
        martial_status.setBounds(100,390,200,30);
        add(martial_status);
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        add(other);
        ButtonGroup marriagegroup = new ButtonGroup();
        marriagegroup.add(married);
        marriagegroup.add(unmarried);
        marriagegroup.add(other);


        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,440,200,30);
        add(state);

        cbstate = new JComboBox();
        cbstate.addItem("Province 1");
        cbstate.addItem("Madesh Pradesh");
        cbstate.addItem("Bagmati Pradesh");
        cbstate.addItem("Gandaki Pradesh");
        cbstate.addItem("Lumbini Pradesh");
        cbstate.addItem("Karnali Pradesh");
        cbstate.addItem("Sudurpaschim Pradesh");

        cbstate.setFont(new Font("Raleway", Font.BOLD, 14));
        cbstate.setBounds(300,440,400,30);
        add(cbstate);
        cbstate.addActionListener(this);

        JLabel city = new JLabel("District:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100,490,200,30);
        add(city);

        cbcity =  new JComboBox();
        cbcity.setBounds(300,490,400,30);
        cbcity.setFont(new Font("Raleway", Font.BOLD, 14));
        cbcity.setEnabled(false);
        add(cbcity);

        JLabel address = new JLabel("City:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100,540,200,30);
        add(address);
        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTF.setBounds(300,540,400,30);
        add(addressTF);


        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        pinTF = new JTextField();
        pinTF.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTF.setBounds(300,590,400,30);
        add(pinTF);

        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        add(next);
        next.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setVisible(true);
        setLocation(230, 50);
    }
    public static void main(String[] args){
        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next){
            String formno = ""+random;
            String name = nameTF.getText();
            String fname = fnameTF.getText();
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String email = emailTF.getText();
            String marital_status = null;
            if(married.isSelected()){
                marital_status = "Married";
            } else if (unmarried.isSelected()) {
                marital_status = "Unmarried";
            } else if (other.isSelected()) {
                marital_status = "Other";
            }
            String address = addressTF.getText();
            String city = cbcity.getSelectedItem().toString();
            String pin = pinTF.getText();
            String state = cbstate.getSelectedItem().toString();
            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is required");
                }else{
                    DBCon c = new DBCon();
                    String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                    c.s.executeUpdate(query);

                    new Register2(first).setVisible(true);
                    setVisible(false);
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }

        }
        if (e.getSource() == cbstate){
            String selectedItem = (String) cbstate.getSelectedItem();
            cbcity.removeAllItems();

            if(selectedItem.equals("Province 1")){
                for(String item:state1){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            } else if (selectedItem.equals("Madesh Pradesh")) {
                for (String item:state2){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            } else if (selectedItem.equals("Bagmati Pradesh")) {
                for(String item:state3){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            } else if (selectedItem.equals("Gandaki Pradesh")) {
                for(String item:state4){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            } else if (selectedItem.equals("Lumbini Pradesh")) {
                for (String item:state5){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            } else if (selectedItem.equals("Karnali Pradesh")) {
                for (String item : state6) {
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            }else if(selectedItem.equals("Sudurpaschim Pradesh")){
                for(String item: state7){
                    cbcity.addItem(item);
                }
                cbcity.setEnabled(true);
            }
        }
    }
}
