package com.feint


fun jsonObj(init:JsonObject.()->Unit):JsonObject{
    val jsonObj=JsonObject()
    jsonObj.init()
    return jsonObj
}

class JsonObject(){

}