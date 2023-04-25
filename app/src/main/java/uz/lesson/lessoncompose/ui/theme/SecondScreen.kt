package uz.lesson.lessoncompose.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import uz.lesson.lessoncompose.SecondViewModel
import uz.lesson.lessoncompose.model.SecondIntent
import uz.lesson.lessoncompose.model.SecondUiState

class SecondScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<SecondViewModel>()
        val uiState = viewModel.uiStateFlow.collectAsState()
        SecondScreenContent(state = uiState, block = viewModel::onEventDispatch)
    }


    @Preview
    @Composable
    fun SecondScreenPreview() {
        LessonComposeTheme {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
//                SecondScreenContent(state = mutableStateOf(SecondUiState()), block = {})
            }
        }
    }

    @Composable
    fun SecondScreenContent(state: State<SecondUiState>, block: (SecondIntent) -> Unit) = Box {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = state.value.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )

            Button(
                onClick = { block.invoke(SecondIntent.Random) },
                modifier = Modifier.padding(20.dp)
            ) {
                Text(text = "Change")
            }
        }

    }
}
