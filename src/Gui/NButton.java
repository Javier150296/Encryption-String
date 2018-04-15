/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author JAVIER1
 */
public class NButton extends JButton{
    
    public NButton(String path){
        super();
        this.cargarIcono(path);
    
    }
    
    private void cargarIcono(String path){
        URL url = System.class.getResource(path);
        ImageIcon im =new ImageIcon(url);
        this.setIcon(im);
    }
}
