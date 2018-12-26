/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 19175
 */
public class  PasswordData  implements Serializable {
    private String username;
    private String email;
    private String password;
    private String website;
    private String association;
    private String tag1;
    private String tag2;
    private String tag3;
    
    public PasswordData(){
        username = "";
        email = "";
        password = "";
        website = "";
        association = "";
        tag1 = "";
        tag2 = "";
        tag3 ="";
    }
    
    public PasswordData(String U, String E, String P, String W, String A, String T1, String T2, String T3){
        username = U;
        email = E;
        password = P;
        website = W;
        association = A;
        tag1 = T1;
        tag2 = T2;
        tag3 = T3;
    }
    
    public void setUsername(String U){
        username = U;
    }
    
    public String getUsername(){
        return username;
    }
    public void setEmail(String E){
        email = E;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String P){
        password = P;
    }
    public String getPassword(){
        return password;
    }
    public void setWebsite(String W){
        website = W;
    }
    public String getWebsite(){
        return website;
    }
    public void setAssociation(String A){
        association = A;
    }
    public String getAssociation(){
        return association;
    }
    public void setTag1(String T1){
        tag1 = T1;
    }
    public String getTag1(){
        return tag1;
    }
    public void setTag2(String T2){
        tag2 = T2;
    }
    public String getTag2(){
        return tag2;
    }
    public void setTag3(String T3){
        tag3 = T3;
    }
    public String getTag3(){
        return tag3;
    }
   
    public static Comparator<PasswordData> usernameComparator = new Comparator<PasswordData>() {

	public int compare(PasswordData u1, PasswordData u2) {
	   String Username1 = u1.getUsername();
	   String Username2 = u2.getUsername();
           int Usernamek = Username1.compareTo(Username2);
	   if(Usernamek != 0){
               return Username1.compareTo(Username2);
           }
           
           String Website1 = u1.getWebsite();
           String Website2 = u2.getWebsite();
           int Websike = Website1.compareTo(Website2);
           if(Websike != 0){
               return Website1.compareTo(Website2);
           }
           
           String Association1 = u1.getAssociation();
           String Association2 = u2.getAssociation();
           int Associek = Association1.compareTo(Association2);
           if(Associek != 0){
               return Association1.compareTo(Association2);
           }
           String Tag11 = u1.getTag1();
           String Tag12 = u2.getTag1();
           int Tag1ek = Tag11.compareTo(Tag12);
           if(Tag1ek != 0){
               return Tag11.compareTo(Tag12);
           }
           return u1.getTag2().compareTo(u2.getTag2());
           
    }};

    
    @Override
    public String toString()
    {
        return "Username: " + username
                + "\nEmail: " + email
                + "\nPassword: " + password
                + "\nWebsite: " + website
                + "\nAssociation: " + association
                + "\nTag1: " + tag1
                + "\nTag2: " + tag2
                + "\nTag3: " + tag3;
        
    }
    
}
