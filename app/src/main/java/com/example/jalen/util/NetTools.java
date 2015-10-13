package com.example.jalen.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetTools {
	/**
	 * 检测网络连接情况
	 * 
	 */
	public static boolean isConnect(Context context) {
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				// 获取网络连接管理的对象
				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnected()) {

					// 判断当前网络是否已经连接
					if (info.getState() == NetworkInfo.State.CONNECTED) {

						if (info.isAvailable()) {

							return true;
						}
					} else {
						Toast.makeText(context, "网络检测异常", Toast.LENGTH_SHORT).show();
					}
				}
			} else {
				Toast.makeText(context, "网络检测异常", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			Toast.makeText(context, "网络检测异常", Toast.LENGTH_SHORT).show();
		}
		return false;
	}
}
