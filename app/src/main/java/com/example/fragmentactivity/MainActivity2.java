package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.MemoryFile;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button bt_add;
    EditText idtext,nametext;
    Spinner spin;
    DonneBase db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = new DonneBase(MainActivity2.this);
        bt_add=(Button)findViewById(R.id.bt_addact2);
        idtext=(EditText)findViewById(R.id.tb_idact2);
        nametext=(EditText)findViewById(R.id.tb_nameact2);
        spin =(Spinner)findViewById(R.id.spin1act2);
        String vil[]={"oujda","rabat","fes"};
        spin.setAdapter(new ArrayAdapter<>(MainActivity2.this,R.layout.support_simple_spinner_dropdown_item,vil));
        bt_add.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                    try{
                            db.insertData(Integer.parseInt(idtext.getText().toString()),nametext.getText().toString(),spin.getSelectedItem().toString());

                        Toast.makeText(MainActivity2.this,"Insert good",Toast.LENGTH_LONG).show();
                        }catch (Exception ee){Toast.makeText(MainActivity2.this,"sam7na",Toast.LENGTH_SHORT).show();}

                 }
            });



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
                Intent in = new Intent (MainActivity2.this,MainActivity2.class);
                MainActivity2.this.startActivity(in);

                break;
            case R.id.iconupdate :
                Intent in1 = new Intent (MainActivity2.this,MainActivity3.class);
                MainActivity2.this.startActivity(in1);
                //Toast.makeText(MainActivity.this," nothing to update",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idcondelete :
                Intent in2 = new Intent (MainActivity2.this,MainActivity3.class);
                MainActivity2.this.startActivity(in2);
                //Toast.makeText(MainActivity.this," nothing to Delete",Toast.LENGTH_SHORT).show();
                break;
        }



    return super.onOptionsItemSelected(item);
}

}