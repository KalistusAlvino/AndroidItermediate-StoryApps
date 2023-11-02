package com.dicoding.picodiploma.loginwithanimation.view.login

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class MyEditText : AppCompatEditText {

    constructor(context: Context): super(context){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context,attributeSet){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet, styleAttr: Int): super(context,attributeSet,styleAttr){
        init()
    }
    private fun init(){
        addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().length < 8) {
                    setError("Password tidak boleh kurang dari 8 karakter", null)
                } else {
                    error = null
                }
            }
            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        hint = "Masukan password"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

}