package edu.njnu.friendinfo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.njnu.friendinfo.InfoOfPassport;
import edu.njnu.friendinfo.R;

/**
 * Created by Sawatari on 2017/1/26.
 */

public class PassDialog extends Dialog {
    public interface OnLatlngSetListener{
        public void posButtonClick(double pointLat, double pointLng);
    }

    public PassDialog(Context context) {
        super(context);
    }

    public PassDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private static OnLatlngSetListener listener;
        private Context context;

        public Builder (Context context){
            this.context = context;
        }

        public PassDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final PassDialog dialog = new PassDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.pass_dialog_layout, null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Button posButton = (Button)layout.findViewById(R.id.positiveButton);
            Button negButton = (Button)layout.findViewById(R.id.negativeButton);
            final EditText idEdit = (EditText)layout.findViewById(R.id.idEdit);
            final EditText passEdit = (EditText)layout.findViewById(R.id.passEdit);
            posButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(idEdit.getText().toString().length() > 0 && passEdit.getText().toString().length() > 0) {
                        Intent intent = new Intent(context, InfoOfPassport.class);
                        context.startActivity(intent);
                        dialog.dismiss();
                    }else{
                        Toast.makeText(context.getApplicationContext(), "输入有误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            negButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            return dialog;
        }

        public void setOnButtonClickListener(OnLatlngSetListener listener) {
            this.listener = listener;
        }

    }
}
