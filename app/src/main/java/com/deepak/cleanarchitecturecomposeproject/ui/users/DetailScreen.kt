package com.deepak.cleanarchitecturecomposeproject.ui.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepak.cleanarchitecturecomposeproject.R
import com.deepak.cleanarchitecturecomposeproject.navigation.Screen

@Composable
fun ShowDetailScreen(userName:String) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.user_name),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 16.dp
                    )
            )
            Text(
                text = userName,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 16.dp,
                        end = 8.dp
                    )
            )


        }
    }
}@Composable
fun ShowWebsiteScreen(website:String) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.user_name),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 16.dp
                    )
            )
            Text(
                text = website,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 16.dp,
                        end = 8.dp
                    )
            )


        }
    }
}