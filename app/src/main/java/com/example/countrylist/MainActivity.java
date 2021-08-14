package com.example.countrylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    private SearchView searchName;
    public ListView listview;
    String listedCountry[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listviewID);
        searchName = (SearchView) findViewById(R.id.searchID);

        listedCountry = getResources().getStringArray(R.array.country_name);
        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.samplelistview, R.id.textViewID, listedCountry);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, description.class);
                startActivity(intent);
            }
        });

        searchName.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}