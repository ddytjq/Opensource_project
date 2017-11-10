package notebook1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

public class Form extends javax.swing.JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JMenuItem createConnection;
    private javax.swing.JMenuItem exit;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JButton reset;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    
    private Connection mysqlCon = null;
    
    private final String database  = "notebook";
    private final String tableName  = database + ".table1";
    private final String mysqlPass = "";
    
    private final String INSERT_STMT = "INSERT INTO "   + tableName + " VALUES(?, ?, ?)";
    private final String DELETE_STMT = "DELETE FROM "   + tableName + " WHERE (name=? AND city=? AND phone=?)";
    private final String SELECT_STMT = "SELECT * FROM " + tableName;
    
    public Form() {
        initComponents();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = d.width/2 - this.getWidth()/2,
            y = d.height/2 - this.getHeight()/2;
        setLocation(x, y);
    }
    

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        createConnection = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("notebook1");
        setResizable(false);

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        infoPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("City :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Phone :");

        insert.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        insert.setText("insert");
        insert.setEnabled(false);
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        reset.setText("reset");
        reset.setEnabled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(phone))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(20);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        scrollPane.setViewportView(table);

        jMenu1.setText("File");

        createConnection.setText("Create Connection");
        createConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createConnectionActionPerformed(evt);
            }
        });
        jMenu1.add(createConnection);
        jMenu1.add(jSeparator1);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        for(Component comp : infoPanel.getComponents())
            if(comp instanceof JTextField)
                ((JTextField)comp).setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        try{
            if(isEmpty())
                throw new Exception("Please enter all data!");

            boolean success = insert();
            if(success)
                showData();
            else
                throw new Exception("An error occure at inserting!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_insertActionPerformed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if(evt.getKeyCode() != KeyEvent.VK_DELETE)
            return;        
        int row = table.getSelectedRow();
        if(row < 0)
            return;
        
        Object Name  = table.getValueAt(row, 0),
               City  = table.getValueAt(row, 1),
               Phone = table.getValueAt(row, 2);
        try {
            boolean success = delete(new Object[] {Name, City, Phone});
            if(success)
                showData();
            else
                throw new Exception("an error occure at deleting!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tableKeyReleased

    private void createConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createConnectionActionPerformed
        load();
    }//GEN-LAST:event_createConnectionActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void load() {
        try {
            // found jdbc driver for mysql
            Class.forName("com.mysql.jdbc.Driver");
            // create connection to mysql
            String url   = "jdbc:mysql://localhost:3306/",
                   uname = "root",
                   upass = "0813";  // mysql password
            
            mysqlCon = DriverManager.getConnection(url, uname, upass);
            
            JOptionPane.showMessageDialog(this, "connection successfull!", "info", JOptionPane.INFORMATION_MESSAGE);

            createConnection.setEnabled(false);
            insert.setEnabled(true);
            reset.setEnabled(true);
            
            createDatabase();
            createTable();
            showData();
            
            // set database
            mysqlCon.setCatalog(database);

        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "An error occur!" + e.getMessage());
        }
    }
    
    private void createDatabase() throws Exception {
        Statement stm = mysqlCon.createStatement();
        String query = "CREATE DATABASE IF NOT EXISTS " + database +
                       " DEFAULT CHARACTER SET utf8 COLLATE utf8_persian_ci";
        stm.execute(query);
    }

    private void createTable() throws Exception {
        Statement stm = mysqlCon.createStatement();

        String query = "CREATE TABLE IF NOT EXISTS "     + tableName +
                        "(name VARCHAR( 15 ) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL ," +
                        " city VARCHAR( 15 ) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL ," +
                        " phone VARCHAR( 15 ) NOT NULL ) ";
        stm.execute(query);
    }

    private boolean insert() throws Exception {
        PreparedStatement pstm = mysqlCon.prepareStatement(INSERT_STMT);
        
        pstm.setObject(1, name.getText().trim());
        pstm.setObject(2, city.getText().trim());
        pstm.setObject(3, phone.getText().trim());

        int result = pstm.executeUpdate();
        return (result > 0);
    }

    private boolean delete(Object[] data) throws Exception {
        PreparedStatement pstm = mysqlCon.prepareStatement(DELETE_STMT);
        
        pstm.setObject(1, data[0]);
        pstm.setObject(2, data[1]);
        pstm.setObject(3, data[2]);

        int result = pstm.executeUpdate();
        return (result > 0);
    }

    private Vector getData() throws Exception {
        Vector data = new Vector();

        Statement stm = mysqlCon.createStatement();
        ResultSet result = stm.executeQuery(SELECT_STMT);

        while(result.next()){
            Vector row = new Vector();

            row.addElement(result.getObject("name"));
            row.addElement(result.getObject("city"));
            row.addElement(result.getObject("phone"));

            data.addElement(row);
        }
        return data;
    }

    private void showData() throws Exception {
        final Vector data = getData();
        
        final String[] columns = {
          "Name","City","Phone"
        };

        table.setModel(new AbstractTableModel() {
            @Override public int getRowCount() {
                return (data == null ? 0 : data.size());
            }
            @Override public int getColumnCount() {
                return columns.length;
            }
            @Override public String getColumnName(int columnIndex) {
                return columns[columnIndex];
            }
            @Override public Object getValueAt(int rowIndex, int columnIndex) {
                Vector row = (Vector)data.elementAt(rowIndex);
                return row.elementAt(columnIndex);
            }
        });

        int count = table.getColumnModel().getColumnCount();
        for(int i = 0; i < count; ++i){
            this.table.getColumnModel().getColumn(i).setMinWidth(100);
            this.table.getColumnModel().getColumn(i).setMaxWidth(150);
        }

    }
    
    private boolean isEmpty() {
        boolean emptyName  = name.getText().equals("");
        boolean emptyCity  = city.getText().equals("");
        boolean emptyPhone = phone.getText().equals("");
        
        return (emptyName || emptyCity || emptyPhone);
    }
}