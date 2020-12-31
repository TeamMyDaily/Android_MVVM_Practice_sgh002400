package org.techtown.mvvm_practice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
//version이란 Database 형태가 바뀌었을 때 기존의 Database를
//새로운 Database로 migration 시켜야 될 때가 있는데 그 때 필요한지 여부를 전달
abstract class TodoDB : RoomDatabase() {
    abstract fun todoDao() : TodoDao

    companion object{
        private var INSTANCE: TodoDB? = null

        fun getInstance(context: Context): TodoDB? {
            if(INSTANCE == null) {
                synchronized(TodoDB::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        TodoDB::class.java, "Todo")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}