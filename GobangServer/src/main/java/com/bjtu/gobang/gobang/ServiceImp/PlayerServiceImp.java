package com.bjtu.gobang.gobang.ServiceImp;

import com.bjtu.gobang.gobang.Enities.GobangMap;
import com.bjtu.gobang.gobang.Enities.Player;
import com.bjtu.gobang.gobang.Service.PlayerService;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerServiceImp implements PlayerService {
    public static List<Player> players=new ArrayList<>();
    public static List<GobangMap> gobangMaps=new ArrayList<>();
    public static int tag=1;

    static int wait=0;
    public GobangMap addUser(Player player){
//        String name=player.getUsername();
        player.setFlag(0);
//        for(Player player1:players){
//            if(player1.getUsername().equals(name))
//                return false;
//        }

        players.add(player);
        wait++;

        GobangMap gobangMap=null;
        if(wait%2==1){
            gobangMap=new GobangMap();
            gobangMap.setTag(tag);
            gobangMaps.add(tag,gobangMap);
            player.setBlackOrWhite(1);
            gobangMap.setP1(player);
            player.setFlag(1);
        }
        else {
            player.setBlackOrWhite(0);
            gobangMap.setP2(player);
            player.setFlag(1);
            //第二人进入就开始游戏
            gobangMap.setOverFlag(1);
        }

        if(wait%2==0){
            //传输给客户端
            tag++;
            wait=wait-2;
        }
        return gobangMaps.get(tag);
    }

    public GobangMap down(int x, int y,int color,int tag,int count){
        GobangMap gobangMap=gobangMaps.get(tag);

        if(gobangMap.getLastPlayer()!=color) {
            gobangMap.map[x][y].setPut_number(count);
            gobangMap.map[x][y].setI(x);
            gobangMap.map[x][y].setJ(y);
            gobangMap.map[x][y].setWhiteOrBlack(color);
            gobangMap.setLastPlayer(color);
            boolean res = gobangMaps.get(tag).judge(x, y);

            if (res) {
                gobangMap.setOverFlag(2);
            }
        }

        return gobangMap;
    }

    public List<Player> getUsers(){
        return players;
    }

    public GobangMap getMap(int indx){
        return gobangMaps.get(indx);
    }

}
