package com.example.whereis.extension

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bind_level")
    fun bindLevel(textView: TextView, level: String?){
        when (level) {
            "1" -> textView.text = "배송준비중"
            "2" -> textView.text = "집화완료"
            "3" -> textView.text = "배송중"
            "4" -> textView.text = "지점 도착"
            "5" -> textView.text = "배송출발"
            "6" -> textView.text = "배송완료"
        }
    }

}