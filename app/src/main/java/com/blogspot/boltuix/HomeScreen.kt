package com.blogspot.boltuix

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.bg_splash_banner),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .alpha(0.2f)
            .fillMaxHeight()
            .fillMaxWidth()
    )


    LazyColumn(modifier = Modifier.fillMaxWidth()) {


        item {
            HomeHeader()
        }

        item {
            Text(
                text = "Get ice cream @ 75% off",
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 16.dp,
                    bottom = 16.dp
                ),
            )
        }

        itemsIndexed(tripListing) { position, data ->
            HomeTripItem(homeTripModel = data,navController = navController)
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

    }

}


@Composable
@Preview
fun HomeHeader() {


    Box {

       /* Image(
            painter = painterResource(id = R.drawable.bg_splash_banner),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .alpha(0.2f)
                .fillMaxWidth()
        )
*/

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .statusBarsPadding()
                .padding(16.dp)
        ) {

            Text(
                text = "Ice Cream World",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                letterSpacing = (-1).sp
            )

            Text(
                text = "Now enjoy your favourite Ice Creams",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = ((-0.2).sp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {


                VerticalButton(vector = Icons.Filled.Fastfood, text = "  Juice   ")
                VerticalButton(vector = Icons.Filled.Icecream, text = "Ice cream")
                VerticalButton(vector = Icons.Filled.LocalShipping, text = "Shopping")

            }


        }


    }

}

@Composable
fun VerticalButton(vector: ImageVector, text: String) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor =MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 40.dp)),
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                imageVector = vector, contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary
            )

            Text(text = text,color = MaterialTheme.colorScheme.onPrimary)

            Spacer(modifier = Modifier.height(8.dp))

        }


    }

}

data class HomeTripModel(
    val image: Int,
    val dayPerson: String,
    val title: String,
    val rating: Float
)

@Composable
fun HomeTripItem(homeTripModel: HomeTripModel,navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {

        //painter = rememberCoilPainter(request = homeTripModel.image, fadeIn = true),
        Image(
            painter = painterResource(id = homeTripModel.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 8.dp, bottomStart = 8.dp, bottomEnd = 40.dp))
                .clickable {
                    navController.navigate("detail")
                }
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row() {

            Text(
                text = homeTripModel.dayPerson,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color(255, 215, 0),
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
                    .align(CenterVertically)
            )

            Text(
                text = homeTripModel.rating.toString(),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }

        Text(
            text = homeTripModel.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        )

    }


}

val tripListing = listOf(

    HomeTripModel(
        R.drawable.item1,
        "$2.00",
        "Blueberry Ice Cream | Baked by Rachel",
        5.9f
    ),

    HomeTripModel(
        R.drawable.item2,
        "$1.00",
        "Summer Berry and Rose Fro-Yo | Recipe",
        4.8f
    ),

    HomeTripModel(
        R.drawable.item1,
        "$2.50",
        "Blueberry ice cream with maple and cinnamon",
        5.9f
    ),

    HomeTripModel(
        R.drawable.item3,
        "$1.00",
        "Roasted Blueberry",
        4.8f
    ),



   HomeTripModel(
       R.drawable.item4,
        "$2.00",
        "Rose Ice Cream",
        1.9f
    ),

)