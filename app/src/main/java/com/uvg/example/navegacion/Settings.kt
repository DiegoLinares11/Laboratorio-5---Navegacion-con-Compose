package com.uvg.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uvg.example.navegacion.R


@Composable
fun settingsView(modifier: Modifier = Modifier, navController: NavHostController){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Gray)

    ){
        Button(onClick = {navController.navigate("emergencia")
        }){
            Text(
                text = "Ve a emergencias"
            )
        }

        plantillaComponentes(imagenID = R.drawable.profile, texto = stringResource(id = R.string.edit_profile))
        plantillaComponentes(imagenID = R.drawable.addresicon, texto = stringResource(id = R.string.email_address))
        plantillaComponentes(imagenID = R.drawable.notifications, texto = stringResource(id = R.string.notifications))
        plantillaComponentes(imagenID = R.drawable.privacy, texto = stringResource(id = R.string.privacy))
        Spacer(modifier = Modifier.height(30.dp))
        plantillaComponentesConTexto(imagenID = R.drawable.help_feedback, texto = stringResource(id = R.string.help_feedback), texto2 = stringResource(id = R.string.troubleshooting_tips))
        plantillaComponentesConTexto(imagenID = R.drawable.about, texto = stringResource(id = R.string.about), texto2 = stringResource(id = R.string.app_information))

        Spacer(modifier = Modifier.height(30.dp))

        TextButton (
            onClick = {/*Aqui iria lo que hace pero por el momento no es funcional*/},
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.White,
                contentColor = Color.Red
            )
        ){
            Text(
                text = "Logout",
                color = Color.Red
            )
        }
    }
}

@Composable
fun plantillaComponentesConTexto(imagenID: Int, texto: String, texto2: String){
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = imagenID),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))

        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = texto)

            Text(
                text = texto2,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun plantillaComponentes(imagenID: Int, texto: String){
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = imagenID),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = texto,
            color = Color.Black
        )

    }
}

