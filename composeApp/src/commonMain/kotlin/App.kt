import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.ExpensesScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    PreComposeApp {
        ExpensesScreen(){}
    }
}