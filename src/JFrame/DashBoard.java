package JFrame;

import admin.AdminAuthendication;
import java.awt.*;
import javax.swing.*;
import model.*;
import pojo.*;
import controller.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Stack;

/**
 *
 * @author VIMAL SUKU
 */
public class DashBoard extends javax.swing.JFrame {

    Color clickedColor, defaultColor;
    LaptopController lapController;
    DesktopController deskController;
    KeyboardController keyboardController;
    MonitorController monitorController;
    PrintController printController;
    MouseController mouseController;
    Stack<BillPair> stack;

    //Constructor
    public DashBoard() {
        clickedColor = new Color(103, 198, 227);
        defaultColor = new Color(54, 70, 78);
        lapController = new LaptopController();
        deskController = new DesktopController();
        keyboardController = new KeyboardController();
        monitorController = new MonitorController();
        printController = new PrintController();
        mouseController = new MouseController();
        stack = new Stack<>();
        initComponents();
//        billReceipt();
        laptopObj(0);
        desktopObj(0);
        keyboardObj(0);
        monitorObj(0);
        printObj(0);
        mouseObj(0);

    }

    public void billReceipt(String name, int price) {
        BillPair newPair = new BillPair(name, price);

        boolean isDuplicate = false;
        for (BillPair pair : stack) {
            if (pair.getName().equals(name) && pair.getPrice() == price) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            String[] dateTime = dateAndTime();
            stack.add(newPair);
            dashboard_TextArea.setText("");

            dashboard_TextArea.setEditable(false);
            dashboard_TextArea.append("\n\t                  Hp Computer  & Accessories\t\n\n\n");
            dashboard_TextArea.append("\tDate:" + dateTime[0] + " \t    Time:" + dateTime[1] + " \n\n");
            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");
            dashboard_TextArea.append("   No.\tName\t\t\tPrice\n");
            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");

            int itemNo = 1;
            int total = 0;
            for (BillPair pair : stack) {
                if (pair.getName().equals("Mouse(HP 240)") || pair.getName().equals("Mouse(HP 930)") || pair.getName().equals("Mouse(HP 410)") || pair.getName().equals("Keyboard(USB)")) {
                    dashboard_TextArea.append("   " + itemNo + "\t" + pair.getName() + "\t\t\t" + pair.getPrice() + "\n");
                } else {
                    dashboard_TextArea.append("   " + itemNo + "\t" + pair.getName() + "\t\t" + pair.getPrice() + "\n");
                }

                itemNo++;
                total += pair.getPrice();
            }

            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");
            dashboard_TextArea.append("\t\t\tGrand Total :\t" + total + " \n");
            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");
            grandTotal_Label.setText(total + "");
        }

    }

    public void removeCart() {
        if (!stack.isEmpty()) {
            stack.pop();
            String[] dateTime = dateAndTime();
            dashboard_TextArea.setText("");
            dashboard_TextArea.setEditable(false);
            dashboard_TextArea.append("\n\t                  Hp Computer  & Accessories\t\n\n\n");
            dashboard_TextArea.append("\tDate:" + dateTime[0] + " \t    Time:" + dateTime[1] + " \n\n");
            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");
            dashboard_TextArea.append("   No.\tName\t\t\tPrice\n");
            dashboard_TextArea.append("----------------------------------------------------------------------------------------------------\n");

            int itemNo = 1;
            int total = 0;
            for (BillPair pair : stack) {
                if (pair.getName().equals("Mouse(HP 240)") || pair.getName().equals("Mouse(HP 930)") || pair.getName().equals("Mouse(HP 410)") || pair.getName().equals("Keyboard(USB)")) {
                    dashboard_TextArea.append("   " + itemNo + "\t" + pair.getName() + "\t\t\t" + pair.getPrice() + "\n");
                } else {
                    dashboard_TextArea.append("   " + itemNo + "\t" + pair.getName() + "\t\t" + pair.getPrice() + "\n");
                }
                itemNo++;
                total += pair.getPrice();
            }

            dashboard_TextArea.append("-----------------------------------------------------------------------------------------------------------------\n");
            dashboard_TextArea.append("\t\tGrand Total :\t\t" + total + " \n");
            dashboard_TextArea.append("-----------------------------------------------------------------------------------------------------------------\n");
            grandTotal_Label.setText(total + "");
            if (stack.isEmpty()) {
                dashboard_TextArea.setText("");
            }

        }

    }

    private String[] dateAndTime() {

        Date now = new Date();

        SimpleDateFormat fDate = new SimpleDateFormat("dd-MM-yyyy ");
        SimpleDateFormat fTime = new SimpleDateFormat("h:mm:ss aa");
        String date = fDate.format(now);
        String time = fTime.format(now);

        return new String[]{date, time};
    }

    public void laptopObj(int index) {
        LaptopPOJO obj = lapController.lapObject(index);

        switch (obj.getLaptopId()) {
            case 1500:
            case 1501:
            case 1502:
            case 1503:
            case 1504:
                ImageIcon icon1 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img1 = icon1.getImage().getScaledInstance(laptop_Pic.getWidth(), laptop_Pic.getHeight(), Image.SCALE_SMOOTH);
                laptop_Pic.setIcon(new ImageIcon(img1));
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon2 = new ImageIcon(imagePath);
                Image img2 = icon2.getImage().getScaledInstance(laptop_Pic.getWidth(), laptop_Pic.getHeight(), Image.SCALE_SMOOTH);
                laptop_Pic.setIcon(new ImageIcon(img2));

        }

        modelNo.setText(obj.getModelNo());
        screenSize.setText(obj.getScreenSize());
        processor.setText(obj.getProcessor());
        operatingSystem.setText(obj.getOperatingSystem());
        ram.setText(obj.getRam());
        hardDisk.setText(obj.getHardDisk());
        price.setText(obj.getPrice() + "");

    }

    public void desktopObj(int index) {
        DesktopPOJO obj = deskController.desktopObj(index);

        switch (obj.getDesktopId()) {
            case 1600:
            case 1601:
            case 1602:
            case 1603:
            case 1604:
                ImageIcon icon2 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img2 = icon2.getImage().getScaledInstance(desktop_Pic.getWidth(), desktop_Pic.getHeight(), Image.SCALE_SMOOTH);
                desktop_Pic.setIcon(new ImageIcon(img2));
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon1 = new ImageIcon(imagePath);
                Image img1 = icon1.getImage().getScaledInstance(desktop_Pic.getWidth(), desktop_Pic.getHeight(), Image.SCALE_SMOOTH);
                desktop_Pic.setIcon(new ImageIcon(img1));

        }

        model_Desk.setText(obj.getModelNo());
        screenSize_Desk.setText(obj.getScreenSize());
        processor_Desk.setText(obj.getProcessor());
        operatingSystem_Desk.setText(obj.getOperatingSystem());
        ram_Desk.setText(obj.getRam());
        hardDisk_Desk.setText(obj.getHardDisk());
        price_Desk.setText(obj.getPrice() + "");
    }

