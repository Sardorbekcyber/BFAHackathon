package uz.eposystems.bfahackathon.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "products",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["uuid"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Product(
    val name: String,
    val price: Long,
    @DrawableRes val pictureUri: Int,
    val installmentPrice: Long,
    val categoryId: UUID,
    val isAfterPayAvailable: Boolean = true,
    @PrimaryKey
    val uuid: UUID = UUID.randomUUID()
)
