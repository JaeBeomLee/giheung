package apt.app.giheung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MyData> arrData;
    private LayoutInflater inflater;

    public MyAdapter(Context c, ArrayList<MyData> arr){
        this.context = c;
        this.arrData = arr;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return arrData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrData.get(position).Date();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.haksa_list_text,parent,false);
        }

        TextView date = (TextView)convertView.findViewById(R.id.date);
        date.setText(arrData.get(position).Date());

        TextView dateTV = (TextView)convertView.findViewById(R.id.dateTV);
        date.setText(arrData.get(position).DateText());

        return convertView;
    }
}
