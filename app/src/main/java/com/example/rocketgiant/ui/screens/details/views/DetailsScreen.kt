package com.example.rocketgiant.ui.screens.details.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.rocketgiant.R
import com.example.rocketgiant.ui.app.RocketScreensApp
import com.example.rocketgiant.ui.common.ErrorScreen
import com.example.rocketgiant.ui.common.LoadingScreen
import com.example.rocketgiant.ui.common.MainTopBar
import com.example.rocketgiant.ui.screens.details.viewmodel.DetailsViewModel

@Composable
fun DetailsScreenState(
    detailsViewModel: DetailsViewModel = hiltViewModel(),
    nameParam: String,
    deckParam: String,
    imageUrlParam: String? = "https://www.giantbomb.com/a/uploads/square_avatar/8/84290/2764528-3772727124-44466.jpg",
    onBackButton: () -> Unit
) {
    Log.e("DetailsScreenState", "DetailsScreenState: $nameParam")
    Log.e("DetailsScreenState", "DetailsScreenState: $deckParam")
    Log.e("DetailsScreenState", "DetailsScreenState: $imageUrlParam")

    val state by detailsViewModel.state.collectAsState()
    detailsViewModel.prepareData(name = nameParam, deck = deckParam, imageUrl = imageUrlParam)

    when (state) {
        is DetailsViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is DetailsViewModel.UIState.Success -> {
            DetailsScreen(
                nameParam = (state as DetailsViewModel.UIState.Success).name,
                deckParam = (state as DetailsViewModel.UIState.Success).deck,
                imageUrlParam = (state as DetailsViewModel.UIState.Success).imageUrl,
                onBackButton = onBackButton
            )
        }
        is DetailsViewModel.UIState.Error -> {
            ErrorScreen(message = (state as DetailsViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun DetailsScreen(
    nameParam: String,
    deckParam: String,
    imageUrlParam: String,
    onBackButton: () -> Unit
) {
    RocketScreensApp {
        Scaffold(topBar = {
            MainTopBar(
                barTitle = nameParam, showBackButton = true,
                onBackClick = onBackButton
            )
        }) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = dimensionResource(id = R.dimen.dimen_16_dp)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp))
                ) {
                    Image(
                        painter = rememberImagePainter(data = imageUrlParam),
                        contentDescription = nameParam,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(2f)
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_4_dp))),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = nameParam,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = deckParam,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevDetailsScreen() {
    DetailsScreen(
        nameParam = "Something about SEGA",
        deckParam = "SEGA AGES 2500 Vol.13: OutRun is a remake of the arcade classic as part of the Sega Ages series. This version was included in the Sega Classics Collection when released in America and Europe.",
        imageUrlParam = "https://www.giantbomb.com/a/uploads/square_avatar/8/84290/2764528-3772727124-44466.jpg"
    ) {

    }
}