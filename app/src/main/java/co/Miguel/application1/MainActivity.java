package co.Miguel.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView nombreUser;
    Button btn1, btn2, btnEnviar, btnAlarma, btnCalendar,btnMapa;
    String Tag = "Prueba";
    boolean late = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.Usuario);
        nombreUser.setText("Estoy en Oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "Estoy en OnStart");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.Usuario);
        nombreUser.setText("Estoy en OnResume");


        nombreUser = (TextView) findViewById(R.id.Usuario);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnAlarma = findViewById(R.id.btnAlarma);
        btnCalendar = findViewById(R.id.btnCalendar);
        btnMapa = findViewById(R.id.btnMapa);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreUser.setText("Soy Boton 1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreUser.setText("Soy Boton 2");
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = "Pepito Perez";
                Intent intent = new Intent(getApplicationContext(), Activity_2.class); //getApplicationContext()
                intent.putExtra("name", Nombre);
                startActivity(intent);
            }
        });
        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAlarm("Despierta", 10, 30);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEvent("EventoNuevo", "LugarX", 2, 4);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // showMap();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "Estoy en OnPause");
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.Usuario);
        nombreUser.setText("Estoy en OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "Estoy en OnStop");
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.Usuario);
        nombreUser.setText("Estoy en OnStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "Estoy en OnDestroy");
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.Usuario);
        nombreUser.setText("Estoy en OnDestroy");
    }

    public double CalcularArea(int l1, int l2) {
        return l1 * l2;
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}