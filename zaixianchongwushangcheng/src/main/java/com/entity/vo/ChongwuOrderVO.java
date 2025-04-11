package com.entity.vo;

import com.entity.ChongwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宠物预定订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwu_order")
public class ChongwuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
