package com.example.applogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorEstudiantes extends RecyclerView.Adapter<AdaptadorEstudiantes.ViewHolderEstudiantes> implements View.OnClickListener {

    ArrayList<EstudiantesVO>listaEstudiantes;
    private View.OnClickListener listener;

    public AdaptadorEstudiantes(ArrayList<EstudiantesVO> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @NonNull
    @Override
    public ViewHolderEstudiantes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiantes,null,false);
        view.setOnClickListener(this);
        return new ViewHolderEstudiantes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEstudiantes holder, int position) {
        holder.etiNombre.setText(listaEstudiantes.get(position).getNombre());
        holder.etiInfomacion.setText(listaEstudiantes.get(position).getInfo());
        holder.foto.setImageResource(listaEstudiantes.get(position).getFoto());

    }

    @Override
    public int getItemCount() { return listaEstudiantes.size(); }

    public  void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }

    }

    public class ViewHolderEstudiantes extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInfomacion;
        ImageView foto;

        public ViewHolderEstudiantes(@NonNull View itemView) {
            super(itemView);
            etiNombre =(TextView) itemView.findViewById(R.id.idNombre);
            etiInfomacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
