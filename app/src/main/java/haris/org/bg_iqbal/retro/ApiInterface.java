package haris.org.bg_iqbal.retro;

import java.util.List;

import haris.org.bg_iqbal.chart.DataTahun_Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("chart.php")
    Call<List<DataTahun_Model>> getPerkembangan();
}
