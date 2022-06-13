package com.zzzyyymmm.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zzzyyymmm.custom.MsgAdapter
import com.zzzyyymmm.entity.Msg

class UIDemoActivity : AppCompatActivity() {

    private val msgList = ArrayList<Msg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uidemo)
        initMsg()
        val uiRecycleView = findViewById<RecyclerView>(R.id.uiRecycleView)
        val adapter = MsgAdapter(msgList)
        val linearLayoutManager = LinearLayoutManager(this)
        uiRecycleView.layoutManager = linearLayoutManager
        uiRecycleView.adapter = adapter

        val uiSendBtn = findViewById<Button>(R.id.uiSendBtn)

        uiSendBtn.setOnClickListener {
            val uiEditText = findViewById<EditText>(R.id.uiEditText)
            val uiEditTextStr = uiEditText.text.toString()
            if (uiEditTextStr.isNotBlank()) {
                val msg = Msg(uiEditTextStr, Msg.TYPE_SENT)
                msgList.add(msg)
                // 当有新消息时，刷新RecyclerView中的显示
                adapter.notifyItemInserted(msgList.size - 1)
                // 将RecyclerView 定位到最后一行
                uiRecycleView.scrollToPosition(msgList.size - 1)
                uiEditText.setText("") // 清空输入框中的内容
            }

        }

    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

}