/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent the Option as it is neededby the receiver (Frontend)
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Option {
    Logger logger = LoggerFactory.getLogger(Option.class);
    
    String pickupLocationCode;
    String barcode;
    boolean onShelf;
    boolean preferred;
    String pickupTimeString;
    
    Option(){
        
    }
    
    Option(
    String pickupLocationCode,
    String barcode,
    boolean onShelf,
    boolean preferred,
    String pickupTimeString
    ){
        this.pickupLocationCode=pickupLocationCode;
        this.barcode=barcode;
        this.onShelf=onShelf;
        this.preferred=preferred;
        this.pickupTimeString=pickupTimeString;
//        logger.info("Timestring: " + pickupTimeString);
        
    }

    public String getPickupLocationCode() {
        return pickupLocationCode;
    }

    public void setPickupLocationCode(String pickupLocationCode) {
        this.pickupLocationCode = pickupLocationCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isOnShelf() {
        return onShelf;
    }

    public void setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public String getPickupTimeString() {
        return pickupTimeString;
    }

    public void setPickupTimeString(String pickupTimeString) {
        this.pickupTimeString = pickupTimeString;
    }
    
    
    
}
