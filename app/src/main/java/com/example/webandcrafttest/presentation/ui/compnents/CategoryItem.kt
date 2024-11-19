package com.example.webandcrafttest.presentation.ui.compnents



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.webandcrafttest.data.local.SubCategoryEntity
import com.example.webandcrafttest.data.model.SubCategory


@Composable
fun CategoryList(products: List<SubCategory>, categoriesImages: List<String>) {
    LazyRow {
        items(products.size) {

            CategoryItem(category = products[it],imageUrl = categoriesImages[it])
        }
    }
}


@Composable
fun SubCategoryList(products: List<SubCategoryEntity>) {
    LazyRow {
        items(products.size) {

            SubCategoryItem(category = products[it])
        }
    }
}

@Composable
fun CategoryItem(
   category: SubCategory,imageUrl: String?
){
OutlinedCard(onClick = { /*TODO*/ },modifier = Modifier
    .padding(6.dp)
    .size(width = 100.dp, height = 100.dp),
    elevation = CardDefaults.cardElevation(5.dp),
    shape = RoundedCornerShape(9.dp),
    border = BorderStroke(1.dp, Color.Black),
       ) {
    Column {
        ImageHolderForCategories(
            imageUrl = imageUrl,
            //imageUrl = "https://fastly.picsum.photos/id/270/200/200.jpg?hmac=kiH2fdp_jvcCUePVPVJYOa7dhBGLGZOERqNnP0tMFhk",
            modifier = Modifier.weight(2f) // Image takes up 2/3 weight
        )
        Text(
            text = category.title,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f).fillMaxWidth() // Text takes up 1/3 weight
        )
    }
}
}

@Composable
fun SubCategoryItem(
    category: SubCategoryEntity
){
    OutlinedCard(onClick = { /*TODO*/ },modifier = Modifier
        .padding(6.dp)
        .size(width = 100.dp, height = 100.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(9.dp),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Column {
            ImageHolderForCategories(
                //imageUrl = category.imageUrl,
                imageUrl = "https://fastly.picsum.photos/id/270/200/200.jpg?hmac=kiH2fdp_jvcCUePVPVJYOa7dhBGLGZOERqNnP0tMFhk",
                modifier = Modifier.weight(2f) // Image takes up 2/3 weight
            )
            Text(
                text = category.title,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).fillMaxWidth() // Text takes up 1/3 weight
            )
        }
    }
}




@Composable
fun ImageHolderForCategories(
    imageUrl: String?,
    modifier: Modifier = Modifier
){
    AsyncImage(
        model = imageUrl,
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .aspectRatio(1/ 1f)

    )
}