package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StorePageDto {
    private String storeNewsCode;
    private String storeCode;
    private String storeNewsTitle;
    private String storeNewsContents;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;
    private LocalDateTime deletedDatetime;
    private int storeNewsDisplay;

    public String getStoreNewsCode() {
        return storeNewsCode;
    }

    public void setStoreNewsCode(String storeNewsCode) {
        this.storeNewsCode = storeNewsCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreNewsTitle() {
        return storeNewsTitle;
    }

    public void setStoreNewsTitle(String storeNewsTitle) {
        this.storeNewsTitle = storeNewsTitle;
    }

    public String getStoreNewsContents() {
        return storeNewsContents;
    }

    public void setStoreNewsContents(String storeNewsContents) {
        this.storeNewsContents = storeNewsContents;
    }

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(LocalDateTime createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public LocalDateTime getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(LocalDateTime updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public LocalDateTime getDeletedDatetime() {
        return deletedDatetime;
    }

    public void setDeletedDatetime(LocalDateTime deletedDatetime) {
        this.deletedDatetime = deletedDatetime;
    }

    public int getStoreNewsDisplay() {
        return storeNewsDisplay;
    }

    public void setStoreNewsDisplay(int storeNewsDisplay) {
        this.storeNewsDisplay = storeNewsDisplay;
    }
}
