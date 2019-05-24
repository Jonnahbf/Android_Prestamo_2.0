package com.example.prestamo20;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ClienteHolder> implements View.OnClickListener {

    private List<Client> Lista_Clientes;
    private View.OnClickListener onClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public RvAdapter(List<Client> Cliente){

        this.Lista_Clientes = Cliente;
        //this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ClienteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.clientes,parent,false);
        view.setOnClickListener(this);
        ClienteHolder clienteHolder = new ClienteHolder(view);
        return clienteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteHolder holder, int position) {
        holder.tvNombre.setText(Lista_Clientes.get(position).getNombre());
        holder.tvApellido.setText(Lista_Clientes.get(position).getapellido());
    }

    @Override
    public int getItemCount() {
        return Lista_Clientes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.onClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(onClickListener!=null){
            onClickListener.onClick(v);
        }
    }


    public class ClienteHolder extends RecyclerView.ViewHolder{
        public TextView tvNombre;
        public TextView tvApellido;
        public ImageButton borrar;
        public ImageButton editar;
        CardView cv;

        public ClienteHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            this.tvNombre = itemView.findViewById(R.id.tv_nombre);
            this.tvApellido = itemView.findViewById(R.id.tv_apellido);
            this.editar = itemView.findViewById((R.id.img_btn_editar));
            this.borrar = itemView.findViewById(R.id.img_btn_borrar);
        }
    }
}
