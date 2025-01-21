package com.swanky.superherobook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.swanky.superherobook.model.SuperHero

@Composable
fun DetailScreen(superHero: SuperHero) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondary)
    ) {
        Column {
            AsyncImage(
                model = superHero.image,
                contentDescription = superHero.name,
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
                    .fillMaxWidth()
            )

            Text(
                superHero.name,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Text(
                text = superHero.description,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {


                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    PropertyText("Power Level:", superHero.powerLevel.toString())
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        "Abilities:",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.padding(3.dp))
                    ListText(superHero.abilities)
                }

                VerticalDivider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                        .padding(horizontal = 8.dp),
                    color = Color.Black
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    PropertyText("Team", superHero.team)
                    Spacer(modifier = Modifier.padding(10.dp))
                    PropertyText("Origin City", superHero.originCity)
                    Spacer(modifier = Modifier.padding(10.dp))
                    PropertyText("Publisher", superHero.publisher)
                    Spacer(modifier = Modifier.padding(10.dp))
                    PropertyText("First Appearance Year", superHero.firstAppearanceYear.toString())
                }
            }
        }
    }
}

@Composable
fun PropertyText(title: String, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun ListText(textList: List<String>) {
    val text = textList.joinToString(separator = "\n") { "• $it" }

    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start
    )
}
