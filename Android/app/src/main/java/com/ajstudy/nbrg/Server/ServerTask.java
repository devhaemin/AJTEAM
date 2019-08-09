package com.ajstudy.nbrg.Server;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerTask<T> extends AsyncTask<RequestObject,ProgressObject,ResultObject<T>> {

    String TAG = "SERVER_TASK";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ResultObject<T> tResultObject) {
        super.onPostExecute(tResultObject);
    }


    @Override
    protected ResultObject<T> doInBackground(RequestObject... requestObjects) {
        String urlBody = "www.naver.com";

        try{

            URL url = new URL(urlBody);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            ResultObject<T> resultObject = new ResultObject<>(connection.getResponseMessage(),connection.getResponseCode());

            String result = "";
            InputStream is;
            InputStreamReader isr;


            Gson gson = new Gson();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                is = connection.getInputStream();
                isr = new InputStreamReader(is);

                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line+ "\n");
                }

                result = stringBuilder.toString();


                Type nameType = new TypeToken<T>(){}.getType();
                resultObject.setResult((T)gson.fromJson(result,nameType));

            }else{
                is = connection.getErrorStream();
                isr = new InputStreamReader(is);

                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line+ "\n");
                }

                result = stringBuilder.toString();

                Type nameType = new TypeToken<ResultObject<String>>(){}.getType();
                resultObject = gson.fromJson(result,nameType);

            }
            /*TO-DO: 반복문을 통해서 결과 String 을 받아서 result에 넣기*/

            gson.fromJson(result,ResultObject.class);

            return resultObject;
        }catch (IOException e){
            e.printStackTrace();
            Log.e(TAG,e.toString());

            ResultObject<T> resultObject = new ResultObject<>(e.getMessage(),800);
            return resultObject;
        }
    }

    @Override
    protected void onProgressUpdate(ProgressObject... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(ResultObject<T> tResultObject) {
        super.onCancelled(tResultObject);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    /*예시 사용코드
     *ServerTask<Region> serverTask = new ServerTask<Region>();
     * serverTask.excute();
     *******************************/
}
