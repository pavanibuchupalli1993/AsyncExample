package com.example.asyncexample;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class Presenter {

    MainActivity context;
    public Presenter(MainActivity context)
    {
        this.context=context;

    }
    public void startTimer()
    {
        AsyncTaskRunner runner = new AsyncTaskRunner();
       String sleepTime = context.time.getText().toString();
        runner.execute(sleepTime);
    }
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            context.displayResult(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(context,
                    "ProgressDialog",
                    "Wait for "+context.time.getText().toString()+ " seconds");
        }


        @Override
        protected void onProgressUpdate(String... text) {
            context.displayResult(text[0]);

        }
    }

}
