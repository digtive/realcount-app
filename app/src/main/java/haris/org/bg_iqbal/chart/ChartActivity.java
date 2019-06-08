package haris.org.bg_iqbal.chart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import haris.org.bg_iqbal.R;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        String tipe = getIntent().getStringExtra("tipe");
        ChartFragment cF = new ChartFragment();
        Bundle bd = new Bundle();
        bd.putString("tipe", tipe);
        cF.setArguments(bd);


        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, cF).commit();
    }
}
