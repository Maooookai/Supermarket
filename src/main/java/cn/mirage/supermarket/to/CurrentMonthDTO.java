package cn.mirage.supermarket.to;

import lombok.Data;

@Data
public class CurrentMonthDTO {

    private String sales;
    private String profit;
    private String mostCommodityName;
    private String mostCommodityNumber;

}
