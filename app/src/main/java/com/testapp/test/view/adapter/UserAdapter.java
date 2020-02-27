package com.testapp.test.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.testapp.test.R;
import com.testapp.test.databinding.RecyclerBinding;
import com.testapp.viewModel.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.customHolder>{
    ArrayList<UserViewModel> userViewModels=new ArrayList<>();
    private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> userViewModels) {
        this.userViewModels = userViewModels;
    }

    @NonNull
    @Override
    public customHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater=LayoutInflater.from(parent.getContext());
        RecyclerBinding recyclerBinding= DataBindingUtil.inflate(layoutInflater, R.layout.recycler,parent,false);
        return new customHolder(recyclerBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull customHolder holder, int position) {
        UserViewModel userViewModel=userViewModels.get(position);
        holder.bind(userViewModel);

    }

    @Override
    public int getItemCount() {
        return userViewModels.size();
    }

    class customHolder extends RecyclerView.ViewHolder{
        private RecyclerBinding recyclerBinding;

        public customHolder(RecyclerBinding recyclerBinding) {
            super(recyclerBinding.getRoot());
            this.recyclerBinding = recyclerBinding;
        }
        public void bind(UserViewModel userViewModel){
            this.recyclerBinding.setItem(userViewModel);
            this.recyclerBinding.executePendingBindings();

        }

        public RecyclerBinding getRecyclerBinding() {
            return recyclerBinding;
        }
    }
}
