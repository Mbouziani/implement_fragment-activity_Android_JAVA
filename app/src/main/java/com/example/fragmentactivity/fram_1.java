package com.example.fragmentactivity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class fram_1 extends Fragment {

    Button bt_add;
    EditText idtext,nametext;
    Spinner spin;
    ListView lv;
    DonneBase db ;
    public static String Chekam;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DonneBase(getActivity());



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View myView = inflater.inflate(R.layout.fragment_fram_1, container, false);

            bt_add=(Button)myView.findViewById(R.id.bt_add);
            idtext=(EditText)myView.findViewById(R.id.tb_id);
            nametext=(EditText)myView.findViewById(R.id.tb_name);
            spin =(Spinner)myView.findViewById(R.id.spin1);
            lv=(ListView) myView.findViewById(R.id.list_item);
            String vil[]={"oujda","rabat","fes"};

            spin.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,vil));
            lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,db.ReadData()));

            bt_add.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                      try{
                            db.insertData(Integer.parseInt(idtext.getText().toString()),nametext.getText().toString(),spin.getSelectedItem().toString());
                            lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,db.ReadData()));
                        Toast.makeText(getActivity().getApplicationContext(),"Insert good",Toast.LENGTH_LONG).show();
                        }catch (Exception ee){Toast.makeText(getActivity().getApplicationContext(),"sam7na",Toast.LENGTH_SHORT).show();}

                 }
            });


              lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                    String idf []= ((String)lv.getItemAtPosition(position)).split(" - ");

                  //Toast.makeText(getActivity().getApplicationContext(),idf[0].trim(),Toast.LENGTH_SHORT).show();


                     //Toast.makeText(getActivity().getApplicationContext(),"ch3ar",Toast.LENGTH_LONG).show();
                     /* Bundle bd = new Bundle();
                      bd.putString("idpersone",idf[0]);*/
                      Chekam = idf[0];
                      /*fram_2 fr = new fram_2();
                      fr.setArguments(bd);*/
                      getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_2()).commit();












                }
              });
        return myView;
    }


}