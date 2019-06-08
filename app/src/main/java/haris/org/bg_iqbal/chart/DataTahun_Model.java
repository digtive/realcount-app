package haris.org.bg_iqbal.chart;

import com.google.gson.annotations.SerializedName;

public class DataTahun_Model {
    @SerializedName("year")
    private int year;

    @SerializedName("growth")
    private String pertumbuhan;

    public int getYear() {
        return year;
    }

    public String getPertumbuhan() {
        return pertumbuhan;
    }
}
