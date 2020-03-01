package com.testapp.viewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.testapp.model.User;
import com.testapp.test.view.Main2Activity;
import com.testapp.test.view.adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {
    private ArrayList<UserViewModel> userViewModels=new ArrayList<>();
    private String name;
    private String phone;
    private String address;
    private Context context;
    private User user=new User(name,phone,address);

    public User getUser() {
        return user;
    }

    public Context getContext() {
        return context;
    }

    public UserViewModel(User user) {
        this.name = user.getName();
        this.address=user.getAddress();
        this.phone=user.getPhone();
    }

        //read users info
    public UserViewModel(Context context) {
        this.context=context;
        for (int i = 0; i < 5 ; i++) {
            User user=new User("my name is:"+i,"phone number: 091234567"+i,"address:tehran no:"+i);
            UserViewModel userViewModel=new UserViewModel(user);
            userViewModels.add(userViewModel);

        }
        notifyPropertyChanged(BR.userViewModels);


    }
    //fill recycler with users
    @BindingAdapter("bind:recyclerUser")
    public static void recyclerviewBinder(final RecyclerView recyclerView , final ArrayList<UserViewModel> userViewModels){
        UserAdapter userAdapter=new UserAdapter(userViewModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(userAdapter);


    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Bindable
    public ArrayList<UserViewModel> getUserViewModels() {
        return userViewModels;
    }

    //clicked user
    public void onClickUser(View view,UserViewModel userViewModel) {
        Context context = view.getContext();
        Intent intent = new Intent(context, Main2Activity.class);
        intent.putExtra("name",userViewModel.getName());
        intent.putExtra("phone",userViewModel.getPhone());
        intent.putExtra("address",userViewModel.getAddress());
        context.startActivity(intent);

    }


}
