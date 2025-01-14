package com.demo.deliveoo.datas

import androidx.compose.ui.graphics.Color
import deliveroo.composeapp.generated.resources.Res
import deliveroo.composeapp.generated.resources.bugerking
import deliveroo.composeapp.generated.resources.daku
import deliveroo.composeapp.generated.resources.mcd
import deliveroo.composeapp.generated.resources.sainsbury
import org.jetbrains.compose.resources.DrawableResource

data class RestaurantItem(
    val restaurantName: String,
    val rating: String,
    val ratingText: String,
    val reviews: String,
    val distance: String,
    val deliveryFee: String,
    val deliveryTime: String,
    val imageRes: DrawableResource,
    val offer: String,
    val offerBadgeColor: Color
)


object RestaurantData {
    val featuredRestaurants = listOf(
        RestaurantItem(
            restaurantName = "Burger King Sports Club",
            rating = "4.2",
            ratingText = "Very Good",
            reviews = "(53)",
            distance = "2.4 km",
            deliveryFee = "£ 7.00 delivery",
            deliveryTime = "45 - 75 min",
            imageRes = Res.drawable.bugerking,
            offer = "Offers available",
            offerBadgeColor = Color.Red
        ),
        RestaurantItem(
            restaurantName = "Daku Coffee",
            rating = "4.0",
            ratingText = "Good",
            reviews = "(138)",
            distance = "3.5 km",
            deliveryFee = "£ 3.99 delivery",
            deliveryTime = "45 - 25 min",
            imageRes = Res.drawable.daku,
            offer = "Add a free item",
            offerBadgeColor = Color.Magenta
        ),
        RestaurantItem(
            restaurantName = "Sainsbury's Supermarket",
            rating = "4.6",
            ratingText = "Very Good",
            reviews = "(258)",
            distance = "2.0 km",
            deliveryFee = "£ 3.99 delivery",
            deliveryTime = "45 - 25 min",
            imageRes = Res.drawable.sainsbury,
            offer = "Free delivery",
            offerBadgeColor = Color.DarkGray
        ),
        RestaurantItem(
            restaurantName = "McDonald's - East Ham",
            rating = "4.2",
            ratingText = "Very Good",
            reviews = "(100)",
            distance = "3.4 km",
            deliveryFee = "£ 3.99 delivery",
            deliveryTime = "40 - 20 min",
            imageRes = Res.drawable.mcd,
            offer = "Offers available",
            offerBadgeColor = Color.Red
        )
    )
}