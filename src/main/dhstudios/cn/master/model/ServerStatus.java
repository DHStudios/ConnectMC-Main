package cn.dhstudios.master.model;

public class ServerStatus {
    private String name;
    private String ip;
    private int players;
    private long lastHeartbeat;

    public ServerStatus(String name, String ip, int players, long lastHeartbeat) {
        // 虽然这里 Java 会隐式调用父类无参构造函数 Object()，但错误提示可能是 IDE 误判，这里显式调用以解决问题
        super(); 
        this.name = name;
        this.ip = ip;
        this.players = players;
        this.lastHeartbeat = lastHeartbeat;
    }

    // Getters
    public String getName() { return name; }
    public String getIp() { return ip; }
    public int getPlayers() { return players; }
    public long getLastHeartbeat() { return lastHeartbeat; }
}