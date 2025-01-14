package com.demo.deliveoo.CatogeryItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.deliveoo.datas.RestaurantItem
import org.jetbrains.compose.resources.painterResource

@Composable
public fun RestaurantSection(
    sectionTitle: String,
    isFeatured: Boolean = false,
    showSeeAll: Boolean = false,
    restaurantList: List<RestaurantItem>,
    overrideOffer: String? = null,
    overrideOfferColor: Color? = null,
    onRestaurantClick: (String) -> Unit
) {
    Column(
    ) {
        if (isFeatured) {
            // Featured section header style
            Text(
                text = sectionTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 5.dp
                )
            )
            Text(
                text = "Paid placements from our partners",
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(
                    top = 5.dp,
                    bottom = 10.dp,
                    start = 5.dp
                )
            )
        } else {
            // Regular section header with see all
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sectionTitle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (showSeeAll) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "See all",
                        tint = Color(0xFF00C2B3)
                    )
                }
            }
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(end = 5.dp)
        ) {
            items(restaurantList) { restaurant ->
                RestaurantCard(
                    restaurantName = restaurant.restaurantName,
                    rating = restaurant.rating,
                    ratingText = restaurant.ratingText,
                    reviews = restaurant.reviews,
                    distance = restaurant.distance,
                    deliveryFee = restaurant.deliveryFee,
                    deliveryTime = restaurant.deliveryTime,
                    painter = painterResource(resource = restaurant.imageRes),
                    offer = overrideOffer ?: restaurant.offer,
                    offerBadgeColor = overrideOfferColor ?: restaurant.offerBadgeColor,
                    onRestaurantClick = onRestaurantClick
                )
            }
        }
    }
}