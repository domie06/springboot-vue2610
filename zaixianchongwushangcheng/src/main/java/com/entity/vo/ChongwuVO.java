package com.entity.vo;

import com.entity.ChongwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宠物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongwu")
public class ChongwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宠物名称
     */

    @TableField(value = "chongwu_name")
    private String chongwuName;


    /**
     * 宠物照片
     */

    @TableField(value = "chongwu_photo")
    private String chongwuPhoto;


    /**
     * 宠物视频
     */

    @TableField(value = "chongwu_video")
    private String chongwuVideo;


    /**
     * 年龄
     */

    @TableField(value = "chongwu_age")
    private String chongwuAge;


    /**
     * 省
     */

    @TableField(value = "chongwu_types")
    private Integer chongwuTypes;


    /**
     * 市
     */

    @TableField(value = "chongwu_erji_types")
    private Integer chongwuErjiTypes;


    /**
     * 宠物类型
     */

    @TableField(value = "chongwu_leixing_types")
    private Integer chongwuLeixingTypes;


    /**
     * 价格
     */

    @TableField(value = "chongwu_new_money")
    private Double chongwuNewMoney;


    /**
     * 线下店名
     */

    @TableField(value = "chongwu_dian_name")
    private String chongwuDianName;


    /**
     * 线下位置
     */

    @TableField(value = "chongwu_address")
    private String chongwuAddress;


    /**
     * 点击次数
     */

    @TableField(value = "chongwu_clicknum")
    private Integer chongwuClicknum;


    /**
     * 宠物介绍
     */

    @TableField(value = "chongwu_content")
    private String chongwuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chongwu_delete")
    private Integer chongwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：宠物名称
	 */
    public String getChongwuName() {
        return chongwuName;
    }


    /**
	 * 获取：宠物名称
	 */

    public void setChongwuName(String chongwuName) {
        this.chongwuName = chongwuName;
    }
    /**
	 * 设置：宠物照片
	 */
    public String getChongwuPhoto() {
        return chongwuPhoto;
    }


    /**
	 * 获取：宠物照片
	 */

    public void setChongwuPhoto(String chongwuPhoto) {
        this.chongwuPhoto = chongwuPhoto;
    }
    /**
	 * 设置：宠物视频
	 */
    public String getChongwuVideo() {
        return chongwuVideo;
    }


    /**
	 * 获取：宠物视频
	 */

    public void setChongwuVideo(String chongwuVideo) {
        this.chongwuVideo = chongwuVideo;
    }
    /**
	 * 设置：年龄
	 */
    public String getChongwuAge() {
        return chongwuAge;
    }


    /**
	 * 获取：年龄
	 */

    public void setChongwuAge(String chongwuAge) {
        this.chongwuAge = chongwuAge;
    }
    /**
	 * 设置：省
	 */
    public Integer getChongwuTypes() {
        return chongwuTypes;
    }


    /**
	 * 获取：省
	 */

    public void setChongwuTypes(Integer chongwuTypes) {
        this.chongwuTypes = chongwuTypes;
    }
    /**
	 * 设置：市
	 */
    public Integer getChongwuErjiTypes() {
        return chongwuErjiTypes;
    }


    /**
	 * 获取：市
	 */

    public void setChongwuErjiTypes(Integer chongwuErjiTypes) {
        this.chongwuErjiTypes = chongwuErjiTypes;
    }
    /**
	 * 设置：宠物类型
	 */
    public Integer getChongwuLeixingTypes() {
        return chongwuLeixingTypes;
    }


    /**
	 * 获取：宠物类型
	 */

    public void setChongwuLeixingTypes(Integer chongwuLeixingTypes) {
        this.chongwuLeixingTypes = chongwuLeixingTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getChongwuNewMoney() {
        return chongwuNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setChongwuNewMoney(Double chongwuNewMoney) {
        this.chongwuNewMoney = chongwuNewMoney;
    }
    /**
	 * 设置：线下店名
	 */
    public String getChongwuDianName() {
        return chongwuDianName;
    }


    /**
	 * 获取：线下店名
	 */

    public void setChongwuDianName(String chongwuDianName) {
        this.chongwuDianName = chongwuDianName;
    }
    /**
	 * 设置：线下位置
	 */
    public String getChongwuAddress() {
        return chongwuAddress;
    }


    /**
	 * 获取：线下位置
	 */

    public void setChongwuAddress(String chongwuAddress) {
        this.chongwuAddress = chongwuAddress;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getChongwuClicknum() {
        return chongwuClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setChongwuClicknum(Integer chongwuClicknum) {
        this.chongwuClicknum = chongwuClicknum;
    }
    /**
	 * 设置：宠物介绍
	 */
    public String getChongwuContent() {
        return chongwuContent;
    }


    /**
	 * 获取：宠物介绍
	 */

    public void setChongwuContent(String chongwuContent) {
        this.chongwuContent = chongwuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChongwuDelete() {
        return chongwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChongwuDelete(Integer chongwuDelete) {
        this.chongwuDelete = chongwuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
