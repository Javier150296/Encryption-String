/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Objects.Encriptador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JAVIER1
 */
public class PrincipalF extends JFrame {
    private JFileChooser fcBuscar;
    private NButton btnBuscar;
    private JLabel lblBuscar;
    private JLabel lblClave;
    private JTextField txtClave;
    private JButton btnEncript;
    private JButton btnDesencript;
    private Encriptador fEncript;
    private FileNameExtensionFilter filter;
    
    public PrincipalF(){
        super("Encriptador de Archivos");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 200);
        super.setLayout(new BorderLayout());
        
        fcBuscar= new JFileChooser();
        filter= new FileNameExtensionFilter("Archivos de texto", "txt");
        fcBuscar.setFileFilter(filter);
        btnBuscar = new NButton("/Images/search.png");
        lblBuscar = new JLabel ("Buscar archivo ");
        JPanel pnlNorte = new JPanel();
        pnlNorte.add(lblBuscar);
        pnlNorte.add(btnBuscar);
        
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion=fcBuscar.showOpenDialog(PrincipalF.this);
                if(opcion== JFileChooser.APPROVE_OPTION){
                    fEncript = new Encriptador(fcBuscar.getSelectedFile().getAbsolutePath());
                    JOptionPane.showMessageDialog(PrincipalF.this, "Se ha seleccionado el archivo "+fcBuscar.getSelectedFile().getName(), "Seleccionado", JOptionPane.INFORMATION_MESSAGE);
                }else if(opcion == JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(PrincipalF.this, "Debe seleccionar un archivo", "Cancelacion", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        lblClave = new JLabel("Clave :");
        txtClave = new JTextField("key");
        txtClave.setPreferredSize(new Dimension(200,30));
        JPanel pnlCentro = new JPanel();
        pnlCentro.add(lblClave);
        pnlCentro.add(txtClave);
        
        btnEncript = new JButton("Encriptar");
        btnDesencript = new JButton("Desencriptar");
        JPanel pnlSur = new JPanel();
        pnlSur.add(btnEncript);
        pnlSur.add(btnDesencript);
        
        btnEncript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fEncript!= null){
                    fcBuscar.showSaveDialog(PrincipalF.this);
                    try {
                        fEncript.Encriptar(fcBuscar.getSelectedFile()+".txt", txtClave.getText());
                        JOptionPane.showMessageDialog(PrincipalF.this, "Se ha encriptado el archivo "+fcBuscar.getSelectedFile().getName(), "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(PrincipalF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(PrincipalF.this, "Debe seleccionar un archivo", "Cancelacion", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        btnDesencript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion=fcBuscar.showOpenDialog(PrincipalF.this);
                if(fEncript!= null){
                    if(opcion== JFileChooser.APPROVE_OPTION){
                        try {
                            fEncript.Desencriptar(fcBuscar.getSelectedFile().getAbsolutePath(),txtClave.getText());
                            JOptionPane.showMessageDialog(PrincipalF.this, "Se ha desencriptado el archivo "+fcBuscar.getSelectedFile().getName(), "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            Logger.getLogger(PrincipalF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    JOptionPane.showMessageDialog(PrincipalF.this, "Se ha seleccionado el archivo "+fcBuscar.getSelectedFile().getName(), "Seleccionado", JOptionPane.INFORMATION_MESSAGE);
                    }else if(opcion == JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(PrincipalF.this, "Debe seleccionar un archivo", "Cancelacion", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(PrincipalF.this, "Debe seleccionar un archivo", "Cancelacion", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        super.add(pnlNorte,BorderLayout.NORTH);
        super.add(pnlCentro,BorderLayout.CENTER);
        super.add(pnlSur,BorderLayout.SOUTH);
        super.setVisible(true);
    }
}
