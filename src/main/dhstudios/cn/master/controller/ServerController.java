package cn.dhstudios.master.controller;

import cn.dhstudios.master.HeartbeatRequest;
import cn.dhstudios.master.ServerStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ServerController {
    private final Map<String, ServerStatus> servers = new ConcurrentHashMap<>();

    @PostMapping("/heartbeat")
    public String handleHeartbeat(@RequestBody HeartbeatRequest request) {
        servers.put(request.getServerName(), new ServerStatus(
            request.getServerName(),
            request.getServerIp(),
            request.getPlayersOnline(),
            System.currentTimeMillis()
        ));
        return "OK";
    }

    @GetMapping("/servers")
    public List<ServerStatus> listServers() {
        return new ArrayList<>(servers.values());
    }

    @Scheduled(fixedRate = 60000)
    public void cleanup() {
        long now = System.currentTimeMillis();
        servers.entrySet().removeIf(entry ->
            (now - entry.getValue().getLastHeartbeat()) > 120000
        );
    }
}