package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import model.Expense
import model.ExpenseCategory
import utils.getColorsTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpensesDetailScreen(
    expense: Expense? = null,
    categories: List<ExpenseCategory> = emptyList(),
    onBack: (Expense) -> Unit
) {

    val colors = getColorsTheme()
    var price by remember { mutableStateOf(expense?.amount ?: 0.0) }
    var description by remember { mutableStateOf(expense?.description ?: "") }
    var expenseCategory by remember { mutableStateOf(expense?.category?.name ?: "") }
    var categorySelected by remember {
        mutableStateOf(
            expense?.category?.name ?: "Select a category"
        )
    }
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(sheetState.targetValue) {
        if (sheetState.targetValue == ModalBottomSheetValue.Expanded) {
            keyboardController?.hide()
        }
    }

    ModalBottomSheetLayout(sheetState = sheetState, sheetContent = {
        CategoryBottomSheetContent(categories = categories) { category ->
            expenseCategory = category.name
            categorySelected = category.name
            scope.launch {
                sheetState.hide()
            }
        }

    }) {

    }
}

@Composable
private fun CategoryBottomSheetContent(
    categories: List<ExpenseCategory>,
    onClick: (ExpenseCategory) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(
            16.dp
        ), columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ) {
        items(categories) { category ->
            CategoryItem(category = category, onCategorySelected = onClick)
        }
    }
}

@Composable
private fun CategoryItem(
    category: ExpenseCategory,
    onCategorySelected: (ExpenseCategory) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable {
            onCategorySelected(category)
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = category.icon, contentDescription = "category icon",
            modifier = Modifier.size(40.dp).clip(CircleShape), contentScale = ContentScale.Crop
        )
        Text(text = category.name)
    }
}