
package com.example.turismo2024;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;


public class MainActivity
        extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, Asynchtask {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llenar el combobox o lista
        //paso 1 Data

        final String[] datos = new String[]{"Alojamiento", "Alimentaci[on y Bebidas", "Atractivos Culturales", "Esparcimientos", "Compras"};
        //Adaptador PASO 2
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        //paso 3 vista

        Spinner cmbOpciones = (Spinner) findViewById(R.id.cbCategoria);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        cmbOpciones.setOnItemSelectedListener(this);

        //Llenar el combobox o lista
        //paso 1 Data
        //ListView
        Map<String, String> datos3 = new HashMap<String, String>();
        WebService ws= new WebService(

                "https://uealecpeterson.net/turismo/lugar_turistico/json_getlistadoGrid" ,
                datos3, MainActivity.this, MainActivity.this);ws.execute("GET");





    }


    public void onItemSelected(AdapterView<?> parent,android.view.View v, int position, long id) {
        TextView txtItem = (TextView) findViewById(R.id.txtCategoria);
        txtItem.setText("Seleccionado: " +
                parent.getItemAtPosition(position));}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView txtItem = 					(TextView)findViewById(R.id.txtCategoria); txtItem.setText("");}

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList <Lugarturistico> listaLugaresTuristicos = new ArrayList<Lugarturistico>();
        //Para hacer la conexiòn en relaciòn a la base de datos , se aplica este mètodo para que funcione bien
        //ya que tiene otro nombre la base de datos "data"
        JSONObject lista=new JSONObject(result);
        JSONArray JSONlista= lista.getJSONArray("data");

        listaLugaresTuristicos = Lugarturistico.JsonObjectsBuild(JSONlista);

        AdaptadorLugaresTuristico adapatorLugares
                = new AdaptadorLugaresTuristico(this, listaLugaresTuristicos);
        ListView lstOpciones=(ListView) findViewById(R.id.lstLugares);
        lstOpciones.setAdapter(adapatorLugares);



    }
}