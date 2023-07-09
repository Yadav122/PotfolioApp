package com.company.bizapp
import android.content.ClipData
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.bizapp.ui.theme.BizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState= remember() {
        mutableStateOf(false)

    }
 Surface(
     Modifier
         .fillMaxWidth()
         .fillMaxHeight()
 ) {
  Card(modifier = Modifier
      .width(200.dp)
      .height(390.dp)
      .padding(12.dp),
      shape = RoundedCornerShape(corner = CornerSize(15.dp)),
      backgroundColor = Color.White,
      elevation = 4.dp) {


   Column(modifier = Modifier.height(300.dp),
   verticalArrangement = Arrangement.Top
   , horizontalAlignment = Alignment.CenterHorizontally)
   {


       CreateImageProfile()
       Divider()
       CreateInfo()



       Button(onClick = {
           buttonClickedState.value=!buttonClickedState.value
       }, shape = RoundedCornerShape(corner = CornerSize(8.dp)))


       {
           Text(text = "Portfolio", style = MaterialTheme.typography.button)

       }
       if (buttonClickedState.value){
           Content()

       }else{
           Box{}
       }
       
   }

  }
  }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Harsh Kumar",
            style = MaterialTheme.typography.h4, color = MaterialTheme.colors.primaryVariant
        )
        Text(text = "Android Compose Programmer ", modifier = Modifier.padding(3.dp))
        Text(text = "kumarharsh74799@gmail.com ", modifier = Modifier.padding(3.dp)
        , style = MaterialTheme.typography.subtitle1)


    }


}



@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp), shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {


        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizAppTheme {
        CreateBizCard()
    }
}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxHeight()
        .fillMaxWidth()){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(3.dp)
        , shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(2.dp, color = Color.LightGray)
        ) {

            Portfolio(data= listOf("Project1", "Project2","Project3","Project4","Project5","Project6","Project7"))

        }

    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
       items(data){item ->
          Card(modifier = Modifier
              .padding(8.dp)
              .fillMaxWidth(),
          shape = RectangleShape, elevation = 4.dp) {
              
              Row(modifier = Modifier
                  .padding(8.dp)
                  .background(MaterialTheme.colors.surface)
                  .padding(7.dp)) {
                   CreateImageProfile(modifier = Modifier.size(100.dp))
                  Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                      Text(text = item, fontWeight = FontWeight.Bold)
                      Text(text = "A Great Project", style = MaterialTheme.typography.body2)
                  }
              }

          }

           
       }
    }
}

