package cn.dhstudios.master.controller;

import cn.dhstudios.master.model.HeartbeatRequest;
import cn.dhstudios.master.model.ServerStatusEntity;
import cn.dhstudios.master.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ServerController {
    private final ServerRepository repository;

    public ServerController() {
        super();
    }

    @PostMapping("/heartbeat")
    public String handleHeartbeat(@RequestBody HeartbeatRequest request) {
        ServerStatusEntity entity = repository.findByName(request.getServerName())
                .orElseGet(ServerStatusEntity::new);

        entity.setName(request.getServerName());
        entity.setIp(request.getServerIp());
        entity.setPlayers(request.getPlayersOnline());
        entity.setLastHeartbeat(LocalDateTime.now());
        
        repository.save(entity);
        return "OK";
    }

    @GetMapping("/servers")
    public List<ServerStatusEntity> listServers() {
        return repository.findAll();
    }

    @Scheduled(fixedRate = 60000)
    public void cleanup() {
        LocalDateTime cutoff = LocalDateTime.now().minusMinutes(2);
        repository.deleteExpiredServers(cutoff);
    }
}

// DTO 类
class HeartbeatRequest {
    private String serverName;
    private String serverIp;
    private int playersOnline;

    // 新增无参构造函数
    public HeartbeatRequest() {
        super();
    }

    // Getters & Setters
    public String getServerName() { return serverName; }
    public void setServerName(String serverName) { this.serverName = serverName; }
    public String getServerIp() { return serverIp; }
    public void setServerIp(String serverIp) { this.serverIp = serverIp; }
    public int getPlayersOnline() { return playersOnline; }
    public void setPlayersOnline(int playersOnline) { this.playersOnline = playersOnline; }
}