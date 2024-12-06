package com.tuhoc.bai20_2_contextmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //đăng ký menu ngữ cảnh
        registerForContextMenu(txtContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //add(int groupId, int itemId, int order, CharSequence title)
        menu?.add(1,1,3,"Red")
        menu?.add(1,2,2,"Green")
        menu?.add(1,3,1,"Black")

        //sub menu
        var subMenu = menu?.addSubMenu("Giới tính")
        subMenu?.add(2,21,1,"Male")?.setChecked(true)
        subMenu?.add(2,22,2,"FeMale")
        /* setGroupCheckable (int group,
        boolean checkable,
        boolean exclusive)
        1. group: id của group muốn có nút check
        2.boolean: true để cho phép dấu kiểm,
        false thành không cho phép. Mặc định sẽ là false
        3. Chọn true để chỉ được chọn 1 item trong group
           Chọn false tích chọn được nhiều lựa chọn
        */
        subMenu?.setGroupCheckable(2,true,true)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{txtOption.setTextColor(Color.RED)}
            2->{txtOption.setTextColor(Color.GREEN)}
            3->{txtOption.setTextColor(Color.BLACK)}
            //tương tác với submenu
            21->{txtOption.setText("Male")}
            22->{txtOption.setText("FeMale")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Mời cụ chọn màu")
    }

    //xử lý sự kiện context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            31->{txtContext.setTextColor(Color.RED)}
            32->{txtContext.setTextColor(Color.GREEN)}
            33->{txtContext.setTextColor(Color.BLACK)}
        }
        return super.onContextItemSelected(item)
    }

}