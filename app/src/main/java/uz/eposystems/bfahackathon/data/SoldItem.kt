package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "sold_item",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["uuid"],
            childColumns = ["productId"]
        ),
        ForeignKey(
            entity = Order::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"]
        )
    ]
)
data class SoldItem(
    val productId: UUID,
    val amount: Int,
    val orderId: UUID,
    @PrimaryKey
    val uuid: UUID = UUID.randomUUID()
)