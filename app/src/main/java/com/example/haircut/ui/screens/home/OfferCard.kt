package com.example.haircut.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.haircut.R

@Composable
fun OfferCard() {
    val padding = 20.dp
    val arrowIconSize = 30.dp
    Card(
        shape = RoundedCornerShape(25),
        content = {
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.green_mint))
                    .padding(padding)
            ) {
                Column() {
                    Text(
                        modifier = Modifier.padding(padding),
                        text = "Accumulate points and get a special prize"
                    )
                    Icon(
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(arrowIconSize),
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_circle_right_24),
                        contentDescription = "arrow",
                    )
                }
            }
        }
    )
}
