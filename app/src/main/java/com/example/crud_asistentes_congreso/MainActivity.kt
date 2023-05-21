package com.example.crud_asistentes_congreso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crud_asistentes_congreso.ui.theme.Crud_Asistentes_CongresoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Crud_Asistentes_CongresoTheme {

                val listaUsuarios = remember { mutableListOf<Usuario>() }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ScreenCrud(listaUsuarios)
                    }

                }
            }
        }
    }
}

@Composable

fun ScreenCrud(listaUsuario: MutableList<Usuario>){
    var fullnombre by remember { mutableStateOf("") }
    var registrationDate by remember { mutableStateOf( "") }
    var bloodtype by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf( "") }
    var email by remember { mutableStateOf("") }
    var amountPaid by remember { mutableStateOf("") }

    var isediting by remember {  mutableStateOf(false)  }
    
    
    
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it },
                email = email,
                funEmail = { email = it },
                isEditando = isediting,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = {
                    nombre = ""
                    email = ""
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaUsuarios) { usuario ->

                        CardUsuario(
                            funNombre = { nombre = it },
                            funEmail =  { email = it },
                            usuario = usuario,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios) }
                        )
                    }
                }
            }
        }
    }
}

fun agregarUsuario(nombre: String, email: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.add(Usuario(nombre, email))
}

fun editarUsuario(nombre: String, email: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            usuario.email = email
        }
    }
}

fun borrarUsuario(nombre: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            listaUsuarios.remove(usuario)
        }
    }
}
