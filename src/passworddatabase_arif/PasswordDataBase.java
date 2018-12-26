/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author 19175
 */
public class PasswordDataBase extends javax.swing.JFrame {

    private ArrayList<PasswordData> theList;
    private ArrayList<wordData> wordList;
    private ArrayList wordArray = new ArrayList();
    private ArrayList savedWordArray = new ArrayList();
    private ArrayList savedCustomWordArray = new ArrayList();
    private ArrayList blackListSavedArray = new ArrayList();
    private ArrayList whiteListArrayList = new ArrayList();
    private ArrayList savedAdvancedSetting = new ArrayList();
    private ArrayList customWordArray = new ArrayList();
    private List<String> tempArray = new ArrayList();

    private List<String> whiteList;
    private List<String> blackList;
    private int counter = 0;
    private String DefaultUsername = "Array";
    private String DefaultPassword = "Arr";
    private String passwordWordCombined = "";
    thePassword passwordFileData = new thePassword();
    createFileOfWords wordFileData = new createFileOfWords();
    saveWord saveWordFileData = new saveWord();
    private final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private final String numbers = "0123456789";
    private final String symbols = "!@#$%^&*_=+-/.?<>)";
    int length = 0;
    char[] password4 = new char[length];
    char[] password5 = new char[length];
    private String passwordCreated = "";
    private String passwordSaved = "";
    private String wordPasswordCreated = "";
    static char[] chars = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
        '#', '$', '%', '^', '&', '(', ')', '+',
        '-', '*', '/', '[', ']', '{', '}', '=',
        '<', '>', '?', '_', '"', '.', ',', ' '
    };

    SecureRandom rand = new SecureRandom();
    Random random = new Random();
    private boolean upperCaseCheckBoxSelected = false;
    private boolean lowerCaseCheckBoxSelected = false;
    private boolean symbolsCheckBoxSelected = false;
    private boolean numbersCheckBoxSelected = false;
    private boolean customWordsCheckBoxSelected = false;
    private boolean wordsCheckBoxSelected = false;

    /**
     * Creates new form PasswordDataBase
     */
    public PasswordDataBase() throws Exception {

        initComponents();

        theList = passwordFileData.getPasswordList();
        wordList = wordFileData.getWordList();
        saveUsernameTF.requestFocus();
        displayTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Username", "Email", "Password", "Website", "Association", "Tag", "Tag", "Tag"
                }
        ));
        for (wordData wordD : wordList) {//for each array putting every word that is native to the program rather than the custom added one into an array
            if (wordD.getCustomWords() == false) {
                wordArray.add(wordD.getWords());
            }
        }

        //gui settings that aren't enabled until user does certain actions to enable them.
        symbolsCheckBox.setEnabled(false);
        numberCheckBox.setEnabled(false);
        lowerCaseLettersCheckBox.setEnabled(false);
        upperCaseLettersCheckBox.setEnabled(false);
        simpleApplyButton.setEnabled(false);
        enableAdvancedSettingsCheckBox.setEnabled(false);
        simpleGeneratePasswordButton.setEnabled(false);
        simpleGeneratePasswordTF.setEnabled(false);
        simpleSaveAndQuitButton.setEnabled(false);
        editNumberOfCharactersButton.setEnabled(false);
        //advanced settings disabled at first
        startWithAlphabetCharacterCheckBox.setEnabled(false);
        startWithNumberCheckBox.setEnabled(false);
        noSameLettersCheckBox.setEnabled(false);
        noSameWordCheckBox.setEnabled(false);
        blackListRadioButton.setEnabled(false);
        whiteListRadioButton.setEnabled(false);
        whiteBlackWordTF.setEnabled(false);
        addCustomButton.setEnabled(false);
        advancedApplyButton.setEnabled(false);
        advancedGeneratePasswordButton.setEnabled(false);
        advancedGeneratePasswordTF.setEnabled(false);
        advancedSaveAndQuitButton.setEnabled(false);
        customWordsQuantityTF.setEnabled(false);
        wordsQuantityTF.setEnabled(false);
        generateWordPasswordButton.setEnabled(false);
        generateWordPasswordTF.setEnabled(false);
        wordSaveAndQuitButton.setEnabled(false);
        applyWordSettingButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        whiteBlackListGroup = new javax.swing.ButtonGroup();
        Tab = new javax.swing.JTabbedPane();
        savePasswordTab = new javax.swing.JPanel();
        saveUsernameLabel = new javax.swing.JLabel();
        saveUsernameTF = new javax.swing.JTextField();
        saveEmailLabel = new javax.swing.JLabel();
        savePasswordLabel = new javax.swing.JLabel();
        saveEmailTF = new javax.swing.JTextField();
        saveUserPasswordButton = new javax.swing.JButton();
        saveWebsiteLabel = new javax.swing.JLabel();
        saveWebsiteTF = new javax.swing.JTextField();
        saveTagsLabel = new javax.swing.JLabel();
        saveTag3TF = new javax.swing.JTextField();
        saveAssociationLabel = new javax.swing.JLabel();
        saveAssociationTF = new javax.swing.JTextField();
        saveGeneratePasswordButton = new javax.swing.JButton();
        savePasswordJPF = new javax.swing.JPasswordField();
        saveTag2TF = new javax.swing.JTextField();
        saveTag1TF = new javax.swing.JTextField();
        showSaveCheckBox = new javax.swing.JCheckBox();
        searchPasswordTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        searchWebsiteNameLabel = new javax.swing.JLabel();
        searchWebsiteNameTF = new javax.swing.JTextField();
        searchTagsLabel = new javax.swing.JLabel();
        searchTag2TF = new javax.swing.JTextField();
        searchAssociationNameLabel = new javax.swing.JLabel();
        searchAssociationNameTF = new javax.swing.JTextField();
        searchTag3TF = new javax.swing.JTextField();
        searchTag1TF = new javax.swing.JTextField();
        searchDisplayTable = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        generatePasswordTab = new javax.swing.JPanel();
        addCustomButton = new javax.swing.JButton();
        advancedGeneratePasswordTF = new javax.swing.JTextField();
        advancedSaveAndQuitButton = new javax.swing.JButton();
        advancedGeneratePasswordButton = new javax.swing.JButton();
        wordsQuantityTF = new javax.swing.JTextField();
        howManyWordsLabel = new javax.swing.JLabel();
        blackListRadioButton = new javax.swing.JRadioButton();
        whiteListRadioButton = new javax.swing.JRadioButton();
        startWithAlphabetCharacterCheckBox = new javax.swing.JCheckBox();
        startWithNumberCheckBox = new javax.swing.JCheckBox();
        lowerCaseLettersCheckBox = new javax.swing.JCheckBox();
        numberCheckBox = new javax.swing.JCheckBox();
        upperCaseLettersCheckBox = new javax.swing.JCheckBox();
        noSameLettersCheckBox = new javax.swing.JCheckBox();
        noSameWordCheckBox = new javax.swing.JCheckBox();
        customWordsOnlyCheckBox = new javax.swing.JCheckBox();
        wordsOnlyCheckBox = new javax.swing.JCheckBox();
        numberOfCharactersLabel = new javax.swing.JLabel();
        whiteBlackWordTF = new javax.swing.JTextField();
        simpleSettingsLabel = new javax.swing.JLabel();
        advancedWordSettingsLabel = new javax.swing.JLabel();
        simpleApplyButton = new javax.swing.JToggleButton();
        advancedApplyButton = new javax.swing.JButton();
        simpleGeneratePasswordButton = new javax.swing.JButton();
        simpleGeneratePasswordTF = new javax.swing.JTextField();
        symbolsCheckBox = new javax.swing.JCheckBox();
        numberOfCharactersTF = new javax.swing.JTextField();
        simpleSaveAndQuitButton = new javax.swing.JToggleButton();
        setNumberOfCharactersButton = new javax.swing.JButton();
        editNumberOfCharactersButton = new javax.swing.JButton();
        howManyWordsLabel1 = new javax.swing.JLabel();
        customWordsQuantityTF = new javax.swing.JTextField();
        advancedCustomSettingsLabel = new javax.swing.JLabel();
        whiteBlackButton = new javax.swing.JButton();
        applyWordSettingButton = new javax.swing.JButton();
        generateWordPasswordButton = new javax.swing.JButton();
        generateWordPasswordTF = new javax.swing.JTextField();
        enableAdvancedSettingsCheckBox = new javax.swing.JCheckBox();
        wordSaveAndQuitButton = new javax.swing.JButton();
        whiteBlackListHelpLabel = new javax.swing.JLabel();
        addWordTab = new javax.swing.JPanel();
        listWordsButton = new javax.swing.JButton();
        wordFieldTF = new javax.swing.JTextField();
        submitAddButton = new javax.swing.JButton();
        addWordLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        saveUsernameLabel.setText("Username");
        saveUsernameLabel.setToolTipText("Key login information when storing password");

        saveUsernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUsernameTFActionPerformed(evt);
            }
        });

        saveEmailLabel.setText("Email*");
        saveEmailLabel.setToolTipText("An Essential Component in the creation of the Password Identity");

        savePasswordLabel.setText("Password*");
        savePasswordLabel.setToolTipText("Main component required in order to create a Password Identity");

        saveEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmailTFActionPerformed(evt);
            }
        });

        saveUserPasswordButton.setText("Save");
        saveUserPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUserPasswordButtonActionPerformed(evt);
            }
        });

        saveWebsiteLabel.setText("Website");
        saveWebsiteLabel.setToolTipText("Website you use this password identity in");

        saveWebsiteTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveWebsiteTFActionPerformed(evt);
            }
        });

        saveTagsLabel.setText("Tags*");
        saveTagsLabel.setToolTipText("Tags are separated in three different store function, each with their own unique identity");

        saveTag3TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTag3TFActionPerformed(evt);
            }
        });

        saveAssociationLabel.setText("Association");
        saveAssociationLabel.setToolTipText("What is the password identity's company or its title");

        saveAssociationTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAssociationTFActionPerformed(evt);
            }
        });

        saveGeneratePasswordButton.setText("Generate");
        saveGeneratePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGeneratePasswordButtonActionPerformed(evt);
            }
        });

        savePasswordJPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePasswordJPFActionPerformed(evt);
            }
        });

        saveTag2TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTag2TFActionPerformed(evt);
            }
        });

        saveTag1TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTag1TFActionPerformed(evt);
            }
        });

        showSaveCheckBox.setText("Show");
        showSaveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSaveCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout savePasswordTabLayout = new javax.swing.GroupLayout(savePasswordTab);
        savePasswordTab.setLayout(savePasswordTabLayout);
        savePasswordTabLayout.setHorizontalGroup(
            savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePasswordTabLayout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(savePasswordTabLayout.createSequentialGroup()
                        .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveTagsLabel)
                            .addComponent(saveAssociationLabel)
                            .addComponent(saveWebsiteLabel)
                            .addComponent(savePasswordLabel)
                            .addComponent(saveEmailLabel)
                            .addComponent(saveUsernameLabel))
                        .addGap(123, 123, 123)
                        .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveAssociationTF, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(saveWebsiteTF, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(saveEmailTF, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(saveUsernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(savePasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, savePasswordTabLayout.createSequentialGroup()
                                .addComponent(saveTag1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(saveTag2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveTag3TF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(saveUserPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveGeneratePasswordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showSaveCheckBox)
                .addContainerGap(960, Short.MAX_VALUE))
        );

        savePasswordTabLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {saveAssociationTF, saveEmailTF, saveUsernameTF, saveWebsiteTF});

        savePasswordTabLayout.setVerticalGroup(
            savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePasswordTabLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(savePasswordTabLayout.createSequentialGroup()
                        .addComponent(saveUsernameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(saveEmailLabel)
                        .addGap(18, 18, 18)
                        .addComponent(savePasswordLabel)
                        .addGap(21, 21, 21)
                        .addComponent(saveWebsiteLabel)
                        .addGap(18, 18, 18)
                        .addComponent(saveAssociationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveTagsLabel))
                    .addGroup(savePasswordTabLayout.createSequentialGroup()
                        .addComponent(saveUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveGeneratePasswordButton)
                            .addComponent(savePasswordJPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showSaveCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveWebsiteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAssociationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(savePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveTag3TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveTag2TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveTag1TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(saveUserPasswordButton)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        savePasswordTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {saveAssociationTF, saveEmailTF, saveTag3TF, saveUsernameTF, saveWebsiteTF});

        Tab.addTab("Save Password", savePasswordTab);

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(displayTable);

        searchWebsiteNameLabel.setText("Website Name");

        searchTagsLabel.setText("Tags");

        searchAssociationNameLabel.setText("Association name");

        searchDisplayTable.setText("Search");
        searchDisplayTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDisplayTableActionPerformed(evt);
            }
        });

        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPasswordTabLayout = new javax.swing.GroupLayout(searchPasswordTab);
        searchPasswordTab.setLayout(searchPasswordTabLayout);
        searchPasswordTabLayout.setHorizontalGroup(
            searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPasswordTabLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchWebsiteNameLabel)
                    .addComponent(searchAssociationNameLabel)
                    .addComponent(searchTagsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPasswordTabLayout.createSequentialGroup()
                        .addComponent(showAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDisplayTable))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPasswordTabLayout.createSequentialGroup()
                        .addComponent(searchTag1TF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTag2TF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTag3TF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchAssociationNameTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchWebsiteNameTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(746, 746, 746))
        );
        searchPasswordTabLayout.setVerticalGroup(
            searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPasswordTabLayout.createSequentialGroup()
                .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPasswordTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPasswordTabLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchWebsiteNameLabel)
                            .addComponent(searchWebsiteNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchAssociationNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchAssociationNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchTagsLabel)
                            .addGroup(searchPasswordTabLayout.createSequentialGroup()
                                .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchTag2TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchTag3TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchTag1TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(searchPasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchDisplayTable)
                                    .addComponent(showAllButton))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Tab.addTab("Search Password", searchPasswordTab);

        addCustomButton.setText("Add Custom Word");
        addCustomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomButtonActionPerformed(evt);
            }
        });

        advancedGeneratePasswordTF.setEditable(false);

        advancedSaveAndQuitButton.setText("Save and Quit");
        advancedSaveAndQuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedSaveAndQuitButtonActionPerformed(evt);
            }
        });

        advancedGeneratePasswordButton.setText("Generate");
        advancedGeneratePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedGeneratePasswordButtonActionPerformed(evt);
            }
        });

        howManyWordsLabel.setText("How many Words? ");

        whiteBlackListGroup.add(blackListRadioButton);
        blackListRadioButton.setText("Blacklist");

        whiteBlackListGroup.add(whiteListRadioButton);
        whiteListRadioButton.setText("Whitelist");

        startWithAlphabetCharacterCheckBox.setText("Start with Alphabet Character");
        startWithAlphabetCharacterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWithAlphabetCharacterCheckBoxActionPerformed(evt);
            }
        });

        startWithNumberCheckBox.setText("Start with Number");
        startWithNumberCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWithNumberCheckBoxActionPerformed(evt);
            }
        });

        lowerCaseLettersCheckBox.setText("a-z");
        lowerCaseLettersCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerCaseLettersCheckBoxActionPerformed(evt);
            }
        });

        numberCheckBox.setText("0-9");
        numberCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberCheckBoxActionPerformed(evt);
            }
        });

        upperCaseLettersCheckBox.setText("A-Z");
        upperCaseLettersCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upperCaseLettersCheckBoxActionPerformed(evt);
            }
        });

        noSameLettersCheckBox.setText("No Same Letter");
        noSameLettersCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noSameLettersCheckBoxActionPerformed(evt);
            }
        });

        noSameWordCheckBox.setText("No Same Word");

        customWordsOnlyCheckBox.setText("Custom Word");
        customWordsOnlyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customWordsOnlyCheckBoxActionPerformed(evt);
            }
        });

        wordsOnlyCheckBox.setText("Words Only");
        wordsOnlyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordsOnlyCheckBoxActionPerformed(evt);
            }
        });

        numberOfCharactersLabel.setText("Number of Characters");

        whiteBlackWordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteBlackWordTFActionPerformed(evt);
            }
        });

        simpleSettingsLabel.setText("Simple Settings");

        advancedWordSettingsLabel.setText("Advanced Custom Words Settings");

        simpleApplyButton.setText("Apply the Setting");
        simpleApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleApplyButtonActionPerformed(evt);
            }
        });

        advancedApplyButton.setText("Apply");
        advancedApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedApplyButtonActionPerformed(evt);
            }
        });

        simpleGeneratePasswordButton.setText("Generate");
        simpleGeneratePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleGeneratePasswordButtonActionPerformed(evt);
            }
        });

        simpleGeneratePasswordTF.setEditable(false);

        symbolsCheckBox.setText("Symbol");
        symbolsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolsCheckBoxActionPerformed(evt);
            }
        });

        numberOfCharactersTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfCharactersTFActionPerformed(evt);
            }
        });

        simpleSaveAndQuitButton.setText("Save and Quit");
        simpleSaveAndQuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleSaveAndQuitButtonActionPerformed(evt);
            }
        });

        setNumberOfCharactersButton.setText("Set");
        setNumberOfCharactersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNumberOfCharactersButtonActionPerformed(evt);
            }
        });

        editNumberOfCharactersButton.setText("Edit Number of Characters");
        editNumberOfCharactersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNumberOfCharactersButtonActionPerformed(evt);
            }
        });

        howManyWordsLabel1.setText("How many Custom Words? ");

        customWordsQuantityTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customWordsQuantityTFActionPerformed(evt);
            }
        });

        advancedCustomSettingsLabel.setText("Advanced Custom Settings");

        whiteBlackButton.setText("Set");
        whiteBlackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteBlackButtonActionPerformed(evt);
            }
        });

        applyWordSettingButton.setText("Apply Word Setting");
        applyWordSettingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyWordSettingButtonActionPerformed(evt);
            }
        });

        generateWordPasswordButton.setText("Generate Word Password");
        generateWordPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateWordPasswordButtonActionPerformed(evt);
            }
        });

        generateWordPasswordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateWordPasswordTFActionPerformed(evt);
            }
        });

        enableAdvancedSettingsCheckBox.setText("Enable Advanced Settings");
        enableAdvancedSettingsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableAdvancedSettingsCheckBoxActionPerformed(evt);
            }
        });

        wordSaveAndQuitButton.setText("Save And Quit");
        wordSaveAndQuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordSaveAndQuitButtonActionPerformed(evt);
            }
        });

        whiteBlackListHelpLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        whiteBlackListHelpLabel.setText("?");
        whiteBlackListHelpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                whiteBlackListHelpLabelMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout generatePasswordTabLayout = new javax.swing.GroupLayout(generatePasswordTab);
        generatePasswordTab.setLayout(generatePasswordTabLayout);
        generatePasswordTabLayout.setHorizontalGroup(
            generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numberOfCharactersLabel)
                                    .addComponent(simpleSettingsLabel)
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addComponent(upperCaseLettersCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberCheckBox))
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addComponent(symbolsCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lowerCaseLettersCheckBox)))
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(numberOfCharactersTF, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setNumberOfCharactersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(editNumberOfCharactersButton))
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addGap(223, 223, 223)
                                        .addComponent(enableAdvancedSettingsCheckBox))))
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(simpleApplyButton)))
                        .addGap(100, 100, 100)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advancedWordSettingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noSameWordCheckBox)
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addComponent(whiteListRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(blackListRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(whiteBlackListHelpLabel))
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(howManyWordsLabel1)
                                            .addComponent(howManyWordsLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(wordsQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customWordsQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addComponent(customWordsOnlyCheckBox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addCustomButton))
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addComponent(whiteBlackWordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(whiteBlackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(wordsOnlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(simpleSaveAndQuitButton)
                                    .addComponent(simpleGeneratePasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(simpleGeneratePasswordButton))
                                .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(advancedCustomSettingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(733, 733, 733)))
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                                .addComponent(startWithAlphabetCharacterCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(advancedApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                                .addComponent(startWithNumberCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noSameLettersCheckBox))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, generatePasswordTabLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(advancedSaveAndQuitButton)
                                            .addComponent(advancedGeneratePasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advancedGeneratePasswordButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(wordSaveAndQuitButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generatePasswordTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(applyWordSettingButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generatePasswordTabLayout.createSequentialGroup()
                                .addComponent(generateWordPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generateWordPasswordButton)))))
                .addGap(600, 727, Short.MAX_VALUE))
        );

        generatePasswordTabLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {customWordsQuantityTF, wordsQuantityTF});

        generatePasswordTabLayout.setVerticalGroup(
            generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addComponent(simpleSettingsLabel)
                        .addGap(22, 22, 22)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfCharactersLabel)
                            .addComponent(numberOfCharactersTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setNumberOfCharactersButton)
                            .addComponent(editNumberOfCharactersButton))
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(symbolsCheckBox)
                                    .addComponent(lowerCaseLettersCheckBox)))
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(enableAdvancedSettingsCheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upperCaseLettersCheckBox)
                            .addComponent(numberCheckBox)
                            .addComponent(simpleApplyButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addComponent(advancedWordSettingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(howManyWordsLabel)
                                    .addComponent(wordsQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generatePasswordTabLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordsOnlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(howManyWordsLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customWordsQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(generatePasswordTabLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customWordsOnlyCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addCustomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(whiteListRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blackListRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(whiteBlackWordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(whiteBlackButton)
                            .addComponent(whiteBlackListHelpLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noSameWordCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)))
                .addComponent(simpleGeneratePasswordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addComponent(simpleGeneratePasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpleSaveAndQuitButton))
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addComponent(applyWordSettingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generateWordPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateWordPasswordButton))))
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advancedCustomSettingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startWithNumberCheckBox)
                            .addComponent(noSameLettersCheckBox)))
                    .addGroup(generatePasswordTabLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(wordSaveAndQuitButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startWithAlphabetCharacterCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advancedApplyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generatePasswordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advancedGeneratePasswordButton)
                    .addComponent(advancedGeneratePasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedSaveAndQuitButton)
                .addContainerGap())
        );

        generatePasswordTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {customWordsQuantityTF, wordsQuantityTF});

        Tab.addTab("Generate Password", generatePasswordTab);

        listWordsButton.setText("List Words");
        listWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listWordsButtonActionPerformed(evt);
            }
        });

        wordFieldTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordFieldTFActionPerformed(evt);
            }
        });

        submitAddButton.setText("Add");
        submitAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddButtonActionPerformed(evt);
            }
        });

        addWordLabel.setText("Word:");

        javax.swing.GroupLayout addWordTabLayout = new javax.swing.GroupLayout(addWordTab);
        addWordTab.setLayout(addWordTabLayout);
        addWordTabLayout.setHorizontalGroup(
            addWordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addWordTabLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(addWordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGroup(addWordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addWordTabLayout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(listWordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addWordTabLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(wordFieldTF, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(856, 856, 856))
        );
        addWordTabLayout.setVerticalGroup(
            addWordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWordTabLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(addWordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(wordFieldTF, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(addWordTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listWordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(231, 231, 231))
        );

        Tab.addTab("Add Word", addWordTab);

        getContentPane().add(Tab);

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

        setJMenuBar(menuBar);

        setSize(new java.awt.Dimension(1246, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void submitAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddButtonActionPerformed
        if (wordFieldTF.getText().matches("0-9")) {//error handling
            JOptionPane.showMessageDialog(this, "A Number is Present in the word", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (wordFieldTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "TEXT FIELD IS EMPTY", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (wordData datas : wordList) {//for each loop to find the error
                if (datas.getWords().equals(wordFieldTF.getText())) {
                    JOptionPane.showMessageDialog(this, "The Word Already Exists in the Database", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }//continue the method if no problem arises
            String fileName = "WordList.text";
            wordData wordAdd = new wordData();

            wordAdd.setWords(wordFieldTF.getText());
            wordAdd.setCustomWords(true);
            wordList.add(wordAdd);

            ObjectOutputStream output;//saving the word to textfile

            try {//error handling
                output = new ObjectOutputStream(new FileOutputStream(fileName));

                try {
                    for (wordData data : wordList) {
                        output.writeObject(data);
                        output.flush();
                    }
                } catch (IOException ex) {
                    System.out.println("Error writing to file!!!");
                }
            } catch (IOException ex) {
                Logger.getLogger(saveWord.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);

            }
            wordFieldTF.setText("");
        }
    }//GEN-LAST:event_submitAddButtonActionPerformed

    private void wordFieldTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordFieldTFActionPerformed
    }//GEN-LAST:event_wordFieldTFActionPerformed

    private void listWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listWordsButtonActionPerformed
        String output = "";
        for (wordData word : wordList) {//for each loop looping through wordlist and adding the toString as an output
            output += word.toString() + "\n\n";
        }
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setText(output);

        JScrollPane scroller = new JScrollPane(outputArea);
        JOptionPane.showMessageDialog(this, scroller);
    }//GEN-LAST:event_listWordsButtonActionPerformed

    private void editNumberOfCharactersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNumberOfCharactersButtonActionPerformed
        symbolsCheckBox.setEnabled(false);
        numberCheckBox.setEnabled(false);
        lowerCaseLettersCheckBox.setEnabled(false);
        upperCaseLettersCheckBox.setEnabled(false);
        simpleApplyButton.setEnabled(false);
        simpleGeneratePasswordTF.setEnabled(false);
        simpleSaveAndQuitButton.setEnabled(false);
        setNumberOfCharactersButton.setEnabled(true);
        numberOfCharactersTF.setEditable(true);
        simpleGeneratePasswordButton.setEnabled(false);
        //in case of advanced setting has been enabled
        startWithAlphabetCharacterCheckBox.setEnabled(false);
        startWithNumberCheckBox.setEnabled(false);
        noSameLettersCheckBox.setEnabled(false);
        addCustomButton.setEnabled(false);
        advancedApplyButton.setEnabled(false);
        advancedGeneratePasswordButton.setEnabled(false);
        advancedGeneratePasswordTF.setEnabled(false);
        advancedSaveAndQuitButton.setEnabled(false);
        if (enableAdvancedSettingsCheckBox.isSelected()) {
            enableAdvancedSettingsCheckBox.doClick();
        }
        enableAdvancedSettingsCheckBox.setEnabled(false);
    }//GEN-LAST:event_editNumberOfCharactersButtonActionPerformed

    private void setNumberOfCharactersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setNumberOfCharactersButtonActionPerformed
        if (numberOfCharactersTF.getText().matches("[-+]?\\d*\\.?\\d+")) {//if the inputted value is number enable settings
            editNumberOfCharactersButton.setEnabled(true);
            symbolsCheckBox.setEnabled(true);
            numberCheckBox.setEnabled(true);
            lowerCaseLettersCheckBox.setEnabled(true);
            upperCaseLettersCheckBox.setEnabled(true);
            simpleApplyButton.setEnabled(true);
            enableAdvancedSettingsCheckBox.setEnabled(true);
            simpleSaveAndQuitButton.setEnabled(true);
            setNumberOfCharactersButton.setEnabled(false);
            numberOfCharactersTF.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "TYPE IN NUMBERS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_setNumberOfCharactersButtonActionPerformed

    private void simpleSaveAndQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleSaveAndQuitButtonActionPerformed
        
        savePasswordJPF.setText(simpleGeneratePasswordTF.getText());
        Tab.setSelectedIndex(0);
        savePasswordJPF.requestFocus();
    }//GEN-LAST:event_simpleSaveAndQuitButtonActionPerformed

    private void numberOfCharactersTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfCharactersTFActionPerformed
        
        if (numberOfCharactersTF.getText().matches("[-+]?\\d*\\.?\\d+")) {//if the inputted value is number enable settings
            editNumberOfCharactersButton.setEnabled(true);
            symbolsCheckBox.setEnabled(true);
            numberCheckBox.setEnabled(true);
            lowerCaseLettersCheckBox.setEnabled(true);
            upperCaseLettersCheckBox.setEnabled(true);
            simpleApplyButton.setEnabled(true);
            enableAdvancedSettingsCheckBox.setEnabled(true);
            simpleGeneratePasswordTF.setEnabled(true);
            simpleSaveAndQuitButton.setEnabled(true);
            setNumberOfCharactersButton.setEnabled(false);
            numberOfCharactersTF.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "TYPE IN NUMBERS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numberOfCharactersTFActionPerformed

    private void symbolsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolsCheckBoxActionPerformed
        
        int length1 = Integer.valueOf(numberOfCharactersTF.getText());
        if (!symbolsCheckBox.isSelected()) {//error handling
            symbolsCheckBoxSelected = false;
        } else {
            symbolsCheckBoxSelected = true;
            if (enableAdvancedSettingsCheckBox.isSelected()) {
                advancedApplyButton.setEnabled(true);
                advancedGeneratePasswordButton.setEnabled(false);
                advancedSaveAndQuitButton.setEnabled(false);
            } else {
                simpleApplyButton.setEnabled(true);
            }
            if (!numberCheckBox.isSelected()
                    && !lowerCaseLettersCheckBox.isSelected() && !upperCaseLettersCheckBox.isSelected()) {
                passwordCreated = symbolsOnlyPasswordGenerate(length1);
            } else {
                String temporaryPassword = passwordCreated + symbolsOnlyPasswordGenerate(length1);
                String passwordHolder = "";
                char[] multiple = new char[length1];
                for (int e = 0; e < length1; e++) {//loop for creating random password
                    multiple[e] = temporaryPassword.charAt(rand.nextInt(temporaryPassword.length()));
                    passwordHolder = passwordHolder + multiple[e];
                }
                passwordCreated = passwordHolder;

            }
        }
    }//GEN-LAST:event_symbolsCheckBoxActionPerformed

    private void simpleApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleApplyButtonActionPerformed
        
        passwordSaved = "";
        simpleGeneratePasswordTF.setText(passwordCreated);
        if (numbersCheckBoxSelected == true) {
            numberCheckBox.doClick();
            passwordSaved = passwordSaved + numbers;

        }
        if (symbolsCheckBoxSelected == true) {
            symbolsCheckBox.doClick();
            passwordSaved = passwordSaved + symbols;
        }
        if (upperCaseCheckBoxSelected == true) {
            upperCaseLettersCheckBox.doClick();
            passwordSaved = passwordSaved + upperCaseLetters;
        }
        if (lowerCaseCheckBoxSelected == true) {
            lowerCaseLettersCheckBox.doClick();
            passwordSaved = passwordSaved + lowerCaseLetters;
        }
        simpleApplyButton.setEnabled(false);
        simpleGeneratePasswordButton.setEnabled(true);
        simpleGeneratePasswordTF.setEnabled(true);

    }//GEN-LAST:event_simpleApplyButtonActionPerformed

    private void wordsOnlyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordsOnlyCheckBoxActionPerformed
        

        if (!wordsOnlyCheckBox.isSelected()) {//usability feature
            wordsQuantityTF.setEnabled(false);
            wordsCheckBoxSelected = false;
            noSameWordCheckBox.setEnabled(false);
            blackListRadioButton.setEnabled(false);
            whiteListRadioButton.setEnabled(false);
            whiteBlackWordTF.setEnabled(false);
            addCustomButton.setEnabled(false);
            applyWordSettingButton.setEnabled(false);
        } else {
            if (customWordsOnlyCheckBox.isSelected()) {
                customWordsOnlyCheckBox.doClick();
            }
            wordsQuantityTF.setEnabled(true);
            wordsCheckBoxSelected = true;

            wordsOnlyCheckBox.setEnabled(true);
            noSameWordCheckBox.setEnabled(true);
            blackListRadioButton.setEnabled(true);
            whiteListRadioButton.setEnabled(true);
            whiteBlackWordTF.setEnabled(true);
            addCustomButton.setEnabled(true);
            applyWordSettingButton.setEnabled(true);
        }
    }//GEN-LAST:event_wordsOnlyCheckBoxActionPerformed

    private void noSameLettersCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noSameLettersCheckBoxActionPerformed
        

        int length = Integer.parseInt(numberOfCharactersTF.getText());
        if (!noSameLettersCheckBox.isSelected()) {

        } else {
            if (startWithNumberCheckBox.isSelected() || startWithAlphabetCharacterCheckBox.isSelected()) {

            } else {
                passwordSaved = "";
                if (symbolsCheckBox.isSelected()) {
                    passwordSaved = symbols;
                }
                if (numberCheckBox.isSelected()) {
                    passwordSaved = passwordSaved + numbers;
                }
                if (lowerCaseLettersCheckBox.isSelected()) {
                    passwordSaved = passwordSaved + lowerCaseLetters;
                }
                if (upperCaseLettersCheckBox.isSelected()) {
                    passwordSaved = passwordSaved + upperCaseLetters;
                }

                if (Integer.valueOf(numberOfCharactersTF.getText()) > passwordSaved.length()) {
                    JOptionPane.showMessageDialog(this, "number of unique letter is lesser than the size of the password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    noSameLettersCheckBox.doClick();
                    return;
                }
                if (symbolsCheckBox.isSelected() || lowerCaseLettersCheckBox.isSelected() || upperCaseLettersCheckBox.isSelected() || numberCheckBox.isSelected()) {
                    recursionCheckIfSameLetter(length);
                } else {
                    JOptionPane.showMessageDialog(this, "Please have at least one simple settings checked", "Error Message", JOptionPane.ERROR_MESSAGE);
                    noSameLettersCheckBox.doClick();
                }

            }
        }
    }//GEN-LAST:event_noSameLettersCheckBoxActionPerformed

    private void upperCaseLettersCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upperCaseLettersCheckBoxActionPerformed
        
        int length1 = Integer.valueOf(numberOfCharactersTF.getText());
        if (!upperCaseLettersCheckBox.isSelected()) {//Error Handling
            upperCaseCheckBoxSelected = false;
        } else {
            upperCaseCheckBoxSelected = true;
            if (enableAdvancedSettingsCheckBox.isSelected()) {
                advancedApplyButton.setEnabled(true);
                advancedGeneratePasswordButton.setEnabled(false);
                advancedSaveAndQuitButton.setEnabled(false);
            } else {
                simpleApplyButton.setEnabled(true);
            }
            if (!symbolsCheckBox.isSelected()
                    && !lowerCaseLettersCheckBox.isSelected() && !numberCheckBox.isSelected()) {

                passwordCreated = upperCaseOnlyPasswordGenerate(length1);

            } else {

                String temporaryPassword = passwordCreated + upperCaseOnlyPasswordGenerate(length1);
                String passwordHolder = "";
                char[] multiple = new char[length1];
                for (int e = 0; e < length1; e++) {
                    multiple[e] = temporaryPassword.charAt(rand.nextInt(temporaryPassword.length()));
                    passwordHolder = passwordHolder + multiple[e];
                }
                passwordCreated = passwordHolder;

            }
        }
    }//GEN-LAST:event_upperCaseLettersCheckBoxActionPerformed

    private void numberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberCheckBoxActionPerformed
        int length1 = Integer.valueOf(numberOfCharactersTF.getText());
        if (!numberCheckBox.isSelected()) {
            numbersCheckBoxSelected = false;
        } else {
            numbersCheckBoxSelected = true;
            if (enableAdvancedSettingsCheckBox.isSelected()) {
                advancedApplyButton.setEnabled(true);
                advancedGeneratePasswordButton.setEnabled(false);
                advancedSaveAndQuitButton.setEnabled(false);
            } else {
                simpleApplyButton.setEnabled(true);
            }
            if (!symbolsCheckBox.isSelected()
                    && !lowerCaseLettersCheckBox.isSelected() && !upperCaseLettersCheckBox.isSelected()) {
                passwordCreated = numbersOnlyPasswordGenerate(length1);

            } else {
                String temporaryPassword = passwordCreated + numbersOnlyPasswordGenerate(length1);
                String passwordHolder = "";
                char[] multiple = new char[length1];
                for (int e = 0; e < length1; e++) {
                    multiple[e] = temporaryPassword.charAt(rand.nextInt(temporaryPassword.length()));
                    passwordHolder = passwordHolder + multiple[e];
                }
                passwordCreated = passwordHolder;

            }
        }
    }//GEN-LAST:event_numberCheckBoxActionPerformed

    private void lowerCaseLettersCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerCaseLettersCheckBoxActionPerformed
        
        int length1 = Integer.valueOf(numberOfCharactersTF.getText());
        if (!lowerCaseLettersCheckBox.isSelected()) {
            lowerCaseCheckBoxSelected = false;
        } else {
            lowerCaseCheckBoxSelected = true;
            if (enableAdvancedSettingsCheckBox.isSelected()) {
                advancedApplyButton.setEnabled(true);
                advancedGeneratePasswordButton.setEnabled(false);
                advancedSaveAndQuitButton.setEnabled(false);
            } else {
                simpleApplyButton.setEnabled(true);
            }
            if (!symbolsCheckBox.isSelected()
                    && !numberCheckBox.isSelected() && !upperCaseLettersCheckBox.isSelected()) {
                passwordCreated = lowerCaseOnlyPasswordGenerate(length1);

            } else {
                String temporaryPassword = passwordCreated + lowerCaseOnlyPasswordGenerate(length1);
                String passwordHolder = "";
                char[] multiple = new char[length1];
                for (int e = 0; e < length1; e++) {
                    multiple[e] = temporaryPassword.charAt(rand.nextInt(temporaryPassword.length()));
                    passwordHolder = passwordHolder + multiple[e];
                }
                passwordCreated = passwordHolder;

            }
        }
    }//GEN-LAST:event_lowerCaseLettersCheckBoxActionPerformed

    private void startWithNumberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWithNumberCheckBoxActionPerformed
        

        if (!startWithNumberCheckBox.isSelected()) {
        } else {
            if (!numberCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Your Number has not been APPLIED to the custom settings ", "Error", JOptionPane.ERROR_MESSAGE);
                startWithNumberCheckBox.doClick();
            } else {
                if (startWithAlphabetCharacterCheckBox.isSelected()) {
                    startWithAlphabetCharacterCheckBox.doClick();
                }
                passwordSaved = "";
                if (numbersCheckBoxSelected == true) {//add numbers to the passwordsetting to create a string consisting of numbers
                    passwordSaved = numbers;

                }
                if (symbolsCheckBoxSelected == true) {//add symbols to passwordsaved string, therefore if previosuly number is added it will have both number and symbol
                    passwordSaved = passwordSaved + symbols;
                }
                if (upperCaseCheckBoxSelected == true) {
                    passwordSaved = passwordSaved + upperCaseLetters;
                }
                if (lowerCaseCheckBoxSelected == true) {
                    passwordSaved = passwordSaved + lowerCaseLetters;
                }
                passwordRecursionForFirstLetterNumber(Integer.valueOf(numberOfCharactersTF.getText()));
            }
        }
    }//GEN-LAST:event_startWithNumberCheckBoxActionPerformed

    private void startWithAlphabetCharacterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWithAlphabetCharacterCheckBoxActionPerformed
        // TODO add your handling code her
        if (!startWithAlphabetCharacterCheckBox.isSelected()) {
        } else {
            if (!upperCaseLettersCheckBox.isSelected() && !lowerCaseLettersCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Your Alphabet has not been APPLIED to the custom settings ", "Error", JOptionPane.ERROR_MESSAGE);
                startWithAlphabetCharacterCheckBox.doClick();
            } else {
                if (startWithNumberCheckBox.isSelected()) {
                    startWithNumberCheckBox.doClick();
                }

            }

        }
    }//GEN-LAST:event_startWithAlphabetCharacterCheckBoxActionPerformed

    private void advancedGeneratePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedGeneratePasswordButtonActionPerformed
        length = Integer.valueOf(numberOfCharactersTF.getText());
        if (startWithAlphabetCharacterCheckBox.isSelected()) {
            passwordRecursionForFirstLetterAlphabet(length);
            advancedGeneratePasswordTF.setText(passwordCreated);
            return;
        } else if (startWithNumberCheckBox.isSelected()) {
            passwordRecursionForFirstLetterNumber(length);
            advancedGeneratePasswordTF.setText(passwordCreated);
            return;
        }
        if (noSameLettersCheckBox.isSelected()) {
            recursionCheckIfSameLetter(length);
            advancedGeneratePasswordTF.setText(passwordCreated);
        }


    }//GEN-LAST:event_advancedGeneratePasswordButtonActionPerformed

    private void advancedSaveAndQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedSaveAndQuitButtonActionPerformed
        
    }//GEN-LAST:event_advancedSaveAndQuitButtonActionPerformed

    private void addCustomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomButtonActionPerformed
        
        wordFieldTF.requestFocus();
        Tab.setSelectedIndex(3);
    }//GEN-LAST:event_addCustomButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();//to edit the displayTable
        model.setRowCount(0);
        for (int i = 0; i < theList.size(); i++) {//loop through all the element in passwordData and display on the displaytable
            model.addRow(new Object[]{null, null, null, null, null, null, null, null});//add row each time it loops in displaytable, creating a platform for the data to enter
            PasswordData record = theList.get(i);
            int key = 5;
            displayTable.setValueAt(record.getUsername(), i, 0);
            displayTable.setValueAt(record.getEmail(), i, 1);
            displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), i, 2);
            displayTable.setValueAt(record.getWebsite(), i, 3);
            displayTable.setValueAt(record.getAssociation(), i, 4);
            displayTable.setValueAt(record.getTag1(), i, 5);
            displayTable.setValueAt(record.getTag2(), i, 6);
            displayTable.setValueAt(record.getTag3(), i, 7);

        }
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void searchDisplayTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDisplayTableActionPerformed
        
        int key = 5;
        int count = 0;
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        ArrayList<PasswordData> saveDataArrayList = new ArrayList<PasswordData>();
        model.setRowCount(0);
        //start of an algorithm for searching with website name
        if (!searchWebsiteNameTF.getText().isEmpty()) {//check if the textbox is empty
            for (int i = 0; i < theList.size(); i++) {//if empty loop till the current thelist array
                if (theList.get(i).getWebsite().equals(searchWebsiteNameTF.getText())) {
                    try {
                        model.addRow(new Object[]{null, null, null, null, null, null, null, null});
                        saveDataArrayList.add(theList.get(i));
                        PasswordData record = saveDataArrayList.get(count);
                        
                        displayTable.setValueAt(record.getUsername(), count, 0);
                        displayTable.setValueAt(record.getEmail(), count, 1);
                        displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), count, 2);
                        displayTable.setValueAt(record.getWebsite(), count, 3);
                        displayTable.setValueAt(record.getAssociation(), count, 4);
                        displayTable.setValueAt(record.getTag1(), count, 5);
                        displayTable.setValueAt(record.getTag2(), count, 6);
                        displayTable.setValueAt(record.getTag3(), count, 7);
                        count++;
                    } catch (Exception ex) {
                        Logger.getLogger(PasswordDataBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
        //end of the algorithm for searching with website name

        if (!searchAssociationNameTF.getText().isEmpty()) {
            for (int i = 0; i < theList.size(); i++) {//if empty loop till the current thelist array
                if (theList.get(i).getAssociation().equals(searchAssociationNameTF.getText())) {
                    model.addRow(new Object[]{null, null, null, null, null, null, null, null});
                    if (saveDataArrayList.contains(theList.get(i))) {

                    } else {
                        saveDataArrayList.add(theList.get(i));
                        PasswordData record = saveDataArrayList.get(count);
                        displayTable.setValueAt(record.getUsername(), count, 0);
                        displayTable.setValueAt(record.getEmail(), count, 1);
                        displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), count, 2);
                        displayTable.setValueAt(record.getWebsite(), count, 3);
                        displayTable.setValueAt(record.getAssociation(), count, 4);
                        displayTable.setValueAt(record.getTag1(), count, 5);
                        displayTable.setValueAt(record.getTag2(), count, 6);
                        displayTable.setValueAt(record.getTag3(), count, 7);
                        count++;
                    }
                }

            }
        }

        if (!searchTag1TF.getText().isEmpty()) {
            for (int i = 0; i < theList.size(); i++) {//if empty loop till the current thelist array
                if (theList.get(i).getTag1().equals(searchTag1TF.getText())) {
                    model.addRow(new Object[]{null, null, null, null, null, null, null, null});
                    if (saveDataArrayList.contains(theList.get(i))) {

                    } else {
                        saveDataArrayList.add(theList.get(i));
                        PasswordData record = saveDataArrayList.get(count);
                        displayTable.setValueAt(record.getUsername(), count, 0);
                        displayTable.setValueAt(record.getEmail(), count, 1);
                        displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), count, 2);
                        displayTable.setValueAt(record.getWebsite(), count, 3);
                        displayTable.setValueAt(record.getAssociation(), count, 4);
                        displayTable.setValueAt(record.getTag1(), count, 5);
                        displayTable.setValueAt(record.getTag2(), count, 6);
                        displayTable.setValueAt(record.getTag3(), count, 7);
                        count++;
                    }
                }

            }
        }
        if (!searchTag2TF.getText().isEmpty()) {
            for (int i = 0; i < theList.size(); i++) {//if empty loop till the current thelist array
                if (theList.get(i).getTag2().equals(searchTag2TF.getText())) {
                    if (saveDataArrayList.contains(theList.get(i))) {

                    } else {
                        model.addRow(new Object[]{null, null, null, null, null, null, null, null});
                        saveDataArrayList.add(theList.get(i));
                        PasswordData record = saveDataArrayList.get(count);
                        displayTable.setValueAt(record.getUsername(), count, 0);
                        displayTable.setValueAt(record.getEmail(), count, 1);
                        displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), count, 2);
                        displayTable.setValueAt(record.getWebsite(), count, 3);
                        displayTable.setValueAt(record.getAssociation(), count, 4);
                        displayTable.setValueAt(record.getTag1(), count, 5);
                        displayTable.setValueAt(record.getTag2(), count, 6);
                        displayTable.setValueAt(record.getTag3(), count, 7);
                        count++;
                    }
                }

            }
        }

        if (!searchTag3TF.getText().isEmpty()) {
            for (int i = 0; i < theList.size(); i++) {//if empty loop till the current thelist array
                if (theList.get(i).getTag3().equals(searchTag3TF.getText())) {
                    if (saveDataArrayList.contains(theList.get(i))) {

                    } else {
                        model.addRow(new Object[]{null, null, null, null, null, null, null, null});
                        saveDataArrayList.add(theList.get(i));
                        PasswordData record = saveDataArrayList.get(count);
                        displayTable.setValueAt(record.getUsername(), count, 0);
                        displayTable.setValueAt(record.getEmail(), count, 1);
                        displayTable.setValueAt(passwordDecrypt(record.getPassword(), key), count, 2);
                        displayTable.setValueAt(record.getWebsite(), count, 3);
                        displayTable.setValueAt(record.getAssociation(), count, 4);
                        displayTable.setValueAt(record.getTag1(), count, 5);
                        displayTable.setValueAt(record.getTag2(), count, 6);
                        displayTable.setValueAt(record.getTag3(), count, 7);
                        count++;
                    }
                }

            }
        }


    }//GEN-LAST:event_searchDisplayTableActionPerformed

    private void showSaveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSaveCheckBoxActionPerformed
        
        if (!showSaveCheckBox.isSelected()) {//reveal the password inside the JPF
            savePasswordJPF.setEchoChar('*');
        } else {
            savePasswordJPF.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_showSaveCheckBoxActionPerformed

    private void saveGeneratePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGeneratePasswordButtonActionPerformed
        
        Tab.setSelectedIndex(2);
    }//GEN-LAST:event_saveGeneratePasswordButtonActionPerformed

    private void saveUserPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUserPasswordButtonActionPerformed
        
        PasswordData passData = new PasswordData();
        if(savePasswordJPF.getPassword().length==0){
            JOptionPane.showMessageDialog(this, "Your Password needs to be inputted", "Error", JOptionPane.ERROR_MESSAGE);
            savePasswordJPF.requestFocus();
            return;
        }

        if (!saveUsernameTF.getText().matches("[^A-Za-z0-9]")) {//ERROR Handling
            if (saveUsernameTF.getText().length() < 99) {
                passData.setUsername(saveUsernameTF.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Your Username is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveUsernameTF.requestFocus();
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your Username has a Symbol", "Error", JOptionPane.ERROR_MESSAGE);
            saveUsernameTF.requestFocus();
            return;

        }

        if (!saveEmailTF.getText().contains("@")) {
            JOptionPane.showMessageDialog(this, "Your Email has a wrong format", "Error", JOptionPane.ERROR_MESSAGE);
            saveEmailTF.requestFocus();
            return;
        } else {
            if (saveEmailTF.getText().length() > 99) {
                JOptionPane.showMessageDialog(this, "Your Email is above word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveEmailTF.requestFocus();
            } else {
                passData.setEmail(saveEmailTF.getText());
            }
        }
        
        if (savePasswordJPF.getPassword().length < 4) {
            JOptionPane.showMessageDialog(this, "Your Password has length lower than 3", "Error", JOptionPane.ERROR_MESSAGE);
            savePasswordJPF.requestFocus();
            return;
        } else {
            int key = 5;
            passData.setPassword(passwordEncrypt(String.valueOf(savePasswordJPF.getPassword()), key));
        }

        if (!saveWebsiteTF.getText().contains(".")) {
            JOptionPane.showMessageDialog(this, "Your Website has a wrong format", "Error", JOptionPane.ERROR_MESSAGE);
            saveWebsiteTF.requestFocus();
            return;
        } else {
            if (saveWebsiteTF.getText().length() > 99) {
                JOptionPane.showMessageDialog(this, "Your Website is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveWebsiteTF.requestFocus();
                return;
            } else {
                passData.setWebsite(saveWebsiteTF.getText());
            }
        }

        if (saveAssociationTF.getText().length() < 99) {
            passData.setAssociation(saveAssociationTF.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Your Association is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
            saveAssociationTF.requestFocus();
            return;
        }

        if (!saveTag1TF.getText().matches("[^A-Za-z0-9]")) {

            if (saveTag1TF.getText().length() > 99) {
                JOptionPane.showMessageDialog(this, "Your Tag 1 is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveTag1TF.requestFocus();
                return;
            } else {
                passData.setTag1(saveTag1TF.getText());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Your Tag 1 has symbol", "Error", JOptionPane.ERROR_MESSAGE);
            saveTag1TF.requestFocus();
            return;
        }

        if (!saveTag2TF.getText().matches("[^A-Za-z0-9]")) {

            if (saveTag2TF.getText().length() > 99) {
                JOptionPane.showMessageDialog(this, "Your Tag 2 is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveTag2TF.requestFocus();
                return;
            } else {
                passData.setTag2(saveTag2TF.getText());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Your Tag 2 has symbol", "Error", JOptionPane.ERROR_MESSAGE);
            saveTag2TF.requestFocus();
            return;
        }

        if (!saveTag3TF.getText().matches("[^A-Za-z0-9]")) {

            if (saveTag3TF.getText().length() > 99) {
                JOptionPane.showMessageDialog(this, "Your Tag 3 is above the word limit", "Error", JOptionPane.ERROR_MESSAGE);
                saveTag3TF.requestFocus();
                return;
            } else {
                passData.setTag3(saveTag3TF.getText());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Your Tag 3 has symbol", "Error", JOptionPane.ERROR_MESSAGE);
            saveTag3TF.requestFocus();
            return;
        }

        theList.add(passData);
        Collections.sort(theList, PasswordData.usernameComparator);
        counter++;//

        String fileName = "EncryptedData.text";

        ObjectOutputStream output;

        try {
            output = new ObjectOutputStream(new FileOutputStream(fileName));

            try {
                for (PasswordData data : theList) {
                    output.writeObject(data);
                    output.flush();
                }
            } catch (IOException ex) {
                System.out.println("Error writing to file!!!");
            }
        } catch (IOException ex) {
            Logger.getLogger(thePassword.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);

        }

        saveUsernameTF.setText("");
        saveEmailTF.setText("");
        savePasswordJPF.setText("");
        saveWebsiteTF.setText("");
        saveAssociationTF.setText("");
        saveTag1TF.setText("");
        saveTag2TF.setText("");
        saveTag3TF.setText("");
    }//GEN-LAST:event_saveUserPasswordButtonActionPerformed

    private void simpleGeneratePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleGeneratePasswordButtonActionPerformed
        

        length = Integer.valueOf(numberOfCharactersTF.getText());
        String passwordHolder = "";
        char[] multiple = new char[length];
        for (int e = 0; e < length; e++) {
            multiple[e] = passwordSaved.charAt(rand.nextInt(passwordSaved.length()));
            passwordHolder = passwordHolder + multiple[e];
        }
        passwordCreated = passwordHolder;
        simpleGeneratePasswordTF.setText(passwordCreated);
    }//GEN-LAST:event_simpleGeneratePasswordButtonActionPerformed

    private void customWordsOnlyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customWordsOnlyCheckBoxActionPerformed
        

        if (!customWordsOnlyCheckBox.isSelected()) {
            customWordsQuantityTF.setEnabled(false);
            customWordsCheckBoxSelected = false;

            noSameWordCheckBox.setEnabled(false);
            blackListRadioButton.setEnabled(false);
            whiteListRadioButton.setEnabled(false);
            whiteBlackWordTF.setEnabled(false);
            addCustomButton.setEnabled(false);
            applyWordSettingButton.setEnabled(false);
        } else {
            customWordsQuantityTF.setEnabled(true);
            customWordsCheckBoxSelected = true;
            if (wordsOnlyCheckBox.isSelected()) {
                wordsOnlyCheckBox.doClick();
            }
            wordsOnlyCheckBox.setEnabled(true);
            noSameWordCheckBox.setEnabled(true);
            blackListRadioButton.setEnabled(true);
            whiteListRadioButton.setEnabled(true);
            whiteBlackWordTF.setEnabled(true);
            addCustomButton.setEnabled(true);
            applyWordSettingButton.setEnabled(true);
        }


    }//GEN-LAST:event_customWordsOnlyCheckBoxActionPerformed

    private void advancedApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedApplyButtonActionPerformed
        
        passwordSaved = "";//delete the previous password setting created

        if (numbersCheckBoxSelected == true) {//add numbers to the passwordsetting to create a string consisting of numbers
            numberCheckBox.doClick();
            passwordSaved = numbers;

        }
        if (symbolsCheckBoxSelected == true) {//add symbols to passwordsaved string, therefore if previosuly number is added it will have both number and symbol
            symbolsCheckBox.doClick();
            passwordSaved = passwordSaved + symbols;
        }
        if (upperCaseCheckBoxSelected == true) {
            upperCaseLettersCheckBox.doClick();
            passwordSaved = passwordSaved + upperCaseLetters;
        }
        if (lowerCaseCheckBoxSelected == true) {
            lowerCaseLettersCheckBox.doClick();
            passwordSaved = passwordSaved + lowerCaseLetters;
        }
        if (startWithAlphabetCharacterCheckBox.isSelected()) {
            passwordRecursionForFirstLetterAlphabet(Integer.valueOf(numberOfCharactersTF.getText()));
        } else if (startWithNumberCheckBox.isSelected()) {
            passwordRecursionForFirstLetterNumber(Integer.valueOf(numberOfCharactersTF.getText()));
        } else if (!startWithNumberCheckBox.isSelected() && !startWithAlphabetCharacterCheckBox.isSelected() && noSameLettersCheckBox.isSelected()) {
            recursionCheckIfSameLetter(Integer.valueOf(numberOfCharactersTF.getText()));
            advancedGeneratePasswordTF.setText(passwordCreated);
        }

        advancedApplyButton.setEnabled(false);
        advancedGeneratePasswordButton.setEnabled(true);
        advancedGeneratePasswordTF.setEnabled(true);
    }//GEN-LAST:event_advancedApplyButtonActionPerformed

    private void saveUsernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUsernameTFActionPerformed
        
        saveEmailTF.requestFocus();//usability feature for the user to be able to press enter and without any need for mouse interaction over moving to next text field.
    }//GEN-LAST:event_saveUsernameTFActionPerformed

    private void saveEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmailTFActionPerformed
        
        savePasswordJPF.requestFocus();
    }//GEN-LAST:event_saveEmailTFActionPerformed

    private void saveWebsiteTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveWebsiteTFActionPerformed
        
        saveAssociationTF.requestFocus();
    }//GEN-LAST:event_saveWebsiteTFActionPerformed

    private void saveAssociationTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAssociationTFActionPerformed
        
        saveTag1TF.requestFocus();
    }//GEN-LAST:event_saveAssociationTFActionPerformed

    private void saveTag1TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTag1TFActionPerformed
        
        saveTag2TF.requestFocus();
    }//GEN-LAST:event_saveTag1TFActionPerformed

    private void saveTag3TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTag3TFActionPerformed
        
        saveUserPasswordButton.doClick();
    }//GEN-LAST:event_saveTag3TFActionPerformed

    private void saveTag2TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTag2TFActionPerformed
        
        saveTag3TF.requestFocus();
    }//GEN-LAST:event_saveTag2TFActionPerformed

    private void savePasswordJPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePasswordJPFActionPerformed
        
        saveWebsiteTF.requestFocus();
    }//GEN-LAST:event_savePasswordJPFActionPerformed

    private void whiteBlackWordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteBlackWordTFActionPerformed
        
        String input = "";
        input = whiteBlackWordTF.getText();
        if (!input.matches("[^A-Za-z0-9]")) {//ERROR handling, to see if the input matches
            if (blackListRadioButton.isSelected()) {
                blackList = Arrays.asList(input.split("\\s*,\\s*"));
            } else if (whiteListRadioButton.isSelected()) {
                whiteList = Arrays.asList(input.split("\\s*,\\s*"));
            }

        } else {
            JOptionPane.showMessageDialog(this, "No Symbol is allowed in the TextField", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        whiteBlackWordTF.setText("");

    }//GEN-LAST:event_whiteBlackWordTFActionPerformed

    private void customWordsQuantityTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customWordsQuantityTFActionPerformed
        length = Integer.valueOf(customWordsQuantityTF.getText());

        if (customWordsQuantityTF.getText().matches("[-+]?\\d*\\.?\\d+")) {
            if (wordsOnlyCheckBox.isSelected()) {
                wordsOnlyCheckBox.doClick();
            }

            passwordWithCustomWords(length);
        } else {
            JOptionPane.showMessageDialog(this, "Please input number in How many Words Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_customWordsQuantityTFActionPerformed

    private void generateWordPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateWordPasswordButtonActionPerformed

        if (wordsOnlyCheckBox.isSelected()) {
            int wordsQuantity = Integer.valueOf(wordsQuantityTF.getText());
            passwordWithWords(wordsQuantity);

            if (blackListRadioButton.isSelected()) {
                passwordBlackList(wordsQuantity);
                if (noSameWordCheckBox.isSelected()) {
                    noSameWords(wordsQuantity, tempArray);
                }
            } else if (whiteListRadioButton.isSelected()) {
                passwordWhiteList(wordsQuantity);

                if (noSameWordCheckBox.isSelected()) {
                    if (whiteListArrayList.size() < wordsQuantity) {
                        JOptionPane.showMessageDialog(this, "unique White List words added must be greater than the words quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    noSameWords(wordsQuantity, whiteListArrayList);
                }
            } else {
                if (noSameWordCheckBox.isSelected()) {
                    noSameWords(wordsQuantity, wordArray);
                }
            }

        } else if (customWordsOnlyCheckBox.isSelected()) {
            int wordsQuantity = Integer.valueOf(customWordsQuantityTF.getText());
            passwordWithCustomWords(wordsQuantity);
            if (blackListRadioButton.isSelected()) {
                passwordBlackList(wordsQuantity);
                if (noSameWordCheckBox.isSelected()) {
                    noSameWords(wordsQuantity, tempArray);
                }
            } else if (whiteListRadioButton.isSelected()) {
                passwordWhiteList(wordsQuantity);

                if (noSameWordCheckBox.isSelected()) {
                    noSameWords(wordsQuantity, whiteListArrayList);
                }
            } else {
                if (noSameWordCheckBox.isSelected()) {
                    noSameWords(wordsQuantity, whiteListArrayList);
                }
            }

        }
        generateWordPasswordTF.setText(wordPasswordCreated);

    }//GEN-LAST:event_generateWordPasswordButtonActionPerformed

    private void applyWordSettingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyWordSettingButtonActionPerformed

        if (customWordsCheckBoxSelected == true) {
            if (customWordsQuantityTF.getText().isEmpty()) {//Error handling
                JOptionPane.showMessageDialog(this, "Please input number in How many Words Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (customWordsQuantityTF.getText().matches("[-+]?\\d*\\.?\\d+")) {
                length = Integer.parseInt(customWordsQuantityTF.getText());

                passwordWithCustomWords(length);//call on the method
                generateWordPasswordButton.setEnabled(true);//make disabled fields enabled so as to allow user interaction
                generateWordPasswordTF.setEnabled(true);
                wordSaveAndQuitButton.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please input number in How many Words Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                generateWordPasswordButton.setEnabled(false);//make enabled fields disabled so as to disallow user interaction
                generateWordPasswordTF.setEnabled(false);
                wordSaveAndQuitButton.setEnabled(false);
            }
        } else if (wordsCheckBoxSelected == true) {

            if (wordsQuantityTF.getText().matches("[-+]?\\d*\\.?\\d+")) {
                length = Integer.valueOf(wordsQuantityTF.getText());
                passwordWithWords(length);

                generateWordPasswordButton.setEnabled(true);//make disabled fields enabled so as to allow user interaction
                generateWordPasswordTF.setEnabled(true);
                wordSaveAndQuitButton.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please input number in How many Words Quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                generateWordPasswordButton.setEnabled(false);//make enabled fields disabled so as to disallow user interaction
                generateWordPasswordTF.setEnabled(false);
                wordSaveAndQuitButton.setEnabled(false);

            }
        }
    }//GEN-LAST:event_applyWordSettingButtonActionPerformed

    private void whiteBlackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteBlackButtonActionPerformed
        String input = "";
        input = whiteBlackWordTF.getText();
        if (!input.contains("[^A-Za-z]")) {//if the input doesnt match with upper and lowercase letter
            if (blackListRadioButton.isSelected()) {
                blackList = Arrays.asList(input.split("\\s*,\\s*"));
            } else if (whiteListRadioButton.isSelected()) {
                whiteList = Arrays.asList(input.split("\\s*,\\s*"));
            }

        } else {
            JOptionPane.showMessageDialog(this, "No Symbol or Number is allowed in the Whitelist or Blacklist Text Field", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        whiteBlackWordTF.setText("");
    }//GEN-LAST:event_whiteBlackButtonActionPerformed

    private void enableAdvancedSettingsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableAdvancedSettingsCheckBoxActionPerformed
        
        if (!enableAdvancedSettingsCheckBox.isSelected()) {
            startWithNumberCheckBox.setEnabled(false);
            advancedApplyButton.setEnabled(false);
            advancedSaveAndQuitButton.setEnabled(false);
            startWithAlphabetCharacterCheckBox.setEnabled(false);
            noSameLettersCheckBox.setEnabled(false);
            simpleApplyButton.setEnabled(true);

        } else {

            startWithNumberCheckBox.setEnabled(true);
            advancedApplyButton.setEnabled(true);
            advancedSaveAndQuitButton.setEnabled(true);
            startWithAlphabetCharacterCheckBox.setEnabled(true);
            noSameLettersCheckBox.setEnabled(true);
            simpleApplyButton.setEnabled(false);
            simpleGeneratePasswordButton.setEnabled(false);
            simpleGeneratePasswordTF.setEnabled(false);
        }
    }//GEN-LAST:event_enableAdvancedSettingsCheckBoxActionPerformed

    private void generateWordPasswordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateWordPasswordTFActionPerformed

    }//GEN-LAST:event_generateWordPasswordTFActionPerformed

    private void wordSaveAndQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordSaveAndQuitButtonActionPerformed
        savePasswordJPF.setText(generateWordPasswordTF.getText());
        Tab.setSelectedIndex(0);
        savePasswordJPF.requestFocus();
    }//GEN-LAST:event_wordSaveAndQuitButtonActionPerformed

    private void whiteBlackListHelpLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_whiteBlackListHelpLabelMouseEntered
        
        JOptionPane.showMessageDialog(this, "Separate the words by comma", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_whiteBlackListHelpLabelMouseEntered
    private String lowerCaseOnlyPasswordGenerate(int lengthSpecified) {
        String pass = "";
        char[] password = new char[lengthSpecified];
        for (int i = 0; i < lengthSpecified; i++) {
            password[i] = lowerCaseLetters.charAt(rand.nextInt(lowerCaseLetters.length()));
            pass = pass + password[i];
        }
        return pass;
    }

    private String upperCaseOnlyPasswordGenerate(int lengthSpecified) {
        String pass2 = "";
        char[] password2 = new char[lengthSpecified];
        for (int l = 0; l < lengthSpecified; l++) {
            password2[l] = upperCaseLetters.charAt(rand.nextInt(upperCaseLetters.length()));
            pass2 = pass2 + password2[l];
        }
        return pass2;
    }

    private String numbersOnlyPasswordGenerate(int lengthSpecified) {
        String pass3 = "";
        char[] password3 = new char[lengthSpecified];
        for (int k = 0; k < lengthSpecified; k++) {
            password3[k] = numbers.charAt(rand.nextInt(numbers.length()));
            pass3 = pass3 + password3[k];
        }
        return pass3;
    }

    private String symbolsOnlyPasswordGenerate(int lengthSpecified) {
        String pass4 = "";
        char[] symbolPassword = new char[lengthSpecified];
        for (int a = 0; a < lengthSpecified; a++) {
            symbolPassword[a] = symbols.charAt(rand.nextInt(symbols.length()));
            pass4 = pass4 + symbolPassword[a];

        }
        return pass4;
    }

    private boolean initialLetterPasswordAlphabet() {
        String upperLowerLetter = upperCaseLetters + lowerCaseLetters;
        for (int u = 0; u < upperLowerLetter.length(); u++) {
            if (upperLowerLetter.charAt(u) == passwordCreated.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    private boolean initialLetterPasswordNumber() {

        for (int u = 0; u < numbers.length(); u++) {
            if (numbers.charAt(u) == passwordCreated.charAt(0)) {
                return true;
            }
        }
        return false;

    }

    private void passwordRecursionForFirstLetterAlphabet(int lengthSpecified) {
        boolean initialAlphabet;
        boolean SameLetter;
        String temp = "";
        char[] multiple = new char[lengthSpecified];
        for (int i = 0; i < lengthSpecified; i++) {
            multiple[i] = passwordSaved.charAt(rand.nextInt(passwordSaved.length()));
            temp = temp + multiple[i];
        }
        passwordCreated = temp;
        SameLetter = checkIfSameLetter(passwordCreated);
        initialAlphabet = initialLetterPasswordAlphabet();

        if (noSameLettersCheckBox.isSelected()) {
            if (initialAlphabet == false || SameLetter == true) {
                passwordRecursionForFirstLetterAlphabet(lengthSpecified);
            }
        } else {
            if (initialAlphabet == false) {
                passwordRecursionForFirstLetterAlphabet(lengthSpecified);
            }
        }

    }

    private void passwordRecursionForFirstLetterNumber(int lengthSpecified) {
        boolean initialNumber;
        boolean sameLetter;
        String passwordHolder = "";
        ArrayList multiple = new ArrayList();
        for (int e = 0; e < lengthSpecified; e++) {
            multiple.add(passwordSaved.charAt(rand.nextInt(passwordSaved.length())));
            passwordHolder = passwordHolder + multiple.get(e);
        }
        passwordCreated = passwordHolder;
        initialNumber = initialLetterPasswordNumber();
        sameLetter = checkIfSameLetter(passwordCreated);
        if (noSameLettersCheckBox.isSelected()) {
            if (sameLetter == true || initialNumber == false) {
                passwordRecursionForFirstLetterNumber(lengthSpecified);
            }
        } else {
            if (initialNumber == false) {
                passwordRecursionForFirstLetterNumber(lengthSpecified);
            }
        }

    }

    private boolean checkIfSameLetter(String temp) {
        for (int i = 0; i < temp.length(); i++) {
            for (int k = i + 1; k < temp.length(); k++) {
                if (temp.charAt(i) == temp.charAt(k)) {
                    return true;
                }
            }
        }
        return false;

    }

    private void recursionCheckIfSameLetter(int lengthSpecified) {
        String passwordHolder = "";
        ArrayList multiple = new ArrayList();
        for (int e = 0; e < lengthSpecified; e++) {
            multiple.add(passwordSaved.charAt(rand.nextInt(passwordSaved.length())));
            passwordHolder = passwordHolder + multiple.get(e);
        }
        System.out.println(passwordHolder);
        passwordCreated = passwordHolder;
        boolean sameLetter = checkIfSameLetter(passwordHolder);
        if (sameLetter == true) {
            recursionCheckIfSameLetter(lengthSpecified);
        }
    }

    private void passwordWithWords(int wordsQuantity) {
        savedWordArray.clear();
        String[] multiple = new String[wordsQuantity];
        String TempHolder = "";
        for (int i = 0; i < wordsQuantity; i++) {
            multiple[i] = String.valueOf(wordArray.get(rand.nextInt(wordArray.size())));
            savedWordArray.add(multiple[i]);
            TempHolder = TempHolder + multiple[i];
        }
        wordPasswordCreated = TempHolder;

    }

    static String passwordEncrypt(String word, int key) {//common encrypt method utilized to protect the data from being stolen
        char[] plain = word.toCharArray();

        for (int i = 0; i < plain.length; i++) {
            for (int n = 0; n < chars.length; n++) {
                if (n <= chars.length - key) {
                    if (plain[i] == chars[n]) {
                        plain[i] = chars[n + key];
                        break;
                    }
                } else if (plain[i] == chars[n]) {
                    plain[i] = chars[n - (chars.length - key + 1)];
                }
            }
        }
        return String.valueOf(plain);
    }

    static String passwordDecrypt(String word, int key) {//common decryption method utilzied to read the encrypted files
        char[] crypto = word.toCharArray();//Separate word through characters and add them to the char array
        for (int i = 0; i < crypto.length; i++) {
            for (int n = 0; n < chars.length; n++) {//loop until every char
                if (n >= key && crypto[i] == chars[n]) {
                    crypto[i] = chars[n - key];
                    break;
                }
                if (crypto[i] == chars[n] && n < key) {
                    crypto[i] = chars[(chars.length - key + 1) + n];
                    break;
                }
            }
        }
        return String.valueOf(crypto);
    }

    private void passwordWithCustomWords(int lengthSpecified) {//method creating a password with custom words and the native words
        for (wordData wordD : wordList) {
            customWordArray.add(wordD.getWords());
        }
        String[] multiple = new String[lengthSpecified];
        String TempHolder = "";
        for (int i = 1; i < lengthSpecified; i++) {
            multiple[i] = String.valueOf(customWordArray.get(rand.nextInt(customWordArray.size())));
            TempHolder = TempHolder + multiple[i];
        }

        wordPasswordCreated = TempHolder;

    }

    private void noSameWords(int wordsQuantity, List<String> savedArray) {//method to have no duplicate letter
        ArrayList multiple = new ArrayList();
        String TempHolder = "";
        boolean sameLetterExists;
        for (int i = 0; i < wordsQuantity; i++) {
            multiple.add(String.valueOf(savedArray.get(rand.nextInt(savedArray.size()))));
            TempHolder = TempHolder + multiple.get(i);
        }
        wordPasswordCreated = TempHolder;
        sameLetterExists = checkSameWord(multiple);
        if (sameLetterExists == true) {
            noSameWords(wordsQuantity, savedArray);
        }
    }

    private boolean checkSameWord(ArrayList multiple) {//simple two dimensional array for a sequential search of the array to search if there is a same letter or not in the password
        for (int n = 0; n < multiple.size(); n++) {
            for (int k = n + 1; k < multiple.size(); k++) {
                if (multiple.get(n).equals(multiple.get(k))) {
                    return true;
                }
            }

        }
        return false;
    }

    private void passwordBlackList(int lengthSpecified) {
        blackListSavedArray.clear();
        tempArray.clear();

        List<String> blackListWords = new ArrayList();
        if (customWordsOnlyCheckBox.isSelected()) {
            for (wordData wordD : wordList) {//for each array putting every word that is native to the program rather than the custom added one into an array
                tempArray.add(wordD.getWords());

            }
        } else {
            for (wordData wordD : wordList) {//for each array putting every word that is native to the program rather than the custom added one into an array
                if (wordD.getCustomWords() == false) {
                    tempArray.add(wordD.getWords());
                }
            }
        }
        for (int k = 0; k < blackList.size(); k++) {
            blackListWords.add(blackList.get(k));
        }
        tempArray.removeAll(blackListWords);
        String[] multiple = new String[lengthSpecified];
        String TempHolder = "";
        for (int i = 0; i < lengthSpecified; i++) {
            multiple[i] = String.valueOf(tempArray.get(rand.nextInt(tempArray.size())));
            TempHolder = TempHolder + multiple[i];
        }
        wordPasswordCreated = TempHolder;
    }

    private void passwordWhiteList(int lengthSpecified) {
        whiteListArrayList.clear();
        for (int i = 0; i < whiteList.size(); i++) {
            whiteListArrayList.add(whiteList.get(i));
        }
        String[] multiple = new String[lengthSpecified];
        String TempHolder = "";
        for (int i = 0; i < lengthSpecified; i++) {
            multiple[i] = String.valueOf(whiteList.get(rand.nextInt(whiteList.size())));
            TempHolder = TempHolder + multiple[i];
        }
        wordPasswordCreated = TempHolder;
    }

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
            java.util.logging.Logger.getLogger(PasswordDataBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordDataBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordDataBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordDataBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PasswordDataBase().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PasswordDataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton addCustomButton;
    private javax.swing.JLabel addWordLabel;
    private javax.swing.JPanel addWordTab;
    private javax.swing.JButton advancedApplyButton;
    private javax.swing.JLabel advancedCustomSettingsLabel;
    private javax.swing.JButton advancedGeneratePasswordButton;
    private javax.swing.JTextField advancedGeneratePasswordTF;
    private javax.swing.JButton advancedSaveAndQuitButton;
    private javax.swing.JLabel advancedWordSettingsLabel;
    private javax.swing.JButton applyWordSettingButton;
    private javax.swing.JRadioButton blackListRadioButton;
    private javax.swing.JCheckBox customWordsOnlyCheckBox;
    private javax.swing.JTextField customWordsQuantityTF;
    private javax.swing.JTable displayTable;
    private javax.swing.JButton editNumberOfCharactersButton;
    private javax.swing.JCheckBox enableAdvancedSettingsCheckBox;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel generatePasswordTab;
    private javax.swing.JButton generateWordPasswordButton;
    private javax.swing.JTextField generateWordPasswordTF;
    private javax.swing.JLabel howManyWordsLabel;
    private javax.swing.JLabel howManyWordsLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listWordsButton;
    private javax.swing.JCheckBox lowerCaseLettersCheckBox;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JCheckBox noSameLettersCheckBox;
    private javax.swing.JCheckBox noSameWordCheckBox;
    private javax.swing.JCheckBox numberCheckBox;
    private javax.swing.JLabel numberOfCharactersLabel;
    private javax.swing.JTextField numberOfCharactersTF;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JLabel saveAssociationLabel;
    private javax.swing.JTextField saveAssociationTF;
    private javax.swing.JLabel saveEmailLabel;
    private javax.swing.JTextField saveEmailTF;
    private javax.swing.JButton saveGeneratePasswordButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JPasswordField savePasswordJPF;
    private javax.swing.JLabel savePasswordLabel;
    private javax.swing.JPanel savePasswordTab;
    private javax.swing.JTextField saveTag1TF;
    private javax.swing.JTextField saveTag2TF;
    private javax.swing.JTextField saveTag3TF;
    private javax.swing.JLabel saveTagsLabel;
    private javax.swing.JButton saveUserPasswordButton;
    private javax.swing.JLabel saveUsernameLabel;
    private javax.swing.JTextField saveUsernameTF;
    private javax.swing.JLabel saveWebsiteLabel;
    private javax.swing.JTextField saveWebsiteTF;
    private javax.swing.JLabel searchAssociationNameLabel;
    private javax.swing.JTextField searchAssociationNameTF;
    private javax.swing.JButton searchDisplayTable;
    private javax.swing.JPanel searchPasswordTab;
    private javax.swing.JTextField searchTag1TF;
    private javax.swing.JTextField searchTag2TF;
    private javax.swing.JTextField searchTag3TF;
    private javax.swing.JLabel searchTagsLabel;
    private javax.swing.JLabel searchWebsiteNameLabel;
    private javax.swing.JTextField searchWebsiteNameTF;
    private javax.swing.JButton setNumberOfCharactersButton;
    private javax.swing.JButton showAllButton;
    private javax.swing.JCheckBox showSaveCheckBox;
    private javax.swing.JToggleButton simpleApplyButton;
    private javax.swing.JButton simpleGeneratePasswordButton;
    private javax.swing.JTextField simpleGeneratePasswordTF;
    private javax.swing.JToggleButton simpleSaveAndQuitButton;
    private javax.swing.JLabel simpleSettingsLabel;
    private javax.swing.JCheckBox startWithAlphabetCharacterCheckBox;
    private javax.swing.JCheckBox startWithNumberCheckBox;
    private javax.swing.JButton submitAddButton;
    private javax.swing.JCheckBox symbolsCheckBox;
    private javax.swing.JCheckBox upperCaseLettersCheckBox;
    private javax.swing.JButton whiteBlackButton;
    private javax.swing.ButtonGroup whiteBlackListGroup;
    private javax.swing.JLabel whiteBlackListHelpLabel;
    private javax.swing.JTextField whiteBlackWordTF;
    private javax.swing.JRadioButton whiteListRadioButton;
    private javax.swing.JTextField wordFieldTF;
    private javax.swing.JButton wordSaveAndQuitButton;
    private javax.swing.JCheckBox wordsOnlyCheckBox;
    private javax.swing.JTextField wordsQuantityTF;
    // End of variables declaration//GEN-END:variables

}
