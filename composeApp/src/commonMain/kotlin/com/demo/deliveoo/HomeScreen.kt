package com.demo.deliveoo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.deliveoo.CatogeryItems.PromotionsRow
import com.demo.deliveoo.CatogeryItems.RestaurantSection
import com.demo.deliveoo.datas.Category
import com.demo.deliveoo.datas.CategoryList
import com.demo.deliveoo.datas.RestaurantData

@Composable
fun HomeScreen(onRestaurantClick: (String) -> Unit
) {
    var selectedCategoryIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Top Bar with Location and Profile
        TopBar()

        // Search Bar
        SearchBar()

        // Categories (Home, Restaurants, etc)
        CategoriesRow(
            selectedIndex = selectedCategoryIndex,
            onCategorySelected = { selectedCategoryIndex = it }
        )
        MainContent(selectedCategory = CategoryList.categories[selectedCategoryIndex], onRestaurantClick = onRestaurantClick)

    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Now",
                color = Color.Gray,
                fontSize = 15.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "E139QF",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color(0xFF00C2B3),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
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
                    modifier = Modifier.size(25.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites",
                        tint = Color(0xFF00C2B3),
                        modifier = Modifier.size(18.dp)  // Smaller icon
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .shadow(
                        elevation = 2.dp,
                        shape = CircleShape
                    )
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(25.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = Color(0xFF00C2B3),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color(0xFFE8FAF7), RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.Gray
        )
        Text(
            text = "Restaurants, groceries, dishes",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
private fun CategoriesRow(
    selectedIndex: Int,
    onCategorySelected: (Int) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.White,
        contentColor = Color(0xFF00C2B3),
        edgePadding = 16.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                color = Color(0xFF00C2B3),
                height = 3.dp
            )
        }
    ) {
        CategoryList.categories.forEachIndexed { index, category ->
            Tab(
                selected = selectedIndex == index,
                onClick = { onCategorySelected(index) },
                text = {
                    Text(
                        text = category.title,
                        color = if (selectedIndex == index) Color(0xFF00C2B3) else Color.Gray
                    )
                }
            )
        }
    }
}

@Composable
private fun MainContent(selectedCategory: Category, onRestaurantClick: (String) -> Unit) {
    LazyColumn {
        // Common sections that appear in multiple categories
        if (selectedCategory.title != "Pickup") {
            item { PromotionsRow() }
        }

        // Featured section appears in all categories
        item {
            RestaurantSection(
            sectionTitle = "Featured",
            isFeatured = true,
            restaurantList = RestaurantData.featuredRestaurants.shuffled(),
            onRestaurantClick = onRestaurantClick
        )
        }

        // Only on Deliveroo section appears only in Home
        if (selectedCategory.title == "Home") {
            item { RestaurantSection(
                sectionTitle = "Only on Deliveroo",
                showSeeAll = true,
                restaurantList = RestaurantData.featuredRestaurants.shuffled(),
                overrideOffer = "Only on Deliveroo",
                overrideOfferColor = Color(0xFF00C2B3),
                onRestaurantClick = onRestaurantClick
            ) }
        }
    }
}
