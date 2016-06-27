package com.matt;

import java.io.Serializable;

public class Message implements Serializable{
    private int missionId;
    private int seed;
    
    public Message(){}

    public int getMissionId() {
        return missionId;
    }
    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }
    public int getSeed() {
        return seed;
    }
    public void setSeed(int seed) {
        this.seed= seed;
    }
}