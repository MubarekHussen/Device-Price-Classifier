package com.price.classifier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Device {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int batteryPower;
    private int blue;
    private float clockSpeed;
    private int dualSim;
    private int fc;
    private int fourG;
    private int intMemory;
    private float mDep;
    private int mobileWt;
    private int nCores;
    private int pc;
    private int pxHeight;
    private int pxWidth;
    private int ram;
    private int scH;
    private int scW;
    private int talkTime;
    private int threeG;
    private int touchScreen;
    private int wifi;
    private int priceRange;

    public Device() {
    }

    public Device(int batteryPower, int blue, float clockSpeed, int dualSim, int fc, int fourG, int intMemory,
            float mDep, int mobileWt, int nCores, int pc, int pxHeight, int pxWidth, int ram, int scH, int scW,
            int talkTime, int threeG, int touchScreen, int wifi, int priceRange) {
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getDualSim() {
        return dualSim;
    }

    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFourG() {
        return fourG;
    }

    public void setFourG(int fourG) {
        this.fourG = fourG;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public float getmDep() {
        return mDep;
    }

    public void setmDep(float mDep) {
        this.mDep = mDep;
    }

    public int getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(int mobileWt) {
        this.mobileWt = mobileWt;
    }

    public int getnCores() {
        return nCores;
    }

    public void setnCores(int nCores) {
        this.nCores = nCores;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getScH() {
        return scH;
    }

    public void setScH(int scH) {
        this.scH = scH;
    }

    public int getScW() {
        return scW;
    }

    public void setScW(int scW) {
        this.scW = scW;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getThreeG() {
        return threeG;
    }

    public void setThreeG(int threeG) {
        this.threeG = threeG;
    }

    public int getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }
}
