package vamsee.application.icons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.temporal.Temporal;

public class IconAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private int[] icons;
    private String[] names;

    public IconAdapter(Context context, int[] icons, String[] names) {
        this.context = context;
        this.icons = icons;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.app_icon, null);
        }

        ImageView icon = convertView.findViewById(R.id.icon_item);
        TextView name = convertView.findViewById(R.id.name_item);

        icon.setImageResource(icons[position]);
        name.setText(names[position]);

        return convertView;
    }
}
