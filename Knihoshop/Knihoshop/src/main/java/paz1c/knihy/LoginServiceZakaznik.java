
package paz1c.knihy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceZakaznik {
    
    public List<User> dajZakaznikov() {
    try {
            List<User> zoznamZakaznikov = new ArrayList<User>();
            Scanner scanner = new Scanner(new File("Zakaznici.txt"));
    
        
            while(scanner.hasNextLine()) {
                String riadok = scanner.nextLine();
                
                String[] polozky = riadok.split(";");
                
                User user = new User();
                user.setLogin(polozky[0]);
                user.setPassword(polozky[1]);

                zoznamZakaznikov.add(user);
            }
            
            return zoznamZakaznikov;

} catch (FileNotFoundException e) {
            System.err.println("Subor sa nenasiel");
            return Collections.emptyList();
        }
    }
    
    
    
    

     boolean login(String login, String password,List<User> zoznamZakaznikov) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        
        int pocitadlo = 0;
        
       for(int i=0; i<zoznamZakaznikov.size(); i++){
           if(zoznamZakaznikov.get(i).getLogin().equals(user.getLogin()) && zoznamZakaznikov.get(i).getPassword().equals(user.getPassword())){
               pocitadlo++;
           }
        }
       if(pocitadlo ==1){
               return true;
           } else {
       return false;
       }
       }
       
    }       
    
    
