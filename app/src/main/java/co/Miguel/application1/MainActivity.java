package co.Miguel.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String name = "Bob";
    int num1 = 10;   // positive value
    int num2 = -5;   // negative value
    int num3 = 0;    // zero value
    int age = 28;
    char grade = 'A';

    TextView nombreUser;
    Button btn1,btn2;


    boolean late = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUser = (TextView) findViewById(R.id.usuario);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nombreUser.setText("Soy Boton 1");
                
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nombreUser.setText("Soy Boton 2");
            }
        });
    }

    public double CalcularArea(int l1, int l2){
        return l1*l2;
    }
}