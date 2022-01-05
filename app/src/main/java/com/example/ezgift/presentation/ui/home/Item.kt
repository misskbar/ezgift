package com.example.ezgift.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ezgift.R
import com.example.ezgift.presentation.ui.theme.EzGiftTheme
import com.example.ezgift.presentation.ui.theme.Primary

@Composable
fun Item() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        elevation = 0.dp,
        shape = RectangleShape
    ) {

        Column() {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(36.dp)
                        .border(BorderStroke(1.dp, Primary), CircleShape)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.ic_icon_facebook),
                    contentDescription = "Facebook Icon",
                )
                Text(
                    text = "Username",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 8.dp, bottom = 8.dp)
                    .background(Color.Black)
                    .border(BorderStroke(1.dp, Primary), RectangleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.ic_icon_facebook),
                contentDescription = "Facebook Icon",
            )

            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.FavoriteBorder, "Love")
                Icon(Icons.Outlined.BookmarkBorder, "Save")
            }

            Text(
                text = "Title",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black
            )

            Text(
                text = "Description",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(
//                    width = 370.dp,
//                    height = 250.dp
//                )
//                .background(Color.White)
//        ) {
//            Column(modifier = Modifier.fillMaxSize()) {
//                Image(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.Black)
//                        .weight(1f),
//                    painter = painterResource(R.drawable.googleg_standard_color_18),
//                    contentDescription = "Item picture",
//                )
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .weight(1f)
//                ) {
//                    Spacer(modifier = Modifier.height(20.dp))
//                    Text(
//                        text = "hola",
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
//                        style = MaterialTheme.typography.h6,
//                        color = Color.Black,
//                        modifier = Modifier.padding(horizontal = 16.dp)
//                    )
//                    Spacer(modifier = Modifier.height(4.dp))
//                    Text(
//                        text = "jhghfgjhfjhgf",
//                        style = MaterialTheme.typography.body1,
//                        color = Color.Black,
//                        modifier = Modifier.padding(horizontal = 16.dp)
//                    )
//                }
//
//            }
//
//            Image(
//                modifier = Modifier
//                    .size(70.dp)
//                    .border(BorderStroke(1.dp, Primary), CircleShape)
//                    .padding(10.dp),
//                contentScale = ContentScale.Crop,
//                painter = painterResource(R.drawable.ic_icon_facebook),
//                contentDescription = "Facebook Icon",
//            )
//        }
    }

}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    EzGiftTheme {
        Item()
    }
}