package presentation

import domain.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.Expense
import model.ExpenseCategory
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope


data class ExpenseUiState(
    val expensesList: List<Expense> = emptyList(),
    val total: Double = 0.0
)

class ExpensesViewModel(private val expenseRepository: ExpenseRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState = _uiState.asStateFlow()
    private val allExpense = expenseRepository.getAllExpense()

    init {
        getAllExpense()
    }

    private fun getAllExpense() {
        viewModelScope.launch {
            updateState()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.addNewExpense(expense)
            updateState()
        }
    }

    fun editExpenses(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.editExpense(expense)
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(expensesList = allExpense, total = allExpense.sumOf { it.amount })
        }
    }

    fun getExpenseWithId(id: Long): Expense {
        return allExpense.first() { it.id == id }
    }

    fun getCategories(): List<ExpenseCategory> = expenseRepository.getCategories()

}