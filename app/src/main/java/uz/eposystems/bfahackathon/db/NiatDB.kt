package uz.eposystems.bfahackathon.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.eposystems.bfahackathon.data.*

@Database(
    entities = [
        Account::class,
        Category::class,
        Order::class,
        Product::class,
        SoldItem::class,
        SubscribeItem::class,
        SubscriptionOrder::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NiatDB : RoomDatabase() {



}