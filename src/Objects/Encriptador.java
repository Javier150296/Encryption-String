/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileOpen, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author JAVIER1
 */
public class Encriptador {
    private Archivo fileOpen;
    private Archivo flieCreate;
    
    public Encriptador(String path){
        this.fileOpen = new Archivo(path);
    }
    
    public void Encriptar(String path,String key) throws IOException{
        int pos=0;
        char [] clave = key.toCharArray();
        
        this.fileOpen.abrir();
        ArrayList<Integer> arreglito= fileOpen.getArray();
        Integer aux;
        for (int i=0; i<arreglito.size(); i++) {
            aux=(int)(clave[pos]);
            arreglito.set(i, arreglito.get(i)+aux);
            
            if(pos==clave.length-1)
                pos=0;
            else
                pos++;
            
            if(arreglito.get(i)>255)
                arreglito.set(i, arreglito.get(i)-255);
        }
        
        this.fileOpen.guardar(path,arreglito);
        
    }
    
    public void Desencriptar(String path, String key) throws IOException{
        int pos=0;
        char [] clave = key.toCharArray();
        
        this.flieCreate = new Archivo(path);
        this.flieCreate.abrir();
        ArrayList<Integer> arreglito =flieCreate.getArray();
        Integer aux;
        for (int i=0; i<arreglito.size(); i++) {
            aux=(int)(clave[pos]);
            
            if(arreglito.get(i)<aux)
                arreglito.set(i, arreglito.get(i)+255);
            
            arreglito.set(i, arreglito.get(i)-aux);
            
            if(pos==clave.length-1)
                pos=0;
            else
                pos++;
        }
        path=path.replaceFirst(".txt", "");
        this.flieCreate.guardar(path+"Desencriptado.txt",arreglito);
    } 
    
    
}
