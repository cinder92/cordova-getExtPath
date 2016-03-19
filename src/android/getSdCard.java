package dante.plugin.getSdCard;

import java.io.File;
import android.os.Environment;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class getSdCard extends CordovaPlugin{
    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if ("getExternal".equals(action)) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    
                    String sdpath = "";//,sd1path,usbdiskpath,sd0path; 

                    if(new File("/storage/extSdCard/").exists()) 
                    { 
                      sdpath="/storage/extSdCard/";
                     // Log.i("Sd Cardext Path",sdpath); 
                    } 
                    if(new File("/storage/sdcard1/").exists()) 
                    { 
                      sdpath="/storage/sdcard1/";
                      //Log.i("Sd Card1 Path",sdpath); 
                    } 
                    if(new File("/storage/usbcard1/").exists()) 
                    { 
                      sdpath="/storage/usbcard1/";
                      //Log.i("USB Path",sdpath); 
                    } 
                    if(new File("/storage/sdcard0/").exists()) 
                    { 
                      sdpath="/storage/sdcard0/";
                      //Log.i("Sd Card0 Path",sdpath); 
                    }

                    callbackContext.success(sdpath);
                    //getInternal(callbackContext);
                }
            });
            return true;
        }else{
           if("getInternal".equals(action)){
               cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                        String baseDir =  Environment.getExternalStorageDirectory().getAbsolutePath();
                        callbackContext.success(baseDir);
                    }
                });
                return true;
           }
        }
        return false;
    }

}