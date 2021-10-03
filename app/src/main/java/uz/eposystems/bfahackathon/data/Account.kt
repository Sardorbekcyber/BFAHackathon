package uz.eposystems.bfahackathon.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "account")
data class Account(
    @PrimaryKey
    val uuid: UUID = UUID.randomUUID(),
    val name: String,
    val phoneNumber: String,
    val point: Long,
    val email: String,
)
