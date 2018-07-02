/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.pe.ingsoftware.util.BussinessException;

/**
 *
 * @author dbermudez
 */
public interface IJsonTransformer {

    String toJson(Object data);

    <Clase> Clase fromJSON(String json, Class<Clase> clase);

    <Clase> List<Clase> fromListJSON(String json, Class<Clase> clase);
}
