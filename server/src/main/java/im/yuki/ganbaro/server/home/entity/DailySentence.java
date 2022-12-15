package im.yuki.ganbaro.server.home.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author longkun
 * @since 12/15/2022 9:32 PM
 */
@Data
@ToString
public class DailySentence {

    private String id;

    private String content;

    private String author;

    private int showTimes;

    private int likeTimes;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

}
