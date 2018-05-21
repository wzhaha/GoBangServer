package com.bjtu.gobang.gobang.Service;

import com.bjtu.gobang.gobang.Enities.Player;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    public boolean addUser(Player player);
    public List<Player> getUsers();
    public JsonObject sentRes(int x, int y,int color);
}
