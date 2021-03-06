
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oshad
 */
public class weight extends javax.swing.JFrame {

    private int Ccspps = 0;
    private int gblCumComplex = 0;
    private String CS = "none";
    private String prevCS = "none";
    private int NoOfConds = 0; // Number of conditions
    private int lastActiveCcspps = 0;
    private int gblLoc = 0;
  
    private boolean isInsideCS = false; // Check whether we are inside a control structure
    
    //private JsonObject weights;
    private String strWeights;
    FileReader fr;
    String code;
    private int LineNo = 1;
    File ff;
    private int sumControl = 0;
    public weight() {
        initComponents();
        jTableDesign();
    }

      public weight(File ff) throws IOException {
        initComponents();
        this.ff = ff;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTableDesign();
       

        //setTableData(ff);
        //lineArray();
        //condition(ff);
        
        //Ccs(ff);
    }
     private void jTableDesign() {
        CTable.setRowHeight(40);
        CTable.setShowGrid(true);
        CTable.setGridColor(new Color(153, 153, 255));
        CTable.setSelectionBackground(Color.DARK_GRAY);

        JTableHeader tableHeader = CTable.getTableHeader();
        tableHeader.setBackground(new Color(153, 153, 255));
        tableHeader.setForeground(Color.BLACK);
        tableHeader.setPreferredSize(new Dimension(70, 70));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));
    }
     
     public int getSumControl() {
        return sumControl;
    } 
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        WD = new javax.swing.JTextField();
        ifElse = new javax.swing.JTextField();
        CaseVariable = new javax.swing.JTextField();
        Swvariable = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea1 = new javax.swing.JTextArea();
        fileUpload = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Weights related to the Control Structure Factor");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 60, 730, 42);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(430, 640, 150, 30);
        jPanel1.add(WD);
        WD.setBounds(530, 520, 50, 30);
        jPanel1.add(ifElse);
        ifElse.setBounds(530, 480, 50, 30);
        jPanel1.add(CaseVariable);
        CaseVariable.setBounds(530, 600, 50, 30);
        jPanel1.add(Swvariable);
        Swvariable.setBounds(530, 560, 50, 30);

        jLabel7.setBackground(new java.awt.Color(0, 204, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Control Structure Type------------------------------");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 450, 490, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("------Weight ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 450, 130, 20);

        TextArea1.setColumns(20);
        TextArea1.setRows(5);
        jScrollPane1.setViewportView(TextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 170, 550, 260);
        jPanel1.add(fileUpload);
        fileUpload.setBounds(30, 140, 400, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(430, 140, 150, 30);

        CTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line no", "Program statements", "Wtcs", "NC", "Ccspps ", "Ccs "
            }
        ));
        jScrollPane2.setViewportView(CTable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(590, 140, 580, 530);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backSmall.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(40, 20, 60, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("The ‘switch’ statement in a ‘switch-case’ control structure ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("An iterative control structure such as a ‘for’, ‘while’, or ‘do-while’ loop");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("A conditional control structure such as an ‘if’ or ‘else-if’ condition");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Each ‘case’ statement in a ‘switch-case’ control structure");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 480, 490, 150);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Create Bar Chart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(280, 640, 150, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Add All weight related dependencies before clicking");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 670, 310, 17);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(130, 640, 150, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/world.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 1320, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        DefaultTableModel model = (DefaultTableModel) CTable.getModel();
        int Wtcs = 0;
        int Nc =0;
        int Ccspps=0;
        int Ccs=0;
        int sumCcspps=0;
        FileReader fr = null;
        try {
            fr = new FileReader(ff);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(weight.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
              
        String strCurrentLine=null;
        try {
            strCurrentLine = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(weight.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            while ((strCurrentLine = br.readLine()) != null) {
                
                for(int i=0;i<strCurrentLine.length();i++)
                {
                    
                    if(strCurrentLine.trim().startsWith("for")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("do-while")||strCurrentLine.trim().startsWith("}do-while")||strCurrentLine.trim().startsWith("}for")||strCurrentLine.trim().startsWith("}while"))
                    {
                        Wtcs=Integer.parseInt(WD.getText());
                    }
                    else if(strCurrentLine.trim().startsWith("if")||strCurrentLine.trim().startsWith("else if")||strCurrentLine.trim().startsWith("}else if")||strCurrentLine.trim().startsWith("}if")||strCurrentLine.trim().startsWith("else-if")||strCurrentLine.trim().startsWith("}else-if"))
                    {
                        Wtcs=Integer.parseInt(ifElse.getText());
                    }
                    else if(strCurrentLine.trim().startsWith("switch")||strCurrentLine.trim().startsWith("}switch"))
                    {
                        Wtcs=Integer.parseInt(Swvariable.getText());//CaseVariable
                    }
                    else if(strCurrentLine.trim().startsWith("case")||strCurrentLine.trim().startsWith("}case"))
                    {
                        Wtcs=Integer.parseInt(CaseVariable.getText());
                    }
                    else{
                        
                        Wtcs=0;
                        
                    }
                    
                }
                
                int total = 0;
                
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\w)if(?!\\w)", "").length()) / 2);
                  if((strCurrentLine.trim().startsWith("//"))) // 'comment' detected
            {
                total=0;
            }
            else if(total > 0||(strCurrentLine.trim().startsWith("if"))||strCurrentLine.trim().startsWith("}")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("}while")||strCurrentLine.trim().startsWith("}if")) // 'if' detected
            {            
            //Detecting &&
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("&&", "").length()) / 2);
            //Detecting &
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!&)&(?![&=])", "").length()));
            //Detecting ||
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("\\|\\|", "").length()) / 2);
            //Detecting |
                total = total + ((strCurrentLine.length() - strCurrentLine.replaceAll("(?<!\\|)\\|(?!\\|)", "").length()));
            
            //System.out.println(total);
                 
            }
            else if(total > 0||(strCurrentLine.trim().startsWith("for"))||(strCurrentLine.trim().startsWith("while"))) // 'for' & 'while' detected 
            {
                total=1;
            }
                          
                for(int i=0;i<CTable.getRowCount();i++){
                    int sumNc;
                    int sum;
                    int sumWtc;
                    //int sumCcspps;
                    
                    sumCcspps=Wtcs*total;
                   
                    Ccs=((Wtcs*total)+sumCcspps);
                    //remove the comment line on the code
             if (strCurrentLine.trim().length() != 0) {
                    System.out.println(strCurrentLine);
                    strCurrentLine = strCurrentLine.trim();

                }
                if (strCurrentLine.contains("//")) {
                    System.out.println(strCurrentLine.substring(0, strCurrentLine.indexOf("//")));
                    strCurrentLine = strCurrentLine.substring(0, strCurrentLine.indexOf("//"));
                    
                }
                }
                
                
                Object[] row = {LineNo++, strCurrentLine, Wtcs, total, sumCcspps,Ccs };
                model.addRow(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(weight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     public void  setWeightData(File ff) throws IOException {
         
        weight ne =new  weight();
        DefaultTableModel model = (DefaultTableModel) CTable.getModel();
        int Wtcs = 0;
        int Nc =0;
        int Ccspps=0;
        int Ccs=0;
        FileReader fr = new FileReader(ff);
        BufferedReader br = new BufferedReader(fr);
              
        String strCurrentLine=null;
        strCurrentLine = br.readLine();
       
        while ((strCurrentLine = br.readLine()) != null) {
          
            for(int i=0;i<strCurrentLine.length();i++)
            {
               
            if(strCurrentLine.trim().startsWith("for")||strCurrentLine.trim().startsWith("while")||strCurrentLine.trim().startsWith("do-while"))
            {
                //Wtcs=Integer.parseInt(FWD.getText());                
            }
            else if(strCurrentLine.trim().startsWith("if")||strCurrentLine.trim().startsWith("else if")||strCurrentLine.trim().startsWith("switch"))
            {
                ///Wtcs=Integer.parseInt(EIF.getText()); 
            }            
            else if(strCurrentLine.trim().startsWith("case"))
            {
               // Wtcs=Integer.parseInt(CaseV.getText()); 
            }
            else{
                
                Wtcs=0;
                                
                }
            
            }                                                                 
            Object[] row = {LineNo++, strCurrentLine, Wtcs, null, Ccspps,Ccs };            
            model.addRow(row);      
        }
        
        /*
        String one=ifElse.getText();
        String two=WD.getText();
        String three=Swvariable.getText();
        String four=CaseVariable.getText();
        //setVisible(false);
        //new interface02().setVisible(true);
        
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          JFileChooser jf = new JFileChooser();
        int aa = jf.showOpenDialog(null);

        if(aa == JFileChooser.APPROVE_OPTION){
            char cbuf[] = null;
            ff = jf.getSelectedFile();
            fileUpload.setText(ff.getName());

            try {
                fr = new FileReader(ff);
                TextArea1.read(fr, "");
                code = TextArea1.getText();
            } catch (Exception ex) {
                Logger.getLogger(interface01.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(interface01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       setVisible(false);
       new interface01().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int if1 = 0;
        int FW = 0;
        int Swva = 0;
        int Case1 = 0;
        
         if1=Integer.parseInt(ifElse.getText());
         FW=Integer.parseInt(WD.getText());
         Swva=Integer.parseInt( Swvariable.getText());
         Case1 =  Integer.parseInt(CaseVariable.getText());     
           
          DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        
          //dataset.setValue(new int(Wr1),"values","weight");
            dataset.setValue(if1, "weight", "If or Else-If");
            dataset.setValue(FW, "weight", "For/While/do-While");
            dataset.setValue(Swva, "weight", "switch");
            dataset.setValue(Case1, "weight", "Case");
            
            
            JFreeChart chart = ChartFactory.createBarChart3D("Control Structure", "Factors", "weightage", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            ChartFrame frame = new ChartFrame("Bar Chart for Control Structure", chart);
            frame.setVisible(true);
            frame.setSize(600,550);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        fileUpload.setText("");
        TextArea1.setText("");
        ifElse.setText("");
        WD.setText("");
        Swvariable.setText("");
        CaseVariable.setText("");
        
        CTable.setModel(new DefaultTableModel(null, new String[]{"Line no", "Program statements", "Wtcs", "NC", "Ccspps", "Ccs"}));
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(weight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(weight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(weight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(weight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new weight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CTable;
    private javax.swing.JTextField CaseVariable;
    private javax.swing.JTextField Swvariable;
    private javax.swing.JTextArea TextArea1;
    private javax.swing.JTextField WD;
    private javax.swing.JTextField fileUpload;
    private javax.swing.JTextField ifElse;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
