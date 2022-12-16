package bg.dimps.tusos.pojos;

import javax.validation.constraints.NotNull;

public class ElectricApplianceRequest {
    @NotNull
    private Long roomId;
    @NotNull
    private String applianceName;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }
}
