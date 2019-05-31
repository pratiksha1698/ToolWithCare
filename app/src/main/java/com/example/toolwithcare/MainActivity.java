package com.example.toolwithcare;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CheckBox checkBox;
    ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home Page");
        toolbar.setSubtitle("Welcome User..!");
        checkBox = findViewById(R.id.mycheckBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    actionMode = MainActivity.this.startSupportActionMode(new ActionBarCallback());
                }else{
                    actionMode.finish();
                }
            }
        });
    }
    class ActionBarCallback implements ActionMode.Callback{
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            actionMode.setTitle("My Action Mode");
            return false;
        }
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

            // You can add Functionality to your Menu Buttons here.
            // Apply switch case statements in case there are more than one Menu Buttons.
            Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            // This is called when Action Mode is completed.

        }
    }
    // For Toolbar Menu Items.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_settings:
startActivity(new Intent(Settings.ACTION_DATE_SETTINGS));
                Toast.makeText(MainActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.action_camera:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show();

                break;

            case R.id.action_logout:

                Toast.makeText(MainActivity.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
