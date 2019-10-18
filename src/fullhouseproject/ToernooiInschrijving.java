/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fullhouseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nour al Zahraa
 * 
 */
public class ToernooiInschrijving extends javax.swing.JFrame {

    /**
     * Creates new form ToernooiInschrijving
     */
    public ToernooiInschrijving() {
        initComponents();
        tabelToernooi1();
        tabelGast();
        tableOverzicht();
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
    public void tableOverzicht(){
        ArrayList<ToernooiInschrijvingVariable> toernooi = getToernooiInschrijving();
        DefaultTableModel model = (DefaultTableModel) tableOverzicht.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<toernooi.size();i++){
            row[0] = toernooi.get(i).getGnaam();
            row[1] = toernooi.get(i).getTnaam();
            row[2] = toernooi.get(i).getBetaling();
            
            model.addRow(row);
        }
    }

    public ArrayList<ToernooiInschrijvingVariable> getToernooiInschrijving(){
        ArrayList<ToernooiInschrijvingVariable>toernooien = new ArrayList<ToernooiInschrijvingVariable>();
        Connection conn = MySqlConnection();
        String query = "select * from toernooi_inschrijving";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                ToernooiInschrijvingVariable toernooi = new ToernooiInschrijvingVariable
                (rs.getString("gnaam"), 
                rs.getString("tnaam"), 
                rs.getString("betaling"));
                toernooien.add(toernooi);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return toernooien;
    }
    public void tabelToernooi1(){
        ArrayList<ToernooiVariable> gast = getToernooi1();
        DefaultTableModel model = (DefaultTableModel) tableToernooi.getModel();
        Object[] row = new Object[1];
        for(int i = 0; i<gast.size();i++){
            row[0] = gast.get(i).getNaam();
            model.addRow(row);
        }
    }
    public ArrayList<ToernooiVariable> getToernooi1(){
        ArrayList<ToernooiVariable>toernooien = new ArrayList<ToernooiVariable>();
        Connection conn = MySqlConnection();
        String query = "select * from toernooi";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                ToernooiVariable toernooi = new ToernooiVariable(rs.getString("naam"), rs.getString("locatie"), rs.getString("datum"), rs.getString("beginEindTijd"), rs.getString("beschrijving") , rs.getString("codities"),
                    rs.getInt("maxInschrijving"),rs.getInt("inleggeld"), rs.getString("Uiterste_inschrijfdatum"), rs.getInt("ronde"));
                
                toernooien.add(toernooi);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return toernooien;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelGast = new javax.swing.JLabel();
        labelToernooi = new javax.swing.JLabel();
        labelBetaling = new javax.swing.JLabel();
        comboboxBetaling = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGast = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableToernooi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableOverzicht = new javax.swing.JTable();
        textGastZoeken = new javax.swing.JTextField();
        textToernooiZoeken = new javax.swing.JTextField();
        labelGastZoeken = new javax.swing.JLabel();
        labelToernooiZoeken = new javax.swing.JLabel();
        inschrijven = new javax.swing.JButton();
        uitschrijven = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        zoeken = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaGast = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaToernooi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelGast.setText("Gast naam:  ");

        labelToernooi.setText("Toernooi naam:");

        labelBetaling.setText("Betaling:");

        comboboxBetaling.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "N" }));
        comboboxBetaling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxBetalingActionPerformed(evt);
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

        tableToernooi.setModel(new javax.swing.table.DefaultTableModel(
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
        tableToernooi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableToernooiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableToernooi);

        tableOverzicht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gnaam", "Tnaam", "Betaling"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        textToernooiZoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textToernooiZoekenKeyReleased(evt);
            }
        });

        labelGastZoeken.setText("Gast zoeken:");

        labelToernooiZoeken.setText("Toernooi zoeken:");

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

        areaToernooi.setColumns(5);
        areaToernooi.setRows(1);
        jScrollPane5.setViewportView(areaToernooi);

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
                .addGap(66, 66, 66)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelGast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelToernooi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelBetaling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboboxBetaling, 0, 200, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uitschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(textGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(textToernooiZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelToernooiZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGast, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(labelToernooi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelGastZoeken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inschrijven, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uitschrijven, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelToernooiZoeken)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textToernooiZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboboxBetaling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBetaling, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(zoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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

    private void tableGastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGastMouseClicked
        try {
            DefaultTableModel tmodel = (DefaultTableModel)tableGast.getModel();

            int selectRowIndex = tableGast.getSelectedRow();
            areaGast.setText(tmodel.getValueAt(selectRowIndex,0).toString());

        } catch (Exception e) {

        }
    }//GEN-LAST:event_tableGastMouseClicked

    private void tableToernooiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableToernooiMouseClicked
        try {
            DefaultTableModel tmodel = (DefaultTableModel)tableToernooi.getModel();

            int selectRowIndex = tableToernooi.getSelectedRow();

            areaToernooi.setText(tmodel.getValueAt(selectRowIndex,0).toString());

        } catch (Exception e) {

        }
    }//GEN-LAST:event_tableToernooiMouseClicked

    private void tableOverzichtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOverzichtMouseClicked
        try{
            DefaultTableModel tmodel = (DefaultTableModel)tableOverzicht.getModel();
            int selectRowIndex = tableOverzicht.getSelectedRow();
            areaGast.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            areaToernooi.setText(tmodel.getValueAt(selectRowIndex,1).toString());
            comboboxBetaling.setSelectedItem(tmodel.getValueAt(selectRowIndex,2).toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_tableOverzichtMouseClicked

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

    private void textToernooiZoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textToernooiZoekenKeyReleased
        ArrayList<ToernooiVariable>al = null;
        al = new ArrayList<ToernooiVariable>();
        String val = textToernooiZoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from toernooi where naam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ToernooiVariable toernooi = new ToernooiVariable(rs.getString("naam"), rs.getString("locatie"), rs.getString("datum"), rs.getString("beginEindTijd"), rs.getString("beschrijving") , rs.getString("condities"),
                    rs.getInt("maxInschrijving"),rs.getInt("inleggeld"), rs.getString("Uiterste_inschrijfdatum"), rs.getInt("ronde"));
                al.add(toernooi);
            }
            DefaultTableModel model = (DefaultTableModel)tableToernooi.getModel();
            model.setRowCount(0);
            Object[] row = new Object[1];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getNaam();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println( "error" +e);
        }
    }//GEN-LAST:event_textToernooiZoekenKeyReleased

    private void inschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inschrijvenActionPerformed
        if(areaGast!=null){
            try{
                Connection conn = MySqlConnection();
                String query = "insert into toernooi_inschrijving (gnaam, tnaam, betaling) values"
                + "(?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, areaGast.getText());
                ps.setString(2, areaToernooi.getText());
                String waardeBetaling = comboboxBetaling.getSelectedItem().toString();
                ps.setString(3, waardeBetaling);

                int res = ps.executeUpdate();
                tableOverzicht();
                if(res >= 1){
                    JOptionPane.showMessageDialog(null, res + "De gast is ingeschreven voor het toernooi :)");
                }else{
                    JOptionPane.showMessageDialog(null, "Inschrijven is mislukt :(");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            areaGast.setText("");
            areaToernooi.setText("");
            zoeken.setText("");
            textGastZoeken.setText("");
            textToernooiZoeken.setText("");

        }else{
            JOptionPane.showMessageDialog(null, "Gegevens zijn niet compleet");
        }

    }//GEN-LAST:event_inschrijvenActionPerformed

    private void uitschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uitschrijvenActionPerformed
        if(areaGast.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Graag naam invoeren van de gast die uitgeschreven moet worden!");
        }else{
            try{
                String query = "delete from toernooi_inschrijving where gnaam=?";
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, areaGast.getText().toString());
                int res = ps.executeUpdate();
                tableOverzicht();
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
        areaToernooi.setText("");
        zoeken.setText("");
        textGastZoeken.setText("");
        textToernooiZoeken.setText("");
    }//GEN-LAST:event_uitschrijvenActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        areaGast.setText("");
        areaToernooi.setText("");
        zoeken.setText("");
        textGastZoeken.setText("");
        textToernooiZoeken.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void zoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zoekenKeyReleased
        ArrayList<ToernooiInschrijvingVariable>al = null;
        al = new ArrayList<ToernooiInschrijvingVariable>();
        String val = zoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from toernooi_inschrijving where gnaam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ToernooiInschrijvingVariable toernooi = new ToernooiInschrijvingVariable(rs.getString("gnaam"), rs.getString("tnaam"), rs.getString("betaling"));
                al.add(toernooi);
            }
            DefaultTableModel model = (DefaultTableModel)tableOverzicht.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getGnaam();
                row[1] = al.get(i).getTnaam();
                row[3] = al.get(i).getBetaling();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_zoekenKeyReleased

    private void comboboxBetalingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxBetalingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxBetalingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.hide();
        StartScherm start = new StartScherm();
        start.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(ToernooiInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ToernooiInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ToernooiInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ToernooiInschrijving.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ToernooiInschrijving().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaGast;
    private javax.swing.JTextArea areaToernooi;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> comboboxBetaling;
    private javax.swing.JButton inschrijven;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelBetaling;
    private javax.swing.JLabel labelGast;
    private javax.swing.JLabel labelGastZoeken;
    private javax.swing.JLabel labelToernooi;
    private javax.swing.JLabel labelToernooiZoeken;
    private javax.swing.JTable tableGast;
    private javax.swing.JTable tableOverzicht;
    private javax.swing.JTable tableToernooi;
    private javax.swing.JTextField textGastZoeken;
    private javax.swing.JTextField textToernooiZoeken;
    private javax.swing.JButton uitschrijven;
    private javax.swing.JTextField zoeken;
    // End of variables declaration//GEN-END:variables
}
