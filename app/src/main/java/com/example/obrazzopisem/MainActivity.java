package com.example.obrazzopisem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView obrazek;
    EditText opis;
    Button wczesniej;
    Button dalej;

    // Lista obiektów przechowujących obraz i opis
    ArrayList<obrazZopisem> obrazyIopisyIobiekt = new ArrayList<>();
    int aktualnyIndeks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        obrazek = findViewById(R.id.imageView);
        opis = findViewById(R.id.editTextText);
        wczesniej = findViewById(R.id.button);
        dalej = findViewById(R.id.button2);

        ArrayList<String> obrazki = new ArrayList<>(Arrays.asList(
                "afterstory",
                "euphonium",
                "geass"
        ));

        ArrayList<String> opisyList = new ArrayList<>(Arrays.asList(
                "to jest clannad after story, true romance",
                "graja na cymbalkach",
                "najlepsze anime"
        ));

        for (int i = 0; i < obrazki.size(); i++) {
            obrazyIopisyIobiekt.add(
                    new obrazZopisem(
                            obrazki.get(i),
                            opisyList.get(i)
                    )
            );
        }

        wyswietlObiekt(aktualnyIndeks);

        dalej.setOnClickListener(v -> {
            if (aktualnyIndeks < obrazyIopisyIobiekt.size() - 1) {
                aktualnyIndeks++;
                wyswietlObiekt(aktualnyIndeks);
            }
        });

        wczesniej.setOnClickListener(v -> {
            if (aktualnyIndeks > 0) {
                aktualnyIndeks--;
                wyswietlObiekt(aktualnyIndeks);
            }
        });
    }

    private void wyswietlObiekt(int index) {
        obrazZopisem aktualny = obrazyIopisyIobiekt.get(index);

        int idObrazu = getResources().getIdentifier(
                aktualny.getIdObrazka(),
                "drawable",
                getPackageName()
        );


        obrazek.setImageResource(idObrazu);
        opis.setText(aktualny.getOpis());
    }
}