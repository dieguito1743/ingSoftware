/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.util;

/**
 *
 * @author dbermudez
 */
public class BussinessMessage {

    private final String fieldName;
    private final String message;

    public BussinessMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
