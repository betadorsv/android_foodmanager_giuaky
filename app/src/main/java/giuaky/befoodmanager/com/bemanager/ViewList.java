package giuaky.befoodmanager.com.bemanager;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {

    ListView listView ;
    ArrayList<UserModel> users=new ArrayList<>();
    static CustomListView viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        try {
            users = UsersDatabaseAdapter.getRows();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        viewAdapter = new CustomListView(this, users);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(viewAdapter);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("View List Foods");
        }

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
//    public void createPDF(View view){
//        ListView listView=findViewById(R.id.listviewID);
//        Context context=ViewList.this;
//        PrintManager printManager=(PrintManager)ViewList.this.getSystemService(context.PRINT_SERVICE);
//        PrintDocumentAdapter adapter=
//
//    }
}
