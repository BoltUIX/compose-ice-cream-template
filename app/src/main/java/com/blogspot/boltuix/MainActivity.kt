package com.blogspot.boltuix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blogspot.boltuix.ui.theme.TravelAppTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // This makes it possible to draw behind the status bar.
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            TravelAppTheme {

                val navController = rememberNavController()

                ProvideWindowInsets {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {

                        NavHost(navController = navController,
                            startDestination = "splash"
                        ) {


                            composable("splash") {

                                SplashScreen(navController)

                            }

                            composable("home") {

                                HomeScreen(navController)

                            }

                            composable("detail") {
                                DetailScreen(navController)
                            }

                        }


                    }

                }


            }

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TravelAppTheme {
        Greeting("Android")
    }
}