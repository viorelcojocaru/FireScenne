/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iucosoft2
 */
public class DataSourceSQLite {
    private static final Logger LOG = Logger.getLogger(DataSourceSQLite.class.getName());
    //bdprop=new LoadDbProperties();   
    private static DataSourceSQLite instance;

    
    java.util.Properties props = new Properties();

    public static DataSourceSQLite getInstance() {
        if (instance == null) {
            instance = new DataSourceSQLite();
        }
        return instance;
    }

    private DataSourceSQLite() {
        startServer();
        loadDriver();
        conectToDB();       
        
//     try {
//         getConnectionTrue();
//         System.out.println("am creat Baza de date");
//     } catch (SQLException ex) {
//         System.err.println("warning");
//       //  Logger.getLogger(DataSourceDerby.cl$ass.getName()).log(Level.SEVERE, null, ex);
//     }

       //createDataBase();
      // createTable();
    }

    private void loadDriver() {
        try {
            Class.forName(driverName);
            LOG.info("Am incarcat cu succes driverul SQLite");
        } catch (ClassNotFoundException ex) {
             LOG.severe("NU AM INCARCAT CU SUCCES DRIVERUL SQLite!!!");
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(urldb, userName, password);
        LOG.info("Am obtinut conectiunea cu succes");
        return conn;
    }
    
   
    private void startServer() {
        try {
            Class.forName(serverName).newInstance();             
            LOG.info("Am pornit serverul");
        } catch (ClassNotFoundException ex) {
             LOG.severe("NU AM PORNIT SERVERUL!!!");
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void conectToDB() {
        try {
            Connection conn = DriverManager.getConnection(urldb,userName,password);
             LOG.info("Am obtinut conecxiunea cu Baza de date");
        } catch (SQLException ex) {
            LOG.severe("NU AM FACUT CONEXIUNEA CU BAZA DE DATE!!!");
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    void createDataBase() {
        try {
            Connection conn = DriverManager.getConnection(urldb);
 conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();           
            LOG.info("Am creat Baza de date");
            stmt.close();
        } catch (SQLException ex) {
 LOG.severe("NU SA CREAT BAZA DE DATE!!!");
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createTable() {
String sqlTable="CREATE TABLE IF NOT EXISTS INFO (id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL UNIQUE , "
        +"TAGS VARCHAR , "
        +"TIME_IN VARCHAR , "
        +"TIME_OUT VARCHAR , "
        +"COMMENTS VARCHAR , "
        +"ANOTIMP VARCHAR , "
        +"FILE_NAME VARCHAR )";
String sqlUser="CREATE TABLE IF NOT EXISTS USER (id INTEGER PRIMARY KEY  NOT NULL  UNIQUE , PASS VARCHAR UNIQUE )";

        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sqlTable);          
            System.out.println("Am creat Tabela INFO cu succes");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Nu am creat Tabela sau este creata");
              Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
         try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();           
            stmt.executeQuery(sqlUser);
            System.out.println("Am creat Tabela USER cu succes");

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Nu am creat Tabela sau este creata");
              Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private  void inserUserData() {
       String user="INSERT INTO USER VALUES (0, 'user')";
             String admin="INSERT INTO USER VALUES (1, 'admin')";
             try {
             Connection conn = getConnection();
                 Statement stmt = conn.createStatement();
                 stmt.execute(user); 
                 stmt.execute(admin); 
                 stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
   public void creazaDB(){
        try {
            loadDriver();
            createDataBase();
            getConnection();
            createTable();
            inserUserData();
        } catch (SQLException ex) {
            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
             
   }
   String separator;
   {
       if (System.getProperty("os.name").startsWith("Windows")) {
        // includes: Windows 2000,  Windows 95, Windows 98, Windows NT, Windows Vista, Windows XP
            separator="\\";
    } else {
        // everything else
           separator="/"; 
    }  
   }
    private String driverName = "org.sqlite.JDBC";
    private String userName = "root";
    private String password = "free";
    private String urldb = "jdbc:sqlite:ScenneDB"+separator+"scenedb.sqlite";   
    String serverName = "org.sqlite.JDBC";  
    
    public static void main(String[] args) {
//        try {
//            DataSourceSQLite mica=  DataSourceSQLite.getInstance();
//            mica.loadDriver();
//            mica.createDataBase();
//            
//            mica.getConnection();           
//            
//            mica.createTable();
//            //mica.conectToDB();
//            mica.inserUserData();
//        } catch (SQLException ex) {
//            Logger.getLogger(DataSourceSQLite.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
              }
}
