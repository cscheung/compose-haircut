package com.example.haircut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.haircut.ui.theme.HaircutTheme
import com.example.haircut.Service

class MainActivity : ComponentActivity() {
    val viewModel = HaircutViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaircutTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Layout(viewModel.services)
                }
            }
        }
    }
}

@Composable
fun Layout(services: ArrayList<Service>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(
            items = services
            ) { service ->
            GridCellContents(service = service)
        }
    }
}

@Composable
fun OfferCard() {
    Card(
        shape = MaterialTheme.shapes.medium,
        content = {
            Text(
                text = "Accumulate points and get a special prize"
            )
        }
    )
}


/*
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalGrid(services: ArrayList<Service>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(services) { service ->
            GridCellContents(service = service)
        }
    }
}

 */

@Composable
fun GridCellContents(service: Service) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = service.icon),
            contentDescription = "grid_content_icon"
        )
        Text(
            text = service.name
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel = HaircutViewModel()
    HaircutTheme {
        Layout(viewModel.services)
    }
}