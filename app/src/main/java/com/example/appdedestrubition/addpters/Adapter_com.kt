package com.example.appdedestrubition.addpters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.appdedestrubition.R
import java.util.ArrayList

class Adapter_com : RecyclerView.Adapter<Adapter_com.ViewHolder>() {
    private var mlists: List<String>? = null
    var selectedValues: MutableList<String>
    private var mContext1: Context? = null
    private var mRecyclerV1: RecyclerView? = null

    inner class ViewHolder(var layout: View) : RecyclerView.ViewHolder(
        layout) {
        var cbactivitieslistreg: TextView

        init {
            cbactivitieslistreg = layout.findViewById(R.id.textView)
            selectedValues = ArrayList()
        }
    }

    fun adapter(myDataset: List<String>?, context: Context?, recyclerView: RecyclerView?) {
        mlists = myDataset
        mContext1 = context
        mRecyclerV1 = recyclerView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_com.ViewHolder {
        val inflater = LayoutInflater.from(
            parent.context)
        val v: View = inflater.inflate(R.layout.row_values, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adapter_com.ViewHolder, position: Int) {
        val al = mlists!![position]
        holder.cbactivitieslistreg.setText(al)
        holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1)
        holder.cbactivitieslistreg.setOnClickListener(View.OnClickListener { v ->
            if (holder.cbactivitieslistreg.getBackground()
                    .getConstantState() !== v.resources.getDrawable(R.drawable.boxes1).constantState
            ) {
                selectedValues.remove(al)
                holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes1)
            } else {
                selectedValues.add(al)
                holder.cbactivitieslistreg.setBackgroundResource(R.drawable.boxes)
            }
        })
    }

    override fun getItemCount(): Int {
        return mlists!!.size
    }

    fun listofselectedactivites(): List<String> {
        return selectedValues
    }
}