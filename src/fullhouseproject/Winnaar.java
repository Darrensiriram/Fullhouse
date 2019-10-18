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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nour al Zahraa
 */
public class Winnaar extends javax.swing.JFrame {

    /**
     * Creates new form Winnaar
     */
    public Winnaar() {
        initComponents();
        tabelGast();
        tabelToernooi1();
        tableOverzicht();
    }
    public void tableOverzicht(){
        ArrayList<WinnaarVariable> winnaar = getToernooiInschrijving();
        DefaultTableModel model = (DefaultTableModel) overzicht.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<winnaar.size();i++){
            row[0] = winnaar.get(i).getGnaam();
            row[1] = winnaar.get(i).getTnaam();
            row[2] = winnaar.get(i).getTafel();
            row[3] = winnaar.get(i).getRonde();
            
            model.addRow(row);
        }
    }

    public ArrayList<WinnaarVariable> getToernooiInschrijving(){
        ArrayList<WinnaarVariable>winnaars = new ArrayList<WinnaarVariable>();
        Connection conn = MySqlConnection();
        String query = "select * from winnaar";
        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                WinnaarVariable winnaar = new WinnaarVariable
                (rs.getString("gnaam"), 
                rs.getString("tnaam"),
                rs.getString("tafel"), 
                rs.getString("ronde"));
                winnaars.add(winnaar);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return winnaars;
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
                ToernooiVariable toernooi = new ToernooiVariable(rs.getString("naam"), rs.getString("locatie"), rs.getString("datum"), rs.getString("beginEindTijd"), rs.getString("beschrijving") , rs.getString("condities"),
                    rs.getInt("maxInschrijving"),rs.getInt("inleggeld"), rs.getString("Uiterste_inschrijfdatum"), rs.getInt("ronde"));
                
                toernooien.add(toernooi);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return toernooien;
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
            System.out.println("error: " + e);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaToernooi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaGast = new javax.swing.JTextArea();
        textTafel = new javax.swing.JTextField();
        textRonde = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableToernooi = new javax.swing.JTable();
        zoeken = new javax.swing.JTextField();
        toernooiNaam = new javax.swing.JTextField();
        gastNaam = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        overzicht = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableGast = new javax.swing.JTable();
        inschrijven = new javax.swing.JButton();
        uitschrijven = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gnaam: ");

        jLabel2.setText("Tnaam:");

        jLabel3.setText("Tafel:");

        jLabel4.setText("Ronde:");

        areaToernooi.setColumns(5);
        areaToernooi.setRows(1);
        jScrollPane1.setViewportView(areaToernooi);

        areaGast.setColumns(5
        );
        areaGast.setRows(1);
        jScrollPane2.setViewportView(areaGast);

        textTafel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTafelActionPerformed(evt);
            }
        });
        textTafel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTafelKeyTyped(evt);
            }
        });

        textRonde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textRondeKeyTyped(evt);
            }
        });

        tableToernooi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Naam"
            }
        ));
        tableToernooi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableToernooiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableToernooi);

        zoeken.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zoekenKeyReleased(evt);
            }
        });

        toernooiNaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toernooiNaamKeyReleased(evt);
            }
        });

        gastNaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gastNaamKeyReleased(evt);
            }
        });

        overzicht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gnaam", "Tnaam", "Tafel", "Ronde"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        overzicht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                overzichtMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(overzicht);

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
        jScrollPane5.setViewportView(tableGast);

        inschrijven.setText("registreren");
        inschrijven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inschrijvenActionPerformed(evt);
            }
        });

        uitschrijven.setText("Uitschrijven");
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

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel5.setText("gast zoeken:");

        jLabel6.setText("toernooi zoeken:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zoeken, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(textTafel)
                    .addComponent(textRonde))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(back, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uitschrijven, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inschrijven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gastNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toernooiNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(469, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(gastNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inschrijven))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textRonde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toernooiNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zoeken, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(uitschrijven)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textTafel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(clear)
                        .addGap(49, 49, 49)
                        .addComponent(back)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(486, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)))
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.hide();
        StartScherm start = new StartScherm();
        start.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void uitschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uitschrijvenActionPerformed
        if(areaGast.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Graag naam invoeren van de gast die uitgeschreven moet worden!");
        }else{
            try{
                String query = "delete from winnaar where gnaam=?";
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, areaGast.getText().toString());
                int res = ps.executeUpdate();
                tableOverzicht();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Gast is geen winnaar meer");
                }else{
                    JOptionPane.showMessageDialog(null, "Gast is niet gevonden!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        areaGast.setText("");
        areaToernooi.setText("");
        textTafel.setText("");
        textRonde.setText("");
    }//GEN-LAST:event_uitschrijvenActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        areaGast.setText("");
        areaToernooi.setText("");
        textTafel.setText("");
        textRonde.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void inschrijvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inschrijvenActionPerformed
        if(areaGast!=null){
            try{
                Connection conn = MySqlConnection();
                String query = "insert into winnaar (gnaam, tnaam, tafel, ronde) values"
                                + "(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, areaGast.getText());
            ps.setString(2, areaToernooi.getText());
            ps.setString(3, textTafel.getText());
            ps.setString(4, textRonde.getText());
            
            int res = ps.executeUpdate();
            tableOverzicht();
            if(res >= 1){
                JOptionPane.showMessageDialog(null, res + "Gast is gerestristreed als winnaar");
            }else{
                JOptionPane.showMessageDialog(null, "Regristreren is mislukt :(");
            }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
            }
            areaGast.setText("");
            areaToernooi.setText("");
            textTafel.setText("");
            textRonde.setText("");
            
                    
        }else{
            JOptionPane.showMessageDialog(null, "Gegevens zijn niet compleet");
    }  
    }//GEN-LAST:event_inschrijvenActionPerformed

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

    private void gastNaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gastNaamKeyReleased
        //textGastZoeken.getText().toString();
        ArrayList<Gast>al = null;
        al = new ArrayList<Gast>();
        String val = gastNaam.getText().toString();
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
    }//GEN-LAST:event_gastNaamKeyReleased

    private void toernooiNaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toernooiNaamKeyReleased
        ArrayList<ToernooiVariable>al = null;
        al = new ArrayList<ToernooiVariable>();
        String val = toernooiNaam.getText().toString();
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
    }//GEN-LAST:event_toernooiNaamKeyReleased

    private void overzichtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overzichtMouseClicked
        try{
            DefaultTableModel tmodel = (DefaultTableModel)overzicht.getModel();
            int selectRowIndex = overzicht.getSelectedRow();
            areaGast.setText(tmodel.getValueAt(selectRowIndex,0).toString());
            areaToernooi.setText(tmodel.getValueAt(selectRowIndex,1).toString());
            textTafel.setText(tmodel.getValueAt(selectRowIndex,2).toString());
            textRonde.setText(tmodel.getValueAt(selectRowIndex,3).toString());
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_overzichtMouseClicked

    private void textRondeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textRondeKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_textRondeKeyTyped

    private void textTafelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTafelKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACKSPACE) || (c==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_textTafelKeyTyped

    private void textTafelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTafelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTafelActionPerformed

    private void zoekenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zoekenKeyReleased
        ArrayList<WinnaarVariable>al = null;
        al = new ArrayList<WinnaarVariable>();
        String val = zoeken.getText().toString();
        try{
            Connection conn = MySqlConnection();
            String query = "select * from winnaar where gnaam like '%" + val + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                WinnaarVariable winnaar = new WinnaarVariable(rs.getString("gnaam"), rs.getString("tnaam"), rs.getString("tafel"), rs.getString("ronde"));
                al.add(winnaar);
            }
            DefaultTableModel model = (DefaultTableModel)overzicht.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
            for(int i = 0; i<al.size();i++){
                row[0] = al.get(i).getGnaam();
                row[1] = al.get(i).getTnaam();
                row[2] = al.get(i).getTafel();
                row[3] = al.get(i).getRonde();
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_zoekenKeyReleased

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
//            java.util.logging.Logger.getLogger(Winnaar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Winnaar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Winnaar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Winnaar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Winnaar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaGast;
    private javax.swing.JTextArea areaToernooi;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JTextField gastNaam;
    private javax.swing.JButton inschrijven;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable overzicht;
    private javax.swing.JTable tableGast;
    private javax.swing.JTable tableToernooi;
    private javax.swing.JTextField textRonde;
    private javax.swing.JTextField textTafel;
    private javax.swing.JTextField toernooiNaam;
    private javax.swing.JButton uitschrijven;
    private javax.swing.JTextField zoeken;
    // End of variables declaration//GEN-END:variables
}
