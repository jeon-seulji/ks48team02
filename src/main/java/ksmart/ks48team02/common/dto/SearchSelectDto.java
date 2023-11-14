package ksmart.ks48team02.common.dto;

import java.util.Arrays;

public class SearchSelectDto {
    private String dateSettStartDate;
    private String dateSettEndDate;
    private String[] orderCategoryCode;
    private String searchKey;
    private String searchValue;

    @Override
    public String toString() {
        return "searchSelectDto{" +
                "dateSettStartDate='" + dateSettStartDate + '\'' +
                ", dateSettEndDate='" + dateSettEndDate + '\'' +
                ", orderCategoryCode=" + Arrays.toString(orderCategoryCode) +
                ", searchKey='" + searchKey + '\'' +
                ", searchValue='" + searchValue + '\'' +
                '}';
    }

    public String getDateSettStartDate() {
        return dateSettStartDate;
    }

    public void setDateSettStartDate(String dateSettStartDate) {
        this.dateSettStartDate = dateSettStartDate;
    }

    public String getDateSettEndDate() {
        return dateSettEndDate;
    }

    public void setDateSettEndDate(String dateSettEndDate) {
        this.dateSettEndDate = dateSettEndDate;
    }

    public String[] getOrderCategoryCode() {
        return orderCategoryCode;
    }

    public void setOrderCategoryCode(String[] orderCategoryCode) {
        this.orderCategoryCode = orderCategoryCode;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
