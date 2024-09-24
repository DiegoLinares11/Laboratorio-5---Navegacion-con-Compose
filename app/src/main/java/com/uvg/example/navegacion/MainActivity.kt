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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uvg.example.navegacion.R
import com.uvg.example.navegacion.ui.theme.GrayColor
import com.uvg.example.navegacion.ui.theme.GreenColor
import com.uvg.example.navegacion.ui.theme.NavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacionTheme {
                appConCompose()
            }
        }
    }
}


//val navController = rememberNavController()

//Esto es lo que se vera dentro de la aplicacion:
@Composable
fun imagenesMargen(modifier: Modifier = Modifier, navController: NavHostController){
    Column(
        modifier = modifier
            .fillMaxSize()
        //.padding(16.dp)
    ){
        Image(
            painter = painterResource(R.drawable.carrera_bi_e1692665091446),
            contentDescription = "Imagen Principal",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Button(onClick = { navController.navigate("perfil") }) {
            Text(
                text = "Go To Next."
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle(title = stringResource(id = R.string.DESTACADOS))
        //PRIMER COMPONENTE DE IMAGENES.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            imagenesCards(
                imageID = R.drawable.imagenes_galeria_cit_02,
                title = stringResource(id = R.string.Service_now),
                colorFondo = GreenColor, //Esto es para el verde Lo pase para Theme.kt para usarlos como constantes
                modifier = Modifier.weight(1f)
            )
            imagenesCards(
                imageID = R.drawable.zro07729,
                title = stringResource(id = R.string.Actualidad_UVG) ,
                colorFondo = GrayColor, //GRIS Lo pase para theme.kt para ser usados como constantes.
                modifier = Modifier.weight(1f)
            )
        }
        //ESTE ES EL SEGUNDO COMPONENTE DE IMAGENES
        SectionTitle(title = stringResource(id = R.string.Servicios_Recursos))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            imagenesCards(
                imageID = R.drawable.uvg2_1765825cf2,
                title = stringResource(id = R.string.directorioEstudiantiles),
                colorFondo = GreenColor,
                modifier = Modifier.weight(1f))
            imagenesCards(
                imageID = R.drawable.portada_becas_carrera_uvg,
                title = stringResource(id = R.string.PortalBiblioUVG),
                colorFondo = GrayColor,
                modifier = Modifier.weight(1f))
        }


    }

}
//Estas son como que la estructura de las imagenes que estaran dentro de cards
@Composable
fun imagenesCards(imageID: Int, title: String, colorFondo: Color, modifier: Modifier){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .height(150.dp)
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(colorFondo)
                    .fillMaxWidth()
                    .padding(6.dp)
            ){
                Text(
                    text = title,
                    color = Color.White
                )

            }

        }

    }
}

//Funcion solo para imprimir un titulo.
//Pendiente de agregar tipografias
@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp),
        color = Color.Gray
    )
}

//El scaffold define la plantilla de la aplicación está acá
@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun appConCompose(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = backStackEntry?.destination?.route ?: "screen1"

    Scaffold(
        topBar = {
            AppBar(
                currentScreen,
                navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                })
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "principal",
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = "principal"){
                imagenesMargen(navController = navController)
            }
            composable(route = "perfil") {
                profileSection(navController = navController)
            }

            composable(route = "Settings") {
                settingsView(navController = navController)
            }
            composable (route = "emergencia"){
                emergencyGreed()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, canNavigateBack: Boolean, navigateUp: () -> Unit = {}, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = title
            ) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        modifier = modifier
    )
}