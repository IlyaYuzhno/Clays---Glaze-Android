package com.ilyad.claysglaze

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class BasicList(val title: String) {

    companion object {

        // Get clays list by manufacturer
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

        // Get temperatures list for specific clay
        fun getTemperature(clay: String, context: Context): ArrayList<String> {
            val temperatureList = ArrayList<String>()
            try {

                // Load data
                val jsonString = loadJsonFromAsset("clays_info.json", context)
                val json = JSONObject(jsonString)
                val clays = json.getJSONArray("clays")

                // Get temperatures for specific clay from json
                for (i in 0 until clays.length()) {
                    val item = clays.getJSONObject(i)
                    val itemClay = item.getString("clay")
                    if (itemClay.equals(clay)){
                        val temp = item.getJSONObject("temperature").names()
                        if (temp != null) {
                        for (i in 0 until temp.length()) {
                            val degrees = temp.getString(i)
                            temperatureList.add(degrees)
                        }
                            } else {
                            temperatureList.add("No info found")
                            }
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return temperatureList
        }

        // Get glazes list for specific clay, temperature and crackle
        fun getGlazesForClay(clay: String,
                             temperature: String,
                             crackle: String,
                             context: Context): ArrayList<String>  {
            val glazesList = ArrayList<String>()
            try {
                // Load data
                val jsonString = loadJsonFromAsset("clays_info.json", context)
                val json = JSONObject(jsonString)
                val clays = json.getJSONArray("clays")

                // Get clays objects from data
                for (i in 0 until clays.length()) {
                    val item = clays.getJSONObject(i)
                    val itemClay = item.getString("clay")
                    if (itemClay.equals(clay)){
                        val temperatureList = item.getJSONObject("temperature")
                        val temperatureItem = temperatureList.getJSONObject(temperature)
                        val crackleItem = temperatureItem.getJSONArray(crackle)
                        for (i in 0 until crackleItem.length()) {
                            glazesList.add(crackleItem.getString(i))
                        }
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return glazesList
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