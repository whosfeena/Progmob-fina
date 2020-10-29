package com.example.progmobtugas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobtugas.CrudMatKul.MatkulUpdateActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaUpdateActivity;
import com.example.progmobtugas.Model.Dosen;
import com.example.progmobtugas.Model.Matkul;
import com.example.progmobtugas.R;

import java.util.ArrayList;
import java.util.List;

public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {
    private Context context; //untuk memanggil context dari luar karna ini adpter
    private List<Matkul> matkulList;

    //buat constructor
    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matkulList = new ArrayList<>();
    }

    public MatkulCRUDRecyclerAdapter(List<Matkul> matkulList){
        this.matkulList = matkulList;
    }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    //setter getter untuk dosenList
    public void setMatkulList(List<Matkul> matkulList) {
        this.matkulList = matkulList;
        notifyDataSetChanged();//kalo ada perubahan android bakal refresh otomatis
    }
    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    @NonNull
    @Override
    public MatkulCRUDRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_matkul,parent,false);
        return new MatkulCRUDRecyclerAdapter.ViewHolder(v,parent.getContext());

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matkul mk = matkulList.get(position);

        holder.txtKodeMatkul.setText(mk.getKode());
        holder.txtNamaMatkul.setText(mk.getNama());
        holder.txtHari.setText(mk.getHari());
        holder.txtSesi.setText(mk.getSesi());
        holder.txtSks.setText(mk.getSks());
        holder.mk = mk;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKodeMatkul, txtNamaMatkul, txtHari, txtSesi, txtSks, rvGetMatkulAll;
        //private RecyclerView rvGetDosenAll;
        Matkul mk;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            txtKodeMatkul = itemView.findViewById(R.id.txtKodeMatkul);
            txtNamaMatkul = itemView.findViewById(R.id.txtNamaMatkul);
            txtHari = itemView.findViewById(R.id.txtHari);
            txtSesi = itemView.findViewById(R.id.txtSesi);
            txtSks = itemView.findViewById(R.id.txtSks);
            rvGetMatkulAll = itemView.findViewById(R.id.rvGetMatkulAll);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent UpInput =new Intent(context, MatkulUpdateActivity.class);
                    UpInput.putExtra("kode",mk.getKode());
                    UpInput.putExtra("nama",mk.getNama());
                    UpInput.putExtra("hari",mk.getHari());
                    UpInput.putExtra("sesi",mk.getSesi());
                    UpInput.putExtra("sks",mk.getSks());
                    context.startActivity(UpInput);
                }
            });
        }
    }
}
