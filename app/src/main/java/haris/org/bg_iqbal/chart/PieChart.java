package haris.org.bg_iqbal.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import haris.org.bg_iqbal.R;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChart extends AppCompatActivity {
    PieChartView vw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pie_chart);
        vw = findViewById(R.id.chart);
        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(10, Color.GREEN).setLabel("PPP"));
        pieData.add(new SliceValue(35, Color.YELLOW).setLabel("Golkar"));
        pieData.add(new SliceValue(55, Color.RED).setLabel("PDIP"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);

        vw.setPieChartData(pieChartData);
    }
}
