package com.ilyad.claysglaze

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class BasicList(val title: String) {

    companion object {

        fun getClaysFromFile(filename: String, brand: String, context: Context): ArrayList<String> {
            val claysList = ArrayList<String>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset(filename, context)
                val json = JSONObject(jsonString)
                val clays = json.getJSONArray("clays")

                // Get clays objects from data
                for (i in 0 until clays.length()) {
                    val item = clays.getJSONObject(i)
                    val itemBrand = item.getString("brand")
                    if (itemBrand.equals(brand)){
                        claysList.add(BasicList(item.getString("clay")).title)
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return claysList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String {
            val json: String

            try {
                val inputStream = context.assets.open("clays_info.json")
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return ""
            }
            return json
        }

    }

}