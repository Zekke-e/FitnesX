package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.example.fitnessapp.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition { viewModel.isLoading.value!! }
        setContentView(R.layout.activity_main)


//        viewModel.getStart().observeOnce(this, observer = Observer {
//            if (it != null) {
//                navController.popBackStack()
//                navController.navigate(it)
//            }
//        })
    }
}
