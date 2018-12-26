/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passworddatabase_arif;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author arifmohammad
 */
public class SortandSearchMethod extends PasswordData {
    
    public static Comparator<PasswordData> UsernameComparator = new Comparator<PasswordData>() {

	public int compare(PasswordData u1, PasswordData u2) {
	   String Username1 = u1.getUsername().toUpperCase();
	   String Username2 = u2.getUsername().toUpperCase();

	   //ascending order
	   return Username1.compareTo(Username2);
    }};
    
    public static String sequentialSearchWebsiteName(ArrayList<PasswordData> arraySearch, String SearchComponent){
        for(int i = 0; i < arraySearch.size(); i++){
            if(arraySearch.get(i).getWebsite().contains(SearchComponent)){
                String websiteSearch = arraySearch.get(i).getWebsite();
                return websiteSearch;
            }
        }
        return null;
    }
        
}
