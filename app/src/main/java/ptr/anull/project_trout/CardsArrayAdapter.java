package ptr.anull.project_trout;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardsArrayAdapter extends ArrayAdapter<Cards> {
    Context context;

    public CardsArrayAdapter(Context context, int resourceId, List<Cards> items){
        super(context, resourceId, items);
    }

   /* @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent){
        Cards cardItem = getItem(position);
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        name.setText(cardItem.getName()); // name
        image.setImageResource(R.mipmap.ic_launcher); // image
        return convertView;
    }*/
}
