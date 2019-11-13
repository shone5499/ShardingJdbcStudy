package com.shone.shardingjdbcdatabasestrategy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Shone
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    /**
     * user表ID
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime addTime;


}
