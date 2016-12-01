/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.model;

/**
 *
 * @author sa841
 */
public class Item {
    String itemName;
    String itemOID;
    String itemValue;

    
    public Item(String itemOID) {
        this.itemOID = itemOID;
    }

    public Item(String itemOID, String itemValue) {
        this.itemOID = itemOID;
        this.itemValue = itemValue;
    }

    
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOID() {
        return itemOID;
    }

    public void setItemOID(String itemOID) {
        this.itemOID = itemOID;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
    
    
}
