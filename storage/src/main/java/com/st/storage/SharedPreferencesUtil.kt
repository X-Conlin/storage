package com.st.storage

import android.content.Context
import android.content.SharedPreferences
import java.util.concurrent.ConcurrentHashMap

object SharedPreferencesUtil {

    private const val SPT = "config"
    private val spfMap: ConcurrentHashMap<String, SharedPreferences> = ConcurrentHashMap()

    fun getUser(userId: String): SharedPreferences {
        val userTag = "$userId$SPT"
        var sharePre = spfMap[userTag]
        if (sharePre == null) {
            sharePre = StorageApplicationHolder.context.getSharedPreferences(userTag, Context.MODE_PRIVATE)
            spfMap[userTag] = sharePre
        }
        return sharePre!!
    }

    fun get(context: Context? = StorageApplicationHolder.context): SharedPreferences {
        var sharePre = spfMap[SPT]
        if (sharePre == null) {
            sharePre = context!!.getSharedPreferences(SPT, Context.MODE_PRIVATE)
            spfMap[SPT] = sharePre
        }
        return sharePre!!
    }

    fun SharedPreferences.putLong(key: String?, value: Long): Boolean {
        //存储节点文件的名称，读写方式
        return this.edit().putLong(key, value).commit()
    }

    fun SharedPreferences.getLong(key: String?, defValue: Long): Long {
        //存储节点文件的名称，读写方式
        return this.getLong(key, defValue)
    }

    fun SharedPreferences.putBoolean(key: String, value: Boolean): Boolean {
        return this.edit().putBoolean(key, value).commit()
    }

    fun SharedPreferences.getBoolean(key: String?, value: Boolean?): Boolean {
        //(存储节点文件名称,读写方式)
        return this.getBoolean(key, value!!)
    }

    fun SharedPreferences.putString(key: String?, value: String?): Boolean {
        //存储节点文件的名称，读写方式
        return this.edit().putString(key, value).commit()
    }

    fun SharedPreferences.putSet(key: String?, value: Set<String>?): Boolean {
        //存储节点文件的名称，读写方式
        return this.edit().putStringSet(key, value).commit()
    }

    fun SharedPreferences.getString(key: String?, defValue: String?): String? {
        //存储节点文件的名称，读写方式
        return this.getString(key, defValue)
    }

    fun SharedPreferences.putInt(key: String?, value: Int): Boolean {
        //存储节点文件的名称，读写方式
        return this.edit().putInt(key, value).commit()
    }

    fun SharedPreferences.getInt(key: String?, defValue: Int): Int {
        //存储节点文件的名称，读写方式
        return this.getInt(key, defValue)
    }

    fun SharedPreferences.removeUserData(): Boolean {
        return this.edit().clear().commit()
    }

    /**
     * 从sharedPreferences中移除指定节点
     * @param context    上下文环境
     * @param key    需要移除节点的名称
     */
    fun remove(context: Context?, key: String) {
        //存储节点文件的名称，读写方式
        get(context).edit()?.remove(key)?.commit()
    }
}