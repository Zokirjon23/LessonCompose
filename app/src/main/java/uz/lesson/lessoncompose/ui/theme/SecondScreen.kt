package uz.lesson.lessoncompose.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen

class SecondScreen : AndroidScreen(){

    @Composable
    override fun Content() {

        Box(modifier = Modifier.fillMaxSize()){

            Text(text = "Hello compose", fontSize = 32.sp, modifier = Modifier.align(Alignment.Center))
        }
    }


    @Preview
    @Composable
    fun SecondScreenPreview() {
        LessonComposeTheme {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Hello compose", fontSize = 32.sp, modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}
