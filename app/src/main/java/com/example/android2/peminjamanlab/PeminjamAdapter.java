package com.example.android2.peminjamanlab;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by android2 on 07/03/18.
 */

public class PeminjamAdapter extends RecyclerView.Adapter<PeminjamAdapter.ViewHoldernya> {

    List<PeminjamanLab> peminjamannya;

    public PeminjamAdapter(List<PeminjamanLab> peminjamannya) {
        this.peminjamannya = peminjamannya;
    }

    @Override
    public ViewHoldernya onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return  new ViewHoldernya(view);

    }

    @Override
    public void onBindViewHolder(ViewHoldernya holder,final int position) {
        holder.namaPeminjam.setText(peminjamannya.get(position).getNamaPeminjam());
        holder.jabatan.setText(peminjamannya.get(position).getJabatan());
        holder.kodeBarang.setText(peminjamannya.get(position).getKodeBarang());
        holder.namaBarang.setText(peminjamannya.get(position).getNamaBarang());
        holder.ruangLab.setText(peminjamannya.get(position).getRuangLab());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long i=peminjamannya.get(position).getId();
                String is=Long.toString(i);
                Intent intent=new Intent(view.getContext(),UbahActivity.class);
                intent.putExtra("id",is);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peminjamannya.size();
    }

    public  class  ViewHoldernya extends RecyclerView.ViewHolder{
        TextView namaPeminjam,jabatan, kodeBarang, namaBarang,ruangLab;

        public ViewHoldernya(View itemView) {
            super(itemView);
            namaPeminjam=(TextView) itemView.findViewById(R.id.txt_namaPeminjam);
            jabatan=(TextView) itemView.findViewById(R.id.txt_jabatan);
            kodeBarang=(TextView) itemView.findViewById(R.id.txt_kode);
            namaBarang=(TextView) itemView.findViewById(R.id.txt_namaBarang);
            ruangLab=(TextView)itemView.findViewById(R.id.txt_ruangLab);
        }
    }
}
