package model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRental
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PartyMode
import androidx.compose.material.icons.filled.ViewCozy
import androidx.compose.ui.graphics.vector.ImageVector

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String,
){
    val icon = category.icon
}


enum class ExpenseCategory(val icon: ImageVector) {
    GROCERIES(icon = Icons.Default.FoodBank),
    PARTY(icon = Icons.Default.PartyMode),
    SNACKS(icon = Icons.Default.Fastfood),
    COFFEE(icon = Icons.Default.Coffee),
    CAR(icon = Icons.Default.CarRental),
    HOUSEHOLD(icon = Icons.Default.House),
    OTHER(icon = Icons.Default.ViewCozy)

}
