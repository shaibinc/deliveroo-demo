package com.demo.deliveoo.CatogeryItems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.deliveoo.datas.PromotionData
import org.jetbrains.compose.resources.painterResource

@Composable
public fun PromotionsRow() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(PromotionData.promotions.shuffled()) { promotion ->
            PromotionItem(
                painter = painterResource(resource = promotion.imageRes),
                text = promotion.text
            )
        }
    }
    Divider(
        color = Color(0xFFEEEEEE),
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp).padding(top = 10.dp)
    )
}

@Composable
private fun PromotionItem(
    painter: Painter,
    text: String
) {
    Column(
        modifier = Modifier
            .width(70.dp)
            .clickable { },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(
                    color = Color.Transparent,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = text,
                modifier = Modifier
                    .size(70.dp)
                    .padding(5.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}