    public void keyboardObj(int index) {
        KeyboardPOJO obj = keyboardController.keyboardObj(index);

        switch (obj.getKeyboardId()) {
            case 1900:
            case 1901:
            case 1902:
            case 1903:
            case 1904:
                ImageIcon icon6 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img6 = icon6.getImage().getScaledInstance(keyboard_Pic.getWidth(), keyboard_Pic.getHeight(), Image.SCALE_SMOOTH);
                keyboard_Pic.setIcon(new ImageIcon(img6));
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon1 = new ImageIcon(imagePath);
                Image img1 = icon1.getImage().getScaledInstance(keyboard_Pic.getWidth(), keyboard_Pic.getHeight(), Image.SCALE_SMOOTH);
                keyboard_Pic.setIcon(new ImageIcon(img1));

        }

        keyboard_Connectivity.setText(obj.getConnectivity());
        keyboard_MinReq.setText(obj.getSystemRequirments());
        keyboard_Color.setText(obj.getColor());
        keyboard_Warrenty.setText(obj.getWarrenty());
        keyboard_Price.setText(obj.getPrice() + "");
    }

    public void monitorObj(int index) {
        MonitorPOJO obj = monitorController.monitorObj(index);

        switch (obj.getMonitorId()) {
            case 1800:
            case 1801:
            case 1802:
            case 1803:           
                ImageIcon icon4 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img4 = icon4.getImage().getScaledInstance(monitor_Pic.getWidth(), monitor_Pic.getHeight(), Image.SCALE_SMOOTH);
                monitor_Pic.setIcon(new ImageIcon(img4));
                ;
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon1 = new ImageIcon(imagePath);
                Image img1 = icon1.getImage().getScaledInstance(monitor_Pic.getWidth(), monitor_Pic.getHeight(), Image.SCALE_SMOOTH);
                monitor_Pic.setIcon(new ImageIcon(img1));

        }

        model_Monitor.setText(obj.getModelNo());
        screenSize_Monitor.setText(obj.getScreenSize());
        resolution_Monitor.setText(obj.getResolution());
        responseTime_Monitor.setText(obj.getResponseTime());
        displayColors_Monitor.setText(obj.getDisplayColors());
        displayFeatures_Monitor.setText(obj.getDisplayFeatures());
        price_Monitor.setText(obj.getPrice() + "");
    }

    public void printObj(int index) {
        PrinterPOJO obj = printController.printerObj(index);

        switch (obj.getPrinterId()) {
            case 1700:
            case 1701:
            case 1702:
            case 1703:
            case 1704:
                ImageIcon icon3 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img3 = icon3.getImage().getScaledInstance(printer_Pic.getWidth(), printer_Pic.getHeight(), Image.SCALE_SMOOTH);
                printer_Pic.setIcon(new ImageIcon(img3));
                ;
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon1 = new ImageIcon(imagePath);
                Image img1 = icon1.getImage().getScaledInstance(printer_Pic.getWidth(), printer_Pic.getHeight(), Image.SCALE_SMOOTH);
                printer_Pic.setIcon(new ImageIcon(img1));

        }

        model_Printers.setText(obj.getModelNo());
        function_Printer.setText(obj.getFunctions());
        colors_Print.setText(obj.getPrintColours());
        technology_Printer.setText(obj.getPrintTechnology());
        wirelessCapability_Print.setText(obj.getWirelessCapability());
        mVolume_Printer.setText(obj.getMonthlyVolume());
        price_Printer.setText(obj.getPrice() + "");
    }

    public void mouseObj(int index) {
        MousePOJO obj = mouseController.mouseObj(index);

        switch (obj.getMouseId()) {
            case 1900:
            case 1901:
            case 1902:
            case 1903:
            case 1904:
                ImageIcon icon5 = new ImageIcon(getClass().getResource(obj.getImageLocation()));
                Image img5 = icon5.getImage().getScaledInstance(mouse_Pic.getWidth(), mouse_Pic.getHeight(), Image.SCALE_SMOOTH);
                mouse_Pic.setIcon(new ImageIcon(img5));
                ;
                break;
            default:
                String imagePath = obj.getImageLocation();
                ImageIcon icon1 = new ImageIcon(imagePath);
                Image img1 = icon1.getImage().getScaledInstance(mouse_Pic.getWidth(), mouse_Pic.getHeight(), Image.SCALE_SMOOTH);
                mouse_Pic.setIcon(new ImageIcon(img1));

        }

        model_Mouse.setText(obj.getModelNo());
        connectivity_Mouse.setText(obj.getConnectivity());
        color_Mouse.setText(obj.getColor());
        warrenty_Mouse.setText(obj.getWarrenty());
        price_Mouse.setText(obj.getPrice() + "");
    }

