package haris.org.bg_iqbal.rci;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;
import java.util.zip.Inflater;

import haris.org.bg_iqbal.R;
import lecho.lib.hellocharts.model.Line;

public class DataCenterRecycleAdapter extends RecyclerView.Adapter<DataCenterRecycleAdapter.ViewHolder> {

    private final List<ItemModel> data;
    private Context context;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public DataCenterRecycleAdapter(final List<ItemModel> data) {
        this.data = data;
        for (int i = 0; i < data.size(); i++) {
            expandState.append(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        ViewHolder amp = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_list_row, parent, false));

        return amp;
    }

    TableRow in; LayoutInflater xx; PopupWindow window_Pop;
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemModel item = data.get(position);
        holder.setIsRecyclable(false);
        holder.textView.setText(item.description+"\n"+item.rincian);

        if (position % 2 == 0){
            holder.isi.setText("Daftar TPS Desa Sekar Sari");
            holder.header.setBackgroundColor(ContextCompat.getColor(context, R.color.material_blue_grey_800));
            xx =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            in = (TableRow)xx.inflate(R.layout.row_login, null);
            TextView tps = (TextView)in.findViewById(R.id.col_tps);
            TableRow ehem = in.findViewById(R.id.rownyaDia);
            ehem.setBackgroundColor(ContextCompat.getColor(context, R.color.material_blue_grey_800));
            tps.setText("009");
            in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View xxx = holder.tl.getChildAt(1);
                    TableRow zzz = (TableRow)xxx;
                    TextView getS = (TextView)zzz.getChildAt(0);

                    View pop_up = xx.inflate(R.layout.pop_up_data, null);
                    window_Pop = new PopupWindow(pop_up, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                    ImageButton tutup = (ImageButton)pop_up.findViewById(R.id.gambar_close);
                    tutup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            window_Pop.dismiss();
                        }
                    });
                    window_Pop.showAtLocation(holder.xxng, Gravity.CENTER,0,0);
                }
            });
            holder.tl.addView(in);
        }
        else {
            holder.isi.setText("Daftar TPS Desa Julung Julung");
        }
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, item.colorId1));
        holder.expandableLayout.setInRecyclerView(true);
        holder.expandableLayout.setBackgroundColor(ContextCompat.getColor(context, item.colorId2));
        holder.expandableLayout.setInterpolator(item.interpolator);
        holder.expandableLayout.setExpanded(expandState.get(position));
        holder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                expandState.put(position, true);
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                expandState.put(position, false);
            }
        });

        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout);
            }
        });
    }

    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView, isi;
        public LinearLayout ln_pop;
        public TableLayout tl;
        public TableRow header;
        public RelativeLayout buttonLayout;
        public View xxng;
        /**
         * You must use the ExpandableLinearLayout in the recycler view.
         * The ExpandableRelativeLayout doesn't work.
         */
        public ExpandableLinearLayout expandableLayout;

        public ViewHolder(View v) {
            super(v);
            xxng = v;
            header = (TableRow)v.findViewById(R.id.row_data);
            tl = (TableLayout)v.findViewById(R.id.tbl_data);
            isi = (TextView)v.findViewById(R.id.isi_expand);
            textView = (TextView) v.findViewById(R.id.textView);
            buttonLayout = (RelativeLayout) v.findViewById(R.id.button);
            expandableLayout = (ExpandableLinearLayout) v.findViewById(R.id.expandableLayout);
        }
    }

    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }
}