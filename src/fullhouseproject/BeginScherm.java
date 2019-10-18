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
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nour al Zahraa
 */
public class BeginScherm extends javax.swing.JFrame {

    /**
     * Creates new form BeginScherm
     */
    public BeginScherm() {
        initComponents();
        tabelGast();
    //    MySqlConnection();
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
        DefaultTableModel model =(DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[10];
        for(int i = 0; i<gast.size();i++){
            row[0] = gast.get(i).getNaam();
            row[1] = gast.get(i).getAdres();
            row[2] = gast.get(i).getPostcodeWoonplaats();
            row[3] = gast.get(i).getTelefoonnummer();
            row[4] = gast.get(i).getEmail();
            row[5] = gast.get(i).getGeslacht();
            row[6] = gast.get(i).getGeboortedatum();
            row[7] = gast.get(i).getBekendeSpeler();
            row[8] = gast.get(i).getRating();
            row[9] = gast.get(i).getGewonnenInleggeld();
            model.addRow(row);
        }
        
    }
    
//    public void gastenZoeken(int index){
//        textNaam.setText(getGasten().get(index).getNaam());
//        textAdres.setText(getGasten().get(index).getAdres());
//        textPostcodeWoonplaats.setText(getGasten().get(index).getPostcodeWoonplaats());
//        textTelefoonnummer.setText(getGasten().get(index).getTelefoonnummer());
//        textEmail.setText(getGasten().get(index).getEmail());
//        textRating.setText(Integer.toString(getGasten().get(index).getRating()));
//        textGewonnenInleggeld.setText(Integer.toString(getGasten().get(index).getGewonnenInleggeld()));
//        
//        try {
//            java.util.Date geboortedatum = null;
//            geboortedatum = new SimpleDateFormat("dd-MM-yyyy").parse((String)getGasten().get(index).getGeboortedatum());
//            kalander.setDate(geboortedatum);
//        }catch(Exception e){
//            System.out.println("Error" + e);
//        }
//    } 
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelNaam = new javax.swing.JLabel();
        labelAdres = new javax.swing.JLabel();
        labelPostcodeWoonplaats = new javax.swing.JLabel();
        labelTelefoonnummer = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelGeslacht = new javax.swing.JLabel();
        labelBekendeSpeler = new javax.swing.JLabel();
        textNaam = new javax.swing.JTextField();
        textAdres = new javax.swing.JTextField();
        textPostcodeWoonplaats = new javax.swing.JTextField();
        textTelefoonnummer = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        labelGeboortedatum = new javax.swing.JLabel();
        buttonNieuw = new javax.swing.JButton();
        buttonWijzigen = new javax.swing.JButton();
        buttonOpslaan = new javax.swing.JButton();
        buttonverwijderen = new javax.swing.JButton();
        labelGastZoeken = new javax.swing.JLabel();
        textGastZoeken = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comboboxGeslacht = new javax.swing.JComboBox<>();
        comboboxBekendeSpeler = new javax.swing.JComboBox<>();
        labelRating = new javax.swing.JLabel();
        textRating = new javax.swing.JTextField();
        labelGewonnenInleggeld = new javax.swing.JLabel();
        textGewonnenInleggeld = new javax.swing.JTextField();
        kalander = new com.toedter.calendar.JDateChooser();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 51));

        labelNaam.setText("Naam: ");

        labelAdres.setText("Adres: ");

        labelPostcodeWoonplaats.setText("Postcode woonplaats ");

        labelTelefoonnummer.setText("Telefoonnummer: ");

        labelEmail.setText("E-mail adres:");

        labelGeslacht.setText("Geslacht:");

        labelBekendeSpeler.setText("Bekende speler:");

        textTelefoonnummer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTelefoonnummerKeyTyped(evt);
            }
        });

        labelGeboortedatum.setText("Geboortedatum: ");

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

        buttonverwijderen.setText("Verwijderen");
        buttonverwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonverwijderenActionPerformed(evt);
            }
        });

        labelGastZoeken.setText("gast zoeken");

        textGastZoeken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textGastZoekenActionPerformed(evt);
            }
        });
        textGastZoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textGastZoekenKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naam", "Adres", "PostcodeWoonplaats", "Tel-nummer", "Email", "Geslacht", "Geboortedatum", "Bekende speler", "Rating", "GewonnenInleggeld"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        comboboxGeslacht.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "V" }));

        comboboxBekendeSpeler.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "N" }));

        labelRating.setText("Rating: ");

        textRating.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textRatingKeyTyped(evt);
            }
        });

        labelGewonnenInleggeld.setText("Gewonnen inleggeld: ");

        textGewonnenInleggeld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textGewonnenInleggeldKeyTyped(evt);
            }
        });

        kalander.setDateFormatString("dd.MM.yyyy");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNaam)
                            .addComponent(labelAdres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textAdres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNaam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelGewonnenInleggeld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textGewonnenInleggeld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelGeslacht)
                                .addComponent(labelEmail)
                                .addComponent(labelTelefoonnummer)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelGeboortedatum)
                                    .addComponent(labelBekendeSpeler, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(labelGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelPostcodeWoonplaats))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelRating, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textRating)
                                    .addComponent(textPostcodeWoonplaats)
                                    .addComponent(textTelefoonnummer)
                                    .addComponent(textEmail)
                                    .addComponent(comboboxGeslacht, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboboxBekendeSpeler, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kalander, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                            .addComponent(textGastZoeken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonWijzigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(buttonOpslaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNieuw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonverwijderen, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(471, 471, 471))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNaam)
                    .addComponent(textNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNieuw, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelAdres)
                            .addComponent(textAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPostcodeWoonplaats)
                            .addComponent(textPostcodeWoonplaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonOpslaan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefoonnummer)
                            .addComponent(textTelefoonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmail)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGeslacht)
                            .addComponent(comboboxGeslacht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonWijzigen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(buttonverwijderen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGeboortedatum)
                    .addComponent(kalander, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboboxBekendeSpeler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBekendeSpeler)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRating)
                    .addComponent(textRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGewonnenInleggeld)
                    .addComponent(textGewonnenInleggeld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textGastZoeken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//gast verwijderen
    private void buttonverwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonverwijderenActionPerformed
        if(textNaam.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Graag naam invoeren van de gast die verwijderd moet worden!");
        }else{
            try{
                String query = "delete from gast where naam=?";
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, textNaam.getText().toString());
                int res = ps.executeUpdate();
                tabelGast();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Gast is verwijderd");
                }else{
                    JOptionPane.showMessageDialog(null, "Gast is niet gevonden!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        textNaam.setText("");
    }//GEN-LAST:event_buttonverwijderenActionPerformed
//om op te slaan of de gast toetevoegen
    private void buttonOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpslaanActionPerformed
        if(textNaam!=null && kalander !=null){
            try{
                Connection conn = MySqlConnection();
                String query = "insert into gast (naam, adres, postcodeWoonplaats, telefoonnummer, email, geslacht, geboortedatum, bekendeSpeler, rating, gewonnenInleggeld) values"
                                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, textNaam.getText());
            ps.setString(2, textAdres.getText());
            ps.setString(3, textPostcodeWoonplaats.getText());
            ps.setString(4, textTelefoonnummer.getText());
            ps.setString(5, textEmail.getText());
            String waardeGeslacht = comboboxGeslacht.getSelectedItem().toString();
            ps.setString(6, waardeGeslacht);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String waardeGeboortedatum = sdf.format(kalander.getDate());
            ps.setString(7, waardeGeboortedatum);
            String waardeBekendeSpeler = comboboxBekendeSpeler.getSelectedItem().toString();
            ps.setString(8, waardeBekendeSpeler);
            ps.setInt(9, Integer.parseInt(textRating.getText()));
            ps.setInt(10, Integer.parseInt(textGewonnenInleggeld.getText()));
            
            int res = ps.executeUpdate();
            tabelGast();
            if(res >= 1){
                JOptionPane.showMessageDialog(null, res + "De gast is toegevoegd aan het systeem :)");
            }else{
                JOptionPane.showMessageDialog(null, "Gast toevoegen is mislukt :(");
            }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
            }
            textNaam.setText("");
            textAdres.setText("");
            textPostcodeWoonplaats.setText("");
            textTelefoonnummer.setText("");
            textEmail.setText("");
            textRating.setText("");
            textGewonnenInleggeld.setText("");
            kalander.setCalendar(null);
            
                    
        }else{
            JOptionPane.showMessageDialog(null, "Gegevens zijn niet compleet");
    }    
       
    }//GEN-LAST:event_buttonOpslaanActionPerformed
