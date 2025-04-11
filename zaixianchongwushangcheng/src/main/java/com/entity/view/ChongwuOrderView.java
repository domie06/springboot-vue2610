package com.entity.view;

import com.entity.ChongwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物预定订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chongwu_order")
public class ChongwuOrderView extends ChongwuOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核状态的值
		*/
		private String chongwuOrderYesnoValue;



		//级联表 chongwu
			/**
			* 宠物名称
			*/
			private String chongwuName;
			/**
			* 宠物照片
			*/
			private String chongwuPhoto;
			/**
			* 宠物视频
			*/
			private String chongwuVideo;
			/**
			* 年龄
			*/
			private String chongwuAge;
			/**
			* 省
			*/
			private Integer chongwuTypes;
				/**
				* 省的值
				*/
				private String chongwuValue;
			/**
			* 市
			*/
			private Integer chongwuErjiTypes;
				/**
				* 市的值
				*/
				private String chongwuErjiValue;
			/**
			* 宠物类型
			*/
			private Integer chongwuLeixingTypes;
				/**
				* 宠物类型的值
				*/
				private String chongwuLeixingValue;
			/**
			* 价格
			*/
			private Double chongwuNewMoney;
			/**
			* 线下店名
			*/
			private String chongwuDianName;
			/**
			* 线下位置
			*/
			private String chongwuAddress;
			/**
			* 点击次数
			*/
			private Integer chongwuClicknum;
			/**
			* 宠物介绍
			*/
			private String chongwuContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer chongwuDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public ChongwuOrderView() {

	}

	public ChongwuOrderView(ChongwuOrderEntity chongwuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chongwuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核状态的值
			*/
			public String getChongwuOrderYesnoValue() {
				return chongwuOrderYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setChongwuOrderYesnoValue(String chongwuOrderYesnoValue) {
				this.chongwuOrderYesnoValue = chongwuOrderYesnoValue;
			}










				//级联表的get和set chongwu
					/**
					* 获取： 宠物名称
					*/
					public String getChongwuName() {
						return chongwuName;
					}
					/**
					* 设置： 宠物名称
					*/
					public void setChongwuName(String chongwuName) {
						this.chongwuName = chongwuName;
					}
					/**
					* 获取： 宠物照片
					*/
					public String getChongwuPhoto() {
						return chongwuPhoto;
					}
					/**
					* 设置： 宠物照片
					*/
					public void setChongwuPhoto(String chongwuPhoto) {
						this.chongwuPhoto = chongwuPhoto;
					}
					/**
					* 获取： 宠物视频
					*/
					public String getChongwuVideo() {
						return chongwuVideo;
					}
					/**
					* 设置： 宠物视频
					*/
					public void setChongwuVideo(String chongwuVideo) {
						this.chongwuVideo = chongwuVideo;
					}
					/**
					* 获取： 年龄
					*/
					public String getChongwuAge() {
						return chongwuAge;
					}
					/**
					* 设置： 年龄
					*/
					public void setChongwuAge(String chongwuAge) {
						this.chongwuAge = chongwuAge;
					}
					/**
					* 获取： 省
					*/
					public Integer getChongwuTypes() {
						return chongwuTypes;
					}
					/**
					* 设置： 省
					*/
					public void setChongwuTypes(Integer chongwuTypes) {
						this.chongwuTypes = chongwuTypes;
					}


						/**
						* 获取： 省的值
						*/
						public String getChongwuValue() {
							return chongwuValue;
						}
						/**
						* 设置： 省的值
						*/
						public void setChongwuValue(String chongwuValue) {
							this.chongwuValue = chongwuValue;
						}
					/**
					* 获取： 市
					*/
					public Integer getChongwuErjiTypes() {
						return chongwuErjiTypes;
					}
					/**
					* 设置： 市
					*/
					public void setChongwuErjiTypes(Integer chongwuErjiTypes) {
						this.chongwuErjiTypes = chongwuErjiTypes;
					}


						/**
						* 获取： 市的值
						*/
						public String getChongwuErjiValue() {
							return chongwuErjiValue;
						}
						/**
						* 设置： 市的值
						*/
						public void setChongwuErjiValue(String chongwuErjiValue) {
							this.chongwuErjiValue = chongwuErjiValue;
						}
					/**
					* 获取： 宠物类型
					*/
					public Integer getChongwuLeixingTypes() {
						return chongwuLeixingTypes;
					}
					/**
					* 设置： 宠物类型
					*/
					public void setChongwuLeixingTypes(Integer chongwuLeixingTypes) {
						this.chongwuLeixingTypes = chongwuLeixingTypes;
					}


						/**
						* 获取： 宠物类型的值
						*/
						public String getChongwuLeixingValue() {
							return chongwuLeixingValue;
						}
						/**
						* 设置： 宠物类型的值
						*/
						public void setChongwuLeixingValue(String chongwuLeixingValue) {
							this.chongwuLeixingValue = chongwuLeixingValue;
						}
					/**
					* 获取： 价格
					*/
					public Double getChongwuNewMoney() {
						return chongwuNewMoney;
					}
					/**
					* 设置： 价格
					*/
					public void setChongwuNewMoney(Double chongwuNewMoney) {
						this.chongwuNewMoney = chongwuNewMoney;
					}
					/**
					* 获取： 线下店名
					*/
					public String getChongwuDianName() {
						return chongwuDianName;
					}
					/**
					* 设置： 线下店名
					*/
					public void setChongwuDianName(String chongwuDianName) {
						this.chongwuDianName = chongwuDianName;
					}
					/**
					* 获取： 线下位置
					*/
					public String getChongwuAddress() {
						return chongwuAddress;
					}
					/**
					* 设置： 线下位置
					*/
					public void setChongwuAddress(String chongwuAddress) {
						this.chongwuAddress = chongwuAddress;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getChongwuClicknum() {
						return chongwuClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setChongwuClicknum(Integer chongwuClicknum) {
						this.chongwuClicknum = chongwuClicknum;
					}
					/**
					* 获取： 宠物介绍
					*/
					public String getChongwuContent() {
						return chongwuContent;
					}
					/**
					* 设置： 宠物介绍
					*/
					public void setChongwuContent(String chongwuContent) {
						this.chongwuContent = chongwuContent;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getChongwuDelete() {
						return chongwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChongwuDelete(Integer chongwuDelete) {
						this.chongwuDelete = chongwuDelete;
					}































				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}
					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}
					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}



}
