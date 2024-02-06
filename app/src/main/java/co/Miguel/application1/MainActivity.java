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

    boolean late = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}