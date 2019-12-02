package jp.techacademy.kotaro.kanemochi.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


//処理の流れとして
//・ボタンにsetOnClickListenerを行う
//・ボタンクリックの処理でTimePickerDialogを表示する（使い方はテキストを参考）
//・TimePickerDialogの時刻を設定したときの処理内で、時刻に応じてTextViewのtextを変更する

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                if (2 <= hour && hour < 10) {
                    textView.text = "おはよう"
                    Log.d("AisatsuApp", "おはよう")
                } else if (10 <= hour && hour < 18) {
                    textView.text = "こんにちは"
                    Log.d("AisatsuApp", "こんにちは")
                } else {
                    textView.text = "こんばんは"
                    Log.d("AisatsuApp", "こんばんは")
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}
