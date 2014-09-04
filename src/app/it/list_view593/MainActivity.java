package app.it.list_view593;

import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
private ListView listview;
private ArrayList<List_item> itemlist;
private ListAdapter adapter;




private int[] drawable ={
		R.drawable.facebook,
		R.drawable.google_plush,
		R.drawable.twitter,
		R.drawable.youtube};
private String[] title= {"Faecbook","Google+","twitter","youtube"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView1);
        
   itemlist = new ArrayList<List_item>();
   
   for(int i=0;i<drawable.length;i++){
	   List_item list_item = new List_item();
	   list_item.setTitle(title[i]);
	   list_item.setDrawable(getResources().getDrawable(drawable[i]));
	   itemlist.add(list_item);
	   
   }
   adapter= new Myadapter();
   listview.setAdapter(adapter)
;        
    }
    private class Myadapter extends BaseAdapter {
    	private Holder holder;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemlist.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			arg1= LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_list, null);
			holder = new  Holder();
			holder.imagsview=(ImageView) arg1.findViewById(R.id.item_image);
			holder.text= (TextView) arg1.findViewById(R.id.item_text);
					
			if(itemlist.get(arg0).getDrawable()!=null){
				
				holder.imagsview.setImageDrawable(itemlist.get(arg0).getDrawable());
			}
			if(itemlist.get(arg0).getTitle()!=null){
				
				holder.text.setText(itemlist.get(arg0).getTitle());
				
				
			}
		
			return arg1;
		}
		
		private class Holder{
			public TextView text;
			public  ImageView imagsview;
			
		}
		
	}

   
}
