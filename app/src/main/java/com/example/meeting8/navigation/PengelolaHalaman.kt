package com.example.meeting8.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meeting8.model.RencanaStudi
import com.example.meeting8.ui.view.screen.MahasiswaFormView
import com.example.meeting8.ui.view.screen.RencanaStudyView
import com.example.meeting8.ui.view.screen.SplashView
import com.example.meeting8.ui.view.screen.TampilView
import com.example.meeting8.ui.view.viewmodel.MahasiswaViewModel
import com.example.meeting8.ui.view.viewmodel.RencanaStudyViewModel


enum class  Halaman {
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsStateUi = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView (onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.MataKuliah.name) {
            RencanaStudyView (
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it)
                navController.navigate(Halaman.Tampil.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }

        composable(route = Halaman.Tampil.name) {
            TampilView(
                mhs = mahasiswaUiState,
                rs = krsStateUi,
                onSelesaiButtonClicked = {
                    navController.navigate(Halaman.Splash.name){
                        popUpTo(0)
                    }
                }
            )
        }
    }
}