    //System generated code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        laptop_Panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        laptop_Pic = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        modelNo = new javax.swing.JLabel();
        screenSize = new javax.swing.JLabel();
        processor = new javax.swing.JLabel();
        operatingSystem = new javax.swing.JLabel();
        ram = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        hardDisk = new javax.swing.JLabel();
        next_Button = new javax.swing.JButton();
        previou_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lap_Add_Button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lap_Remove_Button = new javax.swing.JButton();
        desktop_Panel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        desktop_Pic = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        model_Desk = new javax.swing.JLabel();
        screenSize_Desk = new javax.swing.JLabel();
        processor_Desk = new javax.swing.JLabel();
        operatingSystem_Desk = new javax.swing.JLabel();
        ram_Desk = new javax.swing.JLabel();
        price_Desk = new javax.swing.JLabel();
        hardDisk_Desk = new javax.swing.JLabel();
        desktop_Next_Button = new javax.swing.JButton();
        desktop_Previous_Button = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        desk_Add_Button = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        desk_Remove_Button = new javax.swing.JButton();
        printors_Panel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        printer_Pic = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        model_Printers = new javax.swing.JLabel();
        function_Printer = new javax.swing.JLabel();
        colors_Print = new javax.swing.JLabel();
        technology_Printer = new javax.swing.JLabel();
        wirelessCapability_Print = new javax.swing.JLabel();
        price_Printer = new javax.swing.JLabel();
        mVolume_Printer = new javax.swing.JLabel();
        printer_Next_Button = new javax.swing.JButton();
        printer_Previous_Button = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        printer_Add_Button2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        printer_Remove_Button2 = new javax.swing.JButton();
        monitors_Panel = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        monitor_Pic = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        model_Monitor = new javax.swing.JLabel();
        screenSize_Monitor = new javax.swing.JLabel();
        resolution_Monitor = new javax.swing.JLabel();
        responseTime_Monitor = new javax.swing.JLabel();
        displayColors_Monitor = new javax.swing.JLabel();
        price_Monitor = new javax.swing.JLabel();
        displayFeatures_Monitor = new javax.swing.JLabel();
        monitor_Next_Button = new javax.swing.JButton();
        monitor_Previous_Button = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        monitor_Add_Button = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        monitor_Remove_Button = new javax.swing.JButton();
        mouse_Panel = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        mouse_Pic = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        model_Mouse = new javax.swing.JLabel();
        connectivity_Mouse = new javax.swing.JLabel();
        color_Mouse = new javax.swing.JLabel();
        warrenty_Mouse = new javax.swing.JLabel();
        price_Mouse = new javax.swing.JLabel();
        mouse_Next_Button = new javax.swing.JButton();
        mouse_Previous_Button = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        mouse_Add_Button = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        mouse_Remove_Button = new javax.swing.JButton();
        keyboard_Panel = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        keyboard_Pic = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        keyboard_Connectivity = new javax.swing.JLabel();
        keyboard_MinReq = new javax.swing.JLabel();
        keyboard_Color = new javax.swing.JLabel();
        keyboard_Warrenty = new javax.swing.JLabel();
        keyboard_Price = new javax.swing.JLabel();
        keyBoard_Next_Button = new javax.swing.JButton();
        keyBoard_Previous_Button = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        keyboard_Add_Button = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        keyboard_Remove_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dashboard_TextArea = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jPanel_L = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel_D = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel_P = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel_Mon = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel_Mou = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel_Key = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        grandTotal_Label = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        placeOrder_Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        custName_Label = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        custMobile_Label = new javax.swing.JTextField();
        logoutButton = new javax.swing.JButton();
        adminPageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 70, 78));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hp ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 234, 25));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Computer & Accessories");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, 250, 25));

        laptop_Panel.setBackground(new java.awt.Color(223, 245, 255));
        laptop_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Laptops");
        laptop_Panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 192, 36));

        laptop_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        laptop_Panel.add(laptop_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 372, 234));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Model No:");
        laptop_Panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Screen Size:");
        laptop_Panel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 107, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Operating System:");
        laptop_Panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Processor:");
        laptop_Panel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Hard Disk:");
        laptop_Panel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 117, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("RAM:");
        laptop_Panel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 117, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Price:");
        laptop_Panel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 670, 117, -1));

        modelNo.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        modelNo.setForeground(new java.awt.Color(13, 146, 118));
        modelNo.setText("15s-fr5010TU ");
        laptop_Panel.add(modelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 140, -1));

        screenSize.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        screenSize.setForeground(new java.awt.Color(13, 146, 118));
        screenSize.setText("39.6 cm (15.6) diagonal FHD display with Intel® Iris® Xᵉ Graphics ");
        laptop_Panel.add(screenSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 550, -1));

        processor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        processor.setForeground(new java.awt.Color(13, 146, 118));
        processor.setText("12th Generation Intel® Core™ i5 processor ");
        laptop_Panel.add(processor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 384, -1));

        operatingSystem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        operatingSystem.setForeground(new java.awt.Color(13, 146, 118));
        operatingSystem.setText("Windows 11 Home Single Language ");
        laptop_Panel.add(operatingSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 384, -1));

        ram.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ram.setForeground(new java.awt.Color(13, 146, 118));
        ram.setText("8 GB DDR4 ");
        laptop_Panel.add(ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 384, -1));

        price.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        price.setForeground(new java.awt.Color(13, 146, 118));
        price.setText("60999 ");
        laptop_Panel.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 670, 384, -1));

        hardDisk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        hardDisk.setForeground(new java.awt.Color(13, 146, 118));
        hardDisk.setText("512 GB SSD Hard drive ");
        laptop_Panel.add(hardDisk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 384, -1));

        next_Button.setBackground(new java.awt.Color(65, 201, 226));
        next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        next_Button.setForeground(new java.awt.Color(0, 0, 0));
        next_Button.setText("Next");
        next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        next_Button.setFocusPainted(false);
        next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_ButtonActionPerformed(evt);
            }
        });
        laptop_Panel.add(next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 790, 120, 30));

        previou_Button.setBackground(new java.awt.Color(65, 201, 226));
        previou_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        previou_Button.setForeground(new java.awt.Color(0, 0, 0));
        previou_Button.setText("Previous");
        previou_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        previou_Button.setFocusPainted(false);
        previou_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previou_ButtonActionPerformed(evt);
            }
        });
        laptop_Panel.add(previou_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 120, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("Add To Cart:");
        laptop_Panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        lap_Add_Button.setBackground(new java.awt.Color(13, 146, 118));
        lap_Add_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lap_Add_Button.setForeground(new java.awt.Color(0, 0, 0));
        lap_Add_Button.setText("Add");
        lap_Add_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lap_Add_Button.setFocusPainted(false);
        lap_Add_Button.setFocusable(false);
        lap_Add_Button.setRequestFocusEnabled(false);
        lap_Add_Button.setRolloverEnabled(false);
        lap_Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_Add_ButtonActionPerformed(evt);
            }
        });
        laptop_Panel.add(lap_Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("Remove From Cart:");
        laptop_Panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        lap_Remove_Button.setBackground(new java.awt.Color(255, 32, 78));
        lap_Remove_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lap_Remove_Button.setForeground(new java.awt.Color(0, 0, 0));
        lap_Remove_Button.setText("Remove");
        lap_Remove_Button.setBorder(null);
        lap_Remove_Button.setFocusPainted(false);
        lap_Remove_Button.setFocusable(false);
        lap_Remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lap_Remove_ButtonActionPerformed(evt);
            }
        });
        laptop_Panel.add(lap_Remove_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab1", laptop_Panel);

        desktop_Panel.setBackground(new java.awt.Color(255, 243, 199));
        desktop_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Desktop");
        desktop_Panel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 192, 36));

        desktop_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        desktop_Panel.add(desktop_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 372, 234));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(64, 103, 158));
        jLabel31.setText("Model No:");
        desktop_Panel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(64, 103, 158));
        jLabel32.setText("Screen Size:");
        desktop_Panel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 107, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(64, 103, 158));
        jLabel33.setText("Operating System:");
        desktop_Panel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(64, 103, 158));
        jLabel34.setText("Processor:");
        desktop_Panel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(64, 103, 158));
        jLabel35.setText("Hard Disk:");
        desktop_Panel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 117, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(64, 103, 158));
        jLabel36.setText("RAM:");
        desktop_Panel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 117, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(64, 103, 158));
        jLabel37.setText("Price:");
        desktop_Panel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 670, 117, -1));

        model_Desk.setBackground(new java.awt.Color(255, 243, 199));
        model_Desk.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        model_Desk.setForeground(new java.awt.Color(13, 146, 118));
        model_Desk.setText("15s-fr5010TU ");
        desktop_Panel.add(model_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 140, -1));

        screenSize_Desk.setBackground(new java.awt.Color(255, 243, 199));
        screenSize_Desk.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        screenSize_Desk.setForeground(new java.awt.Color(13, 146, 118));
        screenSize_Desk.setText("39.6 cm (15.6) diagonal FHD display with Intel® Iris® Xᵉ Graphics ");
        desktop_Panel.add(screenSize_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 550, -1));

        processor_Desk.setBackground(new java.awt.Color(255, 243, 199));
        processor_Desk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        processor_Desk.setForeground(new java.awt.Color(13, 146, 118));
        processor_Desk.setText("12th Generation Intel® Core™ i5 processor ");
        desktop_Panel.add(processor_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 384, -1));

        operatingSystem_Desk.setBackground(new java.awt.Color(255, 243, 199));
        operatingSystem_Desk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        operatingSystem_Desk.setForeground(new java.awt.Color(13, 146, 118));
        operatingSystem_Desk.setText("Windows 11 Home Single Language ");
        desktop_Panel.add(operatingSystem_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 384, -1));

        ram_Desk.setBackground(new java.awt.Color(255, 243, 199));
        ram_Desk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ram_Desk.setForeground(new java.awt.Color(13, 146, 118));
        ram_Desk.setText("8 GB DDR4 ");
        desktop_Panel.add(ram_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 384, -1));

        price_Desk.setBackground(new java.awt.Color(255, 243, 199));
        price_Desk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        price_Desk.setForeground(new java.awt.Color(13, 146, 118));
        price_Desk.setText("60999 ");
        desktop_Panel.add(price_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 670, 384, -1));

        hardDisk_Desk.setBackground(new java.awt.Color(255, 243, 199));
        hardDisk_Desk.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        hardDisk_Desk.setForeground(new java.awt.Color(13, 146, 118));
        hardDisk_Desk.setText("512 GB SSD Hard drive ");
        desktop_Panel.add(hardDisk_Desk, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 384, -1));

        desktop_Next_Button.setBackground(new java.awt.Color(65, 201, 226));
        desktop_Next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        desktop_Next_Button.setForeground(new java.awt.Color(0, 0, 0));
        desktop_Next_Button.setText("Next");
        desktop_Next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktop_Next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desktop_Next_ButtonActionPerformed(evt);
            }
        });
        desktop_Panel.add(desktop_Next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 790, 120, 30));

        desktop_Previous_Button.setBackground(new java.awt.Color(65, 201, 226));
        desktop_Previous_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        desktop_Previous_Button.setForeground(new java.awt.Color(0, 0, 0));
        desktop_Previous_Button.setText("Previous");
        desktop_Previous_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktop_Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desktop_Previous_ButtonActionPerformed(evt);
            }
        });
        desktop_Panel.add(desktop_Previous_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 120, 30));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 51));
        jLabel23.setText("Add To Cart:");
        desktop_Panel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        desk_Add_Button.setBackground(new java.awt.Color(13, 146, 118));
        desk_Add_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desk_Add_Button.setForeground(new java.awt.Color(0, 0, 0));
        desk_Add_Button.setText("Add");
        desk_Add_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        desk_Add_Button.setFocusable(false);
        desk_Add_Button.setOpaque(true);
        desk_Add_Button.setRequestFocusEnabled(false);
        desk_Add_Button.setRolloverEnabled(false);
        desk_Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desk_Add_ButtonActionPerformed(evt);
            }
        });
        desktop_Panel.add(desk_Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 0, 51));
        jLabel25.setText("Remove From Cart:");
        desktop_Panel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        desk_Remove_Button.setBackground(new java.awt.Color(255, 32, 78));
        desk_Remove_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        desk_Remove_Button.setForeground(new java.awt.Color(0, 0, 0));
        desk_Remove_Button.setText("Remove");
        desk_Remove_Button.setBorder(null);
        desk_Remove_Button.setFocusPainted(false);
        desk_Remove_Button.setFocusable(false);
        desk_Remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desk_Remove_ButtonActionPerformed(evt);
            }
        });
        desktop_Panel.add(desk_Remove_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab2", desktop_Panel);

        printors_Panel.setBackground(new java.awt.Color(255, 250, 244));
        printors_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Printers");
        printors_Panel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 192, 36));

        printer_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        printors_Panel.add(printer_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 372, 234));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(64, 103, 158));
        jLabel46.setText("Model No:");
        printors_Panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(64, 103, 158));
        jLabel47.setText("Functions:");
        printors_Panel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 107, -1));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(64, 103, 158));
        jLabel48.setText("Print Technology:");
        printors_Panel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(64, 103, 158));
        jLabel49.setText("Print Colours:");
        printors_Panel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(64, 103, 158));
        jLabel50.setText("Monthly Volume:");
        printors_Panel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 117, -1));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(64, 103, 158));
        jLabel51.setText("Wireless Capability:");
        printors_Panel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 150, -1));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(64, 103, 158));
        jLabel52.setText("Price:");
        printors_Panel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 670, 117, -1));

        model_Printers.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        model_Printers.setForeground(new java.awt.Color(13, 146, 118));
        model_Printers.setText("15s-fr5010TU ");
        printors_Panel.add(model_Printers, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 140, -1));

        function_Printer.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        function_Printer.setForeground(new java.awt.Color(13, 146, 118));
        function_Printer.setText("print,copy,scan");
        printors_Panel.add(function_Printer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 550, -1));

        colors_Print.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        colors_Print.setForeground(new java.awt.Color(13, 146, 118));
        colors_Print.setText("Yes");
        printors_Panel.add(colors_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 384, -1));

        technology_Printer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        technology_Printer.setForeground(new java.awt.Color(13, 146, 118));
        technology_Printer.setText("HP Thermal Inject");
        printors_Panel.add(technology_Printer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 384, -1));

        wirelessCapability_Print.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        wirelessCapability_Print.setForeground(new java.awt.Color(13, 146, 118));
        wirelessCapability_Print.setText("Yes, built-in Wi-Fi 2.4G, Wi-Fi Direct");
        printors_Panel.add(wirelessCapability_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 384, -1));

        price_Printer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        price_Printer.setForeground(new java.awt.Color(13, 146, 118));
        price_Printer.setText("15549");
        printors_Panel.add(price_Printer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 670, 384, -1));

        mVolume_Printer.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        mVolume_Printer.setForeground(new java.awt.Color(13, 146, 118));
        mVolume_Printer.setText("400 to 800");
        printors_Panel.add(mVolume_Printer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 384, -1));

        printer_Next_Button.setBackground(new java.awt.Color(65, 201, 226));
        printer_Next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        printer_Next_Button.setForeground(new java.awt.Color(0, 0, 0));
        printer_Next_Button.setText("Next");
        printer_Next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        printer_Next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printer_Next_ButtonActionPerformed(evt);
            }
        });
        printors_Panel.add(printer_Next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 790, 120, 30));

        printer_Previous_Button.setBackground(new java.awt.Color(65, 201, 226));
        printer_Previous_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        printer_Previous_Button.setForeground(new java.awt.Color(0, 0, 0));
        printer_Previous_Button.setText("Previous");
        printer_Previous_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        printer_Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printer_Previous_ButtonActionPerformed(evt);
            }
        });
        printors_Panel.add(printer_Previous_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 120, 30));

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 0, 51));
        jLabel26.setText("Add To Cart:");
        printors_Panel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        printer_Add_Button2.setBackground(new java.awt.Color(13, 146, 118));
        printer_Add_Button2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printer_Add_Button2.setForeground(new java.awt.Color(0, 0, 0));
        printer_Add_Button2.setText("Add");
        printer_Add_Button2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        printer_Add_Button2.setFocusable(false);
        printer_Add_Button2.setOpaque(true);
        printer_Add_Button2.setRequestFocusEnabled(false);
        printer_Add_Button2.setRolloverEnabled(false);
        printer_Add_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printer_Add_Button2ActionPerformed(evt);
            }
        });
        printors_Panel.add(printer_Add_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 0, 51));
        jLabel27.setText("Remove From Cart:");
        printors_Panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        printer_Remove_Button2.setBackground(new java.awt.Color(255, 32, 78));
        printer_Remove_Button2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printer_Remove_Button2.setForeground(new java.awt.Color(0, 0, 0));
        printer_Remove_Button2.setText("Remove");
        printer_Remove_Button2.setBorder(null);
        printer_Remove_Button2.setFocusPainted(false);
        printer_Remove_Button2.setFocusable(false);
        printer_Remove_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printer_Remove_Button2ActionPerformed(evt);
            }
        });
        printors_Panel.add(printer_Remove_Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab3", printors_Panel);

        monitors_Panel.setBackground(new java.awt.Color(243, 204, 243));
        monitors_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Monitors");
        monitors_Panel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 192, 36));

        monitor_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        monitors_Panel.add(monitor_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 372, 234));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(64, 103, 158));
        jLabel61.setText("Model No:");
        monitors_Panel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(64, 103, 158));
        jLabel62.setText("Screen Size:");
        monitors_Panel.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 107, -1));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(64, 103, 158));
        jLabel63.setText("Response Time:");
        monitors_Panel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(64, 103, 158));
        jLabel64.setText("Resolution:");
        monitors_Panel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(64, 103, 158));
        jLabel65.setText("Display Features");
        monitors_Panel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 117, -1));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(64, 103, 158));
        jLabel66.setText("Display Colors:");
        monitors_Panel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 117, -1));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(64, 103, 158));
        jLabel67.setText("Price:");
        monitors_Panel.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 670, 117, -1));

        model_Monitor.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        model_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        model_Monitor.setText("HP V20 ");
        monitors_Panel.add(model_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 140, -1));

        screenSize_Monitor.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        screenSize_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        screenSize_Monitor.setText("49.53 cm (19.5) ");
        monitors_Panel.add(screenSize_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 550, -1));

        resolution_Monitor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        resolution_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        resolution_Monitor.setText("HD+ (1600 x 900) ");
        monitors_Panel.add(resolution_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 384, -1));

        responseTime_Monitor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        responseTime_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        responseTime_Monitor.setText("5ms on/off ");
        monitors_Panel.add(responseTime_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 384, -1));

        displayColors_Monitor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        displayColors_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        displayColors_Monitor.setText("Up to 16.7 million colors supported ");
        monitors_Panel.add(displayColors_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 384, -1));

        price_Monitor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        price_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        price_Monitor.setText("6299");
        monitors_Panel.add(price_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 670, 384, -1));

        displayFeatures_Monitor.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        displayFeatures_Monitor.setForeground(new java.awt.Color(13, 146, 118));
        displayFeatures_Monitor.setText("Anti-glare; Low blue light mode");
        monitors_Panel.add(displayFeatures_Monitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 540, -1));

        monitor_Next_Button.setBackground(new java.awt.Color(65, 201, 226));
        monitor_Next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        monitor_Next_Button.setForeground(new java.awt.Color(0, 0, 0));
        monitor_Next_Button.setText("Next");
        monitor_Next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        monitor_Next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor_Next_ButtonActionPerformed(evt);
            }
        });
        monitors_Panel.add(monitor_Next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 790, 120, 30));

        monitor_Previous_Button.setBackground(new java.awt.Color(65, 201, 226));
        monitor_Previous_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        monitor_Previous_Button.setForeground(new java.awt.Color(0, 0, 0));
        monitor_Previous_Button.setText("Previous");
        monitor_Previous_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        monitor_Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor_Previous_ButtonActionPerformed(evt);
            }
        });
        monitors_Panel.add(monitor_Previous_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 790, 120, 30));

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 0, 51));
        jLabel28.setText("Add To Cart:");
        monitors_Panel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        monitor_Add_Button.setBackground(new java.awt.Color(13, 146, 118));
        monitor_Add_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitor_Add_Button.setForeground(new java.awt.Color(0, 0, 0));
        monitor_Add_Button.setText("Add");
        monitor_Add_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        monitor_Add_Button.setFocusable(false);
        monitor_Add_Button.setOpaque(true);
        monitor_Add_Button.setRequestFocusEnabled(false);
        monitor_Add_Button.setRolloverEnabled(false);
        monitor_Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor_Add_ButtonActionPerformed(evt);
            }
        });
        monitors_Panel.add(monitor_Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel29.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 0, 51));
        jLabel29.setText("Remove From Cart:");
        monitors_Panel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        monitor_Remove_Button.setBackground(new java.awt.Color(255, 32, 78));
        monitor_Remove_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        monitor_Remove_Button.setForeground(new java.awt.Color(0, 0, 0));
        monitor_Remove_Button.setText("Remove");
        monitor_Remove_Button.setBorder(null);
        monitor_Remove_Button.setFocusPainted(false);
        monitor_Remove_Button.setFocusable(false);
        monitor_Remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitor_Remove_ButtonActionPerformed(evt);
            }
        });
        monitors_Panel.add(monitor_Remove_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab4", monitors_Panel);

        mouse_Panel.setBackground(new java.awt.Color(205, 250, 219));
        mouse_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Mouse");
        mouse_Panel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 192, 36));

        mouse_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mouse_Panel.add(mouse_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 372, 234));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(64, 103, 158));
        jLabel76.setText("Model No:");
        mouse_Panel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel77.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(64, 103, 158));
        jLabel77.setText("Connectivity:");
        mouse_Panel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 220, -1));

        jLabel78.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(64, 103, 158));
        jLabel78.setText("Warrenty:");
        mouse_Panel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(64, 103, 158));
        jLabel79.setText("Colour:");
        mouse_Panel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(64, 103, 158));
        jLabel81.setText("Price");
        mouse_Panel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 117, -1));

        model_Mouse.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        model_Mouse.setForeground(new java.awt.Color(26, 93, 26));
        model_Mouse.setText("HP M10 ");
        mouse_Panel.add(model_Mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 140, -1));

        connectivity_Mouse.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        connectivity_Mouse.setForeground(new java.awt.Color(26, 93, 26));
        connectivity_Mouse.setText("USB");
        mouse_Panel.add(connectivity_Mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 550, -1));

        color_Mouse.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        color_Mouse.setForeground(new java.awt.Color(26, 93, 26));
        color_Mouse.setText("Black");
        mouse_Panel.add(color_Mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 384, -1));

        warrenty_Mouse.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        warrenty_Mouse.setForeground(new java.awt.Color(26, 93, 26));
        warrenty_Mouse.setText("2 Years");
        mouse_Panel.add(warrenty_Mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 384, -1));

        price_Mouse.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        price_Mouse.setForeground(new java.awt.Color(26, 93, 26));
        price_Mouse.setText("4790");
        mouse_Panel.add(price_Mouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 384, -1));

        mouse_Next_Button.setBackground(new java.awt.Color(65, 201, 226));
        mouse_Next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mouse_Next_Button.setForeground(new java.awt.Color(0, 0, 0));
        mouse_Next_Button.setText("Next");
        mouse_Next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mouse_Next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouse_Next_ButtonActionPerformed(evt);
            }
        });
        mouse_Panel.add(mouse_Next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 700, 120, 30));

        mouse_Previous_Button.setBackground(new java.awt.Color(65, 201, 226));
        mouse_Previous_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        mouse_Previous_Button.setForeground(new java.awt.Color(0, 0, 0));
        mouse_Previous_Button.setText("Previous");
        mouse_Previous_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mouse_Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouse_Previous_ButtonActionPerformed(evt);
            }
        });
        mouse_Panel.add(mouse_Previous_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, 120, 30));

        jLabel30.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 0, 51));
        jLabel30.setText("Add To Cart:");
        mouse_Panel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        mouse_Add_Button.setBackground(new java.awt.Color(13, 146, 118));
        mouse_Add_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mouse_Add_Button.setForeground(new java.awt.Color(0, 0, 0));
        mouse_Add_Button.setText("Add");
        mouse_Add_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mouse_Add_Button.setFocusable(false);
        mouse_Add_Button.setOpaque(true);
        mouse_Add_Button.setRequestFocusEnabled(false);
        mouse_Add_Button.setRolloverEnabled(false);
        mouse_Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouse_Add_ButtonActionPerformed(evt);
            }
        });
        mouse_Panel.add(mouse_Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel38.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 0, 51));
        jLabel38.setText("Remove From Cart:");
        mouse_Panel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        mouse_Remove_Button.setBackground(new java.awt.Color(255, 32, 78));
        mouse_Remove_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mouse_Remove_Button.setForeground(new java.awt.Color(0, 0, 0));
        mouse_Remove_Button.setText("Remove");
        mouse_Remove_Button.setBorder(null);
        mouse_Remove_Button.setFocusPainted(false);
        mouse_Remove_Button.setFocusable(false);
        mouse_Remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mouse_Remove_ButtonActionPerformed(evt);
            }
        });
        mouse_Panel.add(mouse_Remove_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab5", mouse_Panel);

        keyboard_Panel.setBackground(new java.awt.Color(246, 223, 235));
        keyboard_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Keyboard");
        keyboard_Panel.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 192, 36));

        keyboard_Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        keyboard_Panel.add(keyboard_Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 372, 234));

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(64, 103, 158));
        jLabel82.setText("Connectivity:");
        keyboard_Panel.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 107, -1));

        jLabel88.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(64, 103, 158));
        jLabel88.setText("Minimum System Requirment:");
        keyboard_Panel.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 220, -1));

        jLabel89.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(64, 103, 158));
        jLabel89.setText("Warrenty:");
        keyboard_Panel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 140, -1));

        jLabel105.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(64, 103, 158));
        jLabel105.setText("Colour:");
        keyboard_Panel.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 107, -1));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(64, 103, 158));
        jLabel106.setText("Price");
        keyboard_Panel.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 117, -1));

        keyboard_Connectivity.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        keyboard_Connectivity.setForeground(new java.awt.Color(26, 93, 26));
        keyboard_Connectivity.setText("USB");
        keyboard_Panel.add(keyboard_Connectivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 140, -1));

        keyboard_MinReq.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        keyboard_MinReq.setForeground(new java.awt.Color(26, 93, 26));
        keyboard_MinReq.setText("Windows® 10, 8.1, 8, 7 ");
        keyboard_Panel.add(keyboard_MinReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 550, -1));

        keyboard_Color.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        keyboard_Color.setForeground(new java.awt.Color(26, 93, 26));
        keyboard_Color.setText("Black");
        keyboard_Panel.add(keyboard_Color, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 384, -1));

        keyboard_Warrenty.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        keyboard_Warrenty.setForeground(new java.awt.Color(26, 93, 26));
        keyboard_Warrenty.setText("2 Years");
        keyboard_Panel.add(keyboard_Warrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 384, -1));

        keyboard_Price.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        keyboard_Price.setForeground(new java.awt.Color(26, 93, 26));
        keyboard_Price.setText("4790");
        keyboard_Panel.add(keyboard_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 384, -1));

        keyBoard_Next_Button.setBackground(new java.awt.Color(65, 201, 226));
        keyBoard_Next_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        keyBoard_Next_Button.setForeground(new java.awt.Color(0, 0, 0));
        keyBoard_Next_Button.setText("Next");
        keyBoard_Next_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        keyBoard_Next_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyBoard_Next_ButtonActionPerformed(evt);
            }
        });
        keyboard_Panel.add(keyBoard_Next_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 700, 120, 30));

        keyBoard_Previous_Button.setBackground(new java.awt.Color(65, 201, 226));
        keyBoard_Previous_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        keyBoard_Previous_Button.setForeground(new java.awt.Color(0, 0, 0));
        keyBoard_Previous_Button.setText("Previous");
        keyBoard_Previous_Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        keyBoard_Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyBoard_Previous_ButtonActionPerformed(evt);
            }
        });
        keyboard_Panel.add(keyBoard_Previous_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 120, 30));

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 0, 51));
        jLabel39.setText("Add To Cart:");
        keyboard_Panel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 80, 30));

        keyboard_Add_Button.setBackground(new java.awt.Color(13, 146, 118));
        keyboard_Add_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboard_Add_Button.setForeground(new java.awt.Color(0, 0, 0));
        keyboard_Add_Button.setText("Add");
        keyboard_Add_Button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        keyboard_Add_Button.setFocusable(false);
        keyboard_Add_Button.setOpaque(true);
        keyboard_Add_Button.setRequestFocusEnabled(false);
        keyboard_Add_Button.setRolloverEnabled(false);
        keyboard_Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyboard_Add_ButtonActionPerformed(evt);
            }
        });
        keyboard_Panel.add(keyboard_Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 90, -1));

        jLabel40.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 0, 51));
        jLabel40.setText("Remove From Cart:");
        keyboard_Panel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 120, 30));

        keyboard_Remove_Button.setBackground(new java.awt.Color(255, 32, 78));
        keyboard_Remove_Button.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        keyboard_Remove_Button.setForeground(new java.awt.Color(0, 0, 0));
        keyboard_Remove_Button.setText("Remove");
        keyboard_Remove_Button.setBorder(null);
        keyboard_Remove_Button.setFocusPainted(false);
        keyboard_Remove_Button.setFocusable(false);
        keyboard_Remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyboard_Remove_ButtonActionPerformed(evt);
            }
        });
        keyboard_Panel.add(keyboard_Remove_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, -1));

        tabbedPane.addTab("tab6", keyboard_Panel);

        jPanel1.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, -50, 860, 930));

        dashboard_TextArea.setBackground(new java.awt.Color(255, 255, 255));
        dashboard_TextArea.setColumns(20);
        dashboard_TextArea.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        dashboard_TextArea.setRows(5);
        dashboard_TextArea.setBorder(null);
        jScrollPane1.setViewportView(dashboard_TextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 410, 570));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        jPanel_L.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_L.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_LMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Laptop");

        javax.swing.GroupLayout jPanel_LLayout = new javax.swing.GroupLayout(jPanel_L);
        jPanel_L.setLayout(jPanel_LLayout);
        jPanel_LLayout.setHorizontalGroup(
            jPanel_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_LLayout.setVerticalGroup(
            jPanel_LLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_D.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_D.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_D.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_DMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Desktop");

        javax.swing.GroupLayout jPanel_DLayout = new javax.swing.GroupLayout(jPanel_D);
        jPanel_D.setLayout(jPanel_DLayout);
        jPanel_DLayout.setHorizontalGroup(
            jPanel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_DLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_DLayout.setVerticalGroup(
            jPanel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_DLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_P.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_P.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_PMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Printers");

        javax.swing.GroupLayout jPanel_PLayout = new javax.swing.GroupLayout(jPanel_P);
        jPanel_P.setLayout(jPanel_PLayout);
        jPanel_PLayout.setHorizontalGroup(
            jPanel_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_PLayout.setVerticalGroup(
            jPanel_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Mon.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Mon.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Mon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_MonMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Monitors");

        javax.swing.GroupLayout jPanel_MonLayout = new javax.swing.GroupLayout(jPanel_Mon);
        jPanel_Mon.setLayout(jPanel_MonLayout);
        jPanel_MonLayout.setHorizontalGroup(
            jPanel_MonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MonLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_MonLayout.setVerticalGroup(
            jPanel_MonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Mou.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Mou.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Mou.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_MouMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Mouse");

        javax.swing.GroupLayout jPanel_MouLayout = new javax.swing.GroupLayout(jPanel_Mou);
        jPanel_Mou.setLayout(jPanel_MouLayout);
        jPanel_MouLayout.setHorizontalGroup(
            jPanel_MouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MouLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_MouLayout.setVerticalGroup(
            jPanel_MouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MouLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Key.setBackground(new java.awt.Color(54, 70, 78));
        jPanel_Key.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Key.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel_KeyMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Keyboard");

        javax.swing.GroupLayout jPanel_KeyLayout = new javax.swing.GroupLayout(jPanel_Key);
        jPanel_Key.setLayout(jPanel_KeyLayout);
        jPanel_KeyLayout.setHorizontalGroup(
            jPanel_KeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_KeyLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel_KeyLayout.setVerticalGroup(
            jPanel_KeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KeyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Mou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_Key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_Mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_Mou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_Key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 239, 272, -1));

        jPanel2.setBackground(new java.awt.Color(120, 193, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grandTotal_Label.setBackground(new java.awt.Color(13, 146, 18));
        grandTotal_Label.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        grandTotal_Label.setForeground(new java.awt.Color(0, 0, 204));
        grandTotal_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(grandTotal_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 190, 50));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        placeOrder_Button.setBackground(new java.awt.Color(13, 146, 18));
        placeOrder_Button.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        placeOrder_Button.setForeground(new java.awt.Color(255, 255, 255));
        placeOrder_Button.setText("Place Order");
        placeOrder_Button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        placeOrder_Button.setFocusPainted(false);
        placeOrder_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrder_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(placeOrder_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Enter Name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 30));

        custName_Label.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        custName_Label.setForeground(new java.awt.Color(0, 0, 0));
        custName_Label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(custName_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 170, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mobile:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, 30));

        custMobile_Label.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        custMobile_Label.setForeground(new java.awt.Color(0, 0, 0));
        custMobile_Label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(custMobile_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 560, 410, 280));

        logoutButton.setBackground(new java.awt.Color(255, 32, 78));
        logoutButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(0, 0, 0));
        logoutButton.setText("Logout");
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, 120, 30));

        adminPageButton.setBackground(new java.awt.Color(122, 162, 227));
        adminPageButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        adminPageButton.setForeground(new java.awt.Color(0, 0, 0));
        adminPageButton.setText("Admin Page");
        adminPageButton.setFocusPainted(false);
        adminPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(adminPageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1540, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_LMouseClicked

        tabbedPane.setSelectedIndex(0);
        jPanel_L.setBackground(clickedColor);
        jPanel_D.setBackground(defaultColor);
        jPanel_P.setBackground(defaultColor);
        jPanel_Mon.setBackground(defaultColor);
        jPanel_Mou.setBackground(defaultColor);
        jPanel_Key.setBackground(defaultColor);

    }//GEN-LAST:event_jPanel_LMouseClicked

    private void jPanel_DMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_DMouseClicked
        tabbedPane.setSelectedIndex(1);
        jPanel_L.setBackground(defaultColor);
        jPanel_D.setBackground(clickedColor);
        jPanel_P.setBackground(defaultColor);
        jPanel_Mon.setBackground(defaultColor);
        jPanel_Mou.setBackground(defaultColor);
        jPanel_Key.setBackground(defaultColor);
    }//GEN-LAST:event_jPanel_DMouseClicked

    private void jPanel_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_PMouseClicked
        tabbedPane.setSelectedIndex(2);
        jPanel_L.setBackground(defaultColor);
        jPanel_D.setBackground(defaultColor);
        jPanel_P.setBackground(clickedColor);
        jPanel_Mon.setBackground(defaultColor);
        jPanel_Mou.setBackground(defaultColor);
        jPanel_Key.setBackground(defaultColor);
    }//GEN-LAST:event_jPanel_PMouseClicked

    private void jPanel_MonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_MonMouseClicked
        tabbedPane.setSelectedIndex(3);
        jPanel_L.setBackground(defaultColor);
        jPanel_D.setBackground(defaultColor);
        jPanel_P.setBackground(defaultColor);
        jPanel_Mon.setBackground(clickedColor);
        jPanel_Mou.setBackground(defaultColor);
        jPanel_Key.setBackground(defaultColor);
    }//GEN-LAST:event_jPanel_MonMouseClicked

    private void jPanel_MouMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_MouMouseClicked
        tabbedPane.setSelectedIndex(4);
        jPanel_L.setBackground(defaultColor);
        jPanel_D.setBackground(defaultColor);
        jPanel_P.setBackground(defaultColor);
        jPanel_Mon.setBackground(defaultColor);
        jPanel_Mou.setBackground(clickedColor);
        jPanel_Key.setBackground(defaultColor);
    }//GEN-LAST:event_jPanel_MouMouseClicked

    private void jPanel_KeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_KeyMouseClicked
        tabbedPane.setSelectedIndex(5);
        jPanel_L.setBackground(defaultColor);
        jPanel_D.setBackground(defaultColor);
        jPanel_P.setBackground(defaultColor);
        jPanel_Mon.setBackground(defaultColor);
        jPanel_Mou.setBackground(defaultColor);
        jPanel_Key.setBackground(clickedColor);
    }//GEN-LAST:event_jPanel_KeyMouseClicked

    private void previou_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previou_ButtonActionPerformed

        laptopObj(lapController.showPreviousLaptop());

    }//GEN-LAST:event_previou_ButtonActionPerformed

    private void next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_ButtonActionPerformed

        laptopObj(lapController.showNextLaptop());

    }//GEN-LAST:event_next_ButtonActionPerformed

    private void desktop_Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desktop_Previous_ButtonActionPerformed
        desktopObj(deskController.showPreviousDesktop());
    }//GEN-LAST:event_desktop_Previous_ButtonActionPerformed

    private void desktop_Next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desktop_Next_ButtonActionPerformed
        desktopObj(deskController.showNextDesktop());
    }//GEN-LAST:event_desktop_Next_ButtonActionPerformed

    private void keyBoard_Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyBoard_Previous_ButtonActionPerformed
        keyboardObj(keyboardController.showPreviousKeyboard());
    }//GEN-LAST:event_keyBoard_Previous_ButtonActionPerformed

    private void keyBoard_Next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyBoard_Next_ButtonActionPerformed
        keyboardObj(keyboardController.showNextKeyBoard());
    }//GEN-LAST:event_keyBoard_Next_ButtonActionPerformed

    private void monitor_Next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor_Next_ButtonActionPerformed
        monitorObj(monitorController.showNextMonitor());
    }//GEN-LAST:event_monitor_Next_ButtonActionPerformed

    private void monitor_Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor_Previous_ButtonActionPerformed
        monitorObj(monitorController.showPreviousMonitor());
    }//GEN-LAST:event_monitor_Previous_ButtonActionPerformed

    private void printer_Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printer_Previous_ButtonActionPerformed
        printObj(printController.showPreviousPrinter());
    }//GEN-LAST:event_printer_Previous_ButtonActionPerformed

    private void printer_Next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printer_Next_ButtonActionPerformed
        printObj(printController.showNextPrinter());
    }//GEN-LAST:event_printer_Next_ButtonActionPerformed

    private void mouse_Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouse_Previous_ButtonActionPerformed
        mouseObj(mouseController.showPreviousMouse());
    }//GEN-LAST:event_mouse_Previous_ButtonActionPerformed

    private void mouse_Next_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouse_Next_ButtonActionPerformed
        mouseObj(mouseController.showNextMouse());
    }//GEN-LAST:event_mouse_Next_ButtonActionPerformed

    private void lap_Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_Add_ButtonActionPerformed

        billReceipt("Laptop(" + modelNo.getText() + ")", Integer.parseInt(price.getText()));

    }//GEN-LAST:event_lap_Add_ButtonActionPerformed

    private void lap_Remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lap_Remove_ButtonActionPerformed
        removeCart();
    }//GEN-LAST:event_lap_Remove_ButtonActionPerformed

    private void desk_Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desk_Add_ButtonActionPerformed
        billReceipt("Desktop(" + model_Desk.getText() + ")", Integer.parseInt(price_Desk.getText()));
    }//GEN-LAST:event_desk_Add_ButtonActionPerformed

    private void desk_Remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desk_Remove_ButtonActionPerformed
        removeCart();
    }//GEN-LAST:event_desk_Remove_ButtonActionPerformed

    private void printer_Add_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printer_Add_Button2ActionPerformed
        billReceipt("Printer(" + model_Printers.getText() + ")", Integer.parseInt(price_Printer.getText()));
    }//GEN-LAST:event_printer_Add_Button2ActionPerformed

    private void printer_Remove_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printer_Remove_Button2ActionPerformed
        removeCart();
    }//GEN-LAST:event_printer_Remove_Button2ActionPerformed

    private void monitor_Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor_Add_ButtonActionPerformed
        billReceipt("Monitor(" + model_Monitor.getText() + ")", Integer.parseInt(price_Monitor.getText()));
    }//GEN-LAST:event_monitor_Add_ButtonActionPerformed

    private void monitor_Remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitor_Remove_ButtonActionPerformed
        removeCart();
    }//GEN-LAST:event_monitor_Remove_ButtonActionPerformed

    private void mouse_Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouse_Add_ButtonActionPerformed
        billReceipt("Mouse(" + model_Mouse.getText() + ")", Integer.parseInt(price_Mouse.getText()));
    }//GEN-LAST:event_mouse_Add_ButtonActionPerformed

    private void mouse_Remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mouse_Remove_ButtonActionPerformed
        removeCart();
    }//GEN-LAST:event_mouse_Remove_ButtonActionPerformed

    private void keyboard_Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyboard_Add_ButtonActionPerformed
        billReceipt("Keyboard(" + keyboard_Connectivity.getText() + ")", Integer.parseInt(keyboard_Price.getText()));
    }//GEN-LAST:event_keyboard_Add_ButtonActionPerformed

    private void keyboard_Remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyboard_Remove_ButtonActionPerformed
        removeCart();
    }//GEN-LAST:event_keyboard_Remove_ButtonActionPerformed

    private void placeOrder_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrder_ButtonActionPerformed
        String time[] = dateAndTime();

        new BillModel().placeOrder(custName_Label.getText(), custMobile_Label.getText(), Integer.parseInt(grandTotal_Label.getText()), time[0] + " " + time[1], stack);
    }//GEN-LAST:event_placeOrder_ButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void adminPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPageButtonActionPerformed
       
        new AdminAuthendication().setVisible(true);
    }//GEN-LAST:event_adminPageButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminPageButton;
    private javax.swing.JLabel color_Mouse;
    private javax.swing.JLabel colors_Print;
    private javax.swing.JLabel connectivity_Mouse;
    private javax.swing.JTextField custMobile_Label;
    private javax.swing.JTextField custName_Label;
    private javax.swing.JTextArea dashboard_TextArea;
    private javax.swing.JButton desk_Add_Button;
    private javax.swing.JButton desk_Remove_Button;
    private javax.swing.JButton desktop_Next_Button;
    private javax.swing.JPanel desktop_Panel;
    private javax.swing.JLabel desktop_Pic;
    private javax.swing.JButton desktop_Previous_Button;
    private javax.swing.JLabel displayColors_Monitor;
    private javax.swing.JLabel displayFeatures_Monitor;
    private javax.swing.JLabel function_Printer;
    private javax.swing.JLabel grandTotal_Label;
    private javax.swing.JLabel hardDisk;
    private javax.swing.JLabel hardDisk_Desk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_D;
    private javax.swing.JPanel jPanel_Key;
    private javax.swing.JPanel jPanel_L;
    private javax.swing.JPanel jPanel_Mon;
    private javax.swing.JPanel jPanel_Mou;
    private javax.swing.JPanel jPanel_P;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keyBoard_Next_Button;
    private javax.swing.JButton keyBoard_Previous_Button;
    private javax.swing.JButton keyboard_Add_Button;
    private javax.swing.JLabel keyboard_Color;
    private javax.swing.JLabel keyboard_Connectivity;
    private javax.swing.JLabel keyboard_MinReq;
    private javax.swing.JPanel keyboard_Panel;
    private javax.swing.JLabel keyboard_Pic;
    private javax.swing.JLabel keyboard_Price;
    private javax.swing.JButton keyboard_Remove_Button;
    private javax.swing.JLabel keyboard_Warrenty;
    private javax.swing.JButton lap_Add_Button;
    private javax.swing.JButton lap_Remove_Button;
    private javax.swing.JPanel laptop_Panel;
    private javax.swing.JLabel laptop_Pic;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel mVolume_Printer;
    private javax.swing.JLabel modelNo;
    private javax.swing.JLabel model_Desk;
    private javax.swing.JLabel model_Monitor;
    private javax.swing.JLabel model_Mouse;
    private javax.swing.JLabel model_Printers;
    private javax.swing.JButton monitor_Add_Button;
    private javax.swing.JButton monitor_Next_Button;
    private javax.swing.JLabel monitor_Pic;
    private javax.swing.JButton monitor_Previous_Button;
    private javax.swing.JButton monitor_Remove_Button;
    private javax.swing.JPanel monitors_Panel;
    private javax.swing.JButton mouse_Add_Button;
    private javax.swing.JButton mouse_Next_Button;
    private javax.swing.JPanel mouse_Panel;
    private javax.swing.JLabel mouse_Pic;
    private javax.swing.JButton mouse_Previous_Button;
    private javax.swing.JButton mouse_Remove_Button;
    private javax.swing.JButton next_Button;
    private javax.swing.JLabel operatingSystem;
    private javax.swing.JLabel operatingSystem_Desk;
    private javax.swing.JButton placeOrder_Button;
    private javax.swing.JButton previou_Button;
    private javax.swing.JLabel price;
    private javax.swing.JLabel price_Desk;
    private javax.swing.JLabel price_Monitor;
    private javax.swing.JLabel price_Mouse;
    private javax.swing.JLabel price_Printer;
    private javax.swing.JButton printer_Add_Button2;
    private javax.swing.JButton printer_Next_Button;
    private javax.swing.JLabel printer_Pic;
    private javax.swing.JButton printer_Previous_Button;
    private javax.swing.JButton printer_Remove_Button2;
    private javax.swing.JPanel printors_Panel;
    private javax.swing.JLabel processor;
    private javax.swing.JLabel processor_Desk;
    private javax.swing.JLabel ram;
    private javax.swing.JLabel ram_Desk;
    private javax.swing.JLabel resolution_Monitor;
    private javax.swing.JLabel responseTime_Monitor;
    private javax.swing.JLabel screenSize;
    private javax.swing.JLabel screenSize_Desk;
    private javax.swing.JLabel screenSize_Monitor;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel technology_Printer;
    private javax.swing.JLabel warrenty_Mouse;
    private javax.swing.JLabel wirelessCapability_Print;
    // End of variables declaration//GEN-END:variables
}
