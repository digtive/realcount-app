package haris.org.bg_iqbal.chart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import haris.org.bg_iqbal.R;
import haris.org.bg_iqbal.retro.ApiClient;
import haris.org.bg_iqbal.retro.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChartFragment extends Fragment {

    private BarChart chart_bar;
    private PieChart chart_pie;

    public ChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vw =  inflater.inflate(R.layout.fragment_chart, container, false);
        chart_bar = vw.findViewById(R.id.chart_bar);
        chart_pie = vw.findViewById(R.id.chart_pie);
        getChartType(getArguments().getString("tipe"));
        return vw;
    }

    private void getChartType(final String tipe){
        Call<List<DataTahun_Model>> call = ApiClient.getApi().create(ApiInterface.class).getPerkembangan();
        call.enqueue(new Callback<List<DataTahun_Model>>() {
            @Override
            public void onResponse(Call<List<DataTahun_Model>> call, Response<List<DataTahun_Model>> response) {
                if (response.body() != null){
                    if (tipe.equals("bar")){
                        List<BarEntry> in = new ArrayList<>();
                        for (DataTahun_Model data : response.body()){
                            in.add(new BarEntry(data.getYear(), Float.parseFloat(data.getPertumbuhan())));
                        }
                        BarDataSet bsd = new BarDataSet(in, "Pertumbuhan");
                        bsd.setColors(ColorTemplate.COLORFUL_COLORS);

                        BarData bd = new BarData(bsd);
                        bd.setBarWidth(0.9f);

                        chart_bar.setVisibility(View.VISIBLE);
                        chart_bar.animateY(5000);
                        chart_bar.setData(bd);
                        chart_bar.setFitBars(true);

                        Description desc = new Description();
                        desc.setText("Pertumbuhan per tahun");
                        chart_bar.setDescription(desc);
                        chart_bar.invalidate();
                    }
                    else if (tipe.equals("pie")){
                        List<PieEntry> masuk = new ArrayList<>();
                        for (DataTahun_Model in : response.body()){
                            Float xx = Float.parseFloat(String.valueOf(in.getPertumbuhan()));
                            masuk.add(new PieEntry(in.getYear(), xx));
                        }
                        chart_pie.setVisibility(View.VISIBLE);
                        chart_pie.animateXY(5000,5000);

                        PieDataSet psd = new PieDataSet(masuk, "Pertumbuhan pertahun");
                        psd.setColors(ColorTemplate.COLORFUL_COLORS);

                        PieData pd = new PieData(psd);
                        chart_pie.setData(pd);

                        Description desc = new Description();
                        desc.setText("Pertumbuhan per tahuuuun");
                        chart_pie.setDescription(desc);
                        chart_pie.invalidate();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<DataTahun_Model>> call, Throwable t) {

            }
        });
    }

}
