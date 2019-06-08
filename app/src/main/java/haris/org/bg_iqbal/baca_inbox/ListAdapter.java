package haris.org.bg_iqbal.baca_inbox;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import haris.org.bg_iqbal.R;


/**
 * List adapter for storing SMS data
 *
 * @author itcuties
 *
 */
public class ListAdapter extends ArrayAdapter<SMSData> {

    // List context
    private final Context context;
    // List values
    private final List<SMSData> smsList;

    public ListAdapter(Context context, List<SMSData> smsList) {
        super(context, R.layout.activity_baca_inbox, smsList);
        this.context = context;
        this.smsList = smsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_baca_inbox, parent, false);

        TextView senderNumber = (TextView) rowView.findViewById(R.id.txt_sms);
        senderNumber.setText(smsList.get(position).getNumber());

        return rowView;
    }

}