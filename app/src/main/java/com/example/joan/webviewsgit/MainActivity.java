package com.example.joan.webviewsgit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity {

    WebView navegador;
    ProgressDialog prgDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //codi
        navegador = (WebView) findViewById(R.id.webkit);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.loadUrl("http://www.pccomponentes.com/movil/");
        prgDialog = new ProgressDialog(MainActivity.this);
        prgDialog.setMessage("Carregant la pàgina web");
        navegador.setWebViewClient( new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url){

                return false;
            }
            public void onPageStarted(WebView view, String url, Bitmap favicon){//

                prgDialog.show();

            }
            public void onPageFinished(WebView view, String url, Bitmap favicon){//

                super.onPageFinished(view, url);
                prgDialog.hide();

            }

        });
        //codi

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void stopLoadPage(View view) {

        navegador.stopLoading();

    }

    public void previewsPage(View view) {

        navegador.goBack();

    }

    public void nextPage(View view) {

        navegador.goForward();

    }
}
