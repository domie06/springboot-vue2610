
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 宠物预定订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongwuOrder")
public class ChongwuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChongwuOrderController.class);

    @Autowired
    private ChongwuOrderService chongwuOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ChongwuService chongwuService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chongwuOrderService.queryPage(params);

        //字典表数据转换
        List<ChongwuOrderView> list =(List<ChongwuOrderView>)page.getList();
        for(ChongwuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwuOrderEntity chongwuOrder = chongwuOrderService.selectById(id);
        if(chongwuOrder !=null){
            //entity转view
            ChongwuOrderView view = new ChongwuOrderView();
            BeanUtils.copyProperties( chongwuOrder , view );//把实体数据重构到view中

                //级联表
                ChongwuEntity chongwu = chongwuService.selectById(chongwuOrder.getChongwuId());
                if(chongwu != null){
                    BeanUtils.copyProperties( chongwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChongwuId(chongwu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chongwuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwuOrderEntity chongwuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongwuOrder:{}",this.getClass().getName(),chongwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chongwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chongwuOrder.setInsertTime(new Date());
        chongwuOrder.setCreateTime(new Date());
        chongwuOrderService.insert(chongwuOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwuOrderEntity chongwuOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chongwuOrder:{}",this.getClass().getName(),chongwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chongwuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChongwuOrderEntity> queryWrapper = new EntityWrapper<ChongwuOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongwuOrderEntity chongwuOrderEntity = chongwuOrderService.selectOne(queryWrapper);
        chongwuOrder.setUpdateTime(new Date());
        if(chongwuOrderEntity==null){
            chongwuOrderService.updateById(chongwuOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chongwuOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChongwuOrderEntity> chongwuOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChongwuOrderEntity chongwuOrderEntity = new ChongwuOrderEntity();
//                            chongwuOrderEntity.setChongwuOrderUuidNumber(data.get(0));                    //预约流水号 要改的
//                            chongwuOrderEntity.setChongwuId(Integer.valueOf(data.get(0)));   //宠物 要改的
//                            chongwuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chongwuOrderEntity.setInsertTime(date);//时间
//                            chongwuOrderEntity.setChongwuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            chongwuOrderEntity.setChongwuOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            chongwuOrderEntity.setUpdateTime(new Date(data.get(0)));          //审核时间 要改的
//                            chongwuOrderEntity.setCreateTime(date);//时间
                            chongwuOrderList.add(chongwuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //预约流水号
                                if(seachFields.containsKey("chongwuOrderUuidNumber")){
                                    List<String> chongwuOrderUuidNumber = seachFields.get("chongwuOrderUuidNumber");
                                    chongwuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chongwuOrderUuidNumber = new ArrayList<>();
                                    chongwuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chongwuOrderUuidNumber",chongwuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约流水号
                        List<ChongwuOrderEntity> chongwuOrderEntities_chongwuOrderUuidNumber = chongwuOrderService.selectList(new EntityWrapper<ChongwuOrderEntity>().in("chongwu_order_uuid_number", seachFields.get("chongwuOrderUuidNumber")));
                        if(chongwuOrderEntities_chongwuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChongwuOrderEntity s:chongwuOrderEntities_chongwuOrderUuidNumber){
                                repeatFields.add(s.getChongwuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chongwuOrderService.insertBatch(chongwuOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chongwuOrderService.queryPage(params);

        //字典表数据转换
        List<ChongwuOrderView> list =(List<ChongwuOrderView>)page.getList();
        for(ChongwuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongwuOrderEntity chongwuOrder = chongwuOrderService.selectById(id);
            if(chongwuOrder !=null){


                //entity转view
                ChongwuOrderView view = new ChongwuOrderView();
                BeanUtils.copyProperties( chongwuOrder , view );//把实体数据重构到view中

                //级联表
                    ChongwuEntity chongwu = chongwuService.selectById(chongwuOrder.getChongwuId());
                if(chongwu != null){
                    BeanUtils.copyProperties( chongwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChongwuId(chongwu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chongwuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwuOrderEntity chongwuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongwuOrder:{}",this.getClass().getName(),chongwuOrder.toString());
            ChongwuEntity chongwuEntity = chongwuService.selectById(chongwuOrder.getChongwuId());
            if(chongwuEntity == null){
                return R.error(511,"查不到该宠物");
            }
            else if(chongwuEntity.getChongwuNewMoney() == null){
                return R.error(511,"宠物价格不能为空");
            }

        ChongwuOrderEntity chongwuOrderEntity = chongwuOrderService.selectOne(new EntityWrapper<ChongwuOrderEntity>().eq("chongwu_id", chongwuOrder.getChongwuId()).eq("yonghu_id", chongwuOrder.getYonghuId()));
            if(chongwuOrderEntity != null)
                return R.error(511,"您已经预约过该宠物,请去查看宠物审核状态");


        chongwuOrder.setChongwuOrderUuidNumber(String.valueOf(new Date().getTime()));
            chongwuOrder.setChongwuOrderYesnoTypes(1);
            chongwuOrder.setInsertTime(new Date());
            chongwuOrder.setCreateTime(new Date());
                chongwuOrderService.insert(chongwuOrder);//新增订单
            return R.ok();
    }




}
