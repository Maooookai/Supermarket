package cn.mirage.supermarket.to;

import lombok.Data;

@Data
public class CommodityEditDTO {
    private String id;
    private String name;
    private String code;
    private String purchasePrice;
    private String price;
    private String stock;
}
