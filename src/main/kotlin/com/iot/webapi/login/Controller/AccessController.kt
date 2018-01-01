package com.iot.webapi.login.Controller

import com.iot.webapi.login.model.DataAccess
import com.iot.webapi.login.service.DataAccessService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class AccessController @Autowired constructor(private val dataAccessService: DataAccessService){
    @RequestMapping("/")
    fun root(): ModelAndView{
        return users()
    }

    @RequestMapping("/access")
    fun users(): ModelAndView = ModelAndView("/index").apply { addObject("access", dataAccessService.findAllUser()) }

    @RequestMapping("/access/json")
    fun api_index(): ResponseEntity<MutableList<DataAccess>>{
        return ResponseEntity.ok(dataAccessService.findAllUser())
    }

    @RequestMapping("access/json/{user_seq}")
    fun api_show(@PathVariable("user_seq") user_seq: Int): ResponseEntity<MutableList<DataAccess>{
        return ResponseEntity.ok(dataAccessService.findAllUser())
    }
}


