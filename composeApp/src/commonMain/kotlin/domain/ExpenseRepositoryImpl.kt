package domain

import data.ExpensesManager
import model.Expense
import model.ExpenseCategory

class ExpenseRepositoryImpl : ExpenseRepository {

    override fun addNewExpense(expense: Expense) {
        ExpensesManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        ExpensesManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return ExpensesManager.getCategories()
    }

    override fun getAllExpense(): List<Expense> {
        return ExpensesManager.fakeExpenseList
    }
}