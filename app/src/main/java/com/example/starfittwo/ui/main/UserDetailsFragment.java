package com.example.starfittwo.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.starfittwo.FoodFragment.FoodFrag;
import com.example.starfittwo.FragUserDetails;
import com.example.starfittwo.MainActivity;
import com.example.starfittwo.MainPageTab;
import com.example.starfittwo.R;
import com.google.firebase.auth.FirebaseAuth;

public class UserDetailsFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;

    private FirebaseAuth mFirebaseAuth;

    private TextView signout_tv;


    public static UserDetailsFragment newInstance() {
        return new UserDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_user_details_layout, container, false);

        mFirebaseAuth = FirebaseAuth.getInstance();

        signout_tv = view.findViewById(R.id.signout_tv);
        signout_tv.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signout_tv:
                mFirebaseAuth.signOut();
                startActivity(new Intent(getActivity(), MainActivity.class));
                break;

        }
    }
}