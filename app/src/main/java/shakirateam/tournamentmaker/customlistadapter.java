package shakirateam.tournamentmaker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dylan on 2015-11-23.
 */
public class customlistadapter extends BaseAdapter {


    private class ViewHolder {
        ImageView imageLogo1;
        TextView txtTeam1;
        TextView txtTeam2;
        ImageView imageLogo2;
    }

    private LayoutInflater inflater;
    private ArrayList<CustomGameItem> gameitems;

    public customlistadapter(Context context, ArrayList<CustomGameItem> items) {
        inflater = LayoutInflater.from(context);
        this.gameitems = items;
    }
    public long getItemId(int position) {
        return position;
    }
    public CustomGameItem getItem(int position) {

        return gameitems.get(position);
    }
    public int getCount() {
        return gameitems.size();
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if(view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.games_row_layout, null);
            holder.imageLogo1 = (ImageView) view.findViewById(R.id.logo1);
            holder.txtTeam1 = (TextView) view.findViewById(R.id.team1);
            holder.txtTeam2 = (TextView) view.findViewById(R.id.team2);
            holder.imageLogo2 = (ImageView) view.findViewById(R.id.logo2);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imageLogo1.setImageResource(gameitems.get(position).getLogo1());
        holder.txtTeam1.setText(gameitems.get(position).getTeam1());
        holder.txtTeam2.setText(gameitems.get(position).getTeam2());
        holder.imageLogo2.setImageResource(gameitems.get(position).getLogo2());

        return view;
    }
        }