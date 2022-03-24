package com.example.hemphubdemo10;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    Button mButtonLogout;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account,container,false);
         mButtonLogout=(Button) view.findViewById(R.id.button_logout);

         mButtonLogout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getActivity(),"Successfully Logged Out", Toast.LENGTH_SHORT).show();
                 Intent LoginReturn = new Intent(getActivity(),LoginActivity.class);
                 startActivity(LoginReturn);
             }
         });


        // Inflate the layout for this fragment
        return view;
    }



}