//wijzigd informatie van gast
    private void buttonWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWijzigenActionPerformed
        if(textNaam!=null && kalander !=null){
            String query = "update gast set adres=?, postcodeWoonplaats=?, telefoonnummer=?, email=?, geslacht=?, geboortedatum=?, bekendeSpeler=?, rating=?, gewonnenInleggeld=? where naam=?";
            PreparedStatement ps = null;
            Connection conn = MySqlConnection();
            try{
            ps = conn.prepareStatement(query);
            ps.setString(1, textAdres.getText());
            ps.setString(2, textPostcodeWoonplaats.getText());
            ps.setString(3, textTelefoonnummer.getText());
            ps.setString(4, textEmail.getText());
            String waardeGeslacht = comboboxGeslacht.getSelectedItem().toString();
            ps.setString(5, waardeGeslacht);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String waardeGeboortedatum = sdf.format(kalander.getDate());
            ps.setString(6, waardeGeboortedatum);
            String waardeBekendeSpeler = comboboxBekendeSpeler.getSelectedItem().toString();
            ps.setString(7, waardeBekendeSpeler);
            ps.setInt(8, Integer.parseInt(textRating.getText()));
            ps.setInt(9, Integer.parseInt(textGewonnenInleggeld.getText()));
            ps.setString(10, textNaam.getText());
            
            int res = ps.executeUpdate();
            tabelGast();
            if(res >= 1){
                JOptionPane.showMessageDialog(null, "De gast is geupdated :)");
            }else {
                JOptionPane.showMessageDialog(null, "Gast updaten is mislukt :(");
            }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
            }
            textNaam.setText("");
            textAdres.setText("");
            textPostcodeWoonplaats.setText("");
            textTelefoonnummer.setText("");
            textEmail.setText("");
            textRating.setText("");
            textGewonnenInleggeld.setText("");
            kalander.setCalendar(null);
            
                    
        }else{
            JOptionPane.showMessageDialog(null, "Gast updaten is mislukt :(");
    }
        
    }//GEN-LAST:event_buttonWijzigenActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        try {
            DefaultTableModel tmodel = (DefaultTableModel)jTable1.getModel();
            
            int selectRowIndex = jTable1.getSelectedRow();
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse((String)tmodel.getValueAt(selectRowIndex, 6));
            kalander.setDate(date); 
            textNaam.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            textAdres.setText(tmodel.getValueAt(selectRowIndex,1).toString());
            textPostcodeWoonplaats.setText(tmodel.getValueAt(selectRowIndex,2).toString());
            textTelefoonnummer.setText(tmodel.getValueAt(selectRowIndex,3).toString());
            textEmail.setText(tmodel.getValueAt(selectRowIndex,4).toString());
            comboboxGeslacht.setSelectedItem(tmodel.getValueAt(selectRowIndex,5).toString());
            kalander.setDateFormatString(tmodel.getValueAt(selectRowIndex,6).toString());
            comboboxBekendeSpeler.setSelectedItem(tmodel.getValueAt(selectRowIndex,7).toString());
            textRating.setText(tmodel.getValueAt(selectRowIndex,8).toString());
            textGewonnenInleggeld.setText(tmodel.getValueAt(selectRowIndex,9).toString());
            
            
        } catch (ParseException ex) {
            Logger.getLogger(BeginScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonNieuwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNieuwActionPerformed
            textNaam.setText("");
            textAdres.setText("");
            textPostcodeWoonplaats.setText("");
            textTelefoonnummer.setText("");
            textEmail.setText("");
            textRating.setText("");
            textGewonnenInleggeld.setText("");
            kalander.setCalendar(null);
    }//GEN-LAST:event_buttonNieuwActionPerformed

    private void textGastZoekenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textGastZoekenActionPerformed
        
    }//GEN-LAST:event_textGastZoekenActionPerformed
