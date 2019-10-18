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
public class Masterclass extends javax.swing.JFrame {

    /**
     * Creates new form Masterclass
     */
    public Masterclass() {
        initComponents();
        fillcombo();
        tabelMasterclass();
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
    public void fillcombo(){
        try{
            String sql = "select naam from gast where bekendeSpeler = 'J'";
            Connection conn = MySqlConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String name = rs.getString("naam");
                comboboxBekendeSpeler.addItem(name);
            }
                      
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
    public void tabelMasterclass(){
        ArrayList<MasterclassVariable> gast = getMasterclass();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[10];
        for(int i = 0; i<gast.size();i++){
            row[0] = gast.get(i).getNaam();
            row[1] = gast.get(i).getDatum();
            row[2] = gast.get(i).getBeginEindTijd();
            row[3] = gast.get(i).getBekendeSpeler();
            row[4] = gast.get(i).getKosten();
            row[5] = gast.get(i).getMinimaleRating();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNaam = new javax.swing.JLabel();
        labelDatum = new javax.swing.JLabel();
        labelBeginEindTijd = new javax.swing.JLabel();
        labelMinimaleRating = new javax.swing.JLabel();
        textnaam = new javax.swing.JTextField();
        textBeginEindTijd = new javax.swing.JTextField();
        buttonNieuw = new javax.swing.JButton();
        buttonWijzigen = new javax.swing.JButton();
        buttonOpslaan = new javax.swing.JButton();
        buttonVerwijderen = new javax.swing.JButton();
        labelToernooiZoeken = new javax.swing.JLabel();
        textMasterClassZoeken = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelKosten = new javax.swing.JLabel();
        textMinimaleRating = new javax.swing.JTextField();
        labelBekendeSpeler = new javax.swing.JLabel();
        datum = new com.toedter.calendar.JDateChooser();
        textKosten = new javax.swing.JTextField();
        comboboxBekendeSpeler = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 51));

        labelNaam.setText("Naam: ");

        labelDatum.setText("Datum: ");

        labelBeginEindTijd.setText("BeginEindTijd:");

        labelMinimaleRating.setText("Minimale_rating: ");

        textnaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textnaamActionPerformed(evt);
            }
        });

        buttonNieuw.setText("Nieuw");
        buttonNieuw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNieuwActionPerformed(evt);
            }
        });

        buttonWijzigen.setText("Wijzigen");
        buttonWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWijzigenActionPerformed(evt);
            }
        });

        buttonOpslaan.setText("Opslaan");
        buttonOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpslaanActionPerformed(evt);
            }
        });

        buttonVerwijderen.setText("Verwijderen");
        buttonVerwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerwijderenActionPerformed(evt);
            }
        });

        labelToernooiZoeken.setText("Masterclass zoeken");

        textMasterClassZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMasterClassZoekenActionPerformed(evt);
            }
        });
        textMasterClassZoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMasterClassZoekenKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naam", "Datum", "BeginEindTijd", "BekendeSpeler", "Kosten", "Minimale_rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        labelKosten.setText("Kosten:");

        textMinimaleRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMinimaleRatingActionPerformed(evt);
            }
        });
        textMinimaleRating.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMinimaleRatingKeyTyped(evt);
            }
        });

        labelBekendeSpeler.setText("Bekende Speler:");

        datum.setDateFormatString("dd-MM-yyyy");

        comboboxBekendeSpeler.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelBekendeSpeler)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNaam)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelToernooiZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelMinimaleRating)
                                            .addComponent(labelDatum)
                                            .addComponent(labelBeginEindTijd))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textMasterClassZoeken, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(textnaam)
                                            .addComponent(textMinimaleRating)
                                            .addComponent(textBeginEindTijd)
                                            .addComponent(datum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textKosten)
                                            .addComponent(comboboxBekendeSpeler, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(168, 168, 168))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelKosten, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonWijzigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonOpslaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNieuw, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(buttonVerwijderen, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(310, 310, 310))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNaam)
                    .addComponent(textnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNieuw, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonOpslaan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelDatum)
                        .addGap(18, 18, 18)
                        .addComponent(labelBeginEindTijd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBeginEindTijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(buttonWijzigen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(buttonVerwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKosten)
                            .addComponent(textKosten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMinimaleRating)
                            .addComponent(textMinimaleRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBekendeSpeler)
                            .addComponent(comboboxBekendeSpeler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)))
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelToernooiZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMasterClassZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textnaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textnaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textnaamActionPerformed

    private void buttonNieuwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNieuwActionPerformed
        textnaam.setText("");
        datum.setCalendar(null);
        textBeginEindTijd.setText("");
        textKosten.setText("");
        textMinimaleRating.setText("");
        textMasterClassZoeken.setText("");
       
    }//GEN-LAST:event_buttonNieuwActionPerformed

    private void buttonWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWijzigenActionPerformed
        if(textnaam!=null && datum!=null)
        {
            String query = "update masterclass set datum=?, beginEindTijd=?, kosten=?, minimale_rating=?, bekendeSpeler=? where naam=?";
            PreparedStatement ps = null;
            Connection conn = MySqlConnection();

            try
            {
                ps = conn.prepareStatement(query);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String waardeDatum = sdf.format(datum.getDate());
                ps.setString(1, waardeDatum);
                ps.setString(2, textBeginEindTijd.getText());
                ps.setInt(3,Integer.parseInt(textKosten.getText()));
                ps.setInt(4,Integer.parseInt(textMinimaleRating.getText()));
                String waardeSpeler = comboboxBekendeSpeler.getSelectedItem().toString();
                ps.setString(5, waardeSpeler);
                ps.setString(6, textnaam.getText());
                int res = ps.executeUpdate();
                tabelMasterclass();
                // hier moet nog komen dat die tabel wordt gevuld
                if(res >= 1)
                {
                    JOptionPane.showMessageDialog(null, "De masterclass is geupdated :)");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "De masterclass updaten is mislukt!");
                }
                textnaam.setText("");
                datum.setCalendar(null);
                textBeginEindTijd.setText("");
                textKosten.setText("");
                textMinimaleRating.setText("");
                textMasterClassZoeken.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Updaten is mislukt");
        }
        
    }//GEN-LAST:event_buttonWijzigenActionPerformed

    private void buttonOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpslaanActionPerformed
        if(textnaam!=null&&datum!=null){
            try{
                Connection conn = MySqlConnection();
                String query = "insert into masterclass (naam, datum, beginEindTijd, kosten, minimale_rating, bekendeSpeler) values"
                + "(?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, textnaam.getText());
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String waardeDatum = sdf.format(datum.getDate());
                ps.setString(2, waardeDatum);
                ps.setString(3, textBeginEindTijd.getText());    
                ps.setInt(4, Integer.parseInt(textKosten.getText()));
                ps.setInt(5, Integer.parseInt(textMinimaleRating.getText()));
                String waardeLocatie = comboboxBekendeSpeler.getSelectedItem().toString();
                ps.setString(6, waardeLocatie);
                
                int res = ps.executeUpdate();
                tabelMasterclass();
                if(res >= 1){
                    JOptionPane.showMessageDialog(null, res + "De masterclass is toegevoegd aan het systeem :)");
                }else{
                    JOptionPane.showMessageDialog(null, "Masterclass toevoegen is mislukt :(");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Masterclass gegevens zijn niet compleet");
        }
        textnaam.setText("");
        datum.setCalendar(null);
        textBeginEindTijd.setText("");
        textKosten.setText("");
        textMinimaleRating.setText("");
        datum.setCalendar(null);
        textMasterClassZoeken.setText("");
    }//GEN-LAST:event_buttonOpslaanActionPerformed

    private void buttonVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerwijderenActionPerformed
        if(textnaam.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Graag naam invoeren van het toernooi die verwijderd moet worden!");
        }else{
            try{
                String query = "delete from masterclass where naam=?";
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, textnaam.getText().toString());
                int res = ps.executeUpdate();
                tabelMasterclass();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Masterclass is verwijderd");
                }else{
                    JOptionPane.showMessageDialog(null, "Masterclass is niet gevonden!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        textnaam.setText("");
    }//GEN-LAST:event_buttonVerwijderenActionPerformed

    private void textMasterClassZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMasterClassZoekenActionPerformed

    }//GEN-LAST:event_textMasterClassZoekenActionPerformed

    private void textMasterClassZoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMasterClassZoekenKeyReleased
        
        ArrayList<MasterclassVariable>al = null;
        al = new ArrayList<MasterclassVariable>();
        String val = textMasterClassZoeken.getText().toString();
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
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            Object[] row = new Object[10];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getNaam();
                row[1] = al.get(i).getDatum();
                row[2] = al.get(i).getBeginEindTijd();
                row[3] = al.get(i).getBekendeSpeler();
                row[4] = al.get(i).getKosten();
                row[5] = al.get(i).getMinimaleRating();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_textMasterClassZoekenKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        try {
            DefaultTableModel tmodel = (DefaultTableModel)jTable1.getModel();

            int selectRowIndex = jTable1.getSelectedRow();
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String)tmodel.getValueAt(selectRowIndex, 1));

            textnaam.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            datum.setDate(date);
            textBeginEindTijd.setText(tmodel.getValueAt(selectRowIndex,2).toString());
            comboboxBekendeSpeler.setSelectedItem(tmodel.getValueAt(selectRowIndex,3).toString());
            textKosten.setText(tmodel.getValueAt(selectRowIndex,4).toString());
            textMinimaleRating.setText(tmodel.getValueAt(selectRowIndex,5).toString());
            
        } catch (ParseException ex) {
            Logger.getLogger(BeginScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.hide();
        StartScherm start = new StartScherm();
        start.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void textMinimaleRatingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMinimaleRatingKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        } 
    }//GEN-LAST:event_textMinimaleRatingKeyTyped

    private void textMinimaleRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMinimaleRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMinimaleRatingActionPerformed

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
//            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Masterclass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Masterclass().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton buttonNieuw;
    private javax.swing.JButton buttonOpslaan;
    private javax.swing.JButton buttonVerwijderen;
    private javax.swing.JButton buttonWijzigen;
    private javax.swing.JComboBox<String> comboboxBekendeSpeler;
    private com.toedter.calendar.JDateChooser datum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelBeginEindTijd;
    private javax.swing.JLabel labelBekendeSpeler;
    private javax.swing.JLabel labelDatum;
    private javax.swing.JLabel labelKosten;
    private javax.swing.JLabel labelMinimaleRating;
    private javax.swing.JLabel labelNaam;
    private javax.swing.JLabel labelToernooiZoeken;
    private javax.swing.JTextField textBeginEindTijd;
    private javax.swing.JTextField textKosten;
    private javax.swing.JTextField textMasterClassZoeken;
    private javax.swing.JTextField textMinimaleRating;
    private javax.swing.JTextField textnaam;
    // End of variables declaration//GEN-END:variables
}
