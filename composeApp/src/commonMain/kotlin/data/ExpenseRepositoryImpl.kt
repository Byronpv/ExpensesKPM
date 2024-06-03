package data

import domain.ExpenseRepository
import model.Expense
import model.ExpenseCategory

class ExpenseRepositoryImpl(private val expenseManager: ExpensesManager) : ExpenseRepository {

    override fun addNewExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }

    override fun getAllExpense(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override fun deleteExpense(expense: Expense) {
        expenseManager.deleteExpense(expense)
    }
}