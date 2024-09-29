package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Vector;

import Entity.ItFirm;
import EntityList.ItFirmList;
import Files.FileIO;


public class ItFirmManagement extends JFrame implements ActionListener {
    Font titleFont = new Font("RockWell",Font.BOLD,30);
    Font labelFont = new Font("Cambria",Font.BOLD,15);
    Font buttonFont = new Font("Cambria", Font.BOLD,15);

    JTextField idTextField, nameTextField, ceoTextField, projectDoneTextField, employeeNumberTextField, vacancyTextField, rankingTextField, addressTextField, contactNumberTextField, emailAddressTextField;
    JTextField searchTextField;
    JTextArea displayArea;
    JButton addButton, updateButton, removeButton, searchButton, showAllButton, clearScreenButton,logOutButton;
    JComboBox<String> itFirmTypeBox;
    JComboBox<Integer> establishedYearBox;
    ItFirmList itFirmList = new ItFirmList();
    public JFrame previousPage;


    public ItFirmManagement(){
        super("It Firm Hub ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200,700);
        this.setLocationRelativeTo(null); //for center of windows
        //this.setResizable(false);
        this.getContentPane().setBackground(new Color(227, 237, 247));
        this.setLayout(null);

        //load data from file
        FileIO.loadItFirmFromFile(itFirmList);

        //title
        JLabel titleLabel = new JLabel("ItFirm Hub Management");
        titleLabel.setBounds(330,15,600,50);
        titleLabel.setFont(titleFont);
        this.add(titleLabel);

        //sub title

        //ItFirm Entry Form
        int top = 80;
        int gap = 40;

        //Id
        JLabel firmIdLabel = new JLabel("Firm ID");
        firmIdLabel.setBounds(50,top,200,30);
        firmIdLabel.setFont(labelFont);
        this.add(firmIdLabel);

        idTextField = new JTextField();
        idTextField.setBounds(200,top,200,30);
        idTextField.setFont(labelFont);
        idTextField.setBackground(new Color(230, 230, 230));
        this.add(idTextField);

        //Name
        JLabel firmNameLabel = new JLabel("Firm Name");
        firmNameLabel.setBounds(50, top+=gap, 200,30);
        firmNameLabel.setFont(labelFont);
        this.add(firmNameLabel);

         nameTextField = new JTextField();
         nameTextField.setBounds(200, top, 200,30);
         nameTextField.setFont(labelFont);
         nameTextField.setBackground(new Color(230, 230, 230));
         this.add(nameTextField);

         //CEO name
        JLabel ceoNameLabel = new JLabel("CEO Name");
        ceoNameLabel.setBounds(50,top+=gap,200,30);
        ceoNameLabel.setFont(labelFont);
        this.add(ceoNameLabel);

        ceoTextField  = new JTextField();
        ceoTextField.setBounds(200,top,200,30);
        ceoTextField.setFont(labelFont);
        ceoTextField.setBackground(new Color(230, 230, 230));
        this.add(ceoTextField);

        //Established year,, need to change date to year
        JLabel establishedYearLabel = new JLabel("Established Year");
        establishedYearLabel.setBounds(50,top+=gap, 200,30);
        establishedYearLabel.setFont(labelFont);
        this.add(establishedYearLabel);

        /*establishedYearTextField = new JTextField();
        establishedYearTextField.setBounds(200,top,200,30);
        establishedYearTextField.setFont(labelFont);
        this.add(establishedYearTextField);*/
        establishedYearBox = new JComboBox<>();
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        Vector<Integer> v = new Vector<>();
        for(int i = year; i>=1980; i--){
            v.add(i);
        }
        establishedYearBox.setModel(new DefaultComboBoxModel<>(v));
        establishedYearBox.setSelectedIndex(-1);
        establishedYearBox.setBounds(200,top,200,30);
        establishedYearBox.setFont(labelFont);
        establishedYearBox.setBackground(new Color(230, 230, 230));
        this.add(establishedYearBox);

        //Projects
        JLabel projectDoneLabel = new JLabel("Projects");
        projectDoneLabel.setBounds(50, top+=gap,200,30);
        projectDoneLabel.setFont(labelFont);
        this.add(projectDoneLabel);

        projectDoneTextField = new JTextField();
        projectDoneTextField.setBounds(200,top, 200,30);
        projectDoneTextField.setFont(labelFont);
        projectDoneTextField.setBackground(new Color(230, 230, 230));
        this.add(projectDoneTextField);

        //Employee Number
        JLabel employeeNumberLabel = new JLabel("Employees");
        employeeNumberLabel.setBounds(50, top+=gap, 200,30);
        employeeNumberLabel.setFont(labelFont);
        this.add(employeeNumberLabel);

        employeeNumberTextField = new JTextField();
        employeeNumberTextField.setBounds(200, top, 200,30);
        employeeNumberTextField.setFont(labelFont);
        employeeNumberTextField.setBackground(new Color(230, 230, 230));
        this.add(employeeNumberTextField);

        //Vacancy
        JLabel vacancyLabel = new JLabel("Vacancy");
        vacancyLabel.setBounds(50, top+=gap, 200,30);
        vacancyLabel.setFont(labelFont);
        this.add(vacancyLabel);

        vacancyTextField = new JTextField();
        vacancyTextField.setBounds(200,top,200,30);
        vacancyTextField.setFont(labelFont);
        vacancyTextField.setBackground(new Color(230, 230, 230));
        this.add(vacancyTextField);

        //FirmType
        JLabel firmTypeLabel = new JLabel("Firm Type");
        firmTypeLabel.setBounds(50, top+=gap,200,30);
        firmTypeLabel.setFont(labelFont);
        this.add(firmTypeLabel);

        /*firmTypeTextField =new JTextField();
        firmTypeTextField.setBounds(200, top, 200, 30);
        firmTypeTextField.setFont(labelFont);
        this.add(firmTypeTextField);*/
        itFirmTypeBox = new JComboBox<>(new String[]{"Full-Service IT Solutions","Software  Development","Cloud Management","Web Development","Mobile App Development","Cyber Security","AI and Mechine Learning"});
        itFirmTypeBox.setBounds(200,top,200,30);
        itFirmTypeBox.setFont(new Font("Cambria",Font.BOLD,14));
        itFirmTypeBox.setSelectedIndex(-1);
        itFirmTypeBox.setBackground(new Color(230, 230, 230));
        this.add(itFirmTypeBox);

        //Ranking
        JLabel rankingLabel = new JLabel("Ranking");
        rankingLabel.setBounds(50,top+=gap,200,30);
        rankingLabel.setFont(labelFont);
        this.add(rankingLabel);

        rankingTextField = new JTextField();
        rankingTextField.setBounds(200,top,200,30);
        rankingTextField.setFont(labelFont);
        rankingTextField.setBackground(new Color(230, 230, 230));
        this.add(rankingTextField);

        //Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50,top+=gap,200,30);
        addressLabel.setFont(labelFont);
        this.add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setBounds(200,top,200,30);
        addressTextField.setFont(labelFont);
        addressTextField.setBackground(new Color(230, 230, 230));
        this.add(addressTextField);

        //Contact Number
        JLabel contactNumberLabel= new JLabel("Contact Number");
        contactNumberLabel.setBounds(50,top+=gap,200,30);
        contactNumberLabel.setFont(labelFont);
        this.add(contactNumberLabel);

        contactNumberTextField = new JTextField();
        contactNumberTextField.setBounds(200,top,200,30);
        contactNumberTextField.setFont(labelFont);
        contactNumberTextField.setBackground(new Color(230, 230, 230));
        this.add(contactNumberTextField);

        //Email Address
        JLabel emailAddressLabel = new JLabel("Email Address");
        emailAddressLabel.setBounds(50,top+=gap,200,30);
        emailAddressLabel.setFont(labelFont);
        this.add(emailAddressLabel);

        emailAddressTextField =new JTextField();
        emailAddressTextField.setBounds(200,top,200,30);
        emailAddressTextField.setFont(labelFont);
        emailAddressTextField.setBackground(new Color(230, 230, 230));
        this.add(emailAddressTextField);

        //ItFirm Entry Buttons
        addButton = new JButton("Add Firm");
        addButton.setBounds(50, top+=gap+20,130,30);
        addButton.setBackground(new Color(25, 118, 210));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(buttonFont);
        this.add(addButton);
        addButton.addActionListener(this);

        updateButton = new JButton("Update Firm");
        updateButton.setBounds(200, top,130,30);
        updateButton.setFont(buttonFont);
        updateButton.setBackground(new Color(255, 165, 0));
        this.add(updateButton);
        updateButton.addActionListener(this);

        removeButton = new JButton("Remove Firm");
        removeButton.setBounds(350,top,130,30);
        removeButton.setFont(buttonFont);
        removeButton.setBackground(new Color(220, 53, 69));
        removeButton.setForeground(Color.WHITE);
        this.add(removeButton);
        removeButton.addActionListener(this);

        //Disply Area
        displayArea = new JTextArea();
        displayArea.setBounds(450,80,700,469);
        displayArea.setFont(new Font("Segoe UI",Font.PLAIN,15));
        displayArea.setBackground(new Color(245, 245, 245));
        displayArea.setForeground(Color.BLACK);
        displayArea.setCaretPosition(0);
        displayArea.setEditable(false); //No one can write or edit in Disply Area
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(450,80,700,469);
        this.add(scrollPane);
        reloadData();

        //Search
        JLabel searchLabel = new JLabel("Search By:");
        searchLabel.setBounds(765,40,110,30);
        searchLabel.setFont(labelFont);
        this.add(searchLabel);

        searchTextField = new JTextField();
        searchTextField.setBounds(850, 40, 165 , 30);
        searchTextField.setFont(labelFont);
        searchTextField.setBackground(new Color(230, 230, 230));
        this.add(searchTextField);

        searchButton = new JButton("Search");
        searchButton.setBounds(1030,40,120,30);
        searchButton.setFont(buttonFont);
        searchButton.setBackground(new Color(54, 185, 64));
        searchButton.setForeground(Color.WHITE);
        this.add(searchButton);
        searchButton.addActionListener(this);

        //Show All
        showAllButton = new JButton("Show All Firms");
        showAllButton.setBounds(600,top,160,30);
        showAllButton.setFont(buttonFont);
        this.add(showAllButton);
        showAllButton.addActionListener(this);

        //Clear Screen
        clearScreenButton=new JButton("Clear Screen");
        clearScreenButton.setBounds(780,top,160,30);
        clearScreenButton.setFont(buttonFont);
        this.add(clearScreenButton);
        clearScreenButton.addActionListener(this);

        //delete
        logOutButton = new JButton("LogOut");
        logOutButton.setBounds(1030,620,120,30);
        logOutButton.setFont(buttonFont);
        logOutButton.setBackground(Color.RED);
        logOutButton.setForeground(Color.WHITE);
        this.add(logOutButton);
        logOutButton.addActionListener(this);

        //visiblity
        this.setVisible(true);
    }

    //
    public void actionPerformed(ActionEvent e) {
        if (addButton == e.getSource()) {
            System.out.println("ADD CLICKED"); //for cheak perpose
            try {
                int id = Integer.parseInt(idTextField.getText());
                ItFirm firm = itFirmList.getById(idTextField.getText());
                if (firm == null) {
                    if (!idTextField.getText().isEmpty() &&
                            !nameTextField.getText().isEmpty() &&
                            !ceoTextField.getText().isEmpty() &&
                            establishedYearBox.getSelectedItem() != null &&
                            !projectDoneTextField.getText().isEmpty() &&
                            !employeeNumberTextField.getText().isEmpty() &&
                            !vacancyTextField.getText().isEmpty() &&
                            itFirmTypeBox.getSelectedItem() != null &&
                            !rankingTextField.getText().isEmpty() &&
                            !addressTextField.getText().isEmpty() &&
                            !contactNumberTextField.getText().isEmpty() &&
                            !emailAddressTextField.getText().isEmpty() &&
                            emailAddressTextField.getText().endsWith(".com")) {
                        try {
                            ItFirm tempFirm = new ItFirm(idTextField.getText(), nameTextField.getText(), ceoTextField.getText(), establishedYearBox.getSelectedItem().toString(), Integer.parseInt(projectDoneTextField.getText()), Short.parseShort(employeeNumberTextField.getText()), Integer.parseInt(vacancyTextField.getText()), itFirmTypeBox.getSelectedItem().toString(), rankingTextField.getText(), addressTextField.getText(), contactNumberTextField.getText(), emailAddressTextField.getText());
                            itFirmList.insert(tempFirm);
                            //file I/O
                            FileIO.writeItFirmInFile(tempFirm);
                            JOptionPane.showMessageDialog(this, "Firm Added");
                            reloadData();
                            displayArea.setCaretPosition(0);
                        } catch (NumberFormatException NFE) {
                            JOptionPane.showMessageDialog(this, "Invalid Input Format");
                        }
                    } else {
                        if (!emailAddressTextField.getText().isEmpty() && !emailAddressTextField.getText().endsWith(".com")) {
                            JOptionPane.showMessageDialog(this, "Invalid email address", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Please Provide All Information");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ItFirm ID Already Used");
                }
            }
            catch (NumberFormatException nFE){
                JOptionPane.showMessageDialog(this,"ID must be an integer");
            }
        }
        
        else if (updateButton == e.getSource()) {
            System.out.println("UPDATE CLICKED");

            String itFirmId = idTextField.getText();
            if(itFirmList.getById(itFirmId) == null ){
                JOptionPane.showMessageDialog(this,"No Firm Found");
                return;
            }
            String itFirmName = nameTextField.getText();
            String ceoName = ceoTextField.getText();
            String establishedYear = null;
            if(establishedYearBox.getSelectedIndex() != -1 && establishedYearBox.getSelectedItem() != null){
                establishedYear = establishedYearBox.getSelectedItem().toString();
            }
            int numberOfProjectDone=0;
            short totalEmployeeNumber=0;
            int vacancy=0;
            try {
                if (!projectDoneTextField.getText().isEmpty()) {
                    numberOfProjectDone = Integer.parseInt(projectDoneTextField.getText());
                }
                if (!employeeNumberTextField.getText().isEmpty()) {
                    totalEmployeeNumber = Short.parseShort(employeeNumberTextField.getText());
                }
                if (!vacancyTextField.getText().isEmpty()) {
                    vacancy = Integer.parseInt(vacancyTextField.getText());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Number Format");
                return;
            }
            String firmType = null;
            if(itFirmTypeBox.getSelectedIndex() != -1 && itFirmTypeBox.getSelectedItem() !=null){
                firmType = itFirmTypeBox.getSelectedItem().toString();
            }
            String ranking = rankingTextField.getText();
            String contactNumber = contactNumberTextField.getText();
            String  emailAddress = "";
            if(!emailAddressTextField.getText().isEmpty()) {
                if (emailAddressTextField.getText().endsWith(".com")) {
                    emailAddress = emailAddressTextField.getText();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Email Address", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String address = addressTextField.getText();
            itFirmList.updateFirm(itFirmId,itFirmName,ceoName,establishedYear,numberOfProjectDone,totalEmployeeNumber,vacancy,firmType,ranking,address,contactNumber,emailAddress);
            FileIO.reWriteItFirmInFile(itFirmList);
            reloadData();
            displayArea.setCaretPosition(0);

            JOptionPane.showMessageDialog(this, "Firm Updated");
        }

        else if(searchButton == e.getSource()){
            System.out.println("SEARCH CLICKED");
            String searchInput = searchTextField.getText();
            ItFirm firm;
         try{
             int firmId = Integer.parseInt(searchInput);
             firm = itFirmList.getById(String.valueOf(firmId));
        }
         catch(NumberFormatException nFE){
             firm = itFirmList.getByName(searchInput);
         }
         if(firm != null){
             displayArea.setText(firm.getItFirmAsString());
         }
         else{
             JOptionPane.showMessageDialog(this,"No ItFirm Found");
         }
         // Need to add radio button to choose the user search by id or name (last step)
        }

        else if(removeButton == e.getSource()){
            System.out.println("REMOVE CLICKED");
            ItFirm firm = itFirmList.getById(idTextField.getText());
            if(firm != null){
                itFirmList.removeById(idTextField.getText());
                JOptionPane.showMessageDialog(this,"Removed Successfully");
                FileIO.removeItFirmFromFile(itFirmList,idTextField.getText());
                reloadData();
                displayArea.setCaretPosition(0);
            }
            else{
                JOptionPane.showMessageDialog(this,"No ItFirm Found");
            }
        }

        else if(showAllButton == e.getSource()){
            System.out.println("SHOW ALL CLICKED");
            FileIO.reWriteItFirmInFile(itFirmList);
            reloadData();
            displayArea.setCaretPosition(0);
        }

        else if(clearScreenButton == e.getSource()){
            System.out.println("CLEAR SCREEN CLICKED");
            idTextField.setText("");
            nameTextField.setText("");
            ceoTextField.setText("");
            establishedYearBox.setSelectedIndex(-1);
            projectDoneTextField.setText("");
            employeeNumberTextField.setText("");
            vacancyTextField.setText("");
            itFirmTypeBox.setSelectedIndex(-1);
            rankingTextField.setText("");
            addressTextField.setText("");
            contactNumberTextField.setText("");
            emailAddressTextField.setText("");
            displayArea.setText("");
            JOptionPane.showMessageDialog(this,"Cleared Successfully");
        }

        else if(logOutButton == e.getSource()){
            System.out.println("LogOut Button CLICKED");
            int response = JOptionPane.showConfirmDialog(this, "Do you really want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if(response == JOptionPane.YES_OPTION){
            previousPage.setVisible(true);
            this.dispose();
            }
        }
    }

    //Reload
    public void reloadData(){
        displayArea.setText(itFirmList.getAllItFirmAsString());
    }




}



