package shakirateam.tournamentmaker;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Dylan on 2015-11-23.
 */
public class customlistadapter extends ArrayAdapter{
        String[] color_names;
        Integer[] image_id;
        Context context;
    public customlistadapter(Activity context,Integer[] image_id, String[] text){
        super(context, R.layout.teams_row_layout, text);
        // TODO Auto-generated constructor stub
        this.color_names = text;
        this.image_id = image_id;
        this.context = context;
          }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.teams_row_layout, null,
        true);
        TextView textView = (TextView) single_row.findViewById(R.id.textView);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.logo);
        textView.setText(color_names[position]);
        imageView.setImageResource(image_id[position]);
        return single_row;
        }
        }