package com.demo.deliveoo.datas

data class Category(
    val title: String,
    val content: List<Any> = emptyList()  // You can make this more specific based on your needs
)
object CategoryList {
    val categories = listOf(
        Category("Home"),
        Category("Restaurants"),
        Category("Groceries"),
        Category("Offers"),
        Category("Pickup")
    )
}