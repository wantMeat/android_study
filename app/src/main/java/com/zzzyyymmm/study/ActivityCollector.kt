package com.zzzyyymmm.study

import android.app.Activity

/**
 * @author  zym
 * @date  2022/6/6 14:11
 */
object ActivityCollector {
    private val activityList = ArrayList<Activity>()
    fun addActivity(activity: Activity) = activityList.add(activity)

    fun removeActivity(activity: Activity) = activityList.add(activity)

    fun finishAll(){
        for (activity in activityList){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activityList.clear()
        //android.os.Process.killProcess(android.os.Process.myPid())
    }
}