package com.example.fragmentactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class fram_2 extends Fragment {

    EditText tb_id,tb_name ;
    Button bt_update,bt_delete,bt_cancel,bt_apply;
    Spinner spine;
    LinearLayout LL_info;
    TextView idtxt,nametext,villetext;
    DonneBase db ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DonneBase(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fram_2,null,false);
        LL_info = (LinearLayout)view.findViewById(R.id.layout_update);
        tb_id     =(EditText)view.findViewById(R.id.tb_id);
        tb_name   =(EditText)view.findViewById(R.id.tb_name);
        bt_update =(Button) view.findViewById(R.id.update);
        bt_delete =(Button) view.findViewById(R.id.Delete);
        bt_cancel =(Button) view.findViewById(R.id.cancel);
        bt_apply  =(Button) view.findViewById(R.id.apply);
        spine     =(Spinner) view.findViewById(R.id.spin2);
        idtxt     =(TextView) view.findViewById(R.id.idtext);
        nametext  =(TextView) view.findViewById(R.id.nametext);
        villetext =(TextView) view.findViewById(R.id.villetext);
         String vil[]={"oujda","rabat","fes"};
            spine.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,vil));




        //Bundle b = this.getArguments();
        if(fram_1.Chekam!= null){

           //b.getString("idpersone");
          ArrayList list = db.ReadDataCondition(fram_1.Chekam);
          idtxt.setText(list.get(0).toString());
            nametext.setText(list.get(1).toString());
            villetext.setText(list.get(2).toString());
            fram_1.Chekam=null;

            bt_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    db.updateData(Integer.parseInt(tb_id.getText().toString()), tb_name.getText().toString(), spine.getSelectedItem().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_1()).commit();
                }
                catch (Exception ee)
                {
                    Toast.makeText(getActivity().getApplicationContext(),"sam7na",Toast.LENGTH_SHORT).show();
                }
            }});

            bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    db.DeleteData(idtxt.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_1()).commit();
                }
                catch (Exception ee)
                {
                    Toast.makeText(getActivity().getApplicationContext(),"sam7na",Toast.LENGTH_SHORT).show();
                }
            }});

            bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tb_id.setText(list.get(0).toString());
                tb_id.setEnabled(false);
                LL_info.setVisibility(View.VISIBLE);}});

            bt_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {LL_info.setVisibility(View.GONE);} });

        }
        else
        {
            bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(getActivity().getApplicationContext(),"Empty Data !!",Toast.LENGTH_LONG).show();
            }
        });
        }





        // Inflate the layout for this fragment
        return view;
    }
}