package com.example.webandcrafttest.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.webandcrafttest.R
import com.example.webandcrafttest.presentation.ui.compnents.CategoryList
import com.example.webandcrafttest.presentation.ui.compnents.CategorySection
import com.example.webandcrafttest.presentation.ui.compnents.ProductList
import com.example.webandcrafttest.presentation.ui.compnents.SearchBar
import com.example.webandcrafttest.presentation.ui.compnents.SingleBanner
import com.example.webandcrafttest.presentation.ui.compnents.banners.BannerSlider
import com.example.webandcrafttest.presentation.viewmodel.CategoryViewModel

@Composable
fun HomeScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
    onCartClick:() -> Unit
) {
    val bestSellers by viewModel.bestSellers.collectAsState()
    val mostPopular by viewModel.mostPopular.collectAsState()
    val topCategories by viewModel.topCategories.collectAsState()

    val scrollState = rememberScrollState()

//    LaunchedEffect(Unit) {
//        viewModel.fetchData()
//    }

    Scaffold(
        topBar = { TopAppBar(onCartClick) },

    ) {innerpadding ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .verticalScroll(scrollState)
        ) {
            // Your App Bar


            // Banner Slider
            //need to create a list of images from drawables

            BannerSlider(imageUrls = listOf(
                "https://www.myg.in/lp/05/web/myG-Block_06.jpg",
                "https://telecomtalk.info/wp-content/uploads/2023/01/nothing-phone-2-what-will-be-different-1024x683.jpg",
                "https://www.91-cdn.com/hub/wp-content/uploads/2024/09/galaxy-s24-fe-us-pre-order.jpg?tr=w-781"

            ))


            val bestImages = listOf(
                "https://rukminim2.flixcart.com/image/612/612/xif0q/speaker/e/u/a/-original-imah28h33mx9ydyc.jpeg?q=70",
                "https://f.nooncdn.com/p/v1619507392/N45677408A_1.jpg?format=avif&width=240",
                "https://m.media-amazon.com/images/I/71+Td2t3VDL._AC_UL320_.jpg",
                "https://m.media-amazon.com/images/I/714UFzp5O7L._AC_UL320_.jpg",
                "https://m.media-amazon.com/images/I/61NbiB1GU-L._AC_UY218_.jpg",
                "https://m.media-amazon.com/images/I/71cAYYJDZzL._AC_SY200_.jpg",
                "https://m.media-amazon.com/images/I/41GAnuY2-DL._SR480,440_.jpg"
            )

            // Best Sellers Section
            CategorySection(text = "Best Sellers")
            if (bestSellers.isNotEmpty()) {
                ProductList(products = bestSellers,bestImages)
            }

            // Single Banner
            // todo replace it with new image from drawables
            SingleBanner(
                imageUrl = "https://rukminim2.flixcart.com/fk-p-flap/1600/270/image/680c305665e3e72a.jpeg?q=20"
            )

            val categoriesImages = listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSWgk4CAFWLDm8-WhVc5G8-5z0883ftm7yIbbLoeILm6c8mh2qsBniFn6GAN__g3ujEMQ&usqp=CAU",
                "https://img.etimg.com/thumb/width-640,height-480,imgsize-41334,resizemode-75,msid-64995160/small-biz/startups/newsbuzz/top-electronic-home-appliances-to-buy-this-prime-day-sale/amazonsalenew.jpg",
                "https://images.samsung.com/is/image/samsung/assets/in/offer/online/samsung-fest/Laptop-Monitor-pc-28-07-2024.png?\$100_100_PNG\$",
                "https://images.samsung.com/is/image/samsung/assets/in/offer/online/samsung-fest/Tablets-Wearables-pc-28-07-2024.png?\$100_100_PNG\$"
            )

            // Top Categories Section
            CategorySection(text = "Top Categories")
            if (topCategories.isNotEmpty()) {
                CategoryList(products = topCategories,categoriesImages)
            }

            val mostPopularImages = listOf(
                "https://m.media-amazon.com/images/I/61WvST--FFL._AC_UL320_.jpg",
                "https://rukminim2.flixcart.com/image/612/612/xif0q/gamingconsole/b/w/n/-original-imagzf6vtprhm3sz.jpeg?q=70",
                "https://rukminim2.flixcart.com/image/312/312/xif0q/mobile/y/9/0/-original-imahyuhfg2z4fvyh.jpeg?q=70",
                "https://m.media-amazon.com/images/I/51GGNToj7aL._AC_UL320_.jpg",
                "https://f.nooncdn.com/p/v1686814275/N53414281A_1.jpg?format=avif&width=240",
                "https://m.media-amazon.com/images/I/817bs-vUENL._AC_UL320_.jpg",
                "https://m.media-amazon.com/images/I/51GGNToj7aL._AC_UL320_.jpg"
            )

            // Most Popular Section
            CategorySection(text = "Most Popular")
            if (mostPopular.isNotEmpty()) {
                ProductList(products = mostPopular,mostPopularImages)
            }
        }
    }

    }

@Composable
fun TopAppBar(onCartClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(81.dp)
            .background(Color.Green)
            .padding(horizontal = 8.dp)
            .padding(top = 21.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.sharp_shopping_cart_24),
            contentDescription = "shopping cart icon",
            Modifier.clickable { onCartClick()}
        )
        SearchBar(hint = "search...")
        Icon(
            Icons.Outlined.Notifications,
            contentDescription = "shopping cart icon"
        )
    }
}