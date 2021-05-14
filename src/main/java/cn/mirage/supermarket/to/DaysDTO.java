package cn.mirage.supermarket.to;

import lombok.Data;

import java.util.List;

@Data
public class DaysDTO {

    List<String> days;

    List<Float> sales;

}
