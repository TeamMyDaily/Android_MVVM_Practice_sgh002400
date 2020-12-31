package org.techtown.mvvm_practice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todo")
data class Todo(

    @PrimaryKey(autoGenerate = true) //id 자동생성 되도록 해줌
    var id : Int?,

    @ColumnInfo(name = "title")
    var title : String,

    @ColumnInfo(name = "content")
    var content : String
){
    constructor() : this(null, "", "")
}
