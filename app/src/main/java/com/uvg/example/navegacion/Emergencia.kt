package com.uvg.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.example.navegacion.R


@Composable
fun emergencyGreed(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ){
        callBox(imageID = R.drawable.warning, title = stringResource(id = R.string.Emergency), text = stringResource(id = R.string.Text1), callText = stringResource(id = R.string.Call_1))
        callBox(imageID = R.drawable.zro07729, title = stringResource(id = R.string.Clinic), text = stringResource(id = R.string.Text2), callText = stringResource(id = R.string.Call_2))
    }
}

@Composable
fun callBox(imageID: Int, title: String, text: String, callText: String){
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
    )
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(top = 16.dp)
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = imageID),
            contentDescription = null,
            modifier = Modifier
                .size(75.dp)
                .padding(end = 16.dp)
                .padding(start = 16.dp)
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0F9D58),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = callText,
                color = Color.White,
                fontSize = 16.sp
            )
        }


    }
}
