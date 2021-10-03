package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "subscription_order",
    foreignKeys = [
        ForeignKey(
            entity = SubscribeItem::class,
            parentColumns = ["uuid"],
            childColumns = ["packId"]
        )
    ]
)
data class SubscriptionOrder(
    @PrimaryKey
    val orderId: UUID = UUID.randomUUID(),
    val packId: UUID,
    val cycleTime: Int,
    val onSale: Double = 0.0
)
