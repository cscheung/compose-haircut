package com.example.haircut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.haircut.ui.theme.HaircutTheme

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
                    MainScreen(viewModel.services)
                }
            }
        }
    }
}

@Composable
fun MainScreen(services: ArrayList<Service>) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
    ) {
        ServicesGrid(services = services)
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

@Composable
fun ServicesGrid(services: ArrayList<Service>) {
    val spaceBetweenItems = 10.dp
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = spaceBetweenItems, vertical = spaceBetweenItems),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenItems),
        verticalArrangement = Arrangement.spacedBy(spaceBetweenItems)
    ) {
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
            .background(Color.Green),
        shape = RoundedCornerShape(25)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {

                Icon(
                    modifier = Modifier
                        .background(Color.Blue),
                    painter = painterResource(id = service.icon),
                    contentDescription = "grid_content_icon"
                )
                Text(
                    text = service.name
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel = HaircutViewModel()
    HaircutTheme {
        MainScreen(viewModel.services)
    }
}