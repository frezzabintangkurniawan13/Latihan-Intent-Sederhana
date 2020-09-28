package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity

abstract class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    companion object {
        private const val REQUEST_CODE = 100
    }
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                val tv_result = null
                tv_result.text = "Hasil : $selectedValue"
            }
        }
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithObject:Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone:Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)


    }

fun setContentView(activity: Int) {

}

fun findViewById(btnMoveActivity: Int): Button {

}

override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)

                R.id.btn_move_for_result -> {
                    val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                    val REQUEST_CODE
                    startActivityForResult(moveForResultIntent, REQUEST_CODE)
                }

                R.id.btn_move_activity_data -> {
                    val moveWithDataIntent = Intent(this@ MainActivity, MoveWidthDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWidthDataActivity.EXTRA_NAME, "DIcodingAcademy Boy")
                    MoveWidthDataActivity.putExtra(MoveWidthDataActivity.EXTRA_AGE, 5)
                    startActivity(MoveWidthDataActivity)
                }


                R.id.btn_move_activity_object -> {
                    val person = Person(
                            "DicodingAcademy",
                            5,
                            "academy@dicoding.com"
                            "Bandung"
                    )
                    val moveWidthDataIntent = Intent(this@ MianActivity, MoveWithObjectActivity::class.java)
                    moveWidthDataIntent.putExtra(MoveWidthDataActivity.EXTRA_PERSON, person)
                    startActivity(moveWidthDataIntent)
                }
                R.id.btn_dial_number -> {
                    val phoneNumber = "081210841382"
                    val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    startActivity(dialPhoneIntent)
                }

            }

        }

    fun startActivity(moveIntent: Intent) {
    }
