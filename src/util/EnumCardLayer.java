/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



/**
 *
 * @author viorel.cojocaru
 */
public enum EnumCardLayer {
    LOGIN ("LOGIN"),
    SARCHED ("SARCHED"),
    EDITABLE ("EDITABLE");
    
    private final String layer;

    private EnumCardLayer (String layer){
        this.layer=layer;
    }

    public String getLayer() {
        return layer;
    }
   
}
