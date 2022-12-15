package im.yuki.ganbaro.server.home.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * @author longkun
 * @since 12/15/2022 10:13 PM
 */
@Data
@ToString
public class CheckIn {
    
    private String id;

    private String uid;

    private Date day;

    private String isDidIt;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

}
