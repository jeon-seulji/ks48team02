package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StorePageDto {
    private String store_news_code;
    private String store_code;
    private String title;
    private String contents;
    private LocalDateTime created_datetime;
    private LocalDateTime updated_datetime;
    private LocalDateTime deleted_datetime;
    private int store_news_display;


}
