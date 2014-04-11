package com.vt.vthacks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// -------------------------------------------------------------------------
/**
 * This class handles the interaction/data for the Map page
 *
 * @author Brandon Potts
 * @version Mar 10, 2014
 */
public class MapFragment extends Fragment {

    // ----------------------------------------------------------
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.map, container, false);
		return view;
	}
}