package co.Miguel.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {

    TextView tvNombre,tvPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNombre = findViewById(R.id.tvNombre);
        tvPantalla = findViewById(R.id.tvPantalla);

        String Name = getIntent().getStringExtra("name");
        tvNombre.setText(Name);
    }
}