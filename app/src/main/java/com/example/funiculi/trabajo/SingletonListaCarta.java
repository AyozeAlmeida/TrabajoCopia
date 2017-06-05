package com.example.funiculi.trabajo;

import java.util.ArrayList;

/**
 * Created by funiculi on 04/06/2017.
 */
public class SingletonListaCarta {
    private static SingletonListaCarta instance;
    private static ArrayList<String> nombreCategorias;

    public static SingletonListaCarta getInstance() {
        if(instance == null) {
            instance = new SingletonListaCarta();
        }
        return instance;
    }

    private SingletonListaCarta() {

    }

    public void cargarLista(ArrayList<String>arrayCategorias){
        nombreCategorias = arrayCategorias;
    }

    public ArrayList<String> cogerLista(){
        return nombreCategorias;
    }
}
