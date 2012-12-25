package com.tmm.android.rssreader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.tmm.android.rssreader.reader.RssReader;
import com.tmm.android.rssreader.RssActivity;

public class Main extends FragmentActivity {
	
	//@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_botones);
		
		if (findViewById(R.id.fragment_container) != null) {
		    if (savedInstanceState != null) { return; 
		}


	RssActivity fragmento = new RssActivity();
	getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmento).commit();
	
		}
	}

	public void RSS1 (View view) {
		//if (findViewById(R.id.fragment_container) != null) {
			//if (savedInstanceState != null) { return; 
			//}
		//}
        RssReader.setFeed("http://feeds.reuters.com/reuters/scienceNews");
		RssActivity fragmento = new RssActivity();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmento).commit();
		}
	
	public void RSS2 (View view) {
		RssReader.setFeed("http://elmundo.feedsportal.com/elmundo/rss/ciencia.xml");
		RssActivity fragmento = new RssActivity();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmento).commit();
		}
	
}