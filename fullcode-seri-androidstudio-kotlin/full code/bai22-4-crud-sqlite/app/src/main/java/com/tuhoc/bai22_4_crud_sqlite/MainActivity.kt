package com.tuhoc.bai22_4_crud_sqlite

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteDatabase
    lateinit var rs : Cursor
    lateinit var adapter: SimpleCursorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyHelper(applicationContext)
        db = helper.readableDatabase
        rs = db.rawQuery("SELECT * FROM TUHOC LIMIT 20",null)
        //sql : String chuỗi câu lệnh SQL
        //String[] selectionArgs: Chọn lọc dữ liệu với điều kiện mảng

        //1. đưa thử dữ liệu của dòng đầu tiên trong db lên edtuser và edtEmail
        /*if (rs.moveToLast()){
            edtUser.setText(rs.getString(1))
            edtEmail.setText(rs.getString(2))
        }*/

        //2.code cho button first
        btnFirst.setOnClickListener {
            if (rs.moveToFirst()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
        }

        //3.code cho button next
        btnNext.setOnClickListener {
            if (rs.moveToNext()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else if (rs.moveToFirst()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
        }

        //4.code cho prev
        btnPrev.setOnClickListener {
            if (rs.moveToPrevious()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else if (rs.moveToLast()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
        }

        //5.code cho button last
        btnLast.setOnClickListener {
            if (rs.moveToLast()){
                edtUser.setText(rs.getString(1))
                edtEmail.setText(rs.getString(2))
            }
            else
                Toast.makeText(applicationContext,"No data found",Toast.LENGTH_SHORT).show()
        }

        //6. code phần lvFull
        adapter = SimpleCursorAdapter(
            applicationContext,android.R.layout.simple_expandable_list_item_2,rs,
            arrayOf("user","email"), intArrayOf(android.R.id.text1,android.R.id.text2),0
        )
        lvFull.adapter = adapter
        //7. code cho nút viewall
        btnViewAll.setOnClickListener {
            searchView.visibility = View.VISIBLE
            lvFull.visibility = View.VISIBLE
            adapter.notifyDataSetChanged()
            searchView.queryHint ="Tìm kiếm trong ${rs.count} bản ghi"
        }

        //code cho phần tìm kiếm nội dung
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //ctrl + i
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                rs = db.rawQuery("SELECT * FROM TUHOC WHERE user LIKE '%${newText}' or email LIKE '%${newText}'",
                    null)
                adapter.changeCursor(rs)
                return true
            }
        })

        //8. code cho nút insert
        btnInsert.setOnClickListener {
            var cv = ContentValues()
            cv.put("user", edtUser.text.toString())
            cv.put("email", edtEmail.text.toString())
            db.insert("TUHOC", null, cv)
            rs.requery()
            adapter.notifyDataSetChanged()

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Add record")
            ad.setMessage("Add thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                edtUser.setText("")
                edtEmail.setText("")
                edtUser.requestFocus()
            })
            ad.show()

        }

        //9. code cho nút update
        btnUpdate.setOnClickListener {
            var cv = ContentValues()
            cv.put("user", edtUser.text.toString())
            cv.put("email", edtEmail.text.toString())
            db.update("TUHOC",cv,"_id=?", arrayOf(rs.getString(0)))
            rs.requery()
            adapter.notifyDataSetChanged()

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Update record")
            ad.setMessage("Update thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                edtUser.setText("")
                edtEmail.setText("")
                edtUser.requestFocus()
            })
            ad.show()

        }

        //10. code nút clear
        btnClear.setOnClickListener {
            edtUser.setText("")
            edtEmail.setText("")
            edtUser.requestFocus()
        }

        //11.code delete
        btnDelete.setOnClickListener {
            db.delete("TUHOC","_id=?", arrayOf(rs.getString(0)))
            rs.requery()
            adapter.notifyDataSetChanged()
            //thông báo
            var ad = AlertDialog.Builder(this)
            ad.setTitle("Update record")
            ad.setMessage("Update thành công")
            ad.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                if (rs.moveToFirst()){
                    edtUser.setText("")
                    edtEmail.setText("")
                    edtUser.requestFocus()
                }
                else
                {
                    edtUser.setText("No data found")
                    edtEmail.setText("No data found")
                }

            })
            ad.show()
        }

        //đăng ký sử dụng context menu cho listview lvFull
        registerForContextMenu(lvFull)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(100,11,1,"DELETE")
        menu?.setHeaderTitle("Removing data")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId==11)
        {
            //Toast.makeText(applicationContext,"Cick lên item trên menu",Toast.LENGTH_SHORT).show()
            db.delete("TUHOC","_id=?", arrayOf(rs.getString(0)))
            rs.requery()
            adapter.notifyDataSetChanged()
            searchView.queryHint ="Tìm kiếm trong ${rs.count} bản ghi"
        }

        return super.onContextItemSelected(item)
    }


}