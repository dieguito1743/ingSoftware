/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.interfaces;

import java.util.ArrayList;

/**
 *
 * @author dbermudez
 */
public interface IJsonTransformer {

    String toJson(Object data);

    <Clase> Clase fromJSON(String json, Class<Clase> clase);

    String toJson(ArrayList<String> value);
}
