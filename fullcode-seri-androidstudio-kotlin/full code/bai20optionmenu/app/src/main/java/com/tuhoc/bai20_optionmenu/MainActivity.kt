package com.tuhoc.bai20_optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //khởi tạo menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2,menu)
        return true
    }

    //xử lý sự kiện với item được chọn
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuExit -> finish()
            R.id.mnuHome -> Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
            R.id.mnuSearch -> Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}