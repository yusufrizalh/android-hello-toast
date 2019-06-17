package id.inixindosurabaya.hellotoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView txt_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // memunculkan tanda back button <-
        getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);

        txt_display = (TextView)findViewById(R.id.txtDisplay);
        Intent myIntent = getIntent();
        String display = myIntent.getStringExtra(Intent.EXTRA_TEXT);

        txt_display.setText(display);
    }

    public void onBackPressed() {
        startActivity(new Intent(SecondActivity.this,
                MainActivity.class));
        finish();
    }

    // method untuk back button <-
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
