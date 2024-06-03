import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        AppTheme {
            Scaffold(modifier = Modifier.fillMaxWidth(),
                topBar = {
                    TopAppBar(
                        elevation = 0.dp,
                        title = {
                            Text(
                                text = "Compose App",
                                fontSize = 25.sp,
                                color = colors.textColor
                            )
                        }
                    )
                }) { }


        }
    }
}