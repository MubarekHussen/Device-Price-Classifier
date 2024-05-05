from fastapi import FastAPI
from pydantic import BaseModel
from joblib import load

# Load the trained model
clf = load('random_forest.joblib')

# Define the FastAPI app
app = FastAPI()


# Define a Pydantic model for the device specifications
class Device(BaseModel):
    battery_power: int
    blue: int
    clock_speed: float
    dual_sim: int
    fc: int
    four_g: int
    int_memory: int
    m_dep: float
    mobile_wt: int
    n_cores: int
    pc: int
    px_height: int
    px_width: int
    ram: int
    sc_h: int
    sc_w: int
    talk_time: int
    three_g: int
    touch_screen: int
    wifi: int


@app.post("/predict/{deviceId}")
async def predict(deviceId: int, device: Device):
    # Make a prediction
    prediction = clf.predict([list(device.dict().values())])
    return {"deviceId": deviceId, "predicted_price_range": int(prediction[0])}