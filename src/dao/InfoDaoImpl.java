/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viorel.cojocaru
 */
public class InfoDaoImpl implements InfoDaoIntf {

    private static final Logger LOG = Logger.getLogger(InfoDaoImpl.class.getName());
    private static InfoDaoImpl instance;

    public static InfoDaoImpl getInstance() {
        if (instance == null) {
            instance = new InfoDaoImpl();
        }
        return instance;
    }
    private DataSourceSQLite dataSource = DataSourceSQLite.getInstance();
    private Connection conn;

    public InfoDaoImpl() {
    }

    @Override
    public void saveInfo(Info info) {
        try {
            conn = dataSource.getConnection();

            String saveDerby = "INSERT INTO INFO VALUES (null,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(saveDerby);


            stmt.setString(1, info.getTags());
            stmt.setString(2, info.getTimpIn());
            stmt.setString(3, info.getTimpOut());
            stmt.setString(4, info.getComments());
            stmt.setString(5, info.getAnotimp());
            stmt.setString(6, info.getFisierNume());
            stmt.execute();
            stmt.close();
            LOG.info("Am salvat cu cucces Datele");
        } catch (SQLException ex) {
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            LOG.info("Nu am salvat cu cucces Datele");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Info> findByTag(String tagSarch, String anotimpSarch) {
        Info info = null;
        List<Info> infolista = new ArrayList<Info>();
        try {
            conn = dataSource.getConnection();
            Statement stat = conn.createStatement();

            ResultSet res = stat.executeQuery("SELECT * FROM INFO");
            LOG.info("\n\ntagSarch=" + "'" + tagSarch + "'");
            LOG.info("anotimpSarch=" + "'" + anotimpSarch + "'\n");

            while (res.next()) {
                info = new Info();
                String[] tagsSQL = res.getString("TAGS").split(",");
                String anotimpSQL = res.getString("ANOTIMP");
                LOG.info("tagSarch=" + tagSarch);
                LOG.info("tagsSQL" + tagsSQL);
                Boolean contine = verificExistentaString(tagSarch, tagsSQL);

                LOG.info("contin=" + contine);
                if (contine && anotimpSQL.equals(anotimpSarch)) {
                    info.setId(res.getInt("id"));
                    info.setTags(res.getString("TAGS"));
                    info.setTimpIn(res.getString("TIME_IN"));
                    info.setTimpOut(res.getString("TIME_OUT"));
                    info.setComments(res.getString("COMMENTS"));
                    info.setAnotimp(res.getString("ANOTIMP"));
                    info.setFisierNume(res.getString("FILE_NAME"));
                    infolista.add(info);
                    LOG.info("info=" + info);
                }//end if
            }//end while 
         //   Thread.sleep(200);

            stat.close();
            conn.close();
            LOG.info("Am obtinut Datele cerute");       
        } catch (SQLException ex) {
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            LOG.info("Nu am obtinut Datele cerute");
            ex.printStackTrace();
        }
        // System.out.println("lista =" + infolista);
        return infolista;
    }

    @Override
    public void deleteInfo(int id) {
        String deleteInfo = "DELETE FROM INFO WHERE id=?";
        try {
            conn = dataSource.getConnection();
            PreparedStatement stat = conn.prepareStatement(deleteInfo);
            stat.setInt(1, id);
            stat.execute();
            LOG.info("Am sters inregistrarea cu id=" + id);
            stat.close();
            conn.close();

        } catch (SQLException ex) {
            LOG.info("Nu sters inregistrarea cu id=" + id);
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateInfo(Info info) {
        String updateSql = "UPDATE INFO SET TAGS=?, TIME_IN=?, TIME_OUT=?, COMMENTS=?, ANOTIMP=?, FILE_NAME=? WHERE id=?";
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(updateSql);
            stmt.setString(1, info.getTags());
            stmt.setString(2, info.getTimpIn());
            stmt.setString(3, info.getTimpOut());
            stmt.setString(4, info.getComments());
            stmt.setString(5, info.getAnotimp());
            stmt.setString(6, info.getFisierNume());
            stmt.setInt(7, info.getId());
            stmt.executeUpdate();
            LOG.info("Am executat inoirea datelor");
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Info> findByTag() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) {
//        InfoDaoImpl info = InfoDaoImpl.getInstance();
//        //   info.saveInfo(new Info("fj", "22", "56", "lelel", "saf", "ashd"));
//
//        String anotimpSarch = "IARNA , VARA , PRIMAVARA , TOAMNA";
//        String[] sirAnotimp = anotimpSarch.split(",");
//        for (int i = 0; i < sirAnotimp.length; i++) {
//            String verificAnotimp = sirAnotimp[i].trim();
//
//            if (verificAnotimp.length() != 0) {
//                System.out.println("verificAnotimp:" + verificAnotimp);
//                System.out.println("verificAnotimp=" + verificAnotimp.length());
//                int j = info.findByTag("li", verificAnotimp).size();// IARNA, VARA PRIMAVARA TOAMNA
//                System.out.println("sau gasit " + j + " taguri ");
//            }
//        }
//
//
//        //   info.updateInfo(new Info(3, "Schimbat", "00:10:15", "00:20:30", "ce mai comentarii", "Iarna", "la Sanius"));
//        // info.deleteInfo(3);
//
//
//    }
    @Override
    public String findById(int id) {
        String filePath = "";        
        try {

            conn = dataSource.getConnection();

            String findById = "SELECT * FROM INFO WHERE id=?";

            PreparedStatement stat = conn.prepareStatement(findById);
            stat.setInt(1, id);

            ResultSet res = stat.executeQuery();
            while (res.next()) {
                filePath = res.getString(7);
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filePath;

    }

    private boolean verificExistentaString(String tagSarch, String[] tagsSQL) {

        for (int i = 0; i < tagsSQL.length; i++) {
            String tagsSQLTrim = tagsSQL[i].trim();
            if (tagSarch.equals(tagsSQLTrim)) {
                return true;
            }
        }
        return false;

    }

    public Info findById(String idStr) {
        int id = Integer.parseInt(idStr);
        Info info=new Info();
        try {
            conn = dataSource.getConnection();

            String findById = "SELECT * FROM INFO WHERE id=?";

            PreparedStatement stat = conn.prepareStatement(findById);
            stat.setInt(1, id);

            ResultSet res = stat.executeQuery();
            while (res.next()) {
                info.setId(res.getInt("id"));
                info.setTags(res.getString("TAGS"));
                info.setTimpIn(res.getString("TIME_IN"));
                info.setTimpOut(res.getString("TIME_OUT"));
                info.setComments(res.getString("COMMENTS"));
                info.setAnotimp(res.getString("ANOTIMP"));
                info.setFisierNume(res.getString("FILE_NAME"));
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InfoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
}
