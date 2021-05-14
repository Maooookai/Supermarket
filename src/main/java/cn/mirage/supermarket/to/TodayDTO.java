package cn.mirage.supermarket.to;

import cn.mirage.supermarket.entity.Commodity;
import lombok.Data;

import java.util.List;

@Data
public class TodayDTO {
    private String sales;
    private String profit;
    private String mostCommodityName;
    private String mostCommodityNumber;
}
