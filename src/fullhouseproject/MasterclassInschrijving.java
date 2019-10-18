/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouseproject;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nour al Zahraa
 */
public class MasterclassInschrijving extends javax.swing.JFrame {

    /**
     * Creates new form MasterclassInschrijvingen
     */
    public MasterclassInschrijving() {
        initComponents();
        tabelMasterclass();
        tabelMasterclassOverzicht();
        tabelGast();
    }
    public Connection MySqlConnection()
    {
      Connection conn=null;
      try
      {
            String url = "jdbc:mysql://meru.hhs.nl:3306/18011276";
            String username= "18011276";
            String password = "Wueg7vahVi";
           conn = DriverManager.getConnection(url,username,password);
              // JOptionPane.showMessageDialog(null,"Werkt wel!");
               return conn;
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(null,"Werkt niet!");
         return null;
      }
      
    }
    public void tabelMasterclass(){
        ArrayList<MasterclassVariable> gast = getMasterclass();
        DefaultTableModel model = (DefaultTableModel) tableMasterclass.getModel();
        Object[] row = new Object[1];
        for(int i = 0; i<gast.size();i++){
            row[0] = gast.get(i).getNaam();
            model.addRow(row);
        }
    }
    public ArrayList<MasterclassVariable> getMasterclass(){
        ArrayList<MasterclassVariable>masterclasses = new ArrayList<MasterclassVariable>();
        Connection conn = MySqlConnection();
        String query = "select * from masterclass";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                MasterclassVariable masterclass = new MasterclassVariable
                (rs.getString("naam"), 
                rs.getString("datum"), 
                rs.getString("beginEindTijd"), 
                rs.getString("bekendeSpeler"),
                rs.getDouble("kosten"),
                rs.getInt("minimale_rating"));
                masterclasses.add(masterclass);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return masterclasses;
    }
    public ArrayList<MasterclassInschrijvingVariable> getMasterclassInschrijving(){
        ArrayList<MasterclassInschrijvingVariable>masterclasses = new ArrayList<MasterclassInschrijvingVariable>();
        Connection conn = MySqlConnection();
        String query = "select * from masterclass_inschrijving";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                MasterclassInschrijvingVariable masterclass = new MasterclassInschrijvingVariable
                (rs.getString("gnaam"), 
                rs.getString("mnaam"), 
                 
                rs.getInt("rating"),
                rs.getString("betaling"));
                masterclasses.add(masterclass);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return masterclasses;
    }
    public ArrayList<Gast> getGasten(){
        ArrayList<Gast>gasten = new ArrayList<Gast>();
        Connection conn = MySqlConnection();
        String query = "select * from gast";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                Gast gast = new Gast(rs.getString("naam"), rs.getString("adres"), rs.getString("postcodeWoonplaats"), rs.getString("telefoonnummer"), rs.getString("email") , rs.getString("geslacht"),
                        rs.getString("geboortedatum"), rs.getString("bekendeSpeler"), rs.getInt("rating"), rs.getInt("gewonnenInleggeld"));
                gasten.add(gast);

            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return gasten;
    }
     public void tabelGast(){
        ArrayList<Gast> gast = getGasten();
        DefaultTableModel model =(DefaultTableModel) tableGast.getModel();
        Object[] row = new Object[1];
        for(int i = 0; i<gast.size();i++){
            row[0] = gast.get(i).getNaam();
            model.addRow(row);
        }
        
    }
    public void tabelMasterclassOverzicht(){
        ArrayList<MasterclassInschrijvingVariable> masterclass = getMasterclassInschrijving();
        DefaultTableModel model = (DefaultTableModel) tableOverzicht.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<masterclass.size();i++){
            row[0] = masterclass.get(i).getGnaam();
            row[1] = masterclass.get(i).getMnaam();
            row[2] = masterclass.get(i).getRating();
            row[3] = masterclass.get(i).getBetaling();
            
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelGast = new javax.swing.JLabel();
        labelMasterclass = new javax.swing.JLabel();
        labelrating = new javax.swing.JLabel();
        labelBetaling = new javax.swing.JLabel();
        comboboxBetaling = new javax.swing.JComboBox<>();
        textRating = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGast = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMasterclass = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOverzicht = new javax.swing.JTable();
        textGastZoeken = new javax.swing.JTextField();
        textMasterclassZoeken = new javax.swing.JTextField();
        labelGastZoeken = new javax.swing.JLabel();
        labelMasterclassZoeken = new javax.swing.JLabel();
        inschrijven = new javax.swing.JButton();
        uitschrijven = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        zoeken = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaGast = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaMasterclass = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelGast.setText("Gast naam:  ");

        labelMasterclass.setText("Masterclass naam:");

        labelrating.setText("Rating: ");

        labelBetaling.setText("Betaling:");

        comboboxBetaling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "j", "n" }));

        textRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRatingActionPerformed(evt);
            }
        });
        textRating.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textRatingKeyTyped(evt);
            }
        });

        tableGast.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naam"
            }
        ));
        tableGast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGastMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableGast);

        tableMasterclass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMasterclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMasterclassMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMasterclass);

        tableOverzicht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gnaam", "Mnaam", "Rating", "Betaling"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOverzicht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOverzichtMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableOverzicht);

        textGastZoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textGastZoekenKeyReleased(evt);
            }
        });

        textMasterclassZoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMasterclassZoekenKeyReleased(evt);
            }
        });

        labelGastZoeken.setText("Gast zoeken:");

        labelMasterclassZoeken.setText("Masterclass zoeken:");

        inschrijven.setText("inschrijven");
        inschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inschrijvenActionPerformed(evt);
            }
        });

        uitschrijven.setText("uitschrijven");
        uitschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uitschrijvenActionPerformed(evt);
            }
        });

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        zoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zoekenKeyReleased(evt);
            }
        });

        areaGast.setColumns(5);
        areaGast.setRows(1);
        jScrollPane4.setViewportView(areaGast);

        areaMasterclass.setColumns(5);
        areaMasterclass.setRows(1);
        jScrollPane5.setViewportView(areaMasterclass);

        jLabel1.setText("Vul gast naam in:");

        jLabel2.setText("Vul masterclass naam in:");

        jLabel3.setText("Overzicht inschrijvingen: ");

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelGast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMasterclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelrating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelBetaling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboboxBetaling, 0, 200, Short.MAX_VALUE)
                            .addComponent(textRating)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(zoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(185, 185, 185)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uitschrijven, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(textGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textMasterclassZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMasterclassZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelGast, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inschrijven, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMasterclass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelGastZoeken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(labelrating, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textMasterclassZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxBetaling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBetaling, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uitschrijven, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelMasterclassZoeken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inschrijvenActionPerformed
        if(areaGast!=null){
            try{
                Connection conn = MySqlConnection();
                String query = "insert into masterclass_inschrijving (gnaam, mnaam, rating, betaling) values"
                                + "(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, areaGast.getText());
            ps.setString(2, areaMasterclass.getText());
            ps.setString(3, textRating.getText());
            String waardeBetaling = comboboxBetaling.getSelectedItem().toString();
            ps.setString(4, waardeBetaling);
            
            int res = ps.executeUpdate();
            tabelMasterclass();
            if(res >= 1){
                JOptionPane.showMessageDialog(null, res + "De gast is ingeschreven voor de masterclass :)");
            }else{
                JOptionPane.showMessageDialog(null, "Inschrijven is mislukt :(");
            }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
            }
            areaGast.setText("");
        areaMasterclass.setText("");
        textRating.setText("");
        textGastZoeken.setText("");
        textMasterclassZoeken.setText("");
            
                    
        }else{
            JOptionPane.showMessageDialog(null, "Gegevens zijn niet compleet");
    }    
       
       
    }//GEN-LAST:event_inschrijvenActionPerformed

    private void uitschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uitschrijvenActionPerformed
        if(areaGast.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Graag naam invoeren van de gast die uitgeschreven moet worden!");
        }else{
            try{
                String query = "delete from masterclass_inschrijving where gnaam=?";
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, areaGast.getText().toString());
                int res = ps.executeUpdate();
                tabelMasterclass();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Gast is uitgeschreven");
                }else{
                    JOptionPane.showMessageDialog(null, "Gast is niet gevonden!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        areaGast.setText("");
        areaMasterclass.setText("");
        textRating.setText("");
        textGastZoeken.setText("");
        textMasterclassZoeken.setText("");
    }//GEN-LAST:event_uitschrijvenActionPerformed

    private void tableOverzichtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOverzichtMouseClicked
        try{
        DefaultTableModel tmodel = (DefaultTableModel)tableOverzicht.getModel();
        int selectRowIndex = tableOverzicht.getSelectedRow();
        areaGast.setText(tmodel.getValueAt(selectRowIndex,0).toString());
        areaMasterclass.setText(tmodel.getValueAt(selectRowIndex,1).toString());
        textRating.setText(tmodel.getValueAt(selectRowIndex,2).toString());
        comboboxBetaling.setSelectedItem(tmodel.getValueAt(selectRowIndex,3).toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_tableOverzichtMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        areaGast.setText("");
        areaMasterclass.setText("");
        textRating.setText("");
        textGastZoeken.setText("");
        textMasterclassZoeken.setText("");
        zoeken.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void zoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zoekenKeyReleased
        ArrayList<MasterclassInschrijvingVariable>al = null;
        al = new ArrayList<MasterclassInschrijvingVariable>();
        String val = zoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from masterclass_inschrijving where gnaam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                MasterclassInschrijvingVariable masterclass = new MasterclassInschrijvingVariable(rs.getString("gnaam"), rs.getString("mnaam"), rs.getInt("rating"), rs.getString("betaling"));
                al.add(masterclass);
            }
            DefaultTableModel model = (DefaultTableModel)tableOverzicht.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getGnaam();
                row[1] = al.get(i).getMnaam();
                row[3] = al.get(i).getBetaling();
                row[2] = al.get(i).getRating();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_zoekenKeyReleased

    private void tableMasterclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMasterclassMouseClicked
        try {
            DefaultTableModel tmodel = (DefaultTableModel)tableMasterclass.getModel();

            int selectRowIndex = tableMasterclass.getSelectedRow();
            
            areaMasterclass.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_tableMasterclassMouseClicked

    private void textGastZoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textGastZoekenKeyReleased
        textGastZoeken.getText().toString();
        ArrayList<Gast>al = null;
        al = new ArrayList<Gast>();
        String val = textGastZoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from gast where naam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Gast gast = new Gast(rs.getString("naam"), rs.getString("adres"), rs.getString("postcodeWoonplaats"), rs.getString("telefoonnummer"), rs.getString("email") , rs.getString("geslacht"),
                        rs.getString("geboortedatum"), rs.getString("bekendeSpeler"), rs.getInt("rating"), rs.getInt("gewonnenInleggeld"));
                al.add(gast);
            }
            DefaultTableModel model = (DefaultTableModel)tableGast.getModel();
            model.setRowCount(0);
            Object[] row = new Object[1];
        for(int i = 0; i<al.size();i++){
            row[0] = al.get(i).getNaam();
            model.addRow(row);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_textGastZoekenKeyReleased

    private void tableGastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGastMouseClicked
        try {
            DefaultTableModel tmodel = (DefaultTableModel)tableGast.getModel();
            
            int selectRowIndex = tableGast.getSelectedRow();
            areaGast.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_tableGastMouseClicked

    private void textMasterclassZoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMasterclassZoekenKeyReleased
        ArrayList<MasterclassVariable>al = null;
        al = new ArrayList<MasterclassVariable>();
        String val = textMasterclassZoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from masterclass where naam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                MasterclassVariable masterclass = new MasterclassVariable(rs.getString("naam"), rs.getString("datum"), rs.getString("beginEindTijd"), rs.getString("bekendeSpeler") , rs.getDouble("kosten"),
                    rs.getInt("minimale_rating"));
                al.add(masterclass);
            }
            DefaultTableModel model = (DefaultTableModel)tableMasterclass.getModel();
            model.setRowCount(0);
            Object[] row = new Object[1];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getNaam();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_textMasterclassZoekenKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
        StartScherm start = new StartScherm();
        start.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRatingActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_textRatingActionPerformed

    private void textRatingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRatingKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        } 
    }//GEN-LAST:event_textRatingKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MasterclassInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MasterclassInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MasterclassInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MasterclassInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MasterclassInschrijving().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaGast;
    private javax.swing.JTextArea areaMasterclass;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> comboboxBetaling;
    private javax.swing.JButton inschrijven;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelBetaling;
    private javax.swing.JLabel labelGast;
    private javax.swing.JLabel labelGastZoeken;
    private javax.swing.JLabel labelMasterclass;
    private javax.swing.JLabel labelMasterclassZoeken;
    private javax.swing.JLabel labelrating;
    private javax.swing.JTable tableGast;
    private javax.swing.JTable tableMasterclass;
    private javax.swing.JTable tableOverzicht;
    private javax.swing.JTextField textGastZoeken;
    private javax.swing.JTextField textMasterclassZoeken;
    private javax.swing.JTextField textRating;
    private javax.swing.JButton uitschrijven;
    private javax.swing.JTextField zoeken;
    // End of variables declaration//GEN-END:variables
}
