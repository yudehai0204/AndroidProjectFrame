package com.example.jalen.common;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jalen.mydemoforzhihu.R;
import com.example.jalen.util.NetTools;
import com.example.jalen.util.ToastUtils;

import org.json.JSONObject;

import java.util.Map;


/**
 * Created by Jalen on 2015/7/23.
 */
public class ConstansZhihu {

    /***
     * 访问网络
     */
    public static boolean  getDate(Context context,String url,int methed,final Map<String,String> parmas, Response.Listener<String> success,Response.ErrorListener fail){

      if(NetTools.isConnect(context)) {
          RequestQueue queue = Volley.newRequestQueue(context);
          StringRequest request = new StringRequest(methed, url, success, fail) {

              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  return parmas;
              }
          };

          queue.add(request);
          return true;
      }else {
         new  ToastUtils(context).showToast(context.getResources().getString(R.string.no_net));
        return  false;
      }
    }
}
