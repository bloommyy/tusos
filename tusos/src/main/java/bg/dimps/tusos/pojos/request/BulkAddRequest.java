package bg.dimps.tusos.pojos.request;

import javax.validation.constraints.NotBlank;

public class BulkAddRequest {
    @NotBlank
    private String dormId;

    @NotBlank
    private Long floorCount;

    @NotBlank
    private Long roomsPerFloorCount;

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public Long getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Long floorCount) {
        this.floorCount = floorCount;
    }

    public Long getRoomsPerFloorCount() {
        return roomsPerFloorCount;
    }

    public void setRoomsPerFloorCount(Long roomsPerFloorCount) {
        this.roomsPerFloorCount = roomsPerFloorCount;
    }
}
