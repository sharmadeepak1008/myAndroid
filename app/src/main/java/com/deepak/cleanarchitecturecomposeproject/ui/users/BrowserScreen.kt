package com.deepak.cleanarchitecturecomposeproject.ui.users

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun BrowserScreen(url:String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl("https://$url")
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
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
