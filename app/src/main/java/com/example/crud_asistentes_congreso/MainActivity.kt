package com.example.crud_asistentes_congreso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

fun ScreenCrud(listaUsuarios: MutableList<Usuario>){
    var fullnombre by remember { mutableStateOf("") }
    var registrationDate by remember { mutableStateOf( "") }
    var bloodtype by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf( "") }
    var email by remember { mutableStateOf("") }
    var amountPaid by remember { mutableStateOf("") }

    var isediting by remember {  mutableStateOf(false)  }
    var textButton by remember { mutableStateOf("Agregar Usuario") }
    
    
    
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            Formulario(
                nombre = fullnombre,
                funNombre = { fullnombre = it },
                fecha = registrationDate,
                funFecha = { registrationDate = it },
                tipoSangre = bloodtype,
                funTipoSangre = { bloodtype = it },
                telefono = phone,
                funTelefono = { phone = it },
                email = email,
                funEmail = { email = it },
                montoPagado = amountPaid,
                funMontoPagado = { amountPaid = it },
                isEditando = isediting,
                funIsEditando = { isediting = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = {
                    fullnombre = ""
                    registrationDate = ""
                    bloodtype = ""
                    phone = ""
                    email = ""
                    amountPaid = ""
                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    items(listaUsuarios) { usuario ->

                        CardListUsuario(
                            funNombre = { fullnombre = it },

                            funFecha = { registrationDate = it },
                            funTipoSangre =  { bloodtype = it },
                            funTelefono = { phone = it },
                            funEmail =  { email = it },
                            funMontoPagado =  { amountPaid = it },

                            funTextButton = { textButton = it },
                            funIsEditando = { isediting = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios) },
                            usuario = usuario,
                        )
                    }
                }
            }
        }
    }
}

fun agregarUsuario(nombre: String, fecha:String,tipoSangre:String,telefono:String,email: String,montoPagado:String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.add(Usuario(nombre, fecha, tipoSangre, telefono, email, montoPagado))
}

fun editarUsuario(nombre: String, fecha:String,tipoSangre:String,telefono:String,email: String,montoPagado:String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.fullName == nombre) {
            usuario.registrationDate = fecha
            usuario.bloodType = tipoSangre
            usuario.phone = telefono
            usuario.email = email
            usuario.amountPaid = montoPagado
        }
    }
}

fun borrarUsuario(nombre: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.fullName == nombre) {
            listaUsuarios.remove(usuario)
        }
    }
}
