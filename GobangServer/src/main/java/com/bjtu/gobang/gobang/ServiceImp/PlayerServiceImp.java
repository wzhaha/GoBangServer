package com.bjtu.gobang.gobang.ServiceImp;

import com.bjtu.gobang.gobang.Enities.Player;
import com.bjtu.gobang.gobang.Service.PlayerService;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerServiceImp implements PlayerService {
    public static List<Player> players=new ArrayList<>();

    public boolean addUser(Player player){
        String name=player.getUsername();
        player.setFlag(0);
        for(Player player1:players){
            if(player1.getUsername().equals(name))
                return false;
        }

        players.add(player);
        return true;
    }

    public JsonObject sentRes(int x, int y,int color){
        JsonObject result=new JsonObject();

        result.addProperty("haha","test");

        return result;
    }

    public List<Player> getUsers(){
        return players;
    }

}
