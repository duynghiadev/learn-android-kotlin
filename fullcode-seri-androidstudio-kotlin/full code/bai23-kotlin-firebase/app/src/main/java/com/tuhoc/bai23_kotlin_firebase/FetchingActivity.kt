package com.tuhoc.bai23_kotlin_firebase


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.tuhoc.bai23_kotlin_firebase.adapter.EmpAdapter
import kotlinx.android.synthetic.main.activity_fetching.*

class FetchingActivity : AppCompatActivity() {

    private lateinit var ds:ArrayList<EmployeeModel>
    private lateinit var dbRef :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)

        rvEmp.layoutManager = LinearLayoutManager(this)
        rvEmp.setHasFixedSize(true)
        ds = arrayListOf<EmployeeModel>()
        GetThongTinNV() // alt + enter
    }

    private fun GetThongTinNV() {
        rvEmp.visibility = View.GONE
        txtLoadingData.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        //Để đọc dữ liệu tại một đường dẫn và lắng nghe các thay đổi,
        //hãy sử dụng addValueEventListener()
        //https://firebase.google.com/docs/database/android/read-and-write
        dbRef.addValueEventListener(object : ValueEventListener{
            //ctrl +i
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()){
                    for(empSnap in snapshot.children){
                        val empData = empSnap.getValue(EmployeeModel::class.java)
                        ds.add(empData!!)
                    }
                    val mAdapter = EmpAdapter(ds)
                    rvEmp.adapter = mAdapter
                    //code lắng nghe sự kiện click lên item rv
                    mAdapter.setOnItemClickListener(object : EmpAdapter.onItemClickListener{
                        //ctrl +i
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchingActivity,EmployeeDetailsActivity::class.java)
                            //put extras
                            intent.putExtra("empId",ds[position].empId)
                            intent.putExtra("empName",ds[position].empName)
                            intent.putExtra("empAge",ds[position].empAge)
                            intent.putExtra("empSalary",ds[position].empSalary)
                            startActivity(intent)
                        }
                    })


                    rvEmp.visibility = View.VISIBLE
                    txtLoadingData.visibility = View.GONE
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}