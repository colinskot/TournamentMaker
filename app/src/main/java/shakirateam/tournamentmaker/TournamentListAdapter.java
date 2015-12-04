package shakirateam.tournamentmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Colin on 2015-11-25.
 */

public class TournamentListAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<CustomTournamentItem> items;

    private class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
    }

    public TournamentListAdapter(Context context, ArrayList<CustomTournamentItem> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public CustomTournamentItem getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if(view == null) {

            holder = new ViewHolder();

            view = inflater.inflate(R.layout.tournament_row_layout, null);

            holder.text1 = (TextView) view.findViewById(R.id.nameOfTournament);
            holder.text2 = (TextView) view.findViewById(R.id.typeOfTournament);
            holder.text3 = (TextView) view.findViewById(R.id.typeOfGender);
            holder.text4 = (TextView) view.findViewById(R.id.numberOfTeams);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Sets the text according to the position of the item in the array
        holder.text1.setText(items.get(position).getItem1());
        holder.text2.setText(items.get(position).getItem2());
        holder.text3.setText(items.get(position).getItem3());
        holder.text4.setText(items.get(position).getItem4());

        return view;
    }
}
