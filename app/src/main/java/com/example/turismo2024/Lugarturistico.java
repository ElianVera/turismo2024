package com.example.turismo2024;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Lugarturistico {

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    String nombres;
    String direccion;
    String telefono;
    String logo;
    public Lugarturistico(JSONObject a) throws JSONException {
        nombres =  a.getString("nombre_lugar").toString();
        direccion =  a.getString("direccion").toString() ;
        telefono =  a.getString("telefono").toString() ;
        logo = "https://uealecpeterson.net/turismo/assets/imgs/logos_gifs/" + a.getString("logo").toString() ;


    }

    public static ArrayList<Lugarturistico> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Lugarturistico> lstLugares = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            lstLugares.add(new Lugarturistico(datos.getJSONObject(i)));
        }
        return lstLugares;
    }
}