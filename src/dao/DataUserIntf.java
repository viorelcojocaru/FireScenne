/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author viorel.cojocaru
 */
public interface DataUserIntf {
    void updatePasword(Integer id, String password);
    boolean verifyUserData(Integer id, String password);
    
}
