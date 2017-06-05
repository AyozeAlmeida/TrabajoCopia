package com.example.funiculi.trabajo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amatellanes.android.examples.R;

import java.util.List;

public class CategoriaAdapter extends BaseAdapter {

    private Context context;
    private List<Categorias> items;

    public CategoriaAdapter(Context context, List<Categorias> items) {
            Log.v("contex",context.toString());
        this.context = context;
        this.items = items;
        Log.v("estooo",this.items.toString());
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Log.v("etiqueta","ee hasta aaqui ya no llega 1 ===> "+position);


        View rowView = convertView;


        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.categoria_item, parent, false);
        }

        // Set data into the view.
        TextView t = (TextView) rowView.findViewById(R.id.ide);
        TextView t2 = (TextView) rowView.findViewById(R.id.Nombre);

        Log.v("etiqueta","ee hasta aaqui ya no llega 2 ===> "+position);

        Categorias categorias = this.items.get(position);
        t.setText(categorias.getId());
        t2.setText(categorias.getNombre());
        Log.v("etiqueta","ee hasta aaqui ya no llega 3"+categorias.getId());

        return rowView;
    }

}