package com.zzzyyymmm.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.zzzyyymmm.custom.RightAnotherFragment
import com.zzzyyymmm.custom.RightFragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val leftFBtn = findViewById<Button>(R.id.leftFBtn)
        leftFBtn.setOnClickListener {
            replaceFragment(RightAnotherFragment())
        }
        replaceFragment(RightFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.replace(R.id.rightFrameLayout, fragment)
        beginTransaction.addToBackStack(null)
        beginTransaction.commit()

    }
}