package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.ExpensesManager
import model.Expense
import presentation.ExpenseUiState
import ui.AllExpensesHeader
import ui.ExpensesItem
import ui.ExpensesScreen
import ui.ExpensesTotalHeader

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    ExpensesTotalHeader(total = 100.0)
}

@Preview(showBackground = true)
@Composable
fun AllExpensesPreview() {
    AllExpensesHeader()
}

@Preview(showBackground = true)
@Composable
fun ExpensesItemPreview() {
    ExpensesItem(
        expense = ExpensesManager.fakeExpenseList[0], onExpenseClick = {}
    )

}

@Preview(showBackground = true)
@Composable
fun ExpenseScreenPreview() {
    val fakeExpenseList = ExpensesManager.fakeExpenseList
    ExpensesScreen(
        uiState = ExpenseUiState(
            expensesList = fakeExpenseList,
            total = fakeExpenseList.sumOf { it.amount }), onExpenseClick = {})
}