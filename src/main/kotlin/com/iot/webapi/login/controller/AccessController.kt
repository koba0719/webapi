package com.iot.webapi.login.controller

import com.iot.webapi.login.logic.impl.LoginLogicImpl
import com.iot.webapi.login.model.DataAccess
import com.iot.webapi.login.service.DataAccessService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
class AccessController @Autowired constructor(private val dataAccessService: DataAccessService){

    /**
     * loginCheckへのリダイレクト
     */
    @RequestMapping("/")
    fun root(): ModelAndView{
        return users()
    }

    /**
     * パラメータpassをハッシュ化して正誤の比較
     */
    @RequestMapping("/access", method = RequestMethod.GET)
    fun loginCheck(@RequestParam pass: String){
        val loginLogicImpl = LoginLogicImpl()
        loginLogicImpl.sha256(pass)
        println(pass)
    }

    /**
     * テーブル内容の全件取得
     */
    @RequestMapping("/entity")
    fun users(): ModelAndView = ModelAndView("/index").apply { addObject("access", dataAccessService.findAllUser()) }


    /**
     * ResponseEntityの動作確認
     * @return json形式のEntity
     */
    @RequestMapping("/test")
    fun test(): ResponseEntity<MutableList<DataAccess>>{
        return ResponseEntity.ok(dataAccessService.findAllUser())
    }
}


