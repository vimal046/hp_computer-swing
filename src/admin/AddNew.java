package admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.AdminModel;
import pojo.*;

/**
 *
 * @author VIMAL SUKU
 */
public class AddNew extends javax.swing.JFrame {
    
    private String filePath;
    
    public AddNew() {
        initComponents();
        
    }
    
    public void addNewObject() {
        String productName = combobox.getSelectedItem().toString();
        if (productName.equals("Laptop")) {
            List<LaptopPOJO> list = new ArrayList<>();
            list.add(new LaptopPOJO(Integer.parseInt(price.getText()), modelNo.getText(), screenSize.getText(), processor.getText(), operatingSystem.getText(), ram.getText(), hardDisk.getText(), Integer.parseInt(price.getText()), imageLocation.getText()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        laptopPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        modelNo = new javax.swing.JTextField();
        screenSize = new javax.swing.JTextField();
        processor = new javax.swing.JTextField();
        operatingSystem = new javax.swing.JTextField();
        ram = new javax.swing.JTextField();
        hardDisk = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        desktopPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        deskModelNo = new javax.swing.JTextField();
        deskScreenSize = new javax.swing.JTextField();
        deskProcessor = new javax.swing.JTextField();
        deskOperatingSystem = new javax.swing.JTextField();
        deskRam = new javax.swing.JTextField();
        deskHardDisk = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        deskPrice = new javax.swing.JTextField();
        printerPanel = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        printer_modelNo = new javax.swing.JTextField();
        printer_Functions = new javax.swing.JTextField();
        printer_Colours = new javax.swing.JTextField();
        printerTechnology = new javax.swing.JTextField();
        printerWirelessCapability = new javax.swing.JTextField();
        printer_Volume = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        printerPrice = new javax.swing.JTextField();
        keyboardPanel = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        keyboardConnectivity = new javax.swing.JTextField();
        keyboardRequirments = new javax.swing.JTextField();
        keyboardColour = new javax.swing.JTextField();
        keyboardWarrenty = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        keyboardPrice = new javax.swing.JTextField();
        mousePanel = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        mouseModelNo = new javax.swing.JTextField();
        mouseConnectivity = new javax.swing.JTextField();
        mouseColour = new javax.swing.JTextField();
        mouseWarrenty = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        mousePrice = new javax.swing.JTextField();
        monitorPanel = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        monitorModelNo = new javax.swing.JTextField();
        monitorScreenSize = new javax.swing.JTextField();
        monitorResolution = new javax.swing.JTextField();
        monitorResponseTime = new javax.swing.JTextField();
        monitorDisplayColour = new javax.swing.JTextField();
        monitorDisplayFetures = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        monitorPrise = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        combobox = new javax.swing.JComboBox<>();
        browseButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        imageLocation = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        updateDatabase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(79, 192, 208));

        laptopPanel.setBackground(new java.awt.Color(79, 192, 208));
        laptopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Model no:");
        laptopPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, 20));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Screen Size:");
        laptopPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, 20));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Processor:");
        laptopPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 90, 20));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("OPerating System:");
        laptopPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 20));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("RAM:");
        laptopPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 20));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Hard Disk:");
        laptopPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 120, 20));

        modelNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(modelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 370, 30));

        screenSize.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(screenSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 370, 30));

        processor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(processor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 370, 30));

        operatingSystem.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(operatingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 370, 30));

        ram.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 370, 30));

        hardDisk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(hardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 370, 30));

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Price:");
        laptopPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 120, 20));

        price.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        laptopPanel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 370, 30));

        jTabbedPane1.addTab("tab1", laptopPanel);

        desktopPanel.setBackground(new java.awt.Color(79, 192, 208));
        desktopPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Model no:");
        desktopPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, 20));

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Screen Size:");
        desktopPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, 20));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Processor:");
        desktopPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 90, 20));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("OPerating System:");
        desktopPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 20));

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("RAM:");
        desktopPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 20));

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Hard Disk:");
        desktopPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 120, 20));

        deskModelNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskModelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 370, 30));

        deskScreenSize.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskScreenSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 370, 30));

        deskProcessor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskProcessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 370, 30));

        deskOperatingSystem.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskOperatingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 370, 30));

        deskRam.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 370, 30));

        deskHardDisk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskHardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 370, 30));

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Price:");
        desktopPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 120, 20));

        deskPrice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desktopPanel.add(deskPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 370, 30));

        jTabbedPane1.addTab("tab2", desktopPanel);

        printerPanel.setBackground(new java.awt.Color(79, 192, 208));
        printerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Model no:");
        printerPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, 20));

        jLabel31.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Functions:");
        printerPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 90, 20));

        jLabel32.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Print Colour:");
        printerPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 90, 20));

        jLabel33.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Print Technology:");
        printerPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 120, 20));

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Wirless Capability:");
        printerPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 120, 20));

        jLabel35.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Recommanded Volume:");
        printerPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 150, 20));

        printer_modelNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printer_modelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 370, 30));

        printer_Functions.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printer_Functions, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 370, 30));

        printer_Colours.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printer_Colours, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 370, 30));

        printerTechnology.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printerTechnology, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 370, 30));

        printerWirelessCapability.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printerWirelessCapability, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 370, 30));

        printer_Volume.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printer_Volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 370, 30));

        jLabel36.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Price:");
        printerPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 120, 20));

        printerPrice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printerPanel.add(printerPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 370, 30));

        jTabbedPane1.addTab("tab3", printerPanel);

        keyboardPanel.setBackground(new java.awt.Color(79, 192, 208));
        keyboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Connectivity:");
        keyboardPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 20));

        jLabel51.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Minimum System Requirments:");
        keyboardPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, 20));

        jLabel52.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Colour:");
        keyboardPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, 20));

        jLabel53.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Warrenty:");
        keyboardPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 120, 20));

        keyboardConnectivity.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboardPanel.add(keyboardConnectivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 370, 30));

        keyboardRequirments.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboardPanel.add(keyboardRequirments, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 370, 30));

        keyboardColour.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboardPanel.add(keyboardColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 370, 30));

        keyboardWarrenty.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboardPanel.add(keyboardWarrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 370, 30));

        jLabel56.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Price:");
        keyboardPanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 120, 20));

        keyboardPrice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboardPanel.add(keyboardPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 370, 30));

        jTabbedPane1.addTab("tab5", keyboardPanel);

        mousePanel.setBackground(new java.awt.Color(79, 192, 208));
        mousePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Model no:");
        mousePanel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        jLabel61.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Connectivity:");
        mousePanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 90, 20));

        jLabel62.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Colour:");
        mousePanel.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 90, 20));

        jLabel63.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Warrenty:");
        mousePanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 120, 20));

        mouseModelNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mousePanel.add(mouseModelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 370, 30));

        mouseConnectivity.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mousePanel.add(mouseConnectivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 370, 30));

        mouseColour.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mousePanel.add(mouseColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 370, 30));

        mouseWarrenty.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mousePanel.add(mouseWarrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 370, 30));

        jLabel66.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Price:");
        mousePanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 120, 20));

        mousePrice.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mousePanel.add(mousePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 370, 30));

        jTabbedPane1.addTab("tab6", mousePanel);

        monitorPanel.setBackground(new java.awt.Color(79, 192, 208));
        monitorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Model no:");
        monitorPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, 20));

        jLabel40.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Screen Size:");
        monitorPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, 20));

        jLabel41.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Resolution:");
        monitorPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 90, 20));

        jLabel42.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Response Time:");
        monitorPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 20));

        jLabel43.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Display Colours:");
        monitorPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 20));

        jLabel44.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Display Features:");
        monitorPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 120, 20));

        monitorModelNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorModelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 370, 30));

        monitorScreenSize.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorScreenSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 370, 30));

        monitorResolution.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorResolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 370, 30));

        monitorResponseTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorResponseTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 370, 30));

        monitorDisplayColour.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorDisplayColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 370, 30));

        monitorDisplayFetures.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorDisplayFetures, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 370, 30));

        jLabel45.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Price:");
        monitorPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 120, 20));

        monitorPrise.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitorPanel.add(monitorPrise, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 370, 30));

        jTabbedPane1.addTab("tab3", monitorPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 750, 510));

        jPanel8.setBackground(new java.awt.Color(79, 192, 208));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combobox.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        combobox.setForeground(new java.awt.Color(0, 0, 0));
        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Monitor", "Printer", "Mouse", "Keyboard" }));
        combobox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });
        jPanel8.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 187, 30));

        browseButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        jPanel8.add(browseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, -1, 30));

        uploadButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        jPanel8.add(uploadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, -1, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Upload picture:");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 120, 20));

        imageLocation.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jPanel8.add(imageLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 210, 30));

        cancelButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel8.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 140, 30));

        updateDatabase.setBackground(new java.awt.Color(88, 163, 153));
        updateDatabase.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateDatabase.setForeground(new java.awt.Color(0, 0, 0));
        updateDatabase.setText("Update Database");
        updateDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDatabaseActionPerformed(evt);
            }
        });
        jPanel8.add(updateDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 140, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        String imageName = imageLocation.getText();
        String fileName = "C:\\Users\\VIMAL SUKU\\Downloads" + "\\" + imageName;
        String folderPath = "C:\\Users\\VIMAL SUKU\\Documents\\images";
        
        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an image to upload.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        filePath = "C:/Users/VIMAL SUKU/Documents/images" + "/" + imageName;
        
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        
        File sourceFile = new File(fileName);
        if (!sourceFile.exists()) {
            JOptionPane.showMessageDialog(this, "Selected file does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Path source = sourceFile.toPath();
            Path destination = Paths.get(filePath);
            Files.copy(source, destination);
            JOptionPane.showMessageDialog(this, "Image imported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error importing image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_uploadButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imageLocation.setText(selectedFile.getName());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void updateDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDatabaseActionPerformed
        String selected = (String) combobox.getSelectedItem();
        switch (selected) {
            case "Laptop":
                List<LaptopPOJO> list = new ArrayList<>();
                list.add(new LaptopPOJO(modelNo.getText(), screenSize.getText(), processor.getText(), operatingSystem.getText(), ram.getText(), hardDisk.getText(), Integer.parseInt(price.getText()), filePath));
                new AdminModel().newLaptopObj(list);
                break;
            case "Desktop":
                List<DesktopPOJO> deskList = new ArrayList<>();
                deskList.add(new DesktopPOJO(deskModelNo.getText(), deskScreenSize.getText(), deskProcessor.getText(), deskOperatingSystem.getText(), deskRam.getText(), deskHardDisk.getText(), filePath, Integer.parseInt(deskPrice.getText())));
                new AdminModel().newDesktopObj(deskList);
                break;
            case "Monitor":
                List<MonitorPOJO> monitorList = new ArrayList<>();
                monitorList.add(new MonitorPOJO(monitorModelNo.getText(), monitorScreenSize.getText(), monitorResolution.getText(), monitorResponseTime.getText(), monitorDisplayColour.getText(), monitorDisplayFetures.getText(), Integer.parseInt(monitorPrise.getText()), filePath));
                new AdminModel().newMonitorObj(monitorList);
                break;
            case "Printer":
                
                List<PrinterPOJO> printerList = new ArrayList<>();
                printerList.add(new PrinterPOJO(printer_modelNo.getText(), printer_Functions.getText(), printer_Colours.getText(), printerTechnology.getText(), printerWirelessCapability.getText(), printer_Volume.getText(), Integer.parseInt(printerPrice.getText()), filePath));
                new AdminModel().newPrinterObj(printerList);
                
                break;
            case "Mouse":
                
                List<MousePOJO> mouseList = new ArrayList<>();
                mouseList.add(new MousePOJO(mouseModelNo.getText(), mouseConnectivity.getText(), mouseColour.getText(), mouseWarrenty.getText(), Integer.parseInt(mousePrice.getText()), filePath));
                new AdminModel().newMouseObj(mouseList);
                break;
            case "Keyboard":
                List<KeyboardPOJO> keyboardList = new ArrayList<>();
                keyboardList.add(new KeyboardPOJO(keyboardConnectivity.getText(), keyboardRequirments.getText(), keyboardColour.getText(), keyboardWarrenty.getText(), Integer.parseInt(keyboardPrice.getText()), filePath));
                new AdminModel().newKeyboardObj(keyboardList);
                break;
        }
    }//GEN-LAST:event_updateDatabaseActionPerformed

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        String selected = (String) combobox.getSelectedItem();
        
        switch (selected) {
            case "Laptop":
                jTabbedPane1.setSelectedIndex(0);
                break;
            case "Desktop":
                jTabbedPane1.setSelectedIndex(1);
                break;
            case "Monitor":
                jTabbedPane1.setSelectedIndex(5);
                break;
            case "Printer":
                jTabbedPane1.setSelectedIndex(2);
                break;
            case "Mouse":
                jTabbedPane1.setSelectedIndex(4);
                break;
            case "Keyboard":
                jTabbedPane1.setSelectedIndex(3);
                break;
        }
    }//GEN-LAST:event_comboboxActionPerformed

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
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JTextField deskHardDisk;
    private javax.swing.JTextField deskModelNo;
    private javax.swing.JTextField deskOperatingSystem;
    private javax.swing.JTextField deskPrice;
    private javax.swing.JTextField deskProcessor;
    private javax.swing.JTextField deskRam;
    private javax.swing.JTextField deskScreenSize;
    private javax.swing.JPanel desktopPanel;
    private javax.swing.JTextField hardDisk;
    private javax.swing.JTextField imageLocation;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField keyboardColour;
    private javax.swing.JTextField keyboardConnectivity;
    private javax.swing.JPanel keyboardPanel;
    private javax.swing.JTextField keyboardPrice;
    private javax.swing.JTextField keyboardRequirments;
    private javax.swing.JTextField keyboardWarrenty;
    private javax.swing.JPanel laptopPanel;
    private javax.swing.JTextField modelNo;
    private javax.swing.JTextField monitorDisplayColour;
    private javax.swing.JTextField monitorDisplayFetures;
    private javax.swing.JTextField monitorModelNo;
    private javax.swing.JPanel monitorPanel;
    private javax.swing.JTextField monitorPrise;
    private javax.swing.JTextField monitorResolution;
    private javax.swing.JTextField monitorResponseTime;
    private javax.swing.JTextField monitorScreenSize;
    private javax.swing.JTextField mouseColour;
    private javax.swing.JTextField mouseConnectivity;
    private javax.swing.JTextField mouseModelNo;
    private javax.swing.JPanel mousePanel;
    private javax.swing.JTextField mousePrice;
    private javax.swing.JTextField mouseWarrenty;
    private javax.swing.JTextField operatingSystem;
    private javax.swing.JTextField price;
    private javax.swing.JPanel printerPanel;
    private javax.swing.JTextField printerPrice;
    private javax.swing.JTextField printerTechnology;
    private javax.swing.JTextField printerWirelessCapability;
    private javax.swing.JTextField printer_Colours;
    private javax.swing.JTextField printer_Functions;
    private javax.swing.JTextField printer_Volume;
    private javax.swing.JTextField printer_modelNo;
    private javax.swing.JTextField processor;
    private javax.swing.JTextField ram;
    private javax.swing.JTextField screenSize;
    private javax.swing.JButton updateDatabase;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
