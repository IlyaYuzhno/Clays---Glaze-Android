package com.ilyad.claysglaze

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Interactor(val title: String) {

    companion object {

        // CLAYS PART

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
                        claysList.add(Interactor(item.getString("clay")).title)
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return claysList
        }

        // Get temperatures list for specific clay
        fun getClayTemperature(item: String, context: Context): ArrayList<String> {
            val temperatureList = ArrayList<String>()
            try {

                // Load data
                val jsonString = loadJsonFromAsset("clays_info.json", context)
                val json = JSONObject(jsonString)
                val listOfObjects = json.getJSONArray("clays")

                // Get temperatures for specific item from json
                for (i in 0 until listOfObjects.length()) {
                    val jsonItem = listOfObjects.getJSONObject(i)
                    val itemTitle = jsonItem.getString("clay")
                    if (itemTitle.equals(item)){
                        val temp = jsonItem.getJSONObject("temperature").names()
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

        // Get information for specific item (clay or glaze)
        fun getInformation(mode: String, item: String,
                           context: Context): String  {
            var info = ""
            var filename = ""
            var objects = ""
             when (mode) {
                 "clay" -> {
                     filename = "clays_info.json"
                     objects = "clays"
                 }
                 "glaze" -> {
                     filename = "glazes_info.json"
                     objects = "glazes"
                 }
             }
            try {
                // Load data
                val jsonString = loadJsonFromAsset(filename, context)
                val json = JSONObject(jsonString)
                val itemsList = json.getJSONArray(objects)

                // Get clays objects from data
                for (i in 0 until itemsList.length()) {
                    val itemObject = itemsList.getJSONObject(i)
                    val itemObjectTitle = itemObject.getString(mode)
                    if (itemObjectTitle.equals(item)){
                        info = itemObject.getString("info")
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return info
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

        // GLAZES PART

        // Get glazes list by manufacturer
        fun getGlazesFromFile(brand: String, context: Context): ArrayList<String> {
            val glazesList = ArrayList<String>()
            try {
                // Load data
                    val filename = "glazes_info.json"
                val jsonString = loadJsonFromAsset(filename, context)
                val json = JSONObject(jsonString)
                val glazes = json.getJSONArray("glazes")

                // Get clays objects from data
                for (i in 0 until glazes.length()) {
                    val item = glazes.getJSONObject(i)
                    val itemBrand = item.getString("brand")
                    if (itemBrand.equals(brand)){
                        glazesList.add(Interactor(item.getString("glaze")).title)
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return glazesList
        }

        // Get temperatures list for specific glaze
        fun getGlazeTemperature(item: String, context: Context): ArrayList<String> {
            val temperatureList = ArrayList<String>()
            try {

                // Load data
                val jsonString = loadJsonFromAsset("glazes_info.json", context)
                val json = JSONObject(jsonString)
                val listOfObjects = json.getJSONArray("glazes")

                // Get temperatures for specific item from json
                for (i in 0 until listOfObjects.length()) {
                    val jsonItem = listOfObjects.getJSONObject(i)
                    val itemTitle = jsonItem.getString("glaze")
                    if (itemTitle.equals(item)){
                        val temp = jsonItem.getJSONObject("temperature").names()
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

        // Get clays list for specific glaze, temperature and crackle
        fun getClaysForGlaze(glaze: String,
                             temperature: String,
                             crackle: String,
                             context: Context): ArrayList<String>  {
            val claysList = ArrayList<String>()
            try {
                // Load data
                val jsonString = loadJsonFromAsset("glazes_info.json", context)
                val json = JSONObject(jsonString)
                val glazes = json.getJSONArray("glazes")

                // Get clays objects from data
                for (i in 0 until glazes.length()) {
                    val item = glazes.getJSONObject(i)
                    val itemGlaze = item.getString("glaze")
                    if (itemGlaze.equals(glaze)){
                        val temperatureList = item.getJSONObject("temperature")
                        val temperatureItem = temperatureList.getJSONObject(temperature)
                        val crackleItem = temperatureItem.getJSONArray(crackle)
                        for (i in 0 until crackleItem.length()) {
                            claysList.add(crackleItem.getString(i))
                        }
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return claysList
        }

        // Load JSON from assets folder
        private fun loadJsonFromAsset(filename: String, context: Context): String {
            val json: String
            try {
                val inputStream = context.assets.open(filename)
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