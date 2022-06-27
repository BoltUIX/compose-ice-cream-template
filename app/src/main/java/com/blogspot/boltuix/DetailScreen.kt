package com.blogspot.boltuix

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailScreen(navController: NavController) {

    Image(
        painter = painterResource(id = R.drawable.bg_splash_banner),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .alpha(0.2f)
            .fillMaxHeight()
            .fillMaxWidth()
    )

    /*.background(
            color = MaterialTheme.colorScheme.secondaryContainer
        )*/
    LazyColumn(modifier = Modifier
        ) {

        item {
            DetailHeader(navController)
            TripInfoContent()
        }

        itemsIndexed(tripDays) { position, data ->
            TripDayContent(data)
        }



    }
}

@Composable
fun DetailHeader(navController: NavController) {
    val openDialogCustom = remember{ mutableStateOf(false) }

    /*modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.primary
        )*/

    Box() {
//  painter = rememberCoilPainter(request = detailHeaderImageUrl),
        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )


        Box(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
        ) {

            TopButton(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                navController.popBackStack()
            }

            TopButton(
                imageVector = Icons.Default.Notifications,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                openDialogCustom.value = true
            }

        }


    }
    if (openDialogCustom.value) {
        CustomDialog(openDialogCustom = openDialogCustom)
    }

}


@Composable
fun TripInfoContent() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row {

            LocationChip(text = "Ohio")
            Spacer(modifier = Modifier.weight(1f).background(
                color = MaterialTheme.colorScheme.tertiaryContainer
            ))

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(12.dp)
                    .align(CenterVertically),
                tint = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "4.8 (2.5k reviews)",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(16.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiaryContainer
                )
        )

        Text(
            text = "Summer Berry and Rose Fro-Yo",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = (-0.2).sp
        )

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TripDataItem(
                imageVector = Icons.Default.CalendarToday,
                title = "Duration",
                subtitle = "7 days"
            )

            TripDataItem(
                imageVector = Icons.Default.Person,
                title = "Package For",
                subtitle = "2 Person"
            )

            TripDataItem(
                imageVector = Icons.Default.AttachMoney,
                title = "Cost",
                subtitle = "1.00"
            )

        }

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

    }

}

data class TripDayData(val title: String, val detail: String)

var tripDays = listOf(
    TripDayData(
        title = "Ingredients",
        detail = "600g unsweetened soya/almond/cashew yogurt\n" +
                "\n" +
                "½ cup maple syrup\n" +
                "\n" +
                "Juice of 1 lemon\n" +
                "\n" +
                "2 tsp vanilla extract\n" +
                "\n" +
                "1-2 tbsp. rose water (optional)"
    ),
    TripDayData(
        title = "Berry Mix",
        detail = "250g frozen summery berries or fresh\n" +
                "\n" +
                "2 tbsp. maple syrup\n" +
                "\n" +
                "Extra handful of frozen or fresh to serve"
    ),
    TripDayData(
        title = "Instructions",
        detail = "In small sauce pan add the berries and maple syrup, cook on a medium heat until the juices are flowing and have thawed through. Continue to let them bubble for a few minutes until the liquid becoming a little syrupy. Remove from the heat and allow to cool."
    ),

)


@Composable
fun TripDayContent(day: TripDayData) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Text(
            text = day.title.uppercase(),
            fontSize = 14.sp,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.75.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = day.detail,
            fontSize = 14.sp,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Light,
            lineHeight = 18.sp
        )

    }

}


@Composable
fun TripDataItem(imageVector: ImageVector, title: String, subtitle: String) {

    Row {

        Icon(
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F6FF))
                .size(32.dp)
                .padding(8.dp),

            imageVector = imageVector, contentDescription = ""
        )

        Column {

            Text(
                text = title,
                fontSize = 12.sp,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = subtitle,
                fontSize = 14.sp,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal
            )
        }

    }


}


@Composable
fun LocationChip(text: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {

        Icon(
            imageVector = Icons.Default.LocationOn,
            tint = Color.White,
            contentDescription = "",
            modifier = Modifier
                .padding(end = 4.dp)
                .size(12.dp)
                .align(CenterVertically)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.White
        )
    }

}

@Composable
fun TopButton(imageVector: ImageVector, modifier: Modifier, clickListener: () -> Unit) {

    SmallFloatingActionButton(
        onClick = {  clickListener()  },
        modifier = modifier
    ) {
        Icon(imageVector, contentDescription = "Localized description")
    }
    /*Button(
        onClick = { clickListener() },
        border = BorderStroke(2.dp, Color(0xFFEAFBFF)),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xDDF6F9FF),
            contentColor = Color(0xFF3562D7)
        ),
        modifier = modifier.size(58.dp)

    ) {

        Icon(imageVector = imageVector, contentDescription = "")
    }*/





}

//////////////////////////////////////////////////
@ExperimentalAnimationApi
@Composable
fun BottomOverLay(isLikeButtonVisible: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .padding(horizontal = 24.dp)
            .background(
                Brush.verticalGradient(
                    0.0f to Color(0x00F9FAFF),
                    1.0f to Color(0xFFFAFBFF),
                )
            )

    ) {
        var isLiked by rememberSaveable {
            mutableStateOf(false)
        }
        AnimatedVisibility(
            visible = isLikeButtonVisible,
            modifier = Modifier
                .align(Alignment.CenterEnd),
            enter = slideIn(initialOffset = { IntOffset(0, it.height) }),
            exit = slideOut(targetOffset = { IntOffset(0, it.height * 2) }),
        ) {
            LikeButton(
                isLiked = isLiked,
                onToggleLike = { isLiked = !isLiked }
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun LikeButton(isLiked: Boolean, onToggleLike: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(brush = Brush.linearGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.primary.copy(0.7f))))
            .clickable { onToggleLike() }
            .padding(horizontal = 22.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AnimatedVisibility(
                visible = isLiked,
                enter = expandIn(expandFrom = Alignment.Center),
                exit = shrinkOut(shrinkTowards = Alignment.Center)
            ) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
            AnimatedVisibility(
                visible = !isLiked,
                enter = expandIn(expandFrom = Alignment.Center),
                exit = shrinkOut(shrinkTowards = Alignment.Center)
            ) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.ThumbUp,
                    contentDescription = null,
                    tint = Color.White,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            androidx.compose.material3.Text(
                text = "3.1k",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
