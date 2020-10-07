package com.example.progmobtugas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobtugas.Model.Mahasiswa;
import com.example.progmobtugas.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaRecycleAdapter extends RecyclerView.Adapter<MahasiswaRecycleAdapter.ViewHolder> {
    private Context context; //untuk memanggil context dari luar karna ini adpter
    private List<Mahasiswa> mahasiswaList;

    //buat constructor
    public MahasiswaRecycleAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }
    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    //setter getter untuk mahasiswaList
    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();//kalo ada perubahan android bakal refresh otomatis
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);
        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        holder.tvNoTelp.setText(m.getNoTelp());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
        }
    }
}
