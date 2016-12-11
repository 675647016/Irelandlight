package com.irelandlight.dao;

import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsSizePrice;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/3.
 */
public interface GoodsMapper {
    //查询商品总数
    Integer selectGoodsCount();
    //查询回收站商品
    Integer selectRecycleGoodsCount();
    //查询上架商品数
    Integer selectPutawayGoodsCount();
    //查询下架商品数
    Integer selectSoldOutGoodsCount();
    //按照商品名称查找商品
    List<Goods> selectGoodsByName(@Param("name") String name);
    //查询未上架商品
    List<Goods> selectUnPutawayGoods();
    //查询已上架商品
    List<Goods> selectPutawayGoods();
    //按照商品id查找商品尺寸与价格的对应关系-==
    
    List<GoodsSizePrice> selectPWSizePriceMapByGoodsId(@Param("goodsId") Long goodsId);
    //按照商品id查找商品尺寸与价格的对应关系
    List<GoodsSizePrice> selectUPWSizePriceMapByGoodsId(@Param("goodsId") Long goodsId);
    //按照商品id查找商品头像的url
    String selectGoodsHeadImgUrlByGoodsId(@Param("goodsId") Long goodsId);
    //查询商品的评价总数
    int selectGoodsComment();
    //按照指定的id列表将商品批量上架
    void updateGoodsByIds(@Param("ids") List<Long> ids,@Param("putFlag") int putFlag);
    //按照制定的商品id和size更改商品的上架属性
    void updateGoodsByIdsAndSize(@Param("goodsIdMapSize")  Map<Long,List<String>> goodsIdMapSize,@Param("putFlag") int putFlag);
    //http://ohlu5erjk.bkt.clouddn.com/267b16d4-36aa-4040-a8e5-a2c88205e2b8.jpg
    //http://ohlu5erjk.bkt.clouddn.com/9d45443a-89fd-4aff-8563-1e59d835025c.jpg
    //http://ohlu5erjk.bkt.clouddn.com/f13e0b45-dd44-4156-a417-a1f4b0962dd7.jpg
    void insertIntoGoodsImg(@Param("id")Long id,@Param("imgUrlMap") Map<String,Integer> imgUrlMap);
    //
    void updateGoodsImg(@Param("id")Long id,@Param("imgUrlMap") Map<String,Integer> imgUrlMap);
    //
    void insertIotoGoodsSizePrice(@Param("id") Long id,@Param("sizeMapPrice")Map<String,BigDecimal> sizeMapPrice);
    //
    void updateGoodsSizePrice(@Param("id") Long id,@Param("sizeMapPrice")Map<String,BigDecimal> sizeMapPrice);
    //修改商品中的字段值
    void updateGoods(@Param("goods") Goods goods);
    //将商品添加到tb_goods表中 @Param("goods")
    void insertIntoGoods(@Param("goods") Goods goods);
    void insertIntoGoodsByParam(Goods goods);
    //将商品从tb_goods表中删除
    void deleteFromGoods(@Param("goods") Goods goods);
}