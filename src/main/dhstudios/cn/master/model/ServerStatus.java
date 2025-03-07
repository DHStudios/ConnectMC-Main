package cn.dhstudios.master.model;

public class ServerStatus {
    private String name;
    private String ip;
    private int players;
    private long lastHeartbeat;

    public ServerStatus(String name, String ip, int players, long lastHeartbeat) {
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