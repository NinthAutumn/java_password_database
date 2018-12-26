/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateLoginPasswordDataFile {
    public ArrayList<LoginData> getLoginDetailList()
    {
        
        ArrayList<LoginData> list = new ArrayList<LoginData>();
        list.add(new LoginData("user","password"));
            ObjectInputStream inputFile;
            String fileName = "LoginDetail.text";//set sequenctial file name
            
            try{// see if there is any mistake
                inputFile = new ObjectInputStream(
                new FileInputStream(fileName));
                
                LoginData record = new LoginData(); //used to hpld data one record at a time
                boolean readable= true;//boolean readble stop read all the data from file
                do{
                    try{ 
                        //(worddata) is casting. casting means it takes on the charafcteristic sof the datatype
                        //castng metod to give structure to the byte stream of data
                        record = (LoginData) inputFile.readObject();//reads an obkect
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
