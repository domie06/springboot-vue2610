package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 宠物预定订单
 *
 * @author 
 * @email
 */
@TableName("chongwu_order")
public class ChongwuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongwuOrderEntity() {

	}

	public ChongwuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 预约流水号
     */
    @TableField(value = "chongwu_order_uuid_number")

    private String chongwuOrderUuidNumber;


    /**
     * 宠物
     */
    @TableField(value = "chongwu_id")

    private Integer chongwuId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @TableField(value = "chongwu_order_yesno_types")

    private Integer chongwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "chongwu_order_yesno_text")

    private String chongwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约流水号
	 */
    public String getChongwuOrderUuidNumber() {
        return chongwuOrderUuidNumber;
    }


    /**
	 * 获取：预约流水号
	 */

    public void setChongwuOrderUuidNumber(String chongwuOrderUuidNumber) {
        this.chongwuOrderUuidNumber = chongwuOrderUuidNumber;
    }
    /**
	 * 设置：宠物
	 */
    public Integer getChongwuId() {
        return chongwuId;
    }


    /**
	 * 获取：宠物
	 */

    public void setChongwuId(Integer chongwuId) {
        this.chongwuId = chongwuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getChongwuOrderYesnoTypes() {
        return chongwuOrderYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setChongwuOrderYesnoTypes(Integer chongwuOrderYesnoTypes) {
        this.chongwuOrderYesnoTypes = chongwuOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getChongwuOrderYesnoText() {
        return chongwuOrderYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setChongwuOrderYesnoText(String chongwuOrderYesnoText) {
        this.chongwuOrderYesnoText = chongwuOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChongwuOrder{" +
            "id=" + id +
            ", chongwuOrderUuidNumber=" + chongwuOrderUuidNumber +
            ", chongwuId=" + chongwuId +
            ", yonghuId=" + yonghuId +
            ", insertTime=" + insertTime +
            ", chongwuOrderYesnoTypes=" + chongwuOrderYesnoTypes +
            ", chongwuOrderYesnoText=" + chongwuOrderYesnoText +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
