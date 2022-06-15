package com.zzzyyymmm.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zzzyyymmm.study.R

/**
 * @author  zym
 * @date  2022/6/15 10:14
 */
class RightAnotherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_another_right, container, false)
    }
}