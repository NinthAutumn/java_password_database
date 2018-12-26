/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.Serializable;

/**
 *
 * @author arifmohammad
 */
public class wordData implements Serializable {
    private String words;
    private boolean customWords;
    public wordData(){
        words = "";
        customWords = false;
    }
    
    public wordData(String w, boolean cW){
        words = w;
        customWords = cW;
    }

    public void setCustomWords(boolean cW){
        customWords = cW;
    }
    public boolean getCustomWords(){
        return customWords;
    }
    
    public void setWords(String w){   
        words = w;
    }
    
    public String getWords(){
        return words;
    }
    
    @Override
    public String toString()
    {
        return "Word: " + words + " " + customWords;
        
    }
    
    
    
}
