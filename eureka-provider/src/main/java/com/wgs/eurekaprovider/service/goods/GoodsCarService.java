package com.wgs.eurekaprovider.service.goods;

import com.wgs.dto.goods.GoodsCarDTO;
import com.wgs.entity.GoodsSkuInfo;
import com.wgs.entity.MemberGoodsCar;
import com.wgs.mapper.GoodsSkuInfoMapper;
import com.wgs.mapper.MemberGoodsCarMapper;
import com.ydd.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 购物车
 */
@Service
public class GoodsCarService extends BaseServiceImpl {

    @Resource
    private MemberGoodsCarMapper memberGoodsCarMapper;

    @Resource
    private GoodsSkuInfoMapper goodsSkuInfoMapper;

    /**
     * 添加到购物车
     *
     * @param skuGroupId
     * @param memberId
     */
    public void addGoodsCar(Integer skuGroupId, Integer memberId, Integer goodsId, Integer num) {
        Integer count = memberGoodsCarMapper.countBySkuGroupId(skuGroupId, memberId);
        if (count != null && count > 0) {
            memberGoodsCarMapper.updateNumBySkuGroupId(skuGroupId, memberId, num);
        } else {
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
     *
     * @param skuGroupId
     * @param memberId
     */
    public void delete(Integer skuGroupId, Integer memberId) {
        memberGoodsCarMapper.deleteBySkuGroupId(skuGroupId, memberId);
    }

    /**
     * 获取用户购物车
     *
     * @param memberId
     * @return
     */
    public List<GoodsCarDTO> findGoodsCarByMember(Integer memberId) {
        List<GoodsCarDTO> goodsCarDTOS = memberGoodsCarMapper.findByMember(memberId);
        if (goodsCarDTOS != null && goodsCarDTOS.size() > 0) {
            for (GoodsCarDTO g : goodsCarDTOS) {
                String[] skuIds = g.getGoodsSkuInfoIds().split(";");
                List<GoodsSkuInfo> skuInfos = goodsSkuInfoMapper.findByIds(skuIds);
                StringBuilder skuInfo = new StringBuilder();
                for(GoodsSkuInfo i : skuInfos){
                    skuInfo.append(i.getName()+" ");
                }
                g.setSkuInfo(skuInfo.toString().trim());
            }
        }
        return goodsCarDTOS;
    }

}
