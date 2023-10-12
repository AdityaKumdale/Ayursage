package com.example.ayursage.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ayursage.navigation.Routes
import com.example.ayursage.utils.SharedPref
import com.example.ayursage.viewmodel.AuthViewModel
import com.example.ayursage.viewmodel.UserModel

@Composable
fun Profile(navHostController: NavHostController) {

    val authViewModel:AuthViewModel = viewModel()
    val firebaseUser by authViewModel.firebaseUser.observeAsState(null)

    val context = LocalContext.current
    val user = UserModel(
        name = SharedPref.getName(context )
    )

    LaunchedEffect(firebaseUser){
        if (firebaseUser == null){
            navHostController.navigate(Routes.Login.routes){
                popUpTo(navHostController.graph.startDestinationId)  //clear backstack
                launchSingleTop = true
            }
        }
    }



            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val (text,button) = createRefs()

                Text(text = SharedPref.getName(context), style = TextStyle(
                    fontWeight = FontWeight.ExtraBold, fontSize = 24.sp
                ),modifier = Modifier.constrainAs(text){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

                ElevatedButton(onClick = {
                    authViewModel.logout()
                },modifier = Modifier.constrainAs(button){
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                }) {
                    Text(text = "Logout")
                }
            }



}