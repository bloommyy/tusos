export const ADD_FURNITURE = "ADD_FURNITURE";
export const ADD_APPLIANCE = "ADD_APPLIANCE";
export const VIEW_FURNITURE = "VIEW_FURNITURE";

export const addFurniture = furniture => {
    return {
        type: ADD_FURNITURE,
        payload: furniture
    }
}

export const addAppliance = appliance => {
    return {
        type: ADD_APPLIANCE,
        payload: appliance
    }
}

export const viewFurniture = furnitureList => {
    return {
        type: VIEW_FURNITURE,
        payload: furnitureList
    }
}
