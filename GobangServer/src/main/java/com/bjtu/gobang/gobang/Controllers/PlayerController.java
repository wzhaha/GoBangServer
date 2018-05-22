package com.bjtu.gobang.gobang.Controllers;


import com.bjtu.gobang.gobang.Enities.GobangMap;
import com.bjtu.gobang.gobang.Enities.Player;
import com.bjtu.gobang.gobang.ServiceImp.PlayerServiceImp;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
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
    public GobangMap addUser(@RequestBody Player player){

        System.out.println(player.getUsername());
        GobangMap res=ser.addUser(player);
       return res;
    }

    @RequestMapping(value = "/players",method = RequestMethod.GET)
    public List<Player> getUsers(){
        System.out.println("in");
        return ser.getUsers();
    }

    @PostMapping("/players/down")
    public GobangMap down(@RequestParam("i") int i,@RequestParam("j")int j,@RequestParam("color") int color,
                     @RequestParam("tag") int tag,@RequestParam("count") int count){

        GobangMap res=ser.down(i,j,color,tag,count);

        return res;
    }

    @GetMapping("player/{index}")
    public GobangMap getMapByIndex(@PathVariable("index") int index){
        GobangMap temp=ser.getMap(index);
        return temp;
    }

}
