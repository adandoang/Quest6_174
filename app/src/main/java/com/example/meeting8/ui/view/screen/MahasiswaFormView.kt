package com.example.meeting8.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meeting8.R


@Composable
fun MahasiswaFormView(
    onSubmitButton: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){

    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var listdata: MutableList<String> = mutableListOf(nim, nama, email)

    Column (modifier = Modifier
        .fillMaxSize()
        .background(
            colorResource(
            id = R.color.greenlatern
            )
        )
    ){
        Row (modifier = Modifier
            .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(
                    id = R.drawable.umy
                ), contentDescription = ""
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Column {
                Text(
                    "Universitas Muhammadiyah Yogyakarta",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Unggul dan Islam",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp
                )
            )
        ){
            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Masukkan Data Kamu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    color = colorResource(R.color.greenlatern)
                )
                Text(
                    "Isi sesuai data yang kamu daftarkan",
                    fontWeight = FontWeight.Light,
                )
                Spacer(modifier = Modifier.padding(4.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = nim,
                    onValueChange = {nim = it},
                    label = {
                        Text(
                            "Nomor Induk Mahasiswa",
                            color = Color.Gray
                        )},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                        contentDescription = ""
                        )}
                    )
                Spacer(modifier = Modifier.padding(4.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = nama,
                    onValueChange = {nama = it},
                    label = {
                        Text(
                            "Nama",
                            color = Color.Gray
                        )},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                        contentDescription = ""
                        )}
                )
                Spacer(modifier = Modifier.padding(4.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = email,
                    onValueChange = {email = it},
                    label = {
                        Text(
                            "Email",
                            color = Color.Gray
                        )},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                        contentDescription = ""
                        )}
                )

                Spacer(modifier = Modifier.padding(12.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = {onBackButtonClicked},
                    ) {
                        Text("Kembali")
                    }
                    Button(onClick = {onSubmitButton}) {
                        Text("Simpan")
                    }
                }
            }
        }
    }
}