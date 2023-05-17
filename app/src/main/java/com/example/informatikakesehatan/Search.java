package com.example.informatikakesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);
        list = new ArrayList<String>();

        list.add("AIDS");
        list.add("Asthma");
        list.add("Bronchiolitis");
        list.add("Catch a cold");
        list.add("Chicken pox");
        list.add("Cholera");
        list.add("Constipation");
        list.add("Dengue fever");
        list.add("Diabetes mellitus");
        list.add("Diarrhea");
        list.add("Fifth disease");
        list.add("Giardiasis");
        list.add("Head lice");
        list.add("Hepatitis A");
        list.add("Human Immunodeficiency Virus (HIV)");
        list.add("Influenza");
        list.add("Measles");
        list.add("Meningitis");
        list.add("Mumps");
        list.add("Osteoporosis");
        list.add("Pink eye");
        list.add("Pinworms");
        list.add("Ringworm");
        list.add("Rubella");
        list.add("Salmonellosis");
        list.add("Scabies");
        list.add("Shingles");
        list.add("Swimmer’s Itch");
        list.add("Syphilis");
        list.add("Tuberculosis");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,list);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(view.getContext(), AIDS.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(), Asthma.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(), Bronchiolitis.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(view.getContext(), Catch_a_cold.class);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(view.getContext(), Chicken_pox.class);
                    startActivity(intent);
                }
                if (position == 5){
                    Intent intent = new Intent(view.getContext(), Cholera.class);
                    startActivity(intent);
                }
                if (position == 6){
                    Intent intent = new Intent(view.getContext(), Constipation.class);
                    startActivity(intent);
                }
                if (position == 7){
                    Intent intent = new Intent(view.getContext(), Dengue_fever.class);
                    startActivity(intent);
                }
                if (position == 8){
                    Intent intent = new Intent(view.getContext(), Diabetes_mellitus.class);
                    startActivity(intent);
                }
                if (position == 9){
                    Intent intent = new Intent(view.getContext(), Diarrhea.class);
                    startActivity(intent);
                }
                if (position == 10){
                    Intent intent = new Intent(view.getContext(), Fifth_disease.class);
                    startActivity(intent);
                }
                if (position == 11){
                    Intent intent = new Intent(view.getContext(), Giardiasis.class);
                    startActivity(intent);
                }
                if (position == 12){
                    Intent intent = new Intent(view.getContext(), Head_lice.class);
                    startActivity(intent);
                }
                if (position == 13){
                    Intent intent = new Intent(view.getContext(), Hepatitis_A.class);
                    startActivity(intent);
                }
                if (position == 14){
                    Intent intent = new Intent(view.getContext(), HIV.class);
                    startActivity(intent);
                }
                if (position == 15){
                    Intent intent = new Intent(view.getContext(), Influenza.class);
                    startActivity(intent);
                }
                if (position == 16){
                    Intent intent = new Intent(view.getContext(), Measles.class);
                    startActivity(intent);
                }
                if (position == 17){
                    Intent intent = new Intent(view.getContext(), Meningitis.class);
                    startActivity(intent);
                }
                if (position == 18){
                    Intent intent = new Intent(view.getContext(), Mumps.class);
                    startActivity(intent);
                }
                if (position == 19){
                    Intent intent = new Intent(view.getContext(), Osteoporosis.class);
                    startActivity(intent);
                }
                if (position == 20){
                    Intent intent = new Intent(view.getContext(), Pink_eye.class);
                    startActivity(intent);
                }
                if (position == 21){
                    Intent intent = new Intent(view.getContext(), Pinworms.class);
                    startActivity(intent);
                }
                if (position == 22){
                    Intent intent = new Intent(view.getContext(), Ringworm.class);
                    startActivity(intent);
                }
                if (position == 23){
                    Intent intent = new Intent(view.getContext(), Rubella.class);
                    startActivity(intent);
                }
                if (position == 24){
                    Intent intent = new Intent(view.getContext(), Salmonellosis.class);
                    startActivity(intent);
                }
                if (position == 25){
                    Intent intent = new Intent(view.getContext(), Scabies.class);
                    startActivity(intent);
                }
                if (position == 26){
                    Intent intent = new Intent(view.getContext(), Shingles.class);
                    startActivity(intent);
                }
                if (position == 27){
                    Intent intent = new Intent(view.getContext(), Swimmer_Itch.class);
                    startActivity(intent);
                }
                if (position == 28){
                    Intent intent = new Intent(view.getContext(), Syphilis.class);
                    startActivity(intent);
                }
                if (position == 29){
                    Intent intent = new Intent(view.getContext(), Tuberculosis.class);
                    startActivity(intent);
                }
            }
        });



        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

    }
}