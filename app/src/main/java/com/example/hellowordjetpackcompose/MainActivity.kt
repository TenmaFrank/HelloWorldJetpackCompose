package com.example.hellowordjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellowordjetpackcompose.ui.theme.HelloWordJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWordJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val userName  = User(name = "\"Hola Jetpack\")")
                    Greeting(userName)
                }
            }
        }
    }
}

/*
Modifiers
position = width, height
apearence = background, padding, border
listener, onKeyevent
 */

data class  User(val name: String)

class SampleUserProvider: PreviewParameterProvider<User>{
    override val values = sequenceOf(User("Hello Jetpack"))
}

val itemusu = listOf(Color.Red, Color.Blue, Color.Black, Color.Green, Color.Yellow,
    Color.Cyan, Color.Magenta, Color.DarkGray, Color.Transparent)

val buttonName = "Likes"
@Preview(showBackground = true)
@Composable
fun Greeting(@PreviewParameter(SampleUserProvider::class) user: User) {
    val name = user.name
    var total by remember {
        mutableStateOf(0)
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .wrapContentSize()
        .padding(horizontal = 20.dp)) {
        Texto(txt = name)
        Space()
        Texto(txt = "texto 1")
        Space()
        Texto(txt = "texto 2")
        Row(modifier = Modifier.fillMaxWidth()
            , horizontalArrangement = Arrangement.SpaceEvenly) {
            Circule(color = Color.Red)
            Circule(color = Color.Blue)
            Circule(color = Color.Green)
            Circule(color = Color.Yellow)
        }
        LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
            items(itemusu){
                item -> Circule(color = item)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Space ()
        Row ( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){
            Button(onClick = {total ++}) {
                Text(text = buttonName)
            }
            Spacer(modifier = Modifier.width(10.dp))
            results(likes = total)
        }
    }
}

@Composable
fun Texto (txt: String){
    Text(text = "Hello ${txt}!", color = Color.Red,
        fontWeight = FontWeight.Bold ,
        fontStyle = FontStyle.Italic, fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .background(Color.Black)
            .clickable {
                println("Hola jeckpackt")
            }
    )
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun Circule(color: Color){
    Box(modifier = Modifier
        .size(40.dp)
        .background(color, CircleShape))
}

@Composable
fun results(likes : Int){
    Text(text = likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWordJetpackComposeTheme {
        Greeting("Android")
    }
}*/