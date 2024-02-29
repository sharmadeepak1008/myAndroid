package com.deepak.cleanarchitecturecomposeproject.ui.users

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun BrowserScreen(url:String) {
   // var backEnabled by remember { mutableStateOf(false) }
   // val webView: WebView? =null
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl("https://www.ldoceonline.com/")
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
                Log.d("webview url: ", url)
            }
        },
/*
        update = { webView ->
            webView.loadUrl("https://www.ldoceonline.com/")

        }
*/
    )
}
@Composable
fun ShowSnackbar(message: String) {
    Snackbar(
        action = {
            Button(onClick = {}) {
                Text("Dismiss")
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(message)
    }
}
