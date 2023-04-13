package uz.lesson.lessoncompose.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.lesson.lessoncompose.SplashViewModel
import uz.lesson.lessoncompose.ui.theme.navigator.Navigator
import javax.inject.Inject

class SplashScreen : AndroidScreen() {


    @Composable
    override fun Content() {
        val viewModel = getViewModel<SplashViewModel>()
        SplashContent()
    }


    @Preview
    @Composable
    fun SplashPreview() {
        SplashContent()
    }


    @Composable
    fun SplashContent() {

        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {  }, modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Navigate to")
            }
        }
    }
}