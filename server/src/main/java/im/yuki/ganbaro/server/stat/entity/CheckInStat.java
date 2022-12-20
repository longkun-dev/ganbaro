package im.yuki.ganbaro.server.stat.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/21 12:31 AM
 * @description 统计
 */
@Data
public class CheckInStat {

    private String uid;

    private Date startDate;

    private Date endDate;

    /**
     * 连续天数
     */
    private Integer continuousDays;

}
