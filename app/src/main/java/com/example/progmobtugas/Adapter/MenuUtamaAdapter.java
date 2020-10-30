package com.example.progmobtugas.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.progmobtugas.R;

public class MenuUtamaAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] namaIcon;
    private int[] nomorIcon;

    public MenuUtamaAdapter(Context context, String[] namaIncon, int[] nomorIcon) {
        this.context = context;
        this.namaIcon = namaIncon;
        this.nomorIcon = nomorIcon;
    }

    @Override
    public int getCount() {
        return namaIcon.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(inflater==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null){
            convertView=inflater.inflate(R.layout.row_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);

        imageView.setImageResource(nomorIcon[i]);
        textView.setText(namaIcon[i]);
        return convertView;
    }
}
