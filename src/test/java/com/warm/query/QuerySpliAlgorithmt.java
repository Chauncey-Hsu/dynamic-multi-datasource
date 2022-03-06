package com.warm.query;

import com.warm.system.entity.H2MetaLoc;

import java.time.LocalDateTime;

/**
 * 查询拆分算法
 *
 * @author xuchuanqi
 * @date 2022/3/6 19:45.
 */
public class QuerySpliAlgorithmt {

    public static void main(String[] args) {

        H2MetaLoc A = new H2MetaLoc(null, 0D, 10D, 0D, 10D, LocalDateTime.now(), LocalDateTime.now().plusDays(2), 0);
        H2MetaLoc B = new H2MetaLoc(null, 9D, 10D, 5D, 15D, LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(3), 0);

        Double endLon = null;
        Double startLon = null;
        boolean b = A.getMinLon() < B.getMinLon();
        if (b) {
            boolean b1 = A.getMaxLon() > B.getMinLon();
            if (b1) {
                // 一定有交集
                startLon = A.getMinLon() > B.getMinLon() ? A.getMinLon() : B.getMinLon();
                endLon = A.getMaxLat() < B.getMaxLon() ? A.getMaxLon() : B.getMaxLon();
            }
        } else {
            boolean b1 = A.getMinLon() < B.getMaxLon();
            if (b1) {
                // 一定有交集
                startLon = A.getMinLon() > B.getMinLon() ? A.getMinLon() : B.getMinLon();
                endLon = A.getMaxLat() < B.getMaxLon() ? A.getMaxLon() : B.getMaxLon();
            }
        }
        System.out.println(startLon);
        System.out.println(endLon);
    }
}
