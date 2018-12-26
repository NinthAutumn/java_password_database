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
public class LoginData implements Serializable {
    private String loginUsername;
    private String loginPassword;
    
    
    public LoginData(){
        loginUsername = "";
        loginPassword = "";
    }
    public LoginData(String LU,String LP){
        loginUsername = LU;
        loginPassword = LP;
    }
    public void setLoginUsername(String LU){
        loginUsername = LU;
    }
    
    public String getLoginUsername(){
        return loginUsername;
    }
    public void setLoginPassword(String LP){
        loginPassword = LP;
    }
    public String getLoginPassword(){
        return loginPassword;
    }
    
}



