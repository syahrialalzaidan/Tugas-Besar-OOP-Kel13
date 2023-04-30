/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

/**
 *
* @author ilmag
*/
public class Inventory<T extends Objects> extends javax.swing.JFrame {
    /**
     * Creates new form Inventory
    * With Generics
    */

    // ATTRIBUTES

    // Stores the types of items in invetory and their count (Visible to user)
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    // Stores the actual instantiation of objects of items in inventory
    private ArrayList<T> inventoryList = new ArrayList<T>();
    private String inventoryType;
    private String simOwner;

    // ALGORITHM

    public Inventory(String inventoryType, String simOwner) {
        /* Constructor */
        this.inventoryType = inventoryType;
        this.simOwner = simOwner;
        // For GUI
        initComponents();
    }

    public HashMap<String, Integer> getInventory() {
        /* Getter inventory */
        return inventory;
    }

    public ArrayList<T> getInventoryList() {
        /* Getter list of inventory */
        return inventoryList;
    }

    public String getInventoryType() {
        /* Getter inventoryType */
        return this.inventoryType;
    }

    public T getInventoryElement(T item) throws Exception {
        /* Returns and REDUCES an object instantiation from inventory 
         * 
         * @param T item
         * 
         * Example : getInventoryitem(kasurSingle)
        */
        T inventoryItem = null;
        int index = -1;

        for (int i = 0; i < inventoryList.size(); i++) {
            T currentEl = inventoryList.get(i);
            inventoryItem = currentEl;
            if (currentEl.equals(item)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            inventoryItem = null;
        }
        reduceInventory(item);
        return inventoryItem;
    }

    public T getInventoryElement(String itemName) throws Exception {
        /* Returns and REDUCES the oldest item with the same name as param from inventory 
         * 
         * @param T item
         * 
         * Example : getInventoryItem("Kasur Single")
        */
        T inventoryItem = null;
        int index = -1;

        for (int i = 0; i < inventoryList.size(); i++) {
            T currentEl = inventoryList.get(i);
            inventoryItem = currentEl;
            if (currentEl.getName().equals(itemName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            inventoryItem = null;
        }
        reduceInventory(itemName);
        return inventoryItem;
    }

    public int getValue(T item) {
        /* Getter value count of an item
         * 
         * @param T item (instansiasi dari sebuah generic type Objects)
         * Contoh : getValue(kasurSingle)
         */
        if (inventory.containsKey(item.getName())) {
            return inventory.get(item.getName());
        } else {
            return 0;
        }
    }

    public int getValue(String itemName) {
        /* Getter value count of an item
         * 
         * @param String itemName (String sebuah nama item)
         * Contoh : getValue("Kasur Single");
         */
        if (inventory.containsKey(itemName)) {
            return inventory.get(itemName);
        } else {
            return 0;
        }
    }

    public String getSimOwner() {
        /* Getter simOwner */
        return simOwner;
    }

    public void setInventoryType(String inventoryType) {
        /* Setter inventoryType 
         * Can only be done if inventory and inventoryList are empty
        */
        if (inventory.isEmpty() && inventoryList.isEmpty()) {
            this.inventoryType = inventoryType;
        }
    }

    public void setSimOwner(String simOwner) {
        /* Setter simOwner */
        this.simOwner = simOwner;
    }

    public void addInventory(T item) {
        /* Increments or adds item to inventory */
        
        // Adds object to inventoryList ArrayList
        inventoryList.add(item);

        // Adds count to inventory HashMap
        if (inventory.containsKey(item.getName())) {
            inventory.put(item.getName(), inventory.get(item.getName()) + 1);
        } else {
            inventory.put(item.getName(), 1);
        }
    }

    public void reduceInventory(T item) throws Exception {
        /* Decrements from inventory if item exists 
         * If not, then an error is thrown
         * 
         * @param T item
         * Contoh: reduceInventory(kasurSingle)
        */
        inventoryList.remove(item);
        if (inventory.containsKey(item.getName())) {
            inventory.put(item.getName(), inventory.get(item.getName()) - 1);
            removeFromInventory();
        } else {
            throw new Exception("Item doesn't exist!");
        }
    }

    public void reduceInventory(String itemName) throws Exception {
        /* Decrements from inventory if item exists 
         * If not, then an error is thrown
         * Removes the newest added object with the name same as parameter
         * 
         * @param String itemName
         * Contoh: reduceInventory("Kasur Single")
        */
        if (inventory.containsKey(itemName)) {
            inventory.put(itemName, inventory.get(itemName) - 1);
            removeFromInventory();
            // Removing the oldest added object to inventoryList that has the name same as parameter
            for (int i = 0; i < inventoryList.size(); i++) {
                if (inventoryList.get(i).getName().equals(itemName)) {
                    inventoryList.remove(i);
                    break;
                }
            }
        } else {
            throw new Exception("Item doesn't exist!");
        }
    }

    public void removeFromInventory() {
        /* Helper function */
        /* Removes from inventory if the value of an item reaches 0 */
        Iterator<Map.Entry<String, Integer>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
                System.out.println(entry.getKey() + " is deleted from inventory because the amount is now 0.");
            }
        }
    }

    public void printInventory() {
        /* Prints items in HashMap. If HashMap has "Kasur Queen Size" with the value of 2 
        * and "Kasur Single" with the value of 1, then it will print:
        * 
        * List of Items in inventory
        * Kasur Queen Size = 2
        * Kasur Single = 1
        */
        System.out.printf("List of %s in inventory\n", inventoryType);
        System.out.println("---------------------------------------");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Buy some stuff?");
        } else {
            for (String item : inventory.keySet()) {
                int count = inventory.get(item);
                System.out.println(item + " = " + count);
            }
        }
    }

