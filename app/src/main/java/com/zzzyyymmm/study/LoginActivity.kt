package com.zzzyyymmm.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zzzyyymmm.ToastUtil

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val accountEdit = findViewById<EditText>(R.id.accountEdit)
            val passwordEdit = findViewById<EditText>(R.id.passwordEdit)
            if (accountEdit.text.toString() == "admin" && passwordEdit.text.toString() == "123") {
                ToastUtil.shortToast(this, "登录成功,进行跳转")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                ToastUtil.shortToast(this, "账号密码错误")
            }
        }
    }
}