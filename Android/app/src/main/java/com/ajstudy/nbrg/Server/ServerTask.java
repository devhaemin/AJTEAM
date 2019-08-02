package com.ajstudy.nbrg.Server;

import android.os.AsyncTask;

public class ServerTask<T> extends AsyncTask<RequestObject,ProgressObject,ResultObject<T>> {

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
        return null;
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
