package com.zzzyyymmm.study

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.zzzyyymmm.ToastUtil

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //查询选择框状态,并进行回显

        this.getSharedPreferences("login", Context.MODE_PRIVATE).apply {
            val checkPwd = findViewById<CheckBox>(R.id.checkPwd)
            checkPwd.isChecked = getBoolean("rememberMe", false)
            if (checkPwd.isChecked) {
                val accountEdit = findViewById<EditText>(R.id.accountEdit)
                val passwordEdit = findViewById<EditText>(R.id.passwordEdit)
                accountEdit.setText(getString("username", ""))
                passwordEdit.setText(getString("password", ""))
            }
        }


        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val accountEdit = findViewById<EditText>(R.id.accountEdit)
            val passwordEdit = findViewById<EditText>(R.id.passwordEdit)
            if (accountEdit.text.toString() == "admin" && passwordEdit.text.toString() == "123") {
                val checkPwd = findViewById<CheckBox>(R.id.checkPwd)
                if (checkPwd.isChecked) {
                    this.getSharedPreferences("login", Context.MODE_PRIVATE).edit().apply {
                        putString("username", accountEdit.text.toString())
                        putString("password", passwordEdit.text.toString())
                        putBoolean("rememberMe", true)
                        apply()
                    }
                }
                ToastUtil.shortToast(this, "登录成功,进行跳转")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                ToastUtil.shortToast(this, "账号密码错误")
            }
        }
    }
}