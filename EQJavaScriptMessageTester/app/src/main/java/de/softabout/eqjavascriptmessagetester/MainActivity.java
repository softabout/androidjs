package de.softabout.eqjavascriptmessagetester;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                String message = "SSL Certificate error.";
                switch (error.getPrimaryError()) {
                    case SslError.SSL_UNTRUSTED:
                        message = "The certificate authority is not trusted.";
                        break;
                    case SslError.SSL_EXPIRED:
                        message = "The certificate has expired.";
                        break;
                    case SslError.SSL_IDMISMATCH:
                        message = "The certificate Hostname mismatch.";
                        break;
                    case SslError.SSL_NOTYETVALID:
                        message = "The certificate is not yet valid.";
                        break;
                }
                message += "\"SSL Certificate Error\" Do you want to continue anyway?.. YES";

                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.evaluateJavascript("javascript: var messageData = {token: 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJjYTEyOThhMC02N2NjLTQ2OTctYjY4Zi02N2M2YTllYzE3NWYiLCJpc3MiOiJodHRwczovL2Rldi5vbmV3ZWIubWVyY2VkZXMtYmVuei5jb20iLCJzdWIiOiJHUmVLblVkRVdzNS13RFc4MHBFUVMwcGlwMjN6R0E1aE5RSXZ3S05zN29nIiwiZXhwIjozMDg0MjExNTY4LCJpYXQiOjE1NDIxMDIxODQsIm9yaWdpbmFsX2lzc3VlciI6Imh0dHBzOi8vYXBpLWNlcnQtdGVzdC5pLmRhaW1sZXIuY29tLyIsImF1dGhfdGltZSI6MTU0MjEwMjE4NCwiZ2VuZGVyIjoiIiwibmFtZSI6IkhvbGdlciBNZXllciIsImZpcnN0X25hbWUiOiJIb2xnZXIiLCJsYXN0X25hbWUiOiJNZXllciIsImVtYWlsIjoiaG9sZ2VyLnNlZW11ZWxsZXJAZGFpbWxlci5jb20iLCJwaG9uZSI6IiIsInJvbGVzIjpbInVzZXIiXX0.gQ14LLx53z35r6AnC4b6yraNCmfYI_P_R7cY0qA75fhZDmO1AUVWTqOi3QM5P0PQHGBLjsFWEL7xSxB1MvG2UYuZKAn8osHOcXTikMguX6EGnmHDRfNs2i41LEO4O86FLoJFSB1e6cBOUiPSYeaREFkMjU1VwyrOJUhdFV_k1cr-tIDtJ4QKraaWum76QFiQi4ptBh014NxC9qzOTWcKDuOKCdTWBrFbUIEYwU20bYsbtutKzOHmjRQ4iAE6WS1DCaJH2upzuYhIx5ZVOGG7eLbJLpzX3D_LCrCPr1E3FoHn0bHRHxhRFUlYXPY7ar6rpwfTV8tt5_Y06u-2ZwvuBmgws0UanWxXX3Yuomnc5pK620PxUsuLDlPVskb1tHg69sDAZjipSl7dNk8X1I9FfaAlFSYqJNIEEV0YwSPwW5_O8Llfd95VHi4ROTnXvYtg20CyYp2OHDIM3Nx28otVuc3iXXQXnGSEwcUEmJjVXqTZ8D2UTjYqeOTnIqbdgw3O64dOqRL7tEvRmQLC0I0KtwemcVBaRM3DXAsfDIA013IeavnOpzR2I5m2x9SbrtdRjVPip0Qp8NWUA1c8Wwr_pswaDL_8QurJ2pEgADkMRPBF2ckxKqAJtancl4nEY4tDsq77Hn7yN_4Qws1IdsMrqiM4R1MfPVnpEZp3wK_ntXk',firstname: 'Holger',lastname: 'Seemüller'}; window.postMessage(messageData, '*');", null);
            }
        });
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://eq-preorder-dev.mercedes-benz.com/public/eqreadyv2.html");
    }


}
