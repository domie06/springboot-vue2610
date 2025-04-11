package com.entity.view;

import com.entity.ChongwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chongwu")
public class ChongwuView extends ChongwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 省的值
		*/
		private String chongwuValue;
		/**
		* 市的值
		*/
		private String chongwuErjiValue;
		/**
		* 宠物类型的值
		*/
		private String chongwuLeixingValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ChongwuView() {

	}

	public ChongwuView(ChongwuEntity chongwuEntity) {
		try {
			BeanUtils.copyProperties(this, chongwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
















}
