/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.util.logging.Logger;

/**
 *
 * @author viorel.cojocaru
 */
public class TimeToFromStr {

    public String timeToString(int sec) {

        //converter form seconds to string
        int hours = sec / 3600,
                remainder = sec % 3600,
                minutes = remainder / 60,
                seconds = remainder % 60;
        String disHour = (hours < 10 ? "0" : "") + hours,
                disMinu = (minutes < 10 ? "0" : "") + minutes,
                disSec = (seconds < 10 ? "0" : "") + seconds;
        LOG.info(disHour + ":" + disMinu + ":" + disSec);
        String timeString = disHour + ":" + disMinu + ":" + disSec;
        stringToTime(timeString);

        return timeString;
    }
    

    public Integer stringToTime(String timeString) {       
        int hours, mins, secs;
        String[] sir = timeString.split(":");
        hours = Integer.parseInt(sir[0]);
        mins = Integer.parseInt(sir[1]);
        secs = Integer.parseInt(sir[2]);
        System.out.println("hours="+ hours+" mins="+mins+" secs="+secs);
        int intSecs = (hours * 3600) + (mins * 60) + secs;
        LOG.info("am extras din timpString " + intSecs);
         System.out.println("IntSecs din stringToTime ="+intSecs);
         
         return intSecs;
      
        
    }
    private static final Logger LOG = Logger.getLogger(TimeToFromStr.class.getName());
}
