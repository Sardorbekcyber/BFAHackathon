package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "orders",
    foreignKeys = [ForeignKey(
        entity = Account::class,
        parentColumns = ["uuid"],
        childColumns = ["clientId"]
    )]
)
data class Order(
    @PrimaryKey
    val orderId: UUID = UUID.randomUUID(),
    val clientId: UUID

)
