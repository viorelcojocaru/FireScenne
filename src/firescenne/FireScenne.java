/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firescenne;

import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author viorel.cojocaru
 */
public class FireScenne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FireScenneStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FireScenneStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FireScenneStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FireScenneStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
//                String separator;
//                    if (System.getProperty("os.name").startsWith("Windows")) {
//            // includes: Windows 2000,  Windows 95, Windows 98, Windows NT, Windows Vista, Windows XP
//                separator="\\";
//        } else {
//            // everything else
//               separator="/"; 
//        } 
                
                    try {
                        URL url=new URL("file:///E:\\JAVA\\do\\FireScenne (3)\\FireScenne (3)\\Splash.gif");
                  //  ImageIcon ic=new ImageIcon(FireScenne.class.getResource("/home/iucosoft2/Desktop/FireScenne (3)/Splash.gif"))
                    JSplash splash =new JSplash(url,true, true, true, "V1", null, Color.orange, Color.gray); 
                    splash.splashOn();
                    splash.setProgress(20, "Init");
                    Thread.sleep(1000);
                    splash.setProgress(40, "Verifi DataBase");
                    Thread.sleep(1000);
                    splash.setProgress(60, "Loading");                 
                    Thread.sleep(1000);
                    splash.setProgress(80, "Starting...");
                    Thread.sleep(1000);
                    splash.splashOff();
                } catch (InterruptedException ex) {
                    Logger.getLogger(FireScenne.class.getName()).log(Level.SEVERE, "Nu am imagine pos", ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FireScenne.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                new FireScenneStart().setVisible(true);    
            }
        });
   


    }
}
