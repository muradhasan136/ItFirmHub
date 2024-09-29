package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Files.FileIO;

public class SignUp extends JFrame implements ActionListener  {
    Font title = new Font("Arial",Font.BOLD,24);
    Font label = new Font("cambria", Font.BOLD, 14);
    Font font14 = new Font("cambria", Font.PLAIN, 14);

    JLabel userLabel, passLabel,confirmPassLabel,emailLabel,titleLabel,loginLabel, userImage;
    JTextField userTextField,userEmailField;
    JPasswordField userPassField,userConfirmPass;
    JButton registerButton,loginButton;

    JFrame previousPage;

    public SignUp() {
        super("Register");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));

        //title
        titleLabel = new JLabel("Member Register");
        titleLabel.setBounds(110, 80, 310, 50);
        titleLabel.setFont(title);
        titleLabel.setBackground(new Color(0,0,0));
        titleLabel.setForeground(Color.BLACK);
        this.add(titleLabel);

        userImage = new JLabel(new ImageIcon("./Images/memberRegisterLogo.png"));
        userImage.setBounds(165, 10, 80, 80);
        this.add(userImage);

        //userName
        userLabel = new JLabel("Username");
        userLabel.setBounds(35, 140, 170, 30);
        userLabel.setBackground(new Color(0,0,0));
        userLabel.setFont(label);
        this.add(userLabel);

        userTextField = new JTextField();
        userTextField.setBounds(170, 140, 190, 30);
        userTextField.setFont(label);
        userTextField.setBackground(new Color(230, 230, 230));
        this.add(userTextField);

        //email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(35, 180, 170, 30);
        emailLabel.setBackground(new Color(0,0,0));
        emailLabel.setFont(label);
        this.add(emailLabel);

        userEmailField = new JTextField();
        userEmailField.setBounds(170, 180, 190, 30);
        userEmailField.setFont(label);
        userEmailField.setBackground(new Color(230, 230, 230));
        this.add(userEmailField);

        //pass
        passLabel = new JLabel("Password");
        passLabel.setBounds(35, 220, 170, 30);
        passLabel.setFont(label);
        passLabel.setBackground(new Color(0,0,0));
        this.add(passLabel);

        userPassField = new JPasswordField();
        userPassField.setBounds(170, 220, 190, 30);
        userPassField.setFont(label);
        userPassField.setBackground(new Color(230, 230, 230));
        userPassField.setEchoChar('*');
        this.add(userPassField);

        //confirmPass
        confirmPassLabel = new JLabel("Confirm Password");
        confirmPassLabel.setBounds(35, 260, 170, 30);
        confirmPassLabel.setFont(label);
        confirmPassLabel.setBackground(new Color(0,0,0));
        this.add(confirmPassLabel);

        userConfirmPass = new JPasswordField();
        userConfirmPass.setBounds(170, 260, 190, 30);
        userConfirmPass.setFont(label);
        userConfirmPass.setBackground(new Color(230, 230, 230));
        userConfirmPass.setEchoChar('*');
        this.add(userConfirmPass);

        //register Button
        registerButton = new JButton("Register");
        registerButton.setBounds(260, 310, 100, 30);
        registerButton.setFont(label);
        registerButton.setBackground(new Color(1, 151, 94));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(this);
        this.add(registerButton);

        //return login
        loginLabel = new JLabel("Already have an account?");
        loginLabel.setBounds(99, 350, 300, 30);
        loginLabel.setFont(font14);
        this.add(loginLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(250,350,60,30);
        loginButton.setFont(new Font("cambria",Font.BOLD,14));
        loginButton.setBorder(null);
        loginButton.setForeground(Color.BLUE);
        loginButton.setBackground(new Color(255, 255, 255));
        this.add(loginButton);
        loginButton.addActionListener(this);

    setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton) {
            System.out.println("Register Button clicked");
            String username = userTextField.getText();
            String email = userEmailField.getText();
            String password = String.valueOf(userPassField.getPassword());
            String confirmPassword = new String(userConfirmPass.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Provide All Information", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(FileIO.cheakUserByName(username)){
                JOptionPane.showMessageDialog(this,"Username Already Exists","Error",JOptionPane.ERROR_MESSAGE);
            }
            else if(username.equals(email)){
                JOptionPane.showMessageDialog(this,"Username and email can not be same","Error",JOptionPane.ERROR_MESSAGE);
            }
            else if(!email.endsWith("@gmail.com")){
                JOptionPane.showMessageDialog(this,"Invalid Email", "Error",JOptionPane.ERROR_MESSAGE);
            }
            else if (!password.equals(confirmPassword) ) {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(password.length()<=3){
                JOptionPane.showMessageDialog(this, "Password is too short", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {

                FileIO.writeUserInFile(username,email,password);
                int respone =  JOptionPane.showConfirmDialog(this, "Registration Successful! Do you want to login now?", "Success", JOptionPane.YES_NO_OPTION);
                if(respone == JOptionPane.YES_OPTION) {
                    previousPage.setVisible(true);
                    this.dispose();
                }
            }
        }

        else if(e.getSource() == loginButton){
            System.out.println("LogInButton Clicked");
            if(previousPage != null) {
                previousPage.setVisible(true);
                this.dispose();
            }
        }
    }

}
