package com.demo.deliveoo.datas

import deliveroo.composeapp.generated.resources.Res
import deliveroo.composeapp.generated.resources.all_offer
import deliveroo.composeapp.generated.resources.breakfast
import deliveroo.composeapp.generated.resources.buyone
import deliveroo.composeapp.generated.resources.coffee
import deliveroo.composeapp.generated.resources.rider
import deliveroo.composeapp.generated.resources.top_off
import org.jetbrains.compose.resources.DrawableResource

// PromotionItem.kt
data class PromotionItem(
    val text: String,
    val imageRes: DrawableResource
)

// PromotionData.kt
object PromotionData {
    val promotions = listOf(
        PromotionItem(
            text = "Top Daily\nDeals",
            imageRes = Res.drawable.top_off
        ),
        PromotionItem(
            text = "All offers",
            imageRes = Res.drawable.all_offer
        ),
        PromotionItem(
            text = "Free delivery",
            imageRes = Res.drawable.rider
        ),
        PromotionItem(
            text = "Breakfast",
            imageRes = Res.drawable.breakfast
        ),
        PromotionItem(
            text = "Coffee",
            imageRes = Res.drawable.coffee
        ),
        PromotionItem(
            text = "Buy 1,get 1\nfree",
            imageRes = Res.drawable.buyone
        )
    )
}