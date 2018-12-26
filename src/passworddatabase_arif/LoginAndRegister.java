/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginAndRegister extends javax.swing.JFrame {

    /**
     * Creates new form LoginAndRegister
     */
    private ArrayList<LoginData> loginData;//arraylist of the logindata to get the login information
    CreateLoginPasswordDataFile loginDetails = new CreateLoginPasswordDataFile();//to createa  file that saves permenantly on the device
    String DefaultUsername = "";
    String DefaultPassword = "";
    private PasswordDataBase passwordGUI;

    public LoginAndRegister() {
        initComponents();
        loginData = loginDetails.getLoginDetailList();
        try {
            // TODO add your handling code here:
            passwordGUI = new PasswordDataBase();
        } catch (Exception ex) {
            Logger.getLogger(LoginAndRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginRegisterTab.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginRegisterTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        loginPasswordLabel = new javax.swing.JLabel();
        loginPasswordJPF = new javax.swing.JPasswordField();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JToggleButton();
        loginUsernameLabel = new javax.swing.JLabel();
        loginUsernameTF = new javax.swing.JTextField();
        registerLoginButton = new javax.swing.JButton();
        registerKeyTF = new javax.swing.JTextField();
        registerKeyLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        registerUsernameTF = new javax.swing.JTextField();
        registerPasswordJPF = new javax.swing.JPasswordField();
        registerPasswordLabel = new javax.swing.JLabel();
        registerUsernameLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        loginRegisterTab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginRegisterTabFocusLost(evt);
            }
        });

        loginPasswordLabel.setText("Password");

        loginPasswordJPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordJPFActionPerformed(evt);
            }
        });

        showPasswordCheckBox.setText("Show");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginUsernameLabel.setText("Username");

        registerLoginButton.setText("Register");
        registerLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLoginButtonActionPerformed(evt);
            }
        });

        registerKeyTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerKeyTFActionPerformed(evt);
            }
        });

        registerKeyLabel.setText("Register Key");
        registerKeyLabel.setToolTipText("A combination of words sent by the developer in order to limit access against thievery");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(registerKeyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerKeyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerLoginButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginPasswordLabel)
                            .addComponent(loginUsernameLabel))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loginUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginPasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showPasswordCheckBox)))
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsernameLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginPasswordLabel)
                    .addComponent(loginPasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPasswordCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerLoginButton)
                    .addComponent(registerKeyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerKeyLabel))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        loginRegisterTab.addTab("Login", jPanel2);

        registerPasswordLabel.setText("Password");

        registerUsernameLabel.setText("Username");

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        goBackButton.setText("Go Back");
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(159, 159, 159)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registerPasswordLabel)
                        .addComponent(registerUsernameLabel))
                    .addGap(34, 34, 34)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(registerUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerPasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(goBackButton))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(registerUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(registerUsernameLabel))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(registerPasswordLabel)
                        .addComponent(registerPasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(86, Short.MAX_VALUE)))
        );

        loginRegisterTab.addTab("Register", jPanel1);

        getContentPane().add(loginRegisterTab);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        if (registerUsernameTF.getText().isEmpty()) {//Error handling method for putting an end to error
            JOptionPane.showMessageDialog(this, "your Username is Blank", "Error", JOptionPane.ERROR_MESSAGE);
            registerUsernameTF.requestFocus();
        } else if (String.valueOf(registerPasswordJPF.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "your Passoword is Blank", "Error", JOptionPane.ERROR_MESSAGE);
            registerPasswordJPF.requestFocus();
        } else if (registerUsernameTF.getText().length() < 4) {
            JOptionPane.showMessageDialog(this, "your Username must have more than 4 characters", "Error", JOptionPane.ERROR_MESSAGE);
            registerUsernameTF.requestFocus();
        } else if (String.valueOf(registerPasswordJPF.getPassword()).length() < 4) {
            JOptionPane.showMessageDialog(this, "your Password must have more than 4 characters", "Error", JOptionPane.ERROR_MESSAGE);
            registerPasswordJPF.requestFocus();
        } else if (registerUsernameTF.getText().length() > 16) {
            JOptionPane.showMessageDialog(this, "your Username must be less than 16 characters", "Error", JOptionPane.ERROR_MESSAGE);
            registerUsernameTF.setText("");
            registerUsernameTF.requestFocus();
        } else {
            for (LoginData loginData1 : loginData) {//loop through loginData to see if the username has been taken or not
                if (registerUsernameTF.getText().equals(loginData1.getLoginUsername())) {
                    JOptionPane.showMessageDialog(this, "Your Username is already taken", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }//end loop

            int key = 5;
            String fileName = "LoginDetail.text";
            LoginData loginList = new LoginData();

            loginList.setLoginUsername(registerUsernameTF.getText());
            loginList.setLoginPassword(passwordGUI.passwordEncrypt(String.valueOf(registerPasswordJPF.getPassword()), key));
            loginData.add(loginList);

            ObjectOutputStream output;

            try {//flushing it into the txt file
                output = new ObjectOutputStream(new FileOutputStream(fileName));

                try {
                    for (LoginData data : loginData) {//looping through logindata
                        output.writeObject(data);//write on the file
                        output.flush();//enter it
                    }
                } catch (IOException ex) {//error handling in case of error
                    System.out.println("Error writing to file!!!");
                }
            } catch (IOException ex) {
                Logger.getLogger(CreateLoginPasswordDataFile.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);

            }

            registerUsernameTF.setText("");
            registerPasswordJPF.setText("");
            loginRegisterTab.setSelectedIndex(0);
            loginRegisterTab.setEnabled(false);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        int last = loginData.size() - 1;
        int key = 5;
        if (loginUsernameTF.getText().equals(loginData.get(last).getLoginUsername()) && String.valueOf(loginPasswordJPF.getPassword()).equals(passwordGUI.passwordDecrypt(loginData.get(last).getLoginPassword(), key))) {

            passwordGUI.setVisible(true);
            this.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Either your Password or Username is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLoginButtonActionPerformed
        // TODO add your handling code here:
        String password = "IB Computer Science";
        if (!registerKeyTF.getText().equals(password)) {
            JOptionPane.showMessageDialog(this, "Your registry Key is Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            registerKeyTF.requestFocus();
        } else {
            loginRegisterTab.setEnabled(true);
            loginRegisterTab.setSelectedIndex(1);
        }
    }//GEN-LAST:event_registerLoginButtonActionPerformed

    private void loginRegisterTabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginRegisterTabFocusLost
        // TODO add your handling code here:
        loginRegisterTab.setEnabled(false);
    }//GEN-LAST:event_loginRegisterTabFocusLost

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
        // TODO add your handling code here:
        if (!showPasswordCheckBox.isSelected()) {
            loginPasswordJPF.setEchoChar('*');
        } else {
            loginPasswordJPF.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void loginPasswordJPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordJPFActionPerformed
        // Usability feature allowing the user to just press enter to login rather than going their way clicking the button.
        int key = 5;
        for(LoginData data: loginData){//for each loop for the logindata, where it loops until username is found, and compare it to the password
            if(loginUsernameTF.getText().equals(data.getLoginUsername())){
                if(String.valueOf(loginPasswordJPF.getPassword()).equals(passwordGUI.passwordDecrypt(data.getLoginPassword(), key))){
                    passwordGUI.setVisible(true);
                    this.setEnabled(false);
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(this, "Your Password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Your Username has not been registered", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_loginPasswordJPFActionPerformed

    private void registerKeyTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerKeyTFActionPerformed
        // TODO add your handling code here:
        String password = "IB Computer Science";
        if (!registerKeyTF.getText().equals(password)) {
            JOptionPane.showMessageDialog(this, "Your registry Key is Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            registerKeyTF.requestFocus();
        } else {
            loginRegisterTab.setEnabled(true);
            loginRegisterTab.setSelectedIndex(1);
        }
    }//GEN-LAST:event_registerKeyTFActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        loginRegisterTab.setSelectedIndex(0);
    }//GEN-LAST:event_goBackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAndRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAndRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton goBackButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton loginButton;
    private javax.swing.JPasswordField loginPasswordJPF;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JTabbedPane loginRegisterTab;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField loginUsernameTF;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerKeyLabel;
    private javax.swing.JTextField registerKeyTF;
    private javax.swing.JButton registerLoginButton;
    private javax.swing.JPasswordField registerPasswordJPF;
    private javax.swing.JLabel registerPasswordLabel;
    private javax.swing.JLabel registerUsernameLabel;
    private javax.swing.JTextField registerUsernameTF;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JCheckBox showPasswordCheckBox;
    // End of variables declaration//GEN-END:variables

}