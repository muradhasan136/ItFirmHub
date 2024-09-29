package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import GUI.ItFirmManagement; //same package, so no need to import it
import Files.FileIO;
import java.util.prefs.Preferences;

public class LoginPage extends JFrame implements ActionListener{
    Font label = new Font("cambria",Font.BOLD,15);
    Font font14 = new Font("cambria",Font.PLAIN,14);

    JLabel userLabel, passLabel,titleLabel,registerLabel,subTitleLabel;
    JTextField userTextField;
    JPasswordField userPassField;
    JButton loginButton, signUpButton;
    JCheckBox rememberMeCheckBox;

    //ItFirmList itFirmList;
    Preferences prefs = Preferences.userNodeForPackage(LoginPage.class);

    public LoginPage() {
        super("It Firm Hub");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 450);
        //this.setLocation(200, 100);
        this.setLocationRelativeTo(null); //for center
        this.setLayout(null);
        this.setResizable(false);

        //background color
        this.getContentPane().setBackground(new Color(255, 255, 255));

        /*user icon image
        userImage = new JLabel(new ImageIcon("./Images/user1.jpg"));
        userImage.setBounds(190,0,50,50);
        this.add(userImage); */

        //Welcome
        titleLabel = new JLabel("LoginSphere");
        titleLabel.setBounds(130,25,200,30);
        titleLabel.setForeground(new Color(0,0,0));
        titleLabel.setFont(new Font("Arial",Font.BOLD,25));
        this.add(titleLabel);

        subTitleLabel = new JLabel("Control And Explore");
        subTitleLabel.setBounds(210,55,200,30);
        subTitleLabel.setForeground(new Color(0,0,0));
        subTitleLabel.setFont(new Font("Cambria",Font.ITALIC,14));
        this.add(subTitleLabel);

        //user name
        userLabel = new JLabel("Username");
        userLabel.setBounds(60, 80, 200, 30);
        userLabel.setForeground(new Color(0, 0, 0));
        userLabel.setFont(label);
        this.add(userLabel);

        userTextField = new JTextField();
        userTextField.setBounds(60, 120, 280, 30);
        userTextField.setBackground(new Color(230, 230, 230));
        userTextField.setFont(label);
        this.add(userTextField);

        //password
        passLabel = new JLabel("Password");
        passLabel.setBounds(60, 160, 200, 30);
        passLabel.setForeground(new Color(0, 0, 0));
        passLabel.setFont(label);
        this.add(passLabel);

        userPassField = new JPasswordField();
        userPassField.setBounds(60, 200, 280, 30);
        userPassField.setBackground(new Color(230, 230, 230));
        userPassField.setFont(label);
        userPassField.setEchoChar('*');
        this.add(userPassField);

        // Remember Me checkbox
        rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setBounds(60, 240, 200, 30);
        rememberMeCheckBox.setFont(font14);
        rememberMeCheckBox.setBackground(new Color(255, 255, 255));
        this.add(rememberMeCheckBox);

        String storeUserName = prefs.get("username","");
        String storePassword = prefs.get("password", "");
        if(!storeUserName.isEmpty() &&!storePassword.isEmpty()) {
            userTextField.setText(storeUserName);
            userPassField.setText(storePassword);
        }

        //login button
        loginButton = new JButton("Login");
        loginButton.setBounds(250, 280, 90, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(39, 174, 96));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        this.add(loginButton);

        //register Button
        /*registerButton = new JButton("Register");
        registerButton.setBounds(60, 290, 200, 30);
        registerButton.setFont(label);
        registerButton.setBackground(new Color(144,238,144));
        registerButton.setForeground(Color.BLACK);
        registerButton.addActionListener(this);
        this.add(registerButton);*/
        registerLabel = new JLabel("Don't have a account?");
        registerLabel.setBounds(100,340,150,30);
        registerLabel.setFont(font14);
        this.add(registerLabel);

        signUpButton = new JButton("SignUp");
        signUpButton.setBounds(240,340,50,30);
        signUpButton.setFont(new Font("cambria",Font.BOLD,14));
        signUpButton.setBorder(null);
        signUpButton.setBackground(new Color(255, 255, 255));
        signUpButton.setForeground(Color.BLUE);
        this.add(signUpButton);
        signUpButton.addActionListener(this);

        this.setVisible(true);
    }

        //click events
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == loginButton) {

                String userName = userTextField.getText();
                String userPass = String.valueOf(userPassField.getPassword());

                if (FileIO.cheakUserByNameAndPass(userName,userPass)) {
                    JOptionPane.showMessageDialog(this, "Welcome " + userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase());
                    if(rememberMeCheckBox.isSelected()){
                        prefs.put("username",userName);
                        prefs.put("password",userPass);
                    }
                    else{
                        prefs.remove("username");
                        prefs.remove("password");
                    }

                    ItFirmManagement  itFirmManagement = new ItFirmManagement();
                    itFirmManagement.displayArea.setCaretPosition(0);
                    itFirmManagement.previousPage = this;
                    this.setVisible(false);
                    userTextField.setText("");
                    userPassField.setText("");
                    this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Wrong User Name or Password","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == signUpButton) {
                System.out.println("SignUp Button Clicked");
                int response =JOptionPane.showConfirmDialog(this, "Do you want to Register?", "New User", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(response == JOptionPane.YES_OPTION) {
                    SignUp signUp = new SignUp();
                    signUp.previousPage = this;
                    this.setVisible(false);
                    this.dispose();
                    userTextField.setText("");
                    userPassField.setText("");
                }
            }
        }

    }
