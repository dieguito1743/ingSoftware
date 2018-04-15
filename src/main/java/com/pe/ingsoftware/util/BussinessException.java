/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.util;

import java.util.List;

/**
 *
 * @author dbermudez
 */
public class BussinessException extends Exception{
    List<BussinessMessage> bussinessMessage;

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessage;
    }
}
