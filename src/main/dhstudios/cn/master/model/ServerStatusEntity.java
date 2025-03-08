package main.dhstudios.cn.master.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "servers")
public class ServerStatusEntity {
    // 添加无参构造函数
    public ServerStatusEntity() {
        super();
    }
    // 由于没有其他父类构造函数调用的问题，这里代码本身没问题，无需额外修改
    // 如果存在自定义父类且没有无参构造函数，需要添加相应的构造函数
    // 这里为了示例，添加一个无参构造函数
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String ip;
    private int players;
    private LocalDateTime lastHeartbeat;

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public int getPlayers() { return players; }
    public void setPlayers(int players) { this.players = players; }
    public LocalDateTime getLastHeartbeat() { return lastHeartbeat; }
    public void setLastHeartbeat(LocalDateTime lastHeartbeat) { this.lastHeartbeat = lastHeartbeat; }
}
