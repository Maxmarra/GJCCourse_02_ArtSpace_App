package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var number by remember{ mutableStateOf(1) }

    Column(verticalArrangement = Arrangement.Center) {
        when (number) {
            1 -> {
                ImageWork(painterId = R.drawable.image_1)
                TitleAndArtist(
                    artistTextId = R.string.artist,
                    artWorkNameId = R.string.title_1
                )
                Controls(
                    onBackClick = { number = onBack(number)},
                    onForthClick = { number = onForth(number)}
                )
            }
            2 -> {
                ImageWork(painterId = R.drawable.image_2)
                TitleAndArtist(
                    artistTextId = R.string.artist,
                    artWorkNameId = R.string.title_2
                )
                Controls(
                    onBackClick = { number = onBack(number)},
                    onForthClick = { number = onForth(number)}
                )
            }
            3 -> {
                ImageWork(painterId = R.drawable.image_3)
                TitleAndArtist(
                    artistTextId = R.string.artist,
                    artWorkNameId = R.string.title_3
                )
                Controls(
                    onBackClick = { number = onBack(number)},
                    onForthClick = { number = onForth(number)}
                )
            }
        }
    }



}

fun onBack(number:Int) : Int{
    var temp1:Int
    return if (number > 1) {
        temp1 = number
        temp1--
        temp1
    } else {
        temp1 = 1
        temp1
    }
}
fun onForth(number:Int) :Int{
    var temp2:Int
    return if (number < 3) {
        temp2 = number
        temp2++
        temp2
    }
    else {
        temp2 = 1
        temp2
    }
}

@Composable
fun ImageWork(
    painterId:Int,
    contentDescription:String? = null
){
    Column(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = painterId),
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun TitleAndArtist(
    artistTextId:Int,
    artWorkNameId:Int){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = stringResource(id = artWorkNameId), fontSize = 34.sp)
        Text(text = stringResource(id = artistTextId), fontSize = 16.sp)
    }
    Spacer(modifier = Modifier.height(30.dp))

}

@Composable
fun Controls(
    onBackClick: () -> Unit,
    onForthClick: () -> Unit ){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ){
        Button(onClick = onBackClick) {
            Text("Назад")
        }
        OutlinedButton(onClick = onForthClick) {
            Text("Вперед")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}