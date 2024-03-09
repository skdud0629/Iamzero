package com.example.iamzero.data.diary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.iamzero.Converters

@Database(
    entities = [Post::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DiaryDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        @Volatile
        private var instance: DiaryDatabase? = null

        @Synchronized
        fun getInstance(context: Context): DiaryDatabase? {
            if (instance == null) {
                synchronized(DiaryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDatabase::class.java,
                        "post-database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}

