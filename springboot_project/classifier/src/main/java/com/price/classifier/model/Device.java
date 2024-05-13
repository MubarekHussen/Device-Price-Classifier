package com.price.classifier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity representing a Device.
 */
@Entity
public class Device {

    @Id
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

    /**
     * Default constructor.
     */
    public Device() {
    }

    /**
     * Constructor with all parameters.
     */
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

    /**
     * Returns the ID of the device.
     * 
     * @return the ID of the device.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the device.
     * 
     * @param id the new ID of the device.
     */
    public void setId(Long id) {
        this.id = id;
    }

    // other getters and setters with Javadoc comments...

    /**
     * Returns the battery power of the device.
     * 
     * @return the battery power of the device.
     */
    public int getBatteryPower() {
        return batteryPower;
    }

    /**
     * Sets the battery power of the device.
     * 
     * @param batteryPower the new battery power of the device.
     */
    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    /**
     * Returns the blue feature of the device.
     * 
     * @return the blue feature of the device.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Sets the blue feature of the device.
     * 
     * @param blue the new blue feature of the device.
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * Returns the clock speed of the device.
     * 
     * @return the clock speed of the device.
     */
    public float getClockSpeed() {
        return clockSpeed;
    }

    /**
     * Sets the clock speed of the device.
     * 
     * @param clockSpeed the new clock speed of the device.
     */
    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    /**
     * Returns the dual sim capability of the device.
     * 
     * @return the dual sim capability of the device.
     */
    public int getDualSim() {
        return dualSim;
    }

    /**
     * Sets the dual sim capability of the device.
     * 
     * @param dualSim the new dual sim capability of the device.
     */
    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    /**
     * Returns the front camera megapixels of the device.
     * 
     * @return the front camera megapixels of the device.
     */
    public int getFc() {
        return fc;
    }

    /**
     * Sets the front camera megapixels of the device.
     * 
     * @param fc the new front camera megapixels of the device.
     */
    public void setFc(int fc) {
        this.fc = fc;
    }

    /**
     * Returns the 4G capability of the device.
     * 
     * @return the 4G capability of the device.
     */
    public int getFourG() {
        return fourG;
    }

    /**
     * Sets the 4G capability of the device.
     * 
     * @param fourG the new 4G capability of the device.
     */
    public void setFourG(int fourG) {
        this.fourG = fourG;
    }

    /**
     * Returns the internal memory of the device.
     * 
     * @return the internal memory of the device.
     */
    public int getIntMemory() {
        return intMemory;
    }

    /**
     * Sets the internal memory of the device.
     * 
     * @param intMemory the new internal memory of the device.
     */
    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    /**
     * Returns the mobile depth in cm of the device.
     * 
     * @return the mobile depth in cm of the device.
     */
    public float getmDep() {
        return mDep;
    }

    /**
     * Sets the mobile depth in cm of the device.
     * 
     * @param mDep the new mobile depth in cm of the device.
     */
    public void setmDep(float mDep) {
        this.mDep = mDep;
    }

    /**
     * Returns the weight of the mobile device.
     * 
     * @return the weight of the mobile device.
     */
    public int getMobileWt() {
        return mobileWt;
    }

    /**
     * Sets the weight of the mobile device.
     * 
     * @param mobileWt the new weight of the mobile device.
     */
    public void setMobileWt(int mobileWt) {
        this.mobileWt = mobileWt;
    }

    /**
     * Returns the number of cores of the device.
     * 
     * @return the number of cores of the device.
     */
    public int getnCores() {
        return nCores;
    }

    /**
     * Sets the number of cores of the device.
     * 
     * @param nCores the new number of cores of the device.
     */
    public void setnCores(int nCores) {
        this.nCores = nCores;
    }

    /**
     * Returns the primary camera megapixels of the device.
     * 
     * @return the primary camera megapixels of the device.
     */
    public int getPc() {
        return pc;
    }

    /**
     * Sets the primary camera megapixels of the device.
     * 
     * @param pc the new primary camera megapixels of the device.
     */
    public void setPc(int pc) {
        this.pc = pc;
    }

    /**
     * Returns the pixel height of the device screen.
     * 
     * @return the pixel height of the device screen.
     */
    public int getPxHeight() {
        return pxHeight;
    }

    /**
     * Sets the pixel height of the device screen.
     * 
     * @param pxHeight the new pixel height of the device screen.
     */
    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    /**
     * Returns the pixel width of the device screen.
     * 
     * @return the pixel width of the device screen.
     */
    public int getPxWidth() {
        return pxWidth;
    }

    /**
     * Sets the pixel width of the device screen.
     * 
     * @param pxWidth the new pixel width of the device screen.
     */
    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    /**
     * Returns the RAM of the device.
     * 
     * @return the RAM of the device.
     */
    public int getRam() {
        return ram;
    }

    /**
     * Sets the RAM of the device.
     * 
     * @param ram the new RAM of the device.
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * Returns the screen height of the device.
     * 
     * @return the screen height of the device.
     */
    public int getScH() {
        return scH;
    }

    /**
     * Sets the screen height of the device.
     * 
     * @param scH the new screen height of the device.
     */
    public void setScH(int scH) {
        this.scH = scH;
    }

    /**
     * Returns the screen width of the device.
     * 
     * @return the screen width of the device.
     */
    public int getScW() {
        return scW;
    }

    /**
     * Sets the screen width of the device.
     * 
     * @param scW the new screen width of the device.
     */
    public void setScW(int scW) {
        this.scW = scW;
    }

    /**
     * Returns the talk time of the device.
     * 
     * @return the talk time of the device.
     */
    public int getTalkTime() {
        return talkTime;
    }

    /**
     * Sets the talk time of the device.
     * 
     * @param talkTime the new talk time of the device.
     */
    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    /**
     * Returns the 3G capability of the device.
     * 
     * @return the 3G capability of the device.
     */
    public int getThreeG() {
        return threeG;
    }

    /**
     * Sets the 3G capability of the device.
     * 
     * @param threeG the new 3G capability of the device.
     */
    public void setThreeG(int threeG) {
        this.threeG = threeG;
    }

    /**
     * Returns the touch screen capability of the device.
     * 
     * @return the touch screen capability of the device.
     */
    public int getTouchScreen() {
        return touchScreen;
    }

    /**
     * Sets the touch screen capability of the device.
     * 
     * @param touchScreen the new touch screen capability of the device.
     */
    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    /**
     * Returns the wifi capability of the device.
     * 
     * @return the wifi capability of the device.
     */
    public int getWifi() {
        return wifi;
    }

    /**
     * Sets the wifi capability of the device.
     * 
     * @param wifi the new wifi capability of the device.
     */
    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    /**
     * Returns the price range of the device.
     * 
     * @return the price range of the device.
     */
    public int getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the price range of the device.
     * 
     * @param priceRange the new price range of the device.
     */
    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }
}