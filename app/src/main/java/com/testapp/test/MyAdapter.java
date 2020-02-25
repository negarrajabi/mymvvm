package com.testapp.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<addressModel> address;
    private Context mcontext;
    public MyAdapter(Context mcontext,List<addressModel> address){
        this.address=address;
        this.mcontext=mcontext;
    }


    public onItemInterface mListener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtname;
        public TextView txtadd;
        public View layout;
        public ViewHolder(View v, int viewType, final onItemInterface mListener) {
            super(v);
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onItemClickListener(view, ViewHolder.this.getLayoutPosition());
                    }
                }
            });
            layout = v;
            txtname = v.findViewById(R.id.username);
            txtadd=v.findViewById(R.id.address);
        }
    }

    public void add(int position, addressModel item) {
        address.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        address.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.recycler, parent, false);
        ViewHolder vh = new ViewHolder(v,viewType,mListener);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final addressModel add = address.get(position);


        holder.txtname.setText(add.getName());
        holder.txtname.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext , Main2Activity.class);
                String nameString= add.getName();
                String idString=add.getId();
                String addString=add.getAddress();
                intent.putExtra("username",nameString);
                intent.putExtra("address",addString);
                intent.putExtra("id",idString);
                ((Activity)mcontext).startActivityForResult(intent,1);

            }
        });

        holder.txtname.setText(add.getName());
        holder.txtadd.setText(add.getAddress());

    }

    @Override
    public int getItemCount() {
        return address.size();
    }

    public void setItemClickListener(onItemInterface mListener){
        this.mListener=mListener;
    }
}
