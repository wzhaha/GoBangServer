package com.bjtu.gobang.gobang.Controllers;


import com.bjtu.gobang.gobang.Enities.Player;
import com.bjtu.gobang.gobang.ServiceImp.PlayerServiceImp;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerServiceImp ser;


    @PostMapping("/player/addPlayer")
    public ResponseEntity<Void> addUser(@RequestBody Player player, HttpServletResponse rsp){


        System.out.println(player.getUsername());
        boolean res=ser.addUser(player);
        if(res){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.IM_USED);


    }

    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public List<Player> getUsers(){
        System.out.println("in");
        return ser.getUsers();
    }

    @PostMapping("/players/down")
    public String down(@RequestParam("i") int i,@RequestParam("j")int j,@RequestParam("color") int color){
        String res=null;


        return res;
    }
}
