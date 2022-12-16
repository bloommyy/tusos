package bg.dimps.tusos.pojos;

import javax.validation.constraints.NotNull;

public class AddFurnitureRequest {
    @NotNull
    private Long roomId;
    @NotNull
    private String furnitureName;
    private boolean isBroken;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
