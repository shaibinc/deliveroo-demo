package com.demo.deliveoo.CatogeryItems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RestaurantCard(
    restaurantName: String,
    rating: String,
    ratingText: String,
    reviews: String,
    distance: String,
    deliveryFee: String,
    deliveryTime: String,
    painter: Painter,
    offer: String,
    offerBadgeColor: Color,
    onRestaurantClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .width(260.dp)
            .height(240.dp)
            .padding(start = 5.dp)
            .clickable { onRestaurantClick(restaurantName) },
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                ){
                    Image(
                        painter = painter,
                        contentDescription = restaurantName,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(offerBadgeColor)
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .align(Alignment.TopStart)
                ) {
                    Text(
                        text = offer,
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }

                // Favorite icon
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .size(18.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }

                // Delivery time chip
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = deliveryTime,
                        fontSize = 10.sp
                    )
                }
            }

            // Restaurant details
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = restaurantName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color(0xFF00C2B3),
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = "$rating $ratingText $reviews",
                        color = Color(0xFF00C2B3),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    if (distance.isNotEmpty()) {
                        Text(
                            text = " • $distance",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }
                }

                Text(
                    text = deliveryFee,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}