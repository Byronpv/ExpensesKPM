package data

import model.Expense
import model.ExpenseCategory

object ExpensesManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(currentId++, 100.0, ExpenseCategory.GROCERIES, "Groceries"),
        Expense(currentId++, 50.0, ExpenseCategory.PARTY, "Party"),
        Expense(currentId++, 10.0, ExpenseCategory.SNACKS, "Snacks"),
        Expense(currentId++, 5.0, ExpenseCategory.COFFEE, "Coffee"),
        Expense(currentId++, 20.0, ExpenseCategory.CAR, "Car"),
        Expense(currentId++, 30.0, ExpenseCategory.HOUSEHOLD, "Household"),
        Expense(currentId++, 15.0, ExpenseCategory.OTHER, "Other"),
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }

        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory>{
        return listOf(
            ExpenseCategory.GROCERIES,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.COFFEE,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSEHOLD,
            ExpenseCategory.OTHER)
    }
}