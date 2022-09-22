package com.example.haircut.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun OurBarbers() {
    val imageUrl = "https://picsum.photos/200"
    val imageSize = 45.dp
    val rowPadding = 20.dp
    val imagePadding = 20.dp
    val titleFontSize = 30.sp
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Our Barbers",
            fontSize = titleFontSize
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                content = {
                    Row(
                        modifier = Modifier.padding(rowPadding),
                        horizontalArrangement = Arrangement.spacedBy(imagePadding)
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(imageSize)
                                .clip(CircleShape),
                            model = imageUrl,
                            contentDescription = "barber"
                        )
                        AsyncImage(
                            modifier = Modifier
                                .size(imageSize)
                                .clip(CircleShape),
                            model = imageUrl,
                            contentDescription = "barber"
                        )
                        AsyncImage(
                            modifier = Modifier
                                .size(imageSize)
                                .clip(CircleShape),
                            model = imageUrl,
                            contentDescription = "barber"
                        )
                        AsyncImage(
                            modifier = Modifier
                                .size(imageSize)
                                .clip(CircleShape),
                            model = imageUrl,
                            contentDescription = "barber"
                        )
                    }
                }
            )
        }
    }

}