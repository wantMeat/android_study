package com.zzzyyymmm.study

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.zzzyyymmm.study.no8.FileSaveActivity

class MainActivity : BaseActivity() {

    private val tag = "MainActivity"

    private val lifecycleFlag = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (lifecycleFlag) Log.e(tag, "onCreate")
        Log.e(tag, this.toString())
        Log.e(tag, "task id is $taskId")

        setContentView(R.layout.activity_main)
        val string = savedInstanceState?.getString("tempDate")
        Log.e(tag, "tag savedMsg is $string")


        //按钮传值跳转
        val valBtn = findViewById<Button>(R.id.valBtn)
        valBtn.setOnClickListener {
            //val intent = Intent(this, SecondActivity::class.java)
            val intent = Intent("com.zzzyyymmm.study.ACTION_START")
            intent.putExtra("title", "这是界面1的传值")
            startActivityForResult(intent, 1)
        }

        val interBtn = findViewById<Button>(R.id.interBtn)
        interBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory("com.zzzyyymmm.study.MY_VIEW")
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }


        val telBtn = findViewById<Button>(R.id.telBtn)
        telBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:18268686797")
            startActivity(intent)
        }


        //生命流程
        val normalBtn = findViewById<Button>(R.id.normalBtn)
        val dialogBtn = findViewById<Button>(R.id.dialogBtn)

        normalBtn.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }

        dialogBtn.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

        //启动模式
        val standardBtn = findViewById<Button>(R.id.standardBtn)
        standardBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val jumpSecondBtn = findViewById<Button>(R.id.jumpSecondBtn)
        jumpSecondBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        //控件界面
        val viewBtn = findViewById<Button>(R.id.viewBtn)
        viewBtn.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
        //标题栏demo
        val titleBarBtn = findViewById<Button>(R.id.titleBarBtn)
        titleBarBtn.setOnClickListener {
            val intent = Intent(this, TitleBarActivity::class.java)
            startActivity(intent)
        }
        //listemo
        val jumpListBtn = findViewById<Button>(R.id.jumpListBtn)
        jumpListBtn.setOnClickListener {
            val intent = Intent(this, ListTestActivity::class.java)
            startActivity(intent)
        }
        val jumpRecycleListBtn = findViewById<Button>(R.id.jumpRecycleListBtn)
        jumpRecycleListBtn.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        val jumpGridListBtn = findViewById<Button>(R.id.jumpGridListBtn)
        jumpGridListBtn.setOnClickListener {
            val intent = Intent(this, StaggeredGridActivity::class.java)
            startActivity(intent)
        }
        //UIdemo
        val uiDemoBtn = findViewById<Button>(R.id.uiDemoBtn)
        uiDemoBtn.setOnClickListener {
            val intent = Intent(this, UIDemoActivity::class.java)
            startActivity(intent)
        }
        //fragment
        val fragmentBtn = findViewById<Button>(R.id.fragmentBtn)
        fragmentBtn.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        //新闻fragment
        val newsMainBtn = findViewById<Button>(R.id.newsMainBtn)
        newsMainBtn.setOnClickListener {
            val intent = Intent(this, NewsMainActivity::class.java)
            startActivity(intent)
        }

        //6.2 标准广播接收器
        val normalBroadcastMainBtn = findViewById<Button>(R.id.normalBroadcastMainBtn)
        normalBroadcastMainBtn.setOnClickListener {
            val intent = Intent(this, BroadcastActivity::class.java)
            startActivity(intent)
        }

        //6.4 强制下线功能
        val jumpLoginBtn = findViewById<Button>(R.id.jumpLoginBtn)
        jumpLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val offLineBtn = findViewById<Button>(R.id.offLineBtn)
        offLineBtn.setOnClickListener {
            val intent = Intent("com.zzzyyymmm.study.FORCE_OFFLINE")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

        //7.1 文件保存
        val jumpFileSaveBtn = findViewById<Button>(R.id.jumpFileSaveBtn)
        jumpFileSaveBtn.setOnClickListener {
            val intent = Intent(this, FileSaveActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempDate = "test Bundle save"
        outState.putString("tempDate", tempDate)
    }

/*    override fun onStart() {
        super.onStart()
        if (lifecycleFlag) Log.e(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        if (lifecycleFlag) Log.e(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        if (lifecycleFlag) Log.e(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        if (lifecycleFlag) Log.e(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (lifecycleFlag) Log.e(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        if (lifecycleFlag) Log.e(tag, "onRestart")
    }*/


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> Toast.makeText(this, "点击了添加", Toast.LENGTH_SHORT).show()
            R.id.menu_del -> Toast.makeText(this, "点击了删除", Toast.LENGTH_SHORT).show()
            R.id.menu_colse -> finish()
        }
        return true
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == RESULT_OK) {
                    Toast.makeText(
                        this,
                        data?.getStringExtra("secondMsg") ?: "",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}