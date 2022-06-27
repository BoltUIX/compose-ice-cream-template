package com.blogspot.boltuix

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun SplashScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )



        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(16.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 40.dp))
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                )
                .padding(40.dp)//,40.dp,40.dp,40.dp
        ) {



            Text(
                text = "Buy\nIce Cream",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = (-1).sp,

            )

            Text(
                text = "Buy products from ice cream & frozen desserts at best prices and get them home ...",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.1).sp
            )

            Button(
                colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.primary),
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .padding(8.dp, 24.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Get Started",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )

            }

        }


    }


}


@Preview
@Composable
fun SplashPreview() {


}