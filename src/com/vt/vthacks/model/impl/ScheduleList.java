package com.vt.vthacks.model.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.vt.vthacks.model.IScheduleItem;
import com.vt.vthacks.model.IScheduleList;

public class ScheduleList extends ArrayList<IScheduleItem> implements IScheduleList {

	/**
	 * For serialization.
	 */
	private static final long serialVersionUID = -8332494709360701455L;
	private static final String SCHEDULE_ITEMS = "items";
	private static final String TAG = null;
	
	public ScheduleList(JSONObject root) {
		super();
		if (root == null) {
			return;
		}

		
		// Add all the schedule items, fail if they do not exist.
		JSONArray items = root.optJSONArray(SCHEDULE_ITEMS);
		if (items == null) {
			return;
		}

		for (int i = 0; i < items.length(); i++) {
			this.add(new ScheduleItem(items.optJSONObject(i)));
		}
	}

	public static IScheduleList fromFile(Context context, String string) {
		AssetManager assetManager = context.getAssets();
		InputStream is;
		String jsString = "";
		try {
			is = assetManager.open(string);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
			String line = null;
			while((line = reader.readLine()) != null){
				jsString += line;
			}
			is.close();
			reader.close();
		}
		catch (IOException e) {
			Log.d(TAG, "ioe");
		}

		try {
			JSONObject root = new JSONObject(jsString);
			return new ScheduleList(root);
		}
		catch (JSONException e) {
			Log.d(TAG, "jse");
		}

		return null;
	}
}