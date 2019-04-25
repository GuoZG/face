package com.sft.face.entity;

import com.sys.ant.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author GuoZG
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UFace extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String userId;

    private Blob faceImg;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;


}
