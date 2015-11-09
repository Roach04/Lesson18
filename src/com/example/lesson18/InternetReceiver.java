package com.example.lesson18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetReceiver extends BroadcastReceiver {
	

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO: This method is called when the BroadcastReceiver is receiving
		// an Intent broadcast.
		
		//check whether there is some internet connectivity.
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo info = cm.getActiveNetworkInfo();
		
		//check whether the phone through info var is connected
		//if it is start the appropriate service.
		if (info != null && info.isConnected()) {
			
			Intent s = new Intent(context, UploadService.class);
			
			context.startService(s);
		}
	}
}
