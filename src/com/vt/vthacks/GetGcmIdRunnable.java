package com.vt.vthacks;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by wilsonmitchell on 1/2/14.
 */
public class GetGcmIdRunnable implements Runnable {
	private static final String TAG = "GetGcmIdRunnable";
	private static final long MAX_RETRY_TIME = 1024000;
	private static final String PROJECT_NUMBER = "75742017094";

	private Context context;
	private long retryTime;

	public GetGcmIdRunnable(Context context, long retryTime) {
		this.context = context;
		this.retryTime = retryTime;
	}

	/**
	 * Registers this device with GCM. Retries until successful or takes more than MAX_RETRY_TIME.
	 * 
	 * Success: GCM ID for this device is stored in shared prefs.
	 */
	@Override
	public void run() {
		SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
		String gcmID = sharedPreferences.getString(Constants.PREFS_GCM_ID, null);

		if (gcmID == null) {
			try {
				GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
				gcmID = gcm.register(PROJECT_NUMBER);
			}
			catch (Exception e) {
				Log.d(TAG, "Registration Error: " + e + e.getMessage());
				e.printStackTrace();
				retryGcm();
				return;
			}
			if (gcmID == null) {
				retryGcm();
				return;
			}

			SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.putString(Constants.PREFS_GCM_ID, gcmID);
			editor.commit();
		}
	}

	private void retryGcm() {
		if (retryTime > MAX_RETRY_TIME) {
			return;
		}

		try {
			Thread.sleep(retryTime);
		} catch (InterruptedException e) {
			// You win some, you lose some.
		}
		retryTime *= 2;
		run();
	}
}
