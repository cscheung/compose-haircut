package com.example.haircut.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.haircut.HaircutViewModel

@Preview(showBackground = true)
@Composable
fun ServicesPreview() {
    val viewModel = HaircutViewModel()
    ServicesGrid(viewModel.services)
}

@Preview(showBackground = true)
@Composable
fun Service() {
    val service = HaircutViewModel().services.first()
    GridCellContents(service = service)
}