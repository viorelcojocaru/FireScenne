/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viorel.cojocaru
 */
public class DataUserImpl implements DataUserIntf {

    private static final Logger LOG = Logger.getLogger(DataUserImpl.class.getName());
    private static DataUserImpl instance;

    public static DataUserImpl getInstance() {
        if (instance == null) {
            instance = new DataUserImpl();
        }
        return instance;
    }

    public DataUserImpl() {
    }

    @Override
    public void updatePasword(Integer id, String password) {

        String updatePassword = "UPDATE USER SET PASS=? WHERE id=?";
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(updatePassword);
            stmt.setString(1, password);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            LOG.info("Am schimbat parola pentru id=" + id);
        } catch (SQLException ex) {
            LOG.severe("NU AM PUTUT SCHIMBA PAROLA PENTRU ID=" + id);
            Logger.getLogger(DataUserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean verifyUserData(Integer id, String password) {
        Boolean verify = null;
        try {
            conn = dataSource.getConnection();
            String selectPassword = "SELECT  PASS  FROM  USER WHERE id=" + id;
            Statement stat = conn.createStatement();
            stat.executeQuery(selectPassword);
            ResultSet res = stat.executeQuery(selectPassword);
            LOG.info("datele cerute: id=" + id + " pass=" + password);
            String passQ = res.getString("PASS");
            LOG.info("datele aflate:  passQ=" + passQ);
            if (password.equals(passQ)) {
                verify = true;
            } else {
                verify = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataUserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataUserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verify;
    }
    private DataSourceSQLite dataSource = DataSourceSQLite.getInstance();
    private Connection conn;
//    public static void main(String[] args) {
//        Boolean acordareDrept;
//        DataUserImpl usery = DataUserImpl.getInstance();
//        usery.updatePasword(1, "admi");
//        acordareDrept = user.verifyUserData(0, "admin");
//        System.out.println("Accesul este " + acordareDrept);
//    }
}
