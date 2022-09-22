package com.example.haircut.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.haircut.Service

@Composable
fun ServicesGrid(services: ArrayList<Service>) {
    val spaceBetweenItems = 10.dp
    val horizontalPadding = 20.dp
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = horizontalPadding, vertical = spaceBetweenItems),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenItems),
        verticalArrangement = Arrangement.spacedBy(spaceBetweenItems)
    ) {

        item(
            span = { GridItemSpan(2) }
        ) {
            OfferCard()
        }
        item(
            span = { GridItemSpan(2) }
        ) {
            OurBarbers()
        }
        items(
            items = services
        ) { service ->
            GridCellContents(service = service)
        }
    }
}

@Composable
fun GridCellContents(service: Service) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        shape = RoundedCornerShape(25),
        elevation = 1.dp
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {

                val iconSize = 50.dp

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(iconSize),
                        painter = painterResource(id = service.icon),
                        contentDescription = "grid_content_icon",
                    )
                }

                Text(
                    text = service.name
                )
            }
        }
    }
}
