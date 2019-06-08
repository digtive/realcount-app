package haris.org.bg_iqbal.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.43.157/igbal/";
    private static Retrofit retro;

    public static Retrofit getApi(){
        if (retro == null){
            retro = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retro;
    }
}
