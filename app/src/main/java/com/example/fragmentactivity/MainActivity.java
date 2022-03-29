package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FrameLayout Fram;
    Button bt_fr1, bt_fr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_fr1=findViewById(R.id.fram1);
        bt_fr2=findViewById(R.id.fram2);
        Fram= findViewById(R.id.Framat);
        getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_1()).commit();
        //Fragment fr =new Fragment();

        bt_fr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_1()).commit();
                //Intent in = new Intent (MainActivity.this,MainActivity2.class);
                //MainActivity.this.startActivity(in);
            }
        });
         bt_fr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getSupportFragmentManager().beginTransaction().replace(R.id.Framat,new fram_2()).commit();
                 //Intent in = new Intent (MainActivity.this,MainActivity3.class);
                //MainActivity.this.startActivity(in);
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
                MainActivity.this.startActivity(new Intent (MainActivity.this,MainActivity2.class));
                break;
            case R.id.iconupdate :
                MainActivity.this.startActivity(new Intent (MainActivity.this,MainActivity3.class));
                //Toast.makeText(MainActivity.this," nothing to update",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idcondelete :
                MainActivity.this.startActivity(new Intent (MainActivity.this,MainActivity3.class));
                //Toast.makeText(MainActivity.this," nothing to Delete",Toast.LENGTH_SHORT).show();
                break;
        }

    return super.onOptionsItemSelected(item);
}
}