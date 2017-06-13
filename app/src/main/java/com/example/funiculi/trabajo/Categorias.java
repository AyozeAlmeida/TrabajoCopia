package com.example.funiculi.trabajo;

/**
 * Created by funiculi on 03/06/2017.
 */

public class Categorias {


        private String id;
        private String nombre;

private String putmesu;
        public Categorias() {
            super();
       }
    // es sempre uno sin parametros y otro con por si acaso
        public Categorias(String id, String nombre) {
            super();
            this.id = id;
            this.nombre = nombre;

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


    }