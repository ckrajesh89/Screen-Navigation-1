package com.example.mynavigationpart1

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.mynavigationpart1.ui.theme.Screens

@Preview
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screens.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Rajesh"
                    nullable = true
                }
            )
        ){  entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
    var text by remember {
       mutableStateOf("")
    }
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            ){
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth()
                )
                Text(text = "Enter Text Here")
                Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
                Button(
                    onClick = {
                              navController.navigate(Screens.DetailScreen.withArgs(text))
                     },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "To DetailScreen")
                }
    }
}

@Composable
fun DetailScreen(name: String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Hello $name, You are on detailed Screen")
    }
}
