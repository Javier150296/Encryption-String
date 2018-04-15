/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;

/**
 *
 * @author JAVIER1
 */
public class Archivo {
    private JFileChooser chooser;
    private File file;
    private FileReader fReader;
    private BufferedReader bReader;
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    private ArrayList<Integer> array;

    public Archivo(String file) {
        this.file = new File(file);
    }
    
    public void abrir() throws FileNotFoundException, IOException{
        try{
            
            fReader = new FileReader(file);
            bReader = new BufferedReader(fReader);
            
            this.array = new ArrayList<Integer>();
            Integer c;
            while((c=fReader.read())!= -1){
                array.add(c);
                
            }
        }catch (Exception e){
            
        }finally{
            try{
                if(fReader != null)
                    fReader.close();
            }catch(IOException e2){
                
            }
        }
        
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }
    
    public void guardar(String archivo, ArrayList<Integer> arrayPass) throws IOException{
        try{
            
            File fileNuevo = new File(archivo);
            fWriter = new FileWriter(fileNuevo);
            bWriter = new BufferedWriter(fWriter);
            
            char [] c= new char[arrayPass.size()];
            int a;
            for(int i=0; i<arrayPass.size(); i++){
                a=arrayPass.get(i);
                c[i]=(char)(a);
                
            }
            
            bWriter.write(c);
            bWriter.close();
        }catch (Exception e){
          
        }
        
    }
    
    
}
