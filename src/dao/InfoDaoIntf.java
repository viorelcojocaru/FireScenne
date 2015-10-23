/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Info;
import java.util.List;

/**
 *
 * @author viorel.cojocaru
 */
public interface InfoDaoIntf {

    void saveInfo(Info info);

    List findByTag(String tagNames, String anotimp);

    void deleteInfo(int id);

    void updateInfo(Info info);

    List<Info> findByTag();

    public String findById(int id);
    
  
}
