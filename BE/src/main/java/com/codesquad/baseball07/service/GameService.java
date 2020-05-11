package com.codesquad.baseball07.service;

import com.codesquad.baseball07.dao.GameDao;
import com.codesquad.baseball07.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {

    @Autowired
    GameDao gameDao;

    public Map<String, List<Game>> getAll() {
        List<Game> games =  gameDao.getAll();
        Map<String, List<Game>> map = new HashMap<>();
        map.put("games", games);
        return map;
    }
}