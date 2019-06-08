package haris.org.bg_iqbal.rci;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;

import haris.org.bg_iqbal.R;
import haris.org.bg_iqbal.chart.PieChart;
import haris.org.bg_iqbal.expandable.RecyclerViewRecyclerAdapter;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class DataCenter extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    View ehem;
    PieChartView vw;

    private OnFragmentInteractionListener mListener;

    public DataCenter() {
        // Required empty public constructor
    }


    public static DataCenter newInstance(String param1, String param2) {
        DataCenter fragment = new DataCenter();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void goButtonClicked(View v){
        Toast.makeText(getActivity(), "Hai", Toast.LENGTH_SHORT).show();

//        Toast.makeText(getActivity(), vw.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View datha = inflater.inflate(R.layout.rci_data_center, container, false);
        vw = datha.findViewById(R.id.pizza_chart);
        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(10, Color.GREEN).setLabel("PPP"));
        pieData.add(new SliceValue(35, Color.YELLOW).setLabel("Golkar"));
        pieData.add(new SliceValue(55, Color.RED).setLabel("PDIP"));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        vw.setPieChartData(pieChartData);

        final RecyclerView recyclerView = datha.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        final List<ItemModel> data = new ArrayList<>();
        int jumlahDesa = 10;
        for (int i=0; i<jumlahDesa; i++){
            if (i%2==0){
                data.add(new ItemModel(
                        "Desa Sekar Sari (60%)",
                        "6 TPS dari 10 TPS",
                        R.color.material_blue_grey_500,
                        R.color.material_blue_grey_700,
                        Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR)));
            }
            else {
                data.add(new ItemModel(
                        "Desa Julung Julung (91%)",
                        "10 TPS dari 11 TPS",
                        R.color.material_brown_500,
                        R.color.material_brown_700,
                        Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR)));
            }
        }

        recyclerView.setAdapter(new DataCenterRecycleAdapter(data));

        return datha;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}