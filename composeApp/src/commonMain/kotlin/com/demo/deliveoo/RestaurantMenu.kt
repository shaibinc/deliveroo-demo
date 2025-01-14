package com.demo.deliveoo

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.deliveoo.datas.RestaurantData
import com.demo.deliveoo.datas.RestaurantItem
import deliveroo.composeapp.generated.resources.Res
import deliveroo.composeapp.generated.resources.rider
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RestaurantMenuScreen(
    restaurantName: String?,
    onBackClick: () -> Unit
) {
    var restaurantItem =
        RestaurantData.featuredRestaurants.find { it.restaurantName == restaurantName }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Top App Bar with back button, favorite and share icons
//        TopBar(onBackClick)

        // Banner Image
        BannerSection(restaurantItem!!.imageRes,onBackClick)

        // Restaurant Info
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            RestaurantInfo(restaurantItem)

            InfoSection()

            // Delivery Info
            DeliverySection(restaurantItem.deliveryTime)
        }

        // Free Delivery Card
        FreeDeliveryCard()

        // Offers Section
        OffersSection()
    }
}

@Composable
private fun TopBar(onBackClick: () -> Unit,
                   modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = { onBackClick },
            modifier = Modifier
                .size(25.dp)
                .background(Color.White, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00C2B3),
                modifier = Modifier.size(22.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)  // Slightly larger container to prevent clipping
                    .shadow(
                        elevation = 2.dp,  // Reduced shadow for smaller icons
                        shape = CircleShape
                    )
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color(0xFF00C2B3),
                    modifier = Modifier.size(22.dp)
                )
            }
            }
            Box(
                modifier = Modifier
                    .size(36.dp)  // Slightly larger container to prevent clipping
                    .shadow(
                        elevation = 2.dp,  // Reduced shadow for smaller icons
                        shape = CircleShape
                    )
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = Color(0xFF00C2B3),
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(36.dp)  // Slightly larger container to prevent clipping
                    .shadow(
                        elevation = 2.dp,  // Reduced shadow for smaller icons
                        shape = CircleShape
                    )
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFF00C2B3),
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun BannerSection(imageRes: DrawableResource, onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        // Background banner image
        Image(
            painter = painterResource(resource = imageRes),
            contentDescription = "Exclusive Offers",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        TopBar(
            onBackClick = onBackClick,
            modifier = Modifier.align(Alignment.TopCenter)
        )

    }
}

@Composable
private fun RestaurantInfo(restaurantItem: RestaurantItem) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            text = restaurantItem.restaurantName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(restaurantItem.deliveryTime + " American · Burgers · Fries")
        }

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFF00C2B3),
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = restaurantItem.rating + " " + restaurantItem.ratingText + " " + restaurantItem.reviews + " . " + restaurantItem.distance + " away",
                color = Color(0xFF00C2B3)
            )
        }

    }
}
@Composable
private fun InfoSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White)
            .clickable { /* Handle click */ },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            // Info icon
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Info",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Column() {
                Text(
                    text = "Info",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 12.dp)
                )
                // "Allergens and more" text
                Text(
                    text = "Allergens and more",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        // Right arrow icon
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "View more",
            tint = Color(0xFF00C2B3),
            modifier = Modifier.size(24.dp)
        )
    }

    // Add divider

}

@Composable
private fun DeliverySection(deliveryTime: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.rider),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Deliver in $deliveryTime",
                fontWeight = FontWeight.Medium
            )
        }

        TextButton(onClick = { }) {
            Text(
                text = "Change",
                color = Color(0xFF00C2B3)
            )
        }
    }
}

@Composable
private fun FreeDeliveryCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentColor = Color.White

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Free delivery",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Spend £ 15.00  to get free delivery",
                    color = Color.Gray
                )
            }

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                tint = Color(0xFFFF4646),
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
private fun OffersSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "32% off selected items",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Up to 32% off selected items – T&Cs apply",
            color = Color.Gray
        )

        // Offer cards grid would go here
        // You can implement a LazyVerticalGrid for the offers
    }
}