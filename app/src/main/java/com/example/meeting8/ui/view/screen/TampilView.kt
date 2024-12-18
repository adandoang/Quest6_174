package com.example.meeting8.ui.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.meeting8.R
import com.example.meeting8.model.Mahasiswa
import com.example.meeting8.model.RencanaStudi

@Composable
fun TampilView (
    mhs: Mahasiswa,
    rs: RencanaStudi,
    onSelesaiButtonClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TampilData(
            judul = "NIM",
            isinya = mhs.nim
        )
        TampilData(
            judul = "Nama",
            isinya = mhs.nama
        )
        TampilData(
            judul = "email",
            isinya = mhs.email
        )
        TampilData(
            judul = "Mata Kuliah",
            isinya = rs.namaMK
        )
        TampilData(
            judul = "Kelas",
            isinya = rs.kelas
        )
        Button(onClick = {onSelesaiButtonClicked()}, modifier = Modifier.fillMaxWidth().padding(5.dp)) {
            Text("Selesai")
        }
    }

}

@Composable
fun TampilData(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}

