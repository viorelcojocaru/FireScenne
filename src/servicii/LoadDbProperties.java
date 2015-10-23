/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicii;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viorel.cojocaru
 */
public class LoadDbProperties {
    private String driverName;//
    private String userName;
    private String password;
    private String urldb;

   

    public LoadDbProperties() {
      java.util.Properties props = new Properties();     
        try {
            citesteDinFile(props);
        } catch (IOException ex) {
            Logger.getLogger(LoadDbProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public LoadDbProperties(String driverName, String userName, String password, String urldb) {
        this.driverName = driverName;
        this.userName = userName;
        this.password = password;
        this.urldb = urldb;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrldb() {
        return urldb;
    }
    private  void citesteDinFile(Properties props) throws IOException {
     
            props.load(new FileInputStream("DB_load.properties"));
            System.out.println(" props citit din fisier textual");
            props.list(System.out);
           
             driverName = props.getProperty("driver");
             userName = props.getProperty("user");
             password = props.getProperty("password");
             urldb= props.getProperty("urldb");
             
          System.out.println("driverName=" + driverName + ", userName=" + userName + ", password=" + password + ", urldb=" + urldb);
    }

    @Override
    public String toString() {
        return "LoadDbProperties{" + "driverName=" + driverName + ", userName=" + userName + ", password=" + password + ", urldb=" + urldb + '}';
    }
  
    
}
