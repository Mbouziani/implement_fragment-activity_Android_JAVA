package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
DonneBase db ;
ListView listrow;
public static ArrayList idlist,Namelist,villelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db= new DonneBase(MainActivity3.this);

         idlist = db.getDataquery("SELECT idp FROM person");
         Namelist = db.getDataquery("SELECT name FROM person");
         villelist = db.getDataquery("SELECT ville FROM person");
         listrow = (ListView)findViewById(R.id.list_item3) ;


         listrow.setAdapter(new myadapter());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here.
        switch ( item.getItemId())
        {
            case R.id.iconadd :
                Intent in = new Intent (MainActivity3.this,MainActivity2.class);
                MainActivity3.this.startActivity(in);

                break;
            case R.id.iconupdate :

                Toast.makeText(MainActivity3.this," nothing to update",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idcondelete :
             for (Object e : idslistchecked) {
                   db.DeleteData(e.toString());
             }

                Toast.makeText(MainActivity3.this," nothing to Delete",Toast.LENGTH_SHORT).show();
                break;
        }


    return super.onOptionsItemSelected(item);
}
    ArrayList idslistchecked=new ArrayList()  ;









    class myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return idlist.size();
        }

        @Override
        public Object getItem(int position) {
                      View  view =getLayoutInflater().inflate(R.layout.costumer_rowlist,null);

                        TextView textid  = (TextView)view.findViewById(R.id.textid);

            return textid ;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view =getLayoutInflater().inflate(R.layout.costumer_rowlist,null);

            TextView textid  = (TextView)view.findViewById(R.id.textid);
            TextView textname  = (TextView)view.findViewById(R.id.textname);
            TextView textville  = (TextView)view.findViewById(R.id.textville);

            textid.setText(idlist.get(i).toString());
            textname.setText(Namelist.get(i).toString());
            textville.setText(villelist.get(i).toString());


            CheckBox chekrow = (CheckBox)view.findViewById(R.id.checkrow);
                chekrow.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View v) {
                 if(chekrow.isChecked()){
                     idslistchecked.add(textid.getText().toString());
                 }
             }
             });
            return view;
        }
    }



}