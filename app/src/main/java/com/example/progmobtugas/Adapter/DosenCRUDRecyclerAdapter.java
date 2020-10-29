package com.example.progmobtugas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progmobtugas.CrudDosen.DosenUpdateActivity;
import com.example.progmobtugas.CrudMhs.MahasiswaUpdateActivity;
import com.example.progmobtugas.Model.Dosen;
import com.example.progmobtugas.R;

import java.util.ArrayList;
import java.util.List;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context; //untuk memanggil context dari luar karna ini adpter
    private List<Dosen> dosenList;

    //buat constructor
    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList){
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    //setter getter untuk dosenList
    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();//kalo ada perubahan android bakal refresh otomatis
    }
    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    @NonNull
    @Override
    public DosenCRUDRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dosen,parent,false);
        return new DosenCRUDRecyclerAdapter.ViewHolder(v,parent.getContext());

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen d = dosenList.get(position);

        holder.txtNamaDosen.setText(d.getNama());
        holder.txtNidn.setText(d.getNidn());
        holder.txtAlamat.setText(d.getAlamat());
        holder.txtEmail.setText(d.getEmail());
        holder.txtGelar.setText(d.getGelar());
        holder.d = d;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaDosen, txtNidn, txtAlamat, txtEmail, txtGelar, rvGetDosenAll;
        //private RecyclerView rvGetDosenAll;
        Dosen d;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            txtNamaDosen = itemView.findViewById(R.id.txtNama);
            txtNidn = itemView.findViewById(R.id.txtNidn);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtGelar = itemView.findViewById(R.id.txtGelar);
            rvGetDosenAll = itemView.findViewById(R.id.rvGetDosenAll);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent UpInput =new Intent(context, DosenUpdateActivity.class);
                    UpInput.putExtra("nama",d.getNama());
                    UpInput.putExtra("nidn",d.getNidn());
                    UpInput.putExtra("alamat",d.getAlamat());
                    UpInput.putExtra("email",d.getEmail());
                    UpInput.putExtra("gelar",d.getGelar());
                    context.startActivity(UpInput);
                }
            });
        }
    }
}
