package com.uvg.example.navegacion

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uvg.example.navegacion.R


@Composable
fun profileSection(modifier: Modifier = Modifier, navController: NavHostController){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ){
            Image(
                painter = painterResource(id = R.drawable.portada_becas_carrera_uvg),
                contentDescription = "Fondo del perfil",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .blur(50.dp)
                    .clickable { navController.navigate("Settings") },
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Imagen de perfil",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(4.dp, Color.White, CircleShape)
                )
            }
        }
        SectionTitlePrem(title = stringResource(id = R.string.My_Name))


        Spacer(modifier = Modifier.height(16.dp))


        plantillaComponentesConTexto(imagenID = R.drawable.graduate, texto = stringResource(id = R.string.My_Campus), texto2 = stringResource(id = R.string.Campus_Central))
        plantillaComponentes(imagenID = R.drawable.friends, texto = stringResource(id = R.string.My_Friends))
        plantillaComponentes(imagenID = R.drawable.calendar, texto = stringResource(id = R.string.My_Calendar))
        plantillaComponentes(imagenID = R.drawable.book, texto = stringResource(id = R.string.My_Courses))
        plantillaComponentes(imagenID = R.drawable.document, texto = stringResource(id = R.string.My_Grades))
        plantillaComponentes(imagenID = R.drawable.group, texto = stringResource(id = R.string.My_Groups))
        plantillaComponentes(imagenID = R.drawable.events, texto = stringResource(id = R.string.My_Upcoming_Events))
    }
}

@Composable
fun SectionTitlePrem(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}
