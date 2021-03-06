package org.techtown.mvvm_practice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val title : TextView = itemView.findViewById(R.id.item_title)
    private val content : TextView = itemView.findViewById(R.id.item_content)

    fun onBind(data : Todo) {
        title.text = data.title //data binding 사용시 더 간단한 코드
        content.text = data.content
    }
}