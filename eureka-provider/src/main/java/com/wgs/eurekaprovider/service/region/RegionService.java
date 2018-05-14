package com.wgs.eurekaprovider.service.region;

import com.wgs.dto.RegionDTO;
import com.wgs.mapper.RegionMapper;
import com.ydd.framework.core.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Resource
    private CacheService cacheService;

    private String CACHE_KEY = "REGION_KEY";

    /**
     * 省市区
     * @return
     */
    public List<RegionDTO> findRegionList(){
        List<RegionDTO> regionList = cacheService.getEntity("REGION_KEY");
        if(regionList == null) {
            regionList = regionMapper.findByLevel(1, null);
            for (RegionDTO r : regionList) {
                r.setChilds(regionMapper.findByLevel(2, r.getId()));
                for (RegionDTO r2 : r.getChilds()) {
                    r2.setChilds(regionMapper.findByLevel(3, r2.getId()));
                }
            }
            cacheService.set(CACHE_KEY,regionList);
        }
        return regionList;
    }

}
