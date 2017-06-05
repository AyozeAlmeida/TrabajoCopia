package com.example.funiculi.trabajo;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amatellanes.android.examples.R;

import java.util.ArrayList;


public class FragmentoEjemplo extends Fragment {

    private ListView l;
    public static ArrayList<String> nombreCategorias;
    View vi;

    String[] elementos = {"jose", "pedro", "maria", "miguel", "luis", "daniel", "elena","La"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(SingletonListaCarta.getInstance().cogerLista()==null){
            new DescargarListaCartaTask().execute();
            //aprovecho que descargo la lista nada mas entrar a la aplicacion,
            //para descargar la lista de deudores también
        }else{
            cargarListaCategorias(SingletonListaCarta.getInstance().cogerLista());
        }

        View vi =inflater.inflate(R.layout.fragmento_ejemplo, container, false);
        TextView tvTitle = (TextView)vi.findViewById(R.id.texto);


        this.l = (ListView)vi.findViewById(R.id.listViewCategorias);
        //List cat = new ArrayList();
        //cat.add(new Categorias(1, "Following"));
        //cat.add(new Categorias(2, "Followingeeee"));
        //Log.v("llega etiqueta","llega hasta antes del adapter");
        //l.setAdapter(new CategoriaAdapter(this.getActivity().getApplicationContext(), cat));
        tvTitle.setText("--- ");
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1,elementos);
        //l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),String.valueOf(position),Toast.LENGTH_SHORT).show();

            }
        });
        return vi;
    }

    private void cargarListaCategorias(ArrayList<String> categorias) {
       // ListView lv = (ListView) vi.findViewById(android.R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, categorias);

        l.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public class DescargarListaCartaTask extends AsyncTask<Void, Void, Void> implements DialogInterface.OnCancelListener {

        private Dialog dialog = null;

        @Override
        protected void onPreExecute() {
            dialog = new Dialog(getContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<Categorias> categoriasArrayList = CargadorJSON.getAllCategorias();
            nombreCategorias = new ArrayList<>();
            for (Categorias i : categoriasArrayList) {
                nombreCategorias.add(i.getNombre());
            }
            SingletonListaCarta.getInstance().cargarLista(nombreCategorias);
            dialog.dismiss();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            cargarListaCategorias(SingletonListaCarta.getInstance().cogerLista());
        }

        @Override
        public void onCancel(DialogInterface dialog) {
            cancel(true);
        }

    }
}
