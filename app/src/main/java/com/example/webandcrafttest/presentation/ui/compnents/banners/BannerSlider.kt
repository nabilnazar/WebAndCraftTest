package com.example.webandcrafttest.presentation.ui.compnents.banners


import android.util.Log
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerSlider(imageUrls: List<String>) {

    val linksForTest:List<String> = listOf(
        "https://www.myg.in/lp/05/web/myG-Block_06.jpg",
        "https://rukminim2.flixcart.com/fk-p-flap/844/140/image/85b6c74cb0046bed.jpg?q=50",
        "https://www.myg.in/lp/05/web/myG-Block_55.jpg"
    )

    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        AutoSlidingCarousel(
            itemsCount = imageUrls.size,
            //itemsCount = linksForTest.size,
            itemContent = { index ->

                val encodedUrl = encodeUrl(imageUrls[index]) // Encode URL here
                //val encodedUrl = linksForTest[index]
                 Log.d("SLIDERIMAGE", encodedUrl)


                AsyncImage(
                    model = encodedUrl,
                    contentDescription = "dsd",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp)

                )
            }
        )
    }
}

// Function to encode URLs
fun encodeUrl(url: String): String {
    return url.replace(" ", "%20")
}