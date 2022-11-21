/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.perfumaria.Pages;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mycompany.perfumaria.Perfumaria;
import com.mycompany.perfumaria.model.Product;
import com.mycompany.perfumaria.model.Sale;
import com.mycompany.perfumaria.services.ProductService;
import com.mycompany.perfumaria.services.SaleService;

/**
 *
 * @author guilhermecassianodesouza
 */
public class MainPage extends javax.swing.JFrame {
    private static int idProductSelected;
    private static int idCartProductSelected;

    private static ProductService productService = new ProductService();
    private static SaleService saleService = new SaleService();

    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsNameTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameSelectLabel = new javax.swing.JLabel();
        qtdSpinner = new javax.swing.JSpinner();
        qtdLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();

        qtdSpinner.setEnabled(false);
        addButton.setEnabled(false);
        removeButton.setEnabled(false);
        confirmButton.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PERFUMARIA");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "id", "Nome do Produto", "Qtd", "Valor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        productsNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {null, null},
            new String [] {
                "id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        setTableListProducts();

        jScrollPane2.setViewportView(productsNameTable);

        nameLabel.setText("Nome:");

        nameSelectLabel.setText("");

        qtdLabel.setText("Qtd:");

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Pesquisar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        productsNameTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsNameMouseClicked(evt);
            }
        });

        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });

        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(nameSelectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(qtdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qtdSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(addButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(searchField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameSelectLabel)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtdSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdLabel)
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        removeButton.setText("Excluir");

        exitButton.setText("Sair");

        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(exitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(confirmButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int getIndexProductById(long id) {
        Product product = Perfumaria.productList.stream().filter(e -> e.id == id).findFirst().orElse(null);
        
        if (product == null) {
            return -1;
        }

        return Perfumaria.productList.indexOf(product);
    }

    private int getIndexCartProductById(long id) {
        Product product = Perfumaria.cartList.stream().filter(e -> e.id == id).findFirst().orElse(null);

        if (product == null) {
            return -1;
        }

        return Perfumaria.cartList.indexOf(product);
    }


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
            if (Integer.parseInt(qtdSpinner.getValue().toString()) >= 0) {
                int index = getIndexProductById(idProductSelected);
                if (index >= 0) {
                    Product newProduct = new Product();
                    Product product = Perfumaria.productList.get(index);

                    int cartIndex = getIndexCartProductById(product.id);

                    if (cartIndex >= 0) {
                        int qtd = Integer.parseInt(qtdSpinner.getValue().toString());
                        Product cartProduct = Perfumaria.cartList.get(cartIndex);
                        Perfumaria.cartList.get(cartIndex).setQuantity(cartProduct.getQuantity() + qtd);
                    } else {
                        newProduct.setId(product.getId());
                        newProduct.setName(product.getName());
                        newProduct.setPrice(product.getPrice());
                        newProduct.setQuantity(Integer.parseInt(qtdSpinner.getValue().toString()));
                        Perfumaria.cartList.add(newProduct);
                    }
                    
                    setCartTable(Perfumaria.cartList);
                    setTableListProducts();

                    confirmButton.setEnabled(true);
                    qtdSpinner.setValue(0);
                    addButton.setEnabled(false);
                    nameSelectLabel.setText("");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "A quantidade precisa ser maior que 0!");
            }
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (productsTable.getSelectedRow() != -1) {
            int cartProductIndex = getIndexCartProductById(idCartProductSelected);
        
            if (cartProductIndex >= 0) {
                Perfumaria.cartList.remove(cartProductIndex);
                setCartTable(Perfumaria.cartList);
                setTableListProducts();
            }

            removeButton.setEnabled(false);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void resetProductTable() {
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "id", "Nome do Produto", "Qtd", "Valor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        resetProductTable();

        insertSale();

        updateQuantityProducts();

        Perfumaria.cartList = new ArrayList<Product>();

        Perfumaria.productList = productService.getAllProducts();

        setTableListProducts();

        qtdSpinner.setEnabled(false);
        addButton.setEnabled(false);
        removeButton.setEnabled(false);
        confirmButton.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
    }//GEN-LAST:event_addButtonActionPerformed

    private void insertSale() {
        Sale sale = new Sale();
        
        sale.setIdClient(Perfumaria.person.getId());
        sale.setProducts(Perfumaria.cartList);
        sale.setStatus("EM PROCESSAMENTO");

        double total = Perfumaria.cartList.stream().map(e -> e.getPrice() * e.getQuantity()).reduce(0.0, (subtotal, element) -> subtotal + element);

        sale.setTotal(total);

        saleService.insert(sale);
    }

    private void updateQuantityProducts() {
        for (Product product : Perfumaria.cartList) {
            int index = getIndexProductById(product.getId());
            product.setQuantity(Perfumaria.productList.get(index).getQuantity() - product.getQuantity());
            productService.update(product);
        }
        
        Perfumaria.productList = productService.getAllProducts();

        setTableListProducts();
    }


    public void setTableListProducts() {
        productsNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id", "Nome"
            }
            
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        DefaultTableModel dtmProducts = (DefaultTableModel) productsNameTable.getModel();
        
        for (Product product : Perfumaria.productList) {
            int indexCartProduct = getIndexCartProductById(product.getId());
            boolean valid = (indexCartProduct < 0 ? product.getQuantity() : product.getQuantity() - Perfumaria.cartList.get(indexCartProduct).getQuantity()) > 0;
            
            if (valid) {
                Object[] data = {product.id, product.name};
                dtmProducts.addRow(data);
            }
        }
    }

    private void setCartTable(List<Product> products) {
        resetProductTable();

        for (Product product : products) {
            DefaultTableModel dtmProducts = (DefaultTableModel) productsTable.getModel();

            Object[] data = {product.id, product.name, product.quantity, product.price, product.quantity * product.price};
            dtmProducts.addRow(data);
        }
    }
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int options = JOptionPane.showConfirmDialog(null,"Deseja voltar para tela de login?", "Sair",JOptionPane.OK_CANCEL_OPTION);
        if (options == 0) {
            Perfumaria.mainPage.setVisible(false);
            Perfumaria.loginPage.setVisible(true);
        }
    }

    public void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {
        idCartProductSelected = Integer.parseInt(productsTable.getValueAt(productsTable.getSelectedRow(), 0).toString());
        if (productsTable.getSelectedRow() != -1) {
            removeButton.setEnabled(true);
        }
    }

    public void tableProductsNameMouseClicked(java.awt.event.MouseEvent evt) {
        if(productsNameTable.getSelectedRow() != -1){
           idProductSelected = Integer.parseInt(productsNameTable.getValueAt(productsNameTable.getSelectedRow(), 0).toString());
           int indexSelected = getIndexProductById(idProductSelected);
           int indexCartSelected = getIndexCartProductById(idProductSelected);

           nameSelectLabel.setText(productsNameTable.getValueAt(productsNameTable.getSelectedRow(), 1).toString());

           int quant = indexCartSelected < 0 ? Perfumaria.productList.get(indexSelected).getQuantity() : Perfumaria.productList.get(indexSelected).getQuantity() - Perfumaria.cartList.get(indexCartSelected).getQuantity();

           qtdSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, quant, 1));

           qtdSpinner.setEnabled(true);
           addButton.setEnabled(true);
        }
    }

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameSelectLabel;
    private javax.swing.JTable productsNameTable;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel qtdLabel;
    private javax.swing.JSpinner qtdSpinner;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
