package com.example.funiculi.trabajo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by funiculi on 04/06/2017.
 */

public class CargadorJSON {

    public static String lectorContenidoWeb(String urlALeer) {
        try {
            URL url = new URL(urlALeer);
            Log.v("coñoo",urlALeer);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            InputStream is = conexion.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);
            Log.v("CAMBIO NUMERO 2","llego22");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder respuesta = new StringBuilder();
            String datos;

            while ((datos = br.readLine()) != null) {
                respuesta.append(datos);
            }

            Log.v("coñoo respuesa server",respuesta.toString());

            return respuesta.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Categorias> getAllCategorias() {

        ArrayList<Categorias> categorias = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject((lectorContenidoWeb("http://loquatsolutions.com/detres/detres/api/mostrarCategorias")));
            Log.v("coñoo", "llego");
            JSONArray jsonArray = jsonObject.getJSONArray("categorias");

            Log.v("coñoo con pollasss",jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject objetoCategoria = jsonArray.getJSONObject(i);

                categorias.add(new Categorias(objetoCategoria.getString("id"),
                        objetoCategoria.getString("nombre")));
                Log.v("coñoo con pollasss",objetoCategoria.getString("nombre"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return categorias;

    }

}