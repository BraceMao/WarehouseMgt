package com.zx.whm.specification;

import com.zx.whm.domain.ShipmentRecord;
import com.zx.whm.vo.ShipmentRecordVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/4/15
 * Time: 13:28
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
public class ShipmentRecordSpec implements Specification<ShipmentRecord> {
    private ShipmentRecordVo shipmentRecordVo;
    public ShipmentRecordSpec() {
    }

    public ShipmentRecordSpec(ShipmentRecordVo shipmentRecordVo) {
        this.shipmentRecordVo = shipmentRecordVo;
    }

    public Predicate toPredicate(Root<ShipmentRecord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(StringUtils.isNotBlank(shipmentRecordVo.getCreatorName())){
            predicates.add(cb.like(root.get("creatorName").as(String.class), "%"+shipmentRecordVo.getCreatorName().trim()+"%"));
        }
        Predicate[] p = new Predicate[predicates.size()];
        return cb.and(predicates.toArray(p));
    }
}