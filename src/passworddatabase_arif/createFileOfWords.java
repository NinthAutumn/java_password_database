/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arifmohammad
 */
public class createFileOfWords {
    public ArrayList<wordData> getWordList()
    {
        ArrayList<wordData> list = new ArrayList<wordData>();
        
        list.add (new wordData("aneumonic", false));
        list.add (new wordData("Communism", false));
        list.add (new wordData("Brainwashing", false));
        list.add (new wordData("Toxic", false));
        list.add (new wordData("Cat", false));
        list.add (new wordData("Feminism", false));
        list.add (new wordData("Democracy",false));
        list.add (new wordData("Whale", false));
        list.add (new wordData("fun", false));
        list.add (new wordData("sad", false));
        list.add (new wordData("crying", false));
        list.add (new wordData("endless", false));
        list.add (new wordData("hard", false));
        list.add (new wordData("difficult", false));
        list.add (new wordData("enjoyable",false));
        list.add (new wordData("trust", false));
        list.add (new wordData("definite", false));
        list.add (new wordData("dao", false));
        list.add (new wordData("the", false));
        list.add (new wordData("way", false));
        list.add (new wordData("road", false));
        list.add (new wordData("success", false));
        list.add (new wordData("enjoyable",false));
        list.add (new wordData("entrust", false));
        list.add (new wordData("widow", false));
        list.add (new wordData("window", false));
        list.add (new wordData("person", false));
        list.add (new wordData("Human", false));
        list.add (new wordData("den", false));
        list.add (new wordData("Animal", false));
        list.add (new wordData("Animosity",false));
        list.add (new wordData("Differ", false));
        list.add (new wordData("saying", false));
        list.add (new wordData("sought", false));
        list.add (new wordData("out", false));
        list.add (new wordData("in", false));
        list.add (new wordData("Desk", false));
        list.add (new wordData("Quest", false));
        list.add (new wordData("magic",false));
        list.add (new wordData("Lite", false));
        list.add (new wordData("Long", false));
        list.add (new wordData("late", false));
        list.add (new wordData("bring", false));
        list.add (new wordData("anime", false));
        list.add (new wordData("girls", false));
        list.add (new wordData("men", false));
        list.add (new wordData("boys",false));
        list.add (new wordData("adult", false));
        list.add (new wordData("adolecent", false));
        list.add (new wordData("craft", false));
        list.add (new wordData("saint", false));
        list.add (new wordData("null", false));
        list.add (new wordData("noise", false));
        list.add (new wordData("mango", false));
        list.add (new wordData("queue",false));
        list.add (new wordData("time", false));
        list.add (new wordData("Taking", false));
        list.add (new wordData("Ounce", false));
        list.add (new wordData("Kiss", false));
        list.add (new wordData("rope", false));
        list.add (new wordData("and", false));
        list.add (new wordData("zen", false));
        list.add (new wordData("zebra",false));
        list.add (new wordData("word", false));
      
        
            ArrayList<wordData> List = new ArrayList<wordData>();
            
            
            ObjectInputStream inputFile;
            String fileName = "WordList.text";//set sequenctial file aname
            
            try{// see if there is any mistake
                inputFile = new ObjectInputStream(
                new FileInputStream(fileName));
                
                wordData record = new wordData(); //used to hpld data one record at a time
                boolean readable= true;//boolean readble stop read all the data from file
                do{
                    try{ 
                        //(worddata) is casting. casting means it takes on the charafcteristic sof the datatype
                        //castng metod to give structure to the byte stream of data
                        record = (wordData) inputFile.readObject();//reads an obkect
                        list.add(record);
                    } 
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(PasswordDataBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch(EOFException eof)//end of file error
                    {
                        readable = false;
                        break;
                        
                    }
                }while(readable);
            }
            //process exceptions from opening file
            catch(IOException ioException){
               
            }
            return list;   
    }
}
    