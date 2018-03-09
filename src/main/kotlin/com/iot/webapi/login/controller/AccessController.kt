package com.iot.webapi.login.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.iot.webapi.login.json.LoginResultRequest
import com.iot.webapi.login.json.LoginResultResponse
import com.iot.webapi.login.logic.impl.LoginLogicImpl
import com.iot.webapi.login.model.DataAccess
import com.iot.webapi.login.service.DataAccessService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.io.BufferedReader
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class AccessController @Autowired constructor(private val dataAccessService: DataAccessService){

    /**
     * ※テスト
     * loginCheckへのリダイレクト
     */
    @RequestMapping("/")
    fun root(): ModelAndView{
        return users()
    }

    /**
     * パラメータpassをハッシュ化して正誤の比較
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/access", method = arrayOf(RequestMethod.POST))
    fun loginCheck(request: HttpServletRequest, response: HttpServletResponse): LoginResultResponse{
        val loginLogicImpl = LoginLogicImpl()
        val userList: MutableList<DataAccess> = dataAccessService.findAllUser()

        // requestのbodyからjsonを取得
        val headerFromBody = BufferedReader(request.reader)
        val requestBody: String = headerFromBody.readLine()
        val mapper = jacksonObjectMapper()
        val loginResultRequest: LoginResultRequest = mapper.readValue(requestBody)
        var authenticity: Boolean = false
        if (loginLogicImpl.login(loginResultRequest.loginId, 0, userList)) {
            val shaPass: String = loginLogicImpl.sha256(loginResultRequest.password)
            authenticity = loginLogicImpl.login(shaPass, 1,userList)

            if (authenticity) {
                return LoginResultResponse(authenticity, "成功！")

            } else {
                return LoginResultResponse(authenticity, "ぱすが間違ってる")
            }

        }else{
            return LoginResultResponse(authenticity, "IDが間違ってる")
        }
    }

    /**
     * 動画の保存処理
     * <p>ストリーム先のアドレスに対して、ハッシュ値を付加して投げる。</p>
     */

    /**
     * ※テスト
     * テーブル内容の全件取得
     */
    @RequestMapping("/entity")
    fun users(): ModelAndView = ModelAndView("/index").apply { addObject("access", dataAccessService.findAllUser()) }


    /**
     * ※テスト
     * Collectionをつかったjson返却
     * Responseに付与できます。
     * @return json形式のEntity
     */

    //CrossOriginはCORSを回避できる魔法のアノテーション
    @CrossOrigin
    @RequestMapping("/test",method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun test(response: HttpServletResponse): Map<String, String>{
//        response.setHeader("Access-Control-Allow-Origin", "*")

        val testBool: Boolean = true
        println(Collections.singletonMap("JsonMessage", testBool.toString()).toString())
        return Collections.singletonMap("JsonMessage", testBool.toString())
    }

    @CrossOrigin
    @RequestMapping("/jtest",method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun jTest(request: HttpServletRequest,response: HttpServletResponse): LoginResultResponse {
//        response.setHeader("Access-Control-Allow-Origin", "*")
//      requestのHeader部分の取得
        val head = "ACCEPT: " + request.getHeader("ACCEPT") + "\n" +
            "REFERER: " + request.getHeader("REFERER") + "\n" +
            "ACCEPT-LANGUAGE: " + request.getHeader("ACCEPT-LANGUAGE") + "\n" +
            "USER-AGENT: " + request.getHeader("USER-AGENT") + "\n" +
            "HOST: " + request.getHeader("HOST") + "\n" +
            "CONTENT-TYPE: " + request.getHeader("CONTENT-TYPE") + "\n" +
            "CONTENT-LENGTH: " + request.getHeader("CONTENT-LENGTH") + "\n" +
            "CONNECTION: " + request.getHeader("CONNECTION") + "\n" +
            "CACHE-CONTROL: " + request.getHeader("CACHE-CONTROL")

        val headerFromBody = BufferedReader(request.reader)
        val body:String = headerFromBody.readLine()

        val mapper = jacksonObjectMapper()
        val loginResultRequest:LoginResultRequest = mapper.readValue(body)

        val loginResult = LoginResultResponse(true, "TestToken")
        println(loginResultRequest.loginId)
        println(loginResultRequest.password)
        return loginResult
    }
}
