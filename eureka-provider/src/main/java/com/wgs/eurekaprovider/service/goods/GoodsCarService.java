package com.wgs.eurekaprovider.service.goods;

import com.wgs.entity.MemberGoodsCar;
import com.wgs.mapper.MemberGoodsCarMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 购物车
 */
@Service
public class GoodsCarService extends BaseServiceImpl {

    @Resource
    private MemberGoodsCarMapper memberGoodsCarMapper;

    /**
     * 添加到购物车
     * @param skuGroupId
     * @param memberId
     */
    public void addGoodsCar(Integer skuGroupId,Integer memberId,Integer goodsId,Integer num){
        Integer count = memberGoodsCarMapper.countBySkuGroupId(skuGroupId,memberId);
        if(count != null && count > 0){
            memberGoodsCarMapper.updateNumBySkuGroupId(skuGroupId,memberId,num);
        }else{
            MemberGoodsCar memberGoodsCar = new MemberGoodsCar();
            memberGoodsCar.setMemberId(memberId);
            memberGoodsCar.setGoodsId(goodsId);
            memberGoodsCar.setSkuGroupId(skuGroupId);
            memberGoodsCar.setNum(num);
            memberGoodsCarMapper.insert(memberGoodsCar);
        }
    }

    /**
     * 删除购物车商品
     * @param skuGroupId
     * @param memberId
     */
    public void delete(Integer skuGroupId,Integer memberId){
        memberGoodsCarMapper.deleteBySkuGroupId(skuGroupId,memberId);
    }


}
