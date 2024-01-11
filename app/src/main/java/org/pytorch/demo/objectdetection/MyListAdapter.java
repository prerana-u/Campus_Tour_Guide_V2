package org.pytorch.demo.objectdetection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private ListData[] listdata;
    public DisplayActivity d;

    // RecyclerView recyclerView;
    public MyListAdapter(ArrayList<ListData> listdata) {
        this.listdata = listdata.toArray(new ListData[0]);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.listlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        d=new DisplayActivity();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListData myListData = listdata[position];
        holder.textView1.setText(listdata[position].getName());
        holder.textView2.setText(listdata[position].getRoomno());
        holder.textView3.setText(d.toTitleCase(listdata[position].getFloor()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView1,textView2,textView3;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textView1 = (TextView) itemView.findViewById(R.id.roomname);
            this.textView2 = (TextView) itemView.findViewById(R.id.roomno);
            this.textView3 = (TextView) itemView.findViewById(R.id.floorno);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}