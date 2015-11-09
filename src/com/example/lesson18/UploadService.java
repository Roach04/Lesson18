package com.example.lesson18;

import org.apache.http.Header;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class UploadService extends Service {
	
	//method to be executed every time a service starts.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		String url = "http://10.0.2.2/lesson18/save.php";
		
		RequestParams params = new RequestParams();
		
		params.put("data", "Fitzgerd");
		
		AsyncHttpClient client = new AsyncHttpClient();
		
		client.post(url, params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] response) {
				
				String data = new String(response);
				
				Log.d("RESP", data);
				
				//stop the service from running.
				stopSelf();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				
				Log.e("ERROR", "Failed to upload");
				
				//stop the service from running.
				stopSelf();
			}
		});
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
