package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
        GLOBAL VARIABLE
        semua komponen yg ada dalam layout
    */
    private Button btnToast, btnCount, btnReset, btnSend;
    private TextView txtDisplay;
    private int myCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // mengenali komponen dari layout
        btnToast = (Button)findViewById(R.id.btnToast);
        btnCount = (Button)findViewById(R.id.btnCount);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnSend = (Button)findViewById(R.id.btnSend);
        txtDisplay = (TextView)findViewById(R.id.txtDisplay);

        // buat event handling untuk setiap komponen
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perintah untuk toast
                Toast.makeText(MainActivity.this,
                        "Hasil Count: " + myCount,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perintah untuk count
                myCount++;  // ditambah 1
                if (txtDisplay != null) {
                    txtDisplay.setText(Integer.toString(myCount));
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCount = 0;
                if (txtDisplay != null) {
                    txtDisplay.setText(Integer.toString(myCount));
                }
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perintah mengirim data dari activity 1 ke activity 2
                String txt_display = txtDisplay.getText().toString();
                Intent myIntent = new Intent(MainActivity.this,
                        SecondActivity.class);
                myIntent.putExtra(Intent.EXTRA_TEXT, txt_display);
                startActivity(myIntent);
            }
        });
    }
}
