package domain

import model.Expense
import model.ExpenseCategory

interface ExpenseRepository {

    fun addNewExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
    fun getAllExpense(): List<Expense>
    fun deleteExpense(expense: Expense)
}