    /* GUI */
    /**
     * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInventory = new javax.swing.JLabel();
        lblSimName = new javax.swing.JLabel();
        tblInventoryFoodScrollPane = new javax.swing.JScrollPane();
        tblInventoryFood = new javax.swing.JTable();
        lblFood = new javax.swing.JLabel();
        lblDish = new javax.swing.JLabel();
        tblInventoryDishScrollPane = new javax.swing.JScrollPane();
        tblInventoryDish = new javax.swing.JTable();
        lblItem = new javax.swing.JLabel();
        tblInventoryItemScrollPane = new javax.swing.JScrollPane();
        tblInventoryItem = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(256, 503));

        lblInventory.setFont(new java.awt.Font("Public Sans", 1, 12)); // NOI18N
        lblInventory.setText("INVENTORY");

        lblSimName.setFont(new java.awt.Font("Public Sans", 1, 20)); // NOI18N
        lblSimName.setText("Melly");

        tblInventoryFood.setModel(new javax.swing.table.DefaultTableModel(
            new Objects [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Count"
            }
        ));
        tblInventoryFoodScrollPane.setViewportView(tblInventoryFood);

        lblFood.setFont(new java.awt.Font("Public Sans", 0, 12)); // NOI18N
        lblFood.setText("Food");

        lblDish.setFont(new java.awt.Font("Public Sans", 0, 12)); // NOI18N
        lblDish.setText("Dish");

        tblInventoryDish.setModel(new javax.swing.table.DefaultTableModel(
            new Objects [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Count"
            }
        ));
        tblInventoryDishScrollPane.setViewportView(tblInventoryDish);

        lblItem.setFont(new java.awt.Font("Public Sans", 0, 12)); // NOI18N
        lblItem.setText("Item");

        tblInventoryItem.setModel(new javax.swing.table.DefaultTableModel(
            new Objects [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Count"
            }
        ));
        tblInventoryItemScrollPane.setViewportView(tblInventoryItem);

        btnClose.setFont(new java.awt.Font("Public Sans SemiBold", 1, 12)); // NOI18N
        btnClose.setText("X");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tblInventoryFoodScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tblInventoryItemScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(lblItem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDish, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFood, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSimName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblInventory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClose))
                            .addComponent(tblInventoryDishScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInventory)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSimName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblInventoryFoodScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblInventoryDishScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblInventoryItemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory("Food", "SimName").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblDish;
    private javax.swing.JLabel lblFood;
    private javax.swing.JLabel lblInventory;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblSimName;
    private javax.swing.JTable tblInventoryDish;
    private javax.swing.JScrollPane tblInventoryDishScrollPane;
    private javax.swing.JTable tblInventoryFood;
    private javax.swing.JScrollPane tblInventoryFoodScrollPane;
    private javax.swing.JTable tblInventoryItem;
    private javax.swing.JScrollPane tblInventoryItemScrollPane;
    // End of variables declaration//GEN-END:variables
}