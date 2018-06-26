package nnk.com.babyhealthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LENOVO-PC on 11/27/2017.
 */

public class DisplayAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> id;
    private ArrayList<String> firstName;
    private ArrayList<String> lastName;
    private ArrayList<String> cName;
    private ArrayList<String> dName;
    private ArrayList<String> eName;
    private ArrayList<String> spin;
    private ArrayList<String> spin1;
    private ArrayList<String> spin2;

    public DisplayAdapter(Context c, ArrayList<String> id, ArrayList<String> fname, ArrayList<String> lname, ArrayList<String> selState, ArrayList<String> selmnth, ArrayList<String> selyear, ArrayList<String> cname, ArrayList<String> dname, ArrayList<String> ename) {
        this.mContext = c;
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
        this.cName = cname;
        this.dName = dname;
        this.eName = ename;
        this.spin = selState;
        this.spin1 = selmnth;
        this.spin2 = selyear;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return id.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int pos, View child, ViewGroup parent) {
        Holder mHolder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.listcell, null);
            mHolder = new Holder();
            mHolder.txt_id = child.findViewById(R.id.txt_id);
            mHolder.txt_fName = child.findViewById(R.id.txt_fName);
            mHolder.txt_lName = child.findViewById(R.id.txt_lName);
            mHolder.txt_p = child.findViewById(R.id.txt_p);
            mHolder.txt_r = child.findViewById(R.id.txt_r);
            mHolder.txt_i = child.findViewById(R.id.txt_i);
            mHolder.txt_selState = child.findViewById(R.id.txt_selState);
            mHolder.txt_selmnth = child.findViewById(R.id.txt_selmnth);
            mHolder.txt_selyear = child.findViewById(R.id.txt_selyear);
            child.setTag(mHolder);
        } else {
            mHolder = (Holder) child.getTag();
        }
        mHolder.txt_id.setText(id.get(pos));
        mHolder.txt_fName.setText(firstName.get(pos));
        mHolder.txt_lName.setText(lastName.get(pos));
        mHolder.txt_p.setText(cName.get(pos));
        mHolder.txt_r.setText(dName.get(pos));
        mHolder.txt_i.setText(eName.get(pos));
        mHolder.txt_selState.setText(spin.get(pos));
        mHolder.txt_selmnth.setText(spin1.get(pos));
        mHolder.txt_selyear.setText(spin2.get(pos));

        return child;
    }

    public class Holder {
        TextView txt_id;
        TextView txt_fName;
        TextView txt_lName;
        TextView txt_p;
        TextView txt_r;
        TextView txt_i;
        TextView txt_selState;
        TextView txt_selmnth;
        TextView txt_selyear;
    }

}