//gasten zoeken op naam
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
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            Object[] row = new Object[10];
        for(int i = 0; i<al.size();i++){
            row[0] = al.get(i).getNaam();
            row[1] = al.get(i).getAdres();
            row[2] = al.get(i).getPostcodeWoonplaats();
            row[3] = al.get(i).getTelefoonnummer();
            row[4] = al.get(i).getEmail();
            row[5] = al.get(i).getGeslacht();
            row[6] = al.get(i).getGeboortedatum();
            row[7] = al.get(i).getBekendeSpeler();
            row[8] = al.get(i).getRating();
            row[9] = al.get(i).getGewonnenInleggeld();
            model.addRow(row);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_textGastZoekenKeyReleased

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.hide();
        StartScherm start = new StartScherm();
        start.setVisible(true);
        
    }//GEN-LAST:event_backActionPerformed

    private void textTelefoonnummerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefoonnummerKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_textTelefoonnummerKeyTyped

    private void textRatingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRatingKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_textRatingKeyTyped

    private void textGewonnenInleggeldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textGewonnenInleggeldKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_textGewonnenInleggeldKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//      
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BeginScherm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    private javax.swing.JButton buttonNieuw;
    private javax.swing.JButton buttonOpslaan;
    private javax.swing.JButton buttonWijzigen;
    private javax.swing.JButton buttonverwijderen;
    private javax.swing.JComboBox<String> comboboxBekendeSpeler;
    private javax.swing.JComboBox<String> comboboxGeslacht;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser kalander;
    private javax.swing.JLabel labelAdres;
    private javax.swing.JLabel labelBekendeSpeler;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelGastZoeken;
    private javax.swing.JLabel labelGeboortedatum;
    private javax.swing.JLabel labelGeslacht;
    private javax.swing.JLabel labelGewonnenInleggeld;
    private javax.swing.JLabel labelNaam;
    private javax.swing.JLabel labelPostcodeWoonplaats;
    private javax.swing.JLabel labelRating;
    private javax.swing.JLabel labelTelefoonnummer;
    private javax.swing.JTextField textAdres;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textGastZoeken;
    private javax.swing.JTextField textGewonnenInleggeld;
    public javax.swing.JTextField textNaam;
    private javax.swing.JTextField textPostcodeWoonplaats;
    private javax.swing.JTextField textRating;
    private javax.swing.JTextField textTelefoonnummer;
    // End of variables declaration//GEN-END:variables


}
