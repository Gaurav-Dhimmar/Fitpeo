package com.myapplication.app.main.dialogs

import android.app.Dialog
import android.content.Context
import com.myapplication.app.R
import com.myapplication.app.main.dialogs.base.BaseDialog

class ProgressDialog : BaseDialog() {
    fun build(activity: Context): Dialog {
        val dialog = getDialog(
            activity,
            R.layout.dialog_progress_infinity,
            false
        )
        val decorView = dialog.window?.decorView

        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        return dialog
    }
}