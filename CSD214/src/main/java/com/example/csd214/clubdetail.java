package com.example.csd214;

public class clubdetail {
    private int clubid;
    private String clubname;
    private String mainplayer;

    public clubdetail(int clubid, String clubname,String mainplayer ) {
        this.clubid = clubid;
        this.clubname = clubname;
        this.mainplayer = mainplayer;

    }

    public int getClubid() {
        return clubid;
    }

    public void setClubid(int clubid) {
        this.clubid = clubid;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getMainplayer() {
        return mainplayer;
    }

    public void setMainplayer(String mainplayer) {
        this.mainplayer = mainplayer;
    }
}
