package com.example.turismo2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class AdaptadorLugaresTuristico extends ArrayAdapter<Lugarturistico> {

    public AdaptadorLugaresTuristico(Context context, ArrayList<Lugarturistico> datos) {
        super(context, R.layout.item_layout, datos);   }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_layout, null);

        TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lbldireccion = (TextView) item.findViewById(R.id.lbldireccion);
        lbldireccion.setText(getItem(position).getDireccion());
        TextView lblTelefono = (TextView) item.findViewById(R.id.lbltelefono);
        ImageView imageView = (ImageView)item.findViewById(R.id.logo);
        Glide.with(this.getContext())
                .load(getItem(position).getLogo())
                .into(imageView);

        return (item);
    }}

