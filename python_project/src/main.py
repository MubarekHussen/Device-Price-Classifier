import logging
import pandas as pd
from joblib import load
from fastapi import FastAPI
from pydantic import BaseModel
import re

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


class Device(BaseModel):
    """
    Pydantic model for device data.
    """
    batteryPower: int
    blue: int
    clockSpeed: float
    dualSim: int
    fc: int
    fourG: int
    intMemory: int
    mDep: float
    mobileWt: int
    nCores: int
    pc: int
    pxHeight: int
    pxWidth: int
    ram: int
    scH: int
    scW: int
    talkTime: int
    threeG: int
    touchScreen: int
    wifi: int


clf = load('random_forest.joblib')

app = FastAPI()


@app.post("/predict/{deviceId}")
async def predict(deviceId: int, device: Device):
    """
    Endpoint for predicting the price range of a device.
    
    Args:
        deviceId (int): The ID of the device.
        device (Device): The device data.
    
    Returns:
        dict: The device ID and predicted price range.
    """
    logger.info("Received prediction request for device ID %s: %s", deviceId, device)
    
    device_data = pd.DataFrame([device.model_dump()])
    
    device_data.columns = [re.sub(r'(?<!^)(?=[A-Z])', '_', col).lower() for col in device_data.columns]
    
    prediction = clf.predict(device_data)
    
    logger.info("Predicted price range for device ID %s: %s", deviceId, int(prediction[0]))
    return {"deviceId": deviceId, "predicted_price_range": int(prediction[0])}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)