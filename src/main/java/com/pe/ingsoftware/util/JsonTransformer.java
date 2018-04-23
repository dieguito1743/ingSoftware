/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.ingsoftware.interfaces.IJsonTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbermudez
 */
@Component("jsonTransformer")
public class JsonTransformer implements IJsonTransformer {

    public JsonTransformer() {
    }

    @Override
    public String toJson(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }//terminar control de errores
    }

    @Override
    public <Clase> Clase fromJSON(String json, Class<Clase> clase) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(json, clase);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }//terminar control de errores
    }

    @Override
    public String toJson(ArrayList<String> value) {
        String jsonString = "{\"plan\":" + value + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode actualObj = objectMapper.readTree(jsonString);
            return actualObj.toString();
        } catch (IOException ex) {
            Logger.getLogger(JsonTransformer.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
