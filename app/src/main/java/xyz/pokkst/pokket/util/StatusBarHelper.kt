package xyz.pokkst.pokket.util

import android.app.Activity
import android.os.Build
import android.view.WindowManager

class StatusBarHelper {
    companion object {
        fun setStatusBarColor(activity: Activity?, color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = activity?.window
                window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

                if (activity != null) {
                    window?.statusBarColor = activity.resources.getColor(color)
                }
            }
        }
    }
}