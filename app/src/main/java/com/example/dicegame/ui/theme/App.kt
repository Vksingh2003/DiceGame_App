package com.example.dicegame
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random


@Preview(showBackground = true)
@Composable
fun App(modifier: Modifier=Modifier,innerPadding : PaddingValues=PaddingValues()){
    var scorePlayer1= remember { mutableStateOf(value = 0) }
    var scorePlayer2= remember { mutableStateOf(value = 0) }

    var isplayer1Turn=  remember{mutableStateOf(true)}
    val currentImages= remember { mutableStateOf(1) }
    var images= listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_2,
        R.drawable.dice_5,
        R.drawable.dice_6,
        )
    if (scorePlayer1.value>=20 || scorePlayer2.value>=20) {
        Box (modifier=Modifier.fillMaxSize()
            .padding(innerPadding),
            contentAlignment = Alignment.Center) {


            if (scorePlayer1.value > scorePlayer2.value)
                Text(text = "Player Vk Singh  Won")
            else
                Text(text = " Other player  Won")
        }
    }else {


        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isplayer1Turn.value)

                Text(text = "Player 1 Tern ")
            else
                Text(text = "Player 2 Tern")
            Image(
                painter = painterResource(images.get(currentImages.value - 1)),
                contentDescription = null
            )
            Row {
                Button(onClick = {
                    val random = Random.nextInt(6) + 1
                    currentImages.value = random
                    scorePlayer1.value += random
                    isplayer1Turn.value = !isplayer1Turn.value
                    println(isplayer1Turn)
                }, enabled = if (isplayer1Turn.value) true else false) {
                    Text(text = "Player 1")

                }
                Button(onClick = {

                    val random = Random.nextInt(6) + 1
                    currentImages.value = random
                    scorePlayer2.value += random
                    isplayer1Turn.value = !isplayer1Turn.value
                    println(isplayer1Turn)
                }, enabled = if (isplayer1Turn.value) false else true) {
                    Text(text = "Player 2")
                }


            }
        }
    }
}
