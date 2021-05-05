package giuaky.befoodmanager.com.bemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView extends BaseAdapter {
    Context c;
    ArrayList<UserModel> users;

    public CustomListView(Context c, ArrayList<UserModel> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view=LayoutInflater.from(c).inflate(R.layout.listview,viewGroup,false);
        }

        TextView mtextView1 = (TextView) view.findViewById(R.id.textView1);
        TextView mtextView2 = (TextView) view.findViewById(R.id.textView2);
        TextView mtextView3 = (TextView) view.findViewById(R.id.textView3);

        final UserModel user= (UserModel) this.getItem(i);
        mtextView1.setText(user.getUsername());
        mtextView2.setText(user.getUserphone());
        mtextView3.setText(user.getUseremail());


        return view;
    }
}
