package com.tmm.android.rssreader;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tmm.android.rssreader.reader.RssReader;
import com.tmm.android.rssreader.RssListAdapter;

public class RssActivity extends ListFragment {

	public static int aspecto;
	public static View view;
	public List<JSONObject> jobs;
	private RssListAdapter adapter;
	Activity activity;
	
	/** Called when the activity is first created. 
	 * @return */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
      
		jobs = new ArrayList<JSONObject>();
		try {
			jobs = RssReader.getLatestRssFeed();
		} catch (Exception e) {
			Log.e("RSS ERROR", "Error loading RSS Feed Stream >> " + e.getMessage() + " //" + e.toString());
			}
		
		adapter = new RssListAdapter(getActivity(), jobs);
	    setListAdapter(adapter);
	   	    	    
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	return inflater.inflate(R.layout.main, container, false);
	}
	
	@Override
	public void onListItemClick(ListView list, View v, int pos, long id) {
		
		try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            JSONObject jsonItem = jobs.get(pos);
            String url = (String) jsonItem.get("url");            
            i.setData(Uri.parse(url));
            startActivity(i);
            }

            catch (JSONException e){}
	}
	
}

