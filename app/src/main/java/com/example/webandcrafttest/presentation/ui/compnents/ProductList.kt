package com.example.webandcrafttest.presentation.ui.compnents


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.webandcrafttest.data.model.Product
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProductList(products: List<Product>,imageUrls: List<String>) {
    LazyRow {
        items(products.size) {

                    ProductItem(product = products[it],imageUrl = imageUrls[it])
            }
        }
    }

@Composable
fun ProductItem(product: Product, imageUrl: String?){


OutlinedCard(onClick = { /*TODO*/ },modifier = Modifier
    .padding(6.dp)
    .size(width = 150.dp, height = 275.dp),
    elevation = CardDefaults.cardElevation(5.dp),
    shape = RoundedCornerShape(5.dp),
    border = BorderStroke(1.dp, Color.Black),
       ) {
    ImageHolder(imageUrl = imageUrl)
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
        ),
        modifier = Modifier
            .size(width = 60.dp, height = 26.dp)
            .padding(2.dp)
    ) {
        Text(
            text = product.discount,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize() // Fills the entire card
            ,
            textAlign= TextAlign.Center
        )
    }
    Text(product.productName, fontSize = 9.sp,lineHeight = 10.sp,)
    StarRating(rating = product.productRating,)
    Row(horizontalArrangement = Arrangement.Center){
        product.offerPrice?.let { Text(text = it, fontWeight = FontWeight.Bold,modifier = Modifier.padding(start = 8.dp)) }
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = product.actualPrice, color = Color.LightGray, fontSize = 12.sp, textDecoration = TextDecoration.LineThrough)}

}

}

@Composable
fun ImageHolder(
    imageUrl: String?,
    modifier: Modifier = Modifier
){
    AsyncImage(
        model = imageUrl,
        contentDescription = "Image",
        contentScale = ContentScale.Fit,
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .aspectRatio(10 / 10f),
    )
}


@Composable
fun StarRating(
    rating: Int,
    maxRating: Int = 5,
    size: Dp = 15.dp,
    color: Color = Color.Yellow,
    emptyStarIcon: ImageVector = Icons.Default.Star,
    filledStarIcon: ImageVector = Icons.Default.Star
) {
    Row {
        repeat(maxRating) { index ->
            val icon = if (index < rating) filledStarIcon else emptyStarIcon
            Icon(
                imageVector = icon,
                contentDescription = null, // Content description can be provided
                tint = if (index < rating) color else Color.Gray,
                modifier = Modifier.width(size)
            )
            Spacer(modifier = Modifier.width(4.dp)) // Add some space between stars
        }
    }
}

