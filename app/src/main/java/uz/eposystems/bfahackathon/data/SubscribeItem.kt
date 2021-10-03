package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
     tableName = "subscribe_item",
     foreignKeys = [
          ForeignKey(
               entity = Product::class,
               parentColumns = ["uuid"],
               childColumns = ["productId"]
          )
     ]
)
data class SubscribeItem(
     @PrimaryKey
     val uuid: UUID = UUID.randomUUID(),
     val productId: Long,
     val amount: Int
)
