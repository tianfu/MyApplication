package com.charles.common.factory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;

/**
 * com.charles.common.factory.DialogFactory
 * 创建Dialog实例
 *
 * @author Just.T
 * @since 16/12/27
 */
public class DialogFactory {

    private DialogFactory() {
    }

    private static class Holder {
        private static final DialogFactory factory = new DialogFactory();
    }

    public static DialogFactory getInstance() {
        return Holder.factory;
    }


    public Dialog createNotifacationDialog(Activity activity, String title, int icon, String notifacation, String btn, onClickListener onClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setIcon(icon)
                .setMessage(notifacation)
                .setPositiveButton(btn, (dialog, which) -> {
                    onClickListener.onClick(dialog);
                    dialog.dismiss();
                }).create();
        return alertDialog;
    }

    public interface onClickListener {
        void onClick(DialogInterface dialog);
    }
}
