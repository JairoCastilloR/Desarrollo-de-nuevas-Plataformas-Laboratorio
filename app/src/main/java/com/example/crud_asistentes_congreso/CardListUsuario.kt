package com.example.crud_asistentes_congreso

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardListUsuario(
    funNombre: (String) -> Unit,
    funFecha: (String) -> Unit,
    funTipoSangre: (String) -> Unit,
    funTelefono: (String) -> Unit,
    funEmail: (String) -> Unit,
    funMontoPagado: (String) -> Unit,
    funTextButton: (String) -> Unit,
    funIsEditando: (Boolean) -> Unit,
    usuario: Usuario,
    funBorrarUsuario: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.Center
        ) {
            Text(
                text = usuario.fullName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.registrationDate,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.bloodType,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.phone,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.email,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = usuario.amountPaid,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    onClick = {
                        funNombre(usuario.fullName)
                        funFecha(usuario.registrationDate)
                        funTipoSangre(usuario.bloodType)
                        funTelefono(usuario.phone)
                        funEmail(usuario.email)
                        funMontoPagado(usuario.amountPaid)
                        funTextButton("Editar Usuario")
                        funIsEditando(true)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Editar"
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    onClick = {
                        funBorrarUsuario(usuario.fullName)
                    }
                ) {
                    Text(
                        color = Color.White,
                        text = "Borrar"
                    )
                }
            }
        }
    }
}