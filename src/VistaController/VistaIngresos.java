/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaController;
import Model.Producto;
import Conexion.Conexion;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Marca;
import Model.MarcaRepuesto;
import Model.TipoProducto;
import javax.swing.JOptionPane;
import Export.ExportarExcel;
import java.io.IOException;

/**

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas
 */
public class VistaIngresos extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    
    /**
     * Creates new form VistaIngresos
     */
    public VistaIngresos() {
        initComponents();
        model.addColumn("ID / CODIGO");
        model.addColumn("Nombre Producto");
        model.addColumn("Tipo de Repuestos");
        model.addColumn("Marca Repuesto");
        model.addColumn("Marca Vehiculo");
        model.addColumn("Modelos Compatibles");
        model.addColumn("Cantidad recepcionada");
        llenarTabla();
        llenarComboBox();        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombreProducto = new javax.swing.JTextField();
        btn_ingresar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        comboBox_MarcaRepuesto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_modeloCompatible = new javax.swing.JTextField();
        spinner_CantidadRepuesto = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        comboBox_Marca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboBox_TipoProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combo_productos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_valorProducto = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setText("GESTION DE INVENTARIO");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel2.setText("Marca Repuesto:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel3.setText("Nombre Producto:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel4.setText("Marca Vehiculo:");

        btn_ingresar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_excel.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_excel.setText("EXCEL");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_productos);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel8.setText("Modelos Compatibles:");

        txt_modeloCompatible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modeloCompatibleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel9.setText("Cantidad recepcionada:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel5.setText("Tipo de Producto:");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel6.setText("Codigo Producto a Modificar:");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel10.setText("Valor producto:");

        txt_valorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBox_MarcaRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_modeloCompatible, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBox_TipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinner_CantidadRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combo_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_valorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(combo_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBox_TipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btn_modificar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBox_MarcaRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBox_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_modeloCompatible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinner_CantidadRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ingresar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_excel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void llenarTabla(){
        model.setRowCount(0);
        tbl_productos.setModel(model);
        
        try {
            
            ArrayList <Producto> tablaProductos = Producto.buscarTodasMarcas();
            
            for (Producto productoIndex : tablaProductos) {
                
                Object[] objeto = new Object[8];
                
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getNombreProducto();
                objeto[2]= productoIndex.getTipoProducto();
                objeto[3]= productoIndex.getMarcaRepuesto();
                objeto[4]= productoIndex.getMarcaVehiculo();
                objeto[5]= productoIndex.getModelosCompatibles();
                objeto[6]= productoIndex.getCantidadRecepcionada();
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
               
                   
                
                
                
                
            }
            
        } catch (Exception e) {
        }
        
        
    }     
    
    
    
    
    public void llenarComboBox(){
    
        try {
            
            combo_productos.removeAllItems();
            comboBox_Marca.removeAllItems();
            comboBox_MarcaRepuesto.removeAllItems();
            comboBox_TipoProducto.removeAllItems();
            
            ArrayList<Marca> tablaMarca = Marca.buscarTodasMarcas();
            ArrayList<MarcaRepuesto> tablaMarcaRepuestos = MarcaRepuesto.buscarTodasMarcas();
            ArrayList<TipoProducto> tablaTipoProductos = TipoProducto.listarTodos();
            ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();
            
            
            for (Marca marca : tablaMarca) {
                comboBox_Marca.addItem(marca.getNombreMarca());
            }
            
            
            for (TipoProducto TipoProducto : tablaTipoProductos) {
                comboBox_TipoProducto.addItem(TipoProducto.getTipoNombre());
                
            }
            
            
            for (MarcaRepuesto MarcaRepuesto : tablaMarcaRepuestos) {
                comboBox_MarcaRepuesto.addItem(MarcaRepuesto.getNombreMarca());
            }
            
            
         for (Producto producto : tablaProductos) {
             
             int estado = producto.getProducto_estado();
                
                if (estado != 1) {
                     combo_productos.addItem(String.valueOf(producto.getId_producto()));
                }
               
}
            
           
            
        } catch (Exception e) {
        }
        
    
    }
    
    
    
    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
 int id_producto = Integer.parseInt(combo_productos.getSelectedItem().toString());
    int estadoEliminar = 1; // Estado lógico de eliminación

    try {
        boolean success = Producto.modificarEstadoProducto(estadoEliminar, id_producto);

        if (success) {
            JOptionPane.showMessageDialog(this, "Se ha eliminado el producto: " + combo_productos.getSelectedItem().toString());
            
        } else {
            JOptionPane.showMessageDialog(this, "Error: No se pudo eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        System.err.println("Error al eliminar el producto: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
        
        llenarTabla();
        llenarComboBox(); 
        
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    
 
    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
    
        String nombreProducto = txt_nombreProducto.getText().trim();
        String tipodeProducto = comboBox_TipoProducto.getSelectedItem().toString();
        String marcaRepuesto = comboBox_MarcaRepuesto.getSelectedItem().toString();
        String marcaVehiculo = comboBox_Marca.getSelectedItem().toString();
        String modelosCompatibles = txt_modeloCompatible.getText().trim();
        int Cantidadrecepcionada = (int) spinner_CantidadRepuesto.getValue();
        int id_marca = Producto.VerificacionAsignacion_idMarca(marcaVehiculo);
        int id_marcaRepuesto = Producto.VerificacionAsignacion_idMarcaRepuestos(marcaRepuesto);
        int id_tipo = Producto.VerificacionAsignacion_idTipo(tipodeProducto);
        
        
        try {
            boolean sucess = Producto.ingresoProducto(nombreProducto, tipodeProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, Cantidadrecepcionada, id_marca, id_marcaRepuesto, id_tipo);
            
            if (sucess) {
                JOptionPane.showMessageDialog(this, "Marca Agrgada Exitosamente");
                
            } else {
            
                JOptionPane.showMessageDialog(this, "No fue posible agregar la marca error en VistaController");
            }
           
           
        } catch (Exception e) {
        }
        

llenarTabla();
llenarComboBox();






    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        
        
        String nombreProducto = txt_nombreProducto.getText().trim();
        String tipodeProducto = comboBox_TipoProducto.getSelectedItem().toString();
        String marcaRepuesto = comboBox_MarcaRepuesto.getSelectedItem().toString();
        String marcaVehiculo = comboBox_Marca.getSelectedItem().toString();
        String modelosCompatibles = txt_modeloCompatible.getText().trim();
        int Cantidadrecepcionada = (int) spinner_CantidadRepuesto.getValue();
        int id_marca = Producto.VerificacionAsignacion_idMarca(marcaVehiculo);
        int id_marcaRepuesto = Producto.VerificacionAsignacion_idMarcaRepuestos(marcaRepuesto);
        int id_tipo = Producto.VerificacionAsignacion_idTipo(tipodeProducto);
        int id_producto = Integer.parseInt(combo_productos.getSelectedItem().toString());
        
        
        
        try {
            
            boolean sucess = Producto.modificarProducto(nombreProducto, tipodeProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, Cantidadrecepcionada, id_marca, id_marcaRepuesto, id_tipo, id_producto);
            if (sucess) {
                
                JOptionPane.showMessageDialog(this, "Modificacion del producto realizada con exito");
                
            }
            
        } catch (Exception e) {
        }
   
        
     




        
llenarTabla();
llenarComboBox();

        
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        
        ExportarExcel obj;

try {
    obj = new ExportarExcel();
    obj.exportarExcel(tbl_productos);
} catch (IOException ex) {
    System.out.println("Error: " + ex);
}
        
        
    }//GEN-LAST:event_btn_excelActionPerformed

    
    
    
    
    
    private void txt_modeloCompatibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modeloCompatibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modeloCompatibleActionPerformed

    private void txt_valorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> comboBox_Marca;
    private javax.swing.JComboBox<String> comboBox_MarcaRepuesto;
    private javax.swing.JComboBox<String> comboBox_TipoProducto;
    private javax.swing.JComboBox<String> combo_productos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinner_CantidadRepuesto;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JTextField txt_modeloCompatible;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_valorProducto;
    // End of variables declaration//GEN-END:variables
}
