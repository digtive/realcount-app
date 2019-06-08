package haris.org.bg_iqbal.pop_up;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import haris.org.bg_iqbal.R;

public class PopUpTest extends AppCompatActivity {
    private Context ctx;
    private Activity act;
    private RelativeLayout rl;
    private Button btn_tampilkan;
    private PopupWindow popCuy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        ctx = getApplicationContext();
        act = PopUpTest.this;
        rl = (RelativeLayout)findViewById(R.id.rl);
        btn_tampilkan = (Button)findViewById(R.id.btn);
        btn_tampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater infla = (LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
                View customDong = infla.inflate(R.layout.layout_pop_up, null);
                popCuy = new PopupWindow(customDong, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                if (Build.VERSION.SDK_INT>=21){
                    popCuy.setElevation(5.0f);
                }
                ImageButton close = (ImageButton)customDong.findViewById(R.id.ib_close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popCuy.dismiss();
                    }
                });
                popCuy.showAtLocation(rl, Gravity.CENTER,0,0);
            }
        });
    }
}
