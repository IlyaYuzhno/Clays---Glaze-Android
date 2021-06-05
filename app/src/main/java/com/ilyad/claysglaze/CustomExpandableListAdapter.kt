package com.ilyad.claysglaze

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat

class CustomExpandableListAdapter internal constructor(private val mode: String,
                                                        private val context: Context,
                                                       private val titleList: List<String>,
                                                       private val dataList: HashMap<String, List<String>>)
                                                      : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int,
                          expandedListPosition: Int): Any {
        return this.dataList[this.titleList[listPosition]]!![expandedListPosition]
    }

    override fun getChildId(listPosition: Int,
                            expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(listPosition: Int,
                              expandedListPosition: Int,
                              isLastChild: Boolean,
                              convertView: View?,
                              parent: ViewGroup): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as String

        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item, null)
        }
            val expandedListTextView = convertView!!.findViewById<TextView>(R.id.list_item_title)
            val infoButton = convertView.findViewById<ImageButton>(R.id.infoButton)
            expandedListTextView.text = expandedListText

            // Go to ClayTemperatureActivity
            expandedListTextView.setOnClickListener { _ ->
                if (mode.equals("clay")) {
                    val intent = Intent(context, ClayTemperatureActivity::class.java)
                    intent.putExtra(ClayTemperatureActivity.CLAY_NAME, expandedListTextView.text)
                    startActivity(context, intent, Bundle())
                }
                if (mode.equals("glaze")) {
                    val intent = Intent(context, GlazeTemperatureActivity::class.java)
                    intent.putExtra(GlazeTemperatureActivity.GLAZE_NAME, expandedListTextView.text)
                    startActivity(context, intent, Bundle())
                }
            }

            // Open Information Activity
            infoButton.setOnClickListener{ _ ->
                val intent = Intent(context, InformationActivity::class.java)
                intent.putExtra(InformationActivity.CLAY_NAME, expandedListTextView.text)
                startActivity(context, intent, Bundle())
            }

        return convertView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]!!.size
    }

    override fun getGroup(listPosition: Int): Any {
        return this.titleList[listPosition]
    }

    override fun getGroupCount(): Int {
        return this.titleList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(listPosition: Int,
                              isExpanded: Boolean,
                              convertView: View?,
                              parent: ViewGroup): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.group_item, null)
        }
        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.group_item_title)
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}