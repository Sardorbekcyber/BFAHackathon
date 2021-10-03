package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "category")
data class Category(
    val name: String,
    @PrimaryKey
    val uuid: UUID = UUID.randomUUID()
)
