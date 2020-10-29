package com.example.progmobtugas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobtugas.CrudMhs.MahasiswaUpdateActivity;
import com.example.progmobtugas.Model.Mahasiswa;
import com.example.progmobtugas.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaCRUDRecyclerAdapter extends RecyclerView.Adapter<MahasiswaCRUDRecyclerAdapter.ViewHolder> {
    private Context context; //untuk memanggil context dari luar karna ini adpter
    private List<Mahasiswa> mahasiswaList;

    //buat constructor
    public MahasiswaCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public MahasiswaCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    //setter getter untuk mahasiswaList
    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();//kalo ada perubahan android bakal refresh otomatis
    }
    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v,parent.getContext());

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvAlamat, tvEmail;
        Mahasiswa mhs;

        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent UpInput =new Intent(context, MahasiswaUpdateActivity.class);
                    UpInput.putExtra("nim",mhs.getNim());
                    UpInput.putExtra("nama",mhs.getNama());
                    UpInput.putExtra("alamat",mhs.getAlamat());
                    UpInput.putExtra("email",mhs.getEmail());
                    context.startActivity(UpInput);
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa m = mahasiswaList.get(position);

        holder.tvNama.setText(m.getNama());
        holder.tvNim.setText(m.getNim());
        holder.tvAlamat.setText(m.getAlamat());
        holder.tvEmail.setText(m.getEmail());
        holder.mhs=m;
    }


}
