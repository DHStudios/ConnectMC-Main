package cn.dhstudios.master.model;

public class HeartbeatRequest {
    private String serverName;
    private String serverIp;
    private int playersOnline;

    // Getters & Setters
    public String getServerName() { return serverName; }
    public void setServerName(String serverName) { this.serverName = serverName; }
    public String getServerIp() { return serverIp; }
    public void setServerIp(String serverIp) { this.serverIp = serverIp; }
    public int getPlayersOnline() { return playersOnline; }
    public void setPlayersOnline(int playersOnline) { this.playersOnline = playersOnline; }